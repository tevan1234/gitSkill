package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;

public class EmployeeDAOMemoryImpl implements EmployeeDAO{

	private Employee[] employeeArrays = new Employee[10];
	
	@Override
	public void add(Employee emp) throws DAOException{
		int id = emp.getId();
		try {
			if(employeeArrays[id]!=null)
				throw new DAOException(id+"號員工已存在，新增失敗!");
			employeeArrays[id] = emp;
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10，新增失敗!",ex);
		}		
	}

	@Override
	public void update(Employee emp) throws DAOException{
		int id = emp.getId();
		try {
			if(employeeArrays[id] == null)
				throw new DAOException(id+"號員工不存在，更新失敗!");
			employeeArrays[id] = emp;
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10，更新失敗!",ex);
		}	
	}

	@Override
	public void delete(int id) throws DAOException{
		try {
			if(employeeArrays[id] == null)
				throw new DAOException(id+"號員工不存在，刪除失敗!");
			employeeArrays[id] = null;
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10，刪除失敗!",ex);
		}
		
	}

	@Override
	public Employee findById(int id) throws DAOException{
		try {
			if(employeeArrays[id] == null)
				throw new DAOException(id+"號員工不存在，查詢失敗!");
			return employeeArrays[id];
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new DAOException("員工編號需小於10，查詢失敗!",ex);
		}
	}

	@Override
	public Employee[] getAllEmployees() {
		List<Employee> emps = new ArrayList<>();
        
        for (Employee e : employeeArrays) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("關閉資源");
	}
}
