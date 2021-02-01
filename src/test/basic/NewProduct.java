package test.basic;

import infra.DAO;
import model.basic.Product;

public class NewProduct {

	public static void main(String[] args) {
		
		Product product = new Product("Monitor 23", 789.98);

		DAO<Product> dao = new DAO<>(Product.class);
		dao.atomicInclude(product).close();
		
		System.out.println("Id do produto: " + product.getId());
	}
}
