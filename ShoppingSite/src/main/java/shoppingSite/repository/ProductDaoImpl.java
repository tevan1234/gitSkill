package shoppingSite.repository;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoppingSite.model.entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao{

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select Product_id, Product_type, Product_name, Product_price, Product_stock, Product_Totalsold, Product_star from product";
		try (Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(sql)){
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("Product_id"));
				product.setProductType(rs.getInt("Product_type"));
				product.setProductName(rs.getString("Product_name"));
				product.setProductPrice(rs.getInt("Product_price"));
				product.setProductStock(rs.getInt("Product_stock"));
				product.setProductTotalsold(rs.getInt("Product_Totalsold"));
				product.setProductStar(rs.getDouble("Product_star"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProduct(Integer productId) {
		String sql = "select Product_type, Product_name, Product_price, Product_stock, Product_Totalsold, Product_star, Product_status from product where Product_id = ? ";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, productId);
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					Product product = new Product();
					product.setProductType(rs.getInt("Product_type"));
					product.setProductName(rs.getString("Product_name"));
					product.setProductPrice(rs.getInt("Product_price"));
					product.setProductStock(rs.getInt("Product_stock"));
					product.setProductTotalsold(rs.getInt("Product_Totalsold"));
					product.setProductStar(rs.getDouble("Product_star"));
					product.setProductStatus(rs.getBoolean("Product_status"));
					
					return product;
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into product(Product_type, Product_name, Product_price, Product_stock, Product_Totalsold, Product_star, Product_status) vlues(?,?,?,?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, product.getProductType());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getProductPrice());
			pstmt.setInt(4, product.getProductStock());
			pstmt.setInt(5, product.getProductTotalsold());
			pstmt.setDouble(6, product.getProductStar());
			pstmt.setBoolean(7, product.isProductStatus());
			
			int  rowcount = pstmt.executeUpdate();
			if(rowcount!=1)
				throw new RuntimeException("新增失敗");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterProductPrice(Integer productId, Integer productPrice) {
		String sql = "update product Product_price = ? where Product_id = ? ";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, productPrice);
			pstmt.setInt(2, productId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount!=1)
				throw new RuntimeException("修改失敗 productId:" + productId + "productPrice:" + productPrice );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterProductStock(Integer productId, Integer Restock) {
		String sql = "update product Product_stock = ? where Product_id = ? ";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, Restock);
			pstmt.setInt(2, productId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount!=1)
				throw new RuntimeException("修改失敗 productId:" + productId + "productStock: " + Restock);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterProductStatus(Integer productId, boolean productStatus) {
		String sql = "update product Product_status = ? where Product_id = ? ";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setBoolean(1, productStatus);
			pstmt.setInt(2, productId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount!=1)
				throw new RuntimeException("修改失敗 productId:" + productId + "productStatus:" + productStatus);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Integer productId) {
		String sql = "delete from product where Product_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, productId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount!=1)
				throw new RuntimeException("刪除失敗 productId:" + productId );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
