package shoppingSite.model.entity;

import lombok.Data;

/*建立產品資料庫
CREATE TABLE `product` (
  `Product_id` int NOT NULL AUTO_INCREMENT,
  `Product_type` int DEFAULT NULL,
  `Product_name` varchar(20) DEFAULT NULL,
  `Product_price` int DEFAULT NULL,
  `Product_stock` int DEFAULT NULL,
  `Product_Totalsold` int DEFAULT NULL,
  `Product_star` decimal(1,1) DEFAULT NULL,
  `Product_status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`Product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */

@Data
public class Product {
	private Integer ProductId;
	private Integer ProductType;
	private String  ProductName;
	private Integer ProductPrice;
	private Integer ProductStock;
	private Integer ProductTotalsold;
	private Double ProductStar;
	private boolean ProductStatus;
}
