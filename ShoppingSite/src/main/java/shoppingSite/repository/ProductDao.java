package shoppingSite.repository;

import java.util.List;

import shoppingSite.model.entity.Product;


public interface ProductDao {
	//查詢所有商品
	List<Product> findAllProducts();
	
	//尋找商品
	Product getProduct(Integer productId);
		
	//刪除商品
	void deleteProduct(Integer productId);
	
	//新增產品
	void addProduct(Product product);
	
	//修改產品
	void alterProductPrice(Integer productId, Integer productPrice);
	
	//修改產品
	void alterProductStock(Integer productId, Integer Restock);
	
	//修改產品
	void alterProductStatus(Integer productId, boolean productStatus);
}
