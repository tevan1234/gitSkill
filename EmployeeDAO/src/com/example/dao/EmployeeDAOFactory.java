package com.example.dao;

public class EmployeeDAOFactory {
	public EmployeeDAO createEmployeeDAO() {
		//return new EmployeeDAOMemoryImpl();
		//return new EmployeeDAOMapImpl();
		//return new EmployeeDAOFileImpl("employees.txt");
		return new EmployeeDAOJDBCImpl();
	}
}
