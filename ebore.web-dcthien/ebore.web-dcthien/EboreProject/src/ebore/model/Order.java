package ebore.model;

import java.util.Date;

import ebore.dao.OrderDAO;

public class Order {
	String idOrder, idStory, idUser;
	Date date;
	
	private static OrderDAO orderDAO;
	public Order(String idOrder, String idStory, String idUser, Date date) {
		super();
		this.idOrder = idOrder;
		this.idStory = idStory;
		this.idUser = idUser;
		this.date = date;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdStory() {
		return idStory;
	}
	public void setIdStory(String idStory) {
		this.idStory = idStory;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", idStory=" + idStory + ", idUser=" + idUser + ", date=" + date + "]" + "\n";
	}
	public static void deleteOrder(String id) {
		orderDAO = (orderDAO == null) ? new OrderDAO() : orderDAO;
		orderDAO.delete(id);
	}

}
