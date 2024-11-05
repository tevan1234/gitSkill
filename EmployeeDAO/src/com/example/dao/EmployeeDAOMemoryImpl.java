package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.model.Employee;

public class EmployeeDAOMemoryImpl implements EmployeeDAO{
	private Employee[] employeeArray = new Employee[10]; //陣列為固定大小無法排序，不實用
	
	@Override
	public void add(Employee emp) throws DAOException{
		int id = emp.getId();
		try {
			if(employeeArray[id]!=null)
				throw new DAOException(id+"號員工已存在,資料新增失敗!");
			employeeArray[id]=emp;
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10,新增失敗!");
		}		
	}

	@Override
	public void update(Employee emp) throws DAOException{
		int id = emp.getId();
		try {
			if(employeeArray[id]==null)
				throw new DAOException("員工不存在,資料更新失敗!");
			employeeArray[id] = emp;
		}
		catch(ArrayIndexOutOfBoundsException ex){
			throw new DAOException("員工編號需小於10,資料更新失敗!",ex);
		}
		
	}

	@Override
	public void delete(int id) throws DAOException{
		try {
			if(employeeArray[id] == null)
				throw new DAOException("員工不存在,資料刪除失敗!");
			employeeArray[id] = null;
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10,資料刪除失敗!",ex);
		}
		 
	}

	@Override
	public Employee findById(int id) throws DAOException{
		try {
			if(employeeArray[id] == null)
				throw new DAOException("員工不存在,資料查詢失敗!");
			return employeeArray[id];
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10,資料查詢失敗!");
		}		 
	}

	@Override
	public Employee[] getAllEmployees() {
		 List<Employee> emps = new ArrayList<>();
	        // Iterate through the memory array and find Employee objects
	        for (Employee e : employeeArray) {
	            if (e != null) {
	                emps.add(e);
	            }
	        }
	        return emps.toArray(new Employee[0]);
	}
	
	public void close() {
		System.out.print("程式結束,關閉資源!");
	}
}
