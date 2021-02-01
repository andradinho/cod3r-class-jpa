package test.onetomany;

import infra.DAO;
import model.basic.Product;
import model.onetomany.Order;
import model.onetomany.OrderedItem;

public class NewOrder {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Product product = new Product("Geladeira", 2789.99);
		Order order = new Order();
		OrderedItem item = new OrderedItem(order, product, 10);
		
		dao.openTransaction()
			.include(product)
			.include(order)
			.include(item)
			.closeTransaction()
			.close();
	}
}
