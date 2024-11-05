package shoppingSite.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shoppingSite.model.entity.User;


public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		String sql = "select user_id,user_role,user_phone,user_mail,user_account,user_salt,user_passwordHash,user_active from user";
		try(Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(sql)){//沒有帶參數的直接用Statement
			while(rs.next()){
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserRole(rs.getInt("user_role"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserMail(rs.getString("user_mail"));
				user.setAccount(rs.getString("user_account"));
				user.setSalt(rs.getString("user_salt"));
				user.setPasswordHash(rs.getString("user_passwordHash"));
				user.setUserActive(rs.getBoolean("user_active"));
				users.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUser(String userAccount) {
		String sql = "select user_id,user_role,user_phone,user_mail,user_account,user_salt,user_passwordHash,user_active from user where user_account=?";//不能使用"... where user_account=" + user_account
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){//有帶參數的要用PreparedStatement
			pstmt.setString(1, userAccount);
			
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) { //若有得到資料
					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setUserRole(rs.getInt("user_role"));
					user.setUserPhone(rs.getString("user_phone"));
					user.setUserMail(rs.getString("user_mail"));
					user.setAccount(rs.getString("user_account"));
					user.setSalt(rs.getString("user_salt"));
					user.setPasswordHash(rs.getString("user_passwordHash"));
					user.setUserActive(rs.getBoolean("user_active"));
					return user;
				}			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into user(user_phone,user_mail,user_account,user_salt,user_passwordHash,user_active) values(?,?,?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
			pstmt.setString(1, user.getUserPhone());
			pstmt.setString(2, user.getUserMail());
			pstmt.setString(3, user.getAccount());
			pstmt.setString(4, user.getSalt());
			pstmt.setString(5, user.getPasswordHash());
			pstmt.setBoolean(6, user.getUserActive());
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount!=1)
				throw new RuntimeException("新增失敗");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateUserActive(Integer userId, Boolean active) {
		String sql = "update user set user_active = ? where user_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setBoolean(1, active);
			pstmt.setInt(2, userId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
				throw new RuntimeException("修改失敗 userId:" + userId + " active:" + active);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateUserRole(Integer userId, Integer role) {
		String sql = "update user set user_role = ? where user_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, role);
			pstmt.setInt(2, userId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
				throw new RuntimeException("修改失敗 userId:" + userId + " role:" + role);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUserInfo(Integer userId,String phone,String email) {
		String sql = "update user set user_phone = ?,user_mail = ? where user_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, phone);
			pstmt.setString(2, email);
			pstmt.setInt(3, userId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
				throw new RuntimeException("修改失敗 userId:" + userId + " phone:" + phone + " email:" + email);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePasswordHash(Integer userId, String newPasswordHash) {
		String sql = "update user set user_passwordHash = ? where user_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, newPasswordHash);
			pstmt.setInt(2, userId);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(Integer userId) {
		String sql = "delete from user where user_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, userId);
			
			int rowcount = pstmt.executeUpdate();
			if(rowcount != 1) {
				throw new RuntimeException("刪除失敗 userId:" + userId);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
