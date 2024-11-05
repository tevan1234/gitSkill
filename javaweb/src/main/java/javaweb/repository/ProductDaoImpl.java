package javaweb.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javaweb.model.entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao{

	
	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select product_id,product_name,price,stock_quantity from product";
		try (Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				// 建立 product 物件並將資料配置進去
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getString("price"));
				product.setStock_quantity(rs.getInt("stock_quantity"));
				
				// 將 product 物件放到 products 集合中保存
				products.add(product);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	return products;
	}
	
	public void deleteProduct(Integer productId) {
		String sql = "delete from product where product_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, productId);
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
				throw new RuntimeException("刪除失敗 userId:" + productId);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into product(product_name, price, stock_quantity) values(?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, product.getProduct_name());
			pstmt.setString(2, product.getPrice());
			pstmt.setInt(3, product.getStock_quantity());
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
				throw new RuntimeException("新增失敗");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Double> querySalesRanking() {
		String sql = """
				SELECT p.product_name, SUM(o.subtotal) AS total_sales
				FROM orders o
				LEFT JOIN product p ON o.product_id = p.product_id
				GROUP BY p.product_name
				ORDER BY total_sales DESC
				""".trim();
		// 存放銷售排行		
		Map<String, Double> map = new LinkedHashMap<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				
				String key = rs.getString("product_name");
				Double value = rs.getDouble("total_sales");
				// 將排行放到 map 集合中
				map.put(key, value);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
}
