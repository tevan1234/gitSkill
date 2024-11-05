package javaweb.model.entity;

import lombok.Data;

@Data
public class Product {
	private Integer product_id;
	private String product_name;
	private String price;
	private Integer stock_quantity;
}
