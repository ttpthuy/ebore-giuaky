package ebore.model;

import java.util.List;

import ebore.dao.OrderDAO;

public class OrderList {
	List<Order> orders;
	static OrderDAO orderDAO;
	
	
public static List<Order> getAllOrder() {
	orderDAO = (orderDAO == null) ? new OrderDAO():orderDAO;
	return orderDAO.selectAllOrder();
	
}	


}
