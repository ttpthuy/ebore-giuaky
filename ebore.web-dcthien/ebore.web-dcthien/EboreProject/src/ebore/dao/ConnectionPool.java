package ebore.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
	private ConcurrentLinkedQueue<MyConnection> availablePool;
	private ConcurrentLinkedQueue<MyConnection> busyPool;
	
	private ScheduledExecutorService executorService;
	
	/**
	 * Creates the pool.
	 *
	 * @param minIdle
	 *            minimum number of objects residing in the pool
	 */
	public ConnectionPool(final int minIdle) {
		// initialize pool
		initialize(minIdle);
	}

	/**
	 * Creates the pool.
	 *
	 * @param minIdle
	 *            minimum number of objects residing in the pool
	 * @param maxIdle
	 *            maximum number of objects residing in the pool
	 * @param validationInterval
	 *            time in seconds for periodical checking of minIdle / maxIdle
	 *            conditions in a separate thread. When the number of objects is
	 *            greater than maxIdle, too many instances will be removed.
	 */
	public ConnectionPool(final int minIdle, final int maxIdle, final long validationInterval) {
		// initialize pool
		initialize(minIdle);

		// check pool conditions in a separate thread
		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				int size = availablePool.size();
				if (!busyPool.isEmpty()) {
					long timeInMillis = Calendar.getInstance().getTimeInMillis();
					Timestamp currentTime = new Timestamp(timeInMillis);

					// if the head connection is time out, that connect will be
					// move into available queue.
					boolean check = true;
					while (check) {
						check = false;
						MyConnection connection = busyPool.peek();
						if (connection != null && connection.getTimestamp().compareTo(currentTime) < 0) {
							check = true;
							System.out.println("Connenction Time Out: " + connection.toString());
							availablePool.add(busyPool.poll());
						}
					}
				}

				// Check if the number of connection in available pool is larger
				// than maximum number of connection, the redundancy will be
				// remove.
				if (size > maxIdle) {
					int sizeToBeRemoved = size - maxIdle;
					for (int i = 0; i < sizeToBeRemoved; i++) {
						availablePool.poll();
						System.out.println("remove redundancy!");
					}
				}
			}
		}, validationInterval, validationInterval, TimeUnit.SECONDS);		
	}
	
	/**
	 * Gets the next free object from the pool. If the pool doesn't contain any
	 * objects, a new object will be created and given to the caller of this
	 * method back.
	 *
	 * @return T borrowed object
	 */
	public MyConnection borrowConnection() {
		MyConnection connection;
		if (availablePool.isEmpty()) {
			availablePool.add(createObject());
		}
		if ((connection = availablePool.poll()) != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.SECOND, 180);
			Timestamp currentTime = new Timestamp(calendar.getTimeInMillis());

			connection.setTimestamp(currentTime);
			System.out.println("Borrow: " + connection.toString());
			busyPool.add(connection);
			System.out.println(availablePool.toString());
			System.out.println(busyPool.toString());
		}
		return connection;
	}

	/**
	 * Returns object back to the pool.
	 *
	 * @param object
	 *            object to be returned
	 */
	public void returnConnection(MyConnection myConnection) {
		if (myConnection == null) {
			return;
		}
		this.busyPool.remove(myConnection);
		this.availablePool.offer(myConnection);
		System.out.println("Return: " + myConnection.toString());
		System.out.println(availablePool.toString());
		System.out.println(busyPool.toString());
	}

	/**
	 * Shutdown this pool.
	 */
	public void shutdown() {
		if (executorService != null) {
			executorService.shutdown();
		}
	}

	/**
	 * Creates a new object.
	 *
	 * @return T new object
	 */
	private MyConnection createObject() {
		return new MyConnection();
	}
	
	
	private void initialize(int minIdle) {
		availablePool = new ConcurrentLinkedQueue<MyConnection>();
		busyPool = new ConcurrentLinkedQueue<MyConnection>();
		for (int i = 0; i < minIdle; i++) {
			availablePool.add(createObject());
		}
	}

}
