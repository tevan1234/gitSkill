package shoppingSite.service;

import java.util.ArrayList;
import java.util.List;

import shoppingSite.model.dto.ProductDto;
import shoppingSite.model.entity.Product;
import shoppingSite.repository.ProductDao;
import shoppingSite.repository.ProductDaoImpl;

public class ProductService {
	private ProductDao productDao = new ProductDaoImpl();
	
	public List<ProductDto> findAll(){
		List<ProductDto> productDtos = new ArrayList<>();
		List<Product> products = productDao.findAllProducts();
		
		for(Product product:products) {
			ProductDto productDto = new ProductDto();
			productDto.setPid(product.getProductId());
			productDto.setPtype(product.getProductType());
			productDto.setPname(product.getProductName());
			productDto.setPrice(product.getProductPrice());
			productDto.setPstock(product.getProductStock());
			productDto.setTotalsold(product.getProductTotalsold());
			productDto.setStar(product.getProductStar());
			productDto.setPStatus(product.isProductStatus());
			
			productDtos.add(productDto);
		}
		return productDtos;
	}
	
	public ProductDto getProduct(String productId) {
		Product product = productDao.getProduct(Integer.parseInt(productId));
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setPtype(product.getProductType());
		productDto.setPname(product.getProductName());		
		productDto.setPrice(product.getProductPrice());
		productDto.setPstock(product.getProductStock());
		productDto.setTotalsold(product.getProductTotalsold());
		productDto.setStar(product.getProductStar());
		productDto.setPStatus(product.isProductStatus());
		
		return productDto;		
	}
	
	public void appendProduct(String productType,String productName,String productPrice,String productStock) {
		//boolean status = true;
		
		Product product = new Product();
		product.setProductType(Integer.parseInt(productType));
		product.setProductName(productName);
		product.setProductPrice(Integer.parseInt(productPrice));
		product.setProductStock(Integer.parseInt(productStock));
		
	}
	
	public void deleteProduct(String productId) {
		productDao.deleteProduct(Integer.parseInt(productId));
	}
}
