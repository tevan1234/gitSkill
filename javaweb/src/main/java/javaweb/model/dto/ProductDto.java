package javaweb.model.dto;

import lombok.Data;

@Data
public class ProductDto {
	private Integer product_id;
	private String product_name;
	private String price;
	private Integer stock_quantity;
}
