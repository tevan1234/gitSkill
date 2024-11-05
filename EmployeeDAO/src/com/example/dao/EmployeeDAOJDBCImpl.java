package com.example.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

	private Connection conn;
	public EmployeeDAOJDBCImpl() {
		String url = "jdbc:mysql://localhost:3306/EmployeeDB";
        String username = "root";
        String password = "root1234";
        
        try {
        	conn = DriverManager.getConnection(url, username, password);
        }catch (SQLException ex) {
			System.out.println("資料庫連線失敗!"+ex);
			System.exit(0);
		}
	}
	
	@Override
	public void add(Employee emp) throws DAOException {
		String sql = "INSERT INTO Employee Values(?,?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(5, emp.getSalary());
			int result = pstmt.executeUpdate();
			if(result != 1)
				throw new DAOException("員工新增失敗!");
		} catch (SQLException ex) {
			throw new DAOException("資料庫新增失敗:",ex);
		}		
	}

	@Override
	public void update(Employee emp) throws DAOException {
		String sql = "UPDATE Employee SET FIRSTNAME = ?,LASTNAME = ?, BIRTHDATE = ?,SALARY = ?,WHERE ID = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(5, emp.getSalary());
			int result = pstmt.executeUpdate();
			if(result != 1)
				throw new DAOException("員工更新失敗!");
		} catch (SQLException ex) {
			throw new DAOException("資料庫更新失敗!",ex);
		}		
	}

	@Override
	public void delete(int id) throws DAOException {
		String sql = "DELETE FROM EMPLOYEE WHERE ID = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			if(result != 1)
				throw new DAOException("員工刪除失敗!");
		}catch (SQLException ex) {
			throw new DAOException("資料庫刪除失敗!",ex);
		}	
	}

	@Override
	public Employee findById(int id) throws DAOException {
		String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
		Employee emp = null;
		try (PreparedStatement pstmt = conn.prepareStatement(query)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				emp = new Employee(rs.getInt("ID"),rs.getString("FIRSTNAME")
						,rs.getString("LASTNAME"),rs.getDate("BIRTHDATE"),rs.getFloat("SALARY"));
			return emp;
		}catch (SQLException ex) {
			throw new DAOException("資料庫查詢失敗!",ex);
		}	
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		String query = "SELECT * FROM EMPLOYEE";
		ArrayList<Employee> emp = new ArrayList<>();
		try (Statement pstmt = conn.createStatement()){
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()) {
				emp.add (new Employee(rs.getInt("ID"),rs.getString("FIRSTNAME")
						,rs.getString("LASTNAME"),rs.getDate("BIRTHDATE"),rs.getFloat("SALARY")));
			}
			return emp.toArray(new Employee[0]);
		}catch (SQLException ex) {
			throw new DAOException("資料庫列印失敗!",ex);
		}
	}

	@Override
	public void close() throws Exception {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException ex) {
			throw new DAOException("資料庫連線關閉失敗!",ex);
		}
	}

}
