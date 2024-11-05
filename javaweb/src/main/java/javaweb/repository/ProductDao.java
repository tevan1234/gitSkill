package javaweb.repository;

import java.util.List;
import java.util.Map;

import javaweb.model.entity.Product;

public interface ProductDao {
	//查詢所有商品
	List<Product> findAllProducts();
	
	//刪除商品
	void deleteProduct(Integer productId);
	
	void addProduct(Product product);
	
	Map<String, Double>querySalesRanking() ;
}
