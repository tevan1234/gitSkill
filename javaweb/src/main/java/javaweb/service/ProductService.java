package javaweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javaweb.model.dto.ProductDto;
import javaweb.model.entity.Product;
import javaweb.repository.ProductDao;
import javaweb.repository.ProductDaoImpl;

public class ProductService {
	
	private ProductDao productDao = new ProductDaoImpl();
	
	// 所有使用者
	public List<ProductDto> findAll(){
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productDao.findAllProducts();
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			productDto.setProduct_id(product.getProduct_id());
			productDto.setProduct_name(product.getProduct_name());
			productDto.setPrice(product.getPrice());
			productDto.setStock_quantity(product.getStock_quantity());
			
			productDtos.add(productDto);
		}
		return productDtos;
	}
	
	//刪除使用者
	public void deleteProduct(String productId) {
		productDao.deleteProduct(Integer.parseInt(productId));
	}
	
	//新增使用者
	public void addProducts(String productname,String price,String stock) {
		Product product = new Product();
		product.setProduct_name(productname);
		product.setPrice(price);
		product.setStock_quantity(Integer.parseInt(stock));
		
		productDao.addProduct(product);
	}
	
	public Map<String, Double> querySalesRanking() {
		return productDao.querySalesRanking();
	}
}
