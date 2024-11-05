package com.example.dao;
import java.util.*;
import com.example.model.Employee;

public class EmployeeDAOMapImpl implements EmployeeDAO {
	private SortedMap<Integer,Employee> employees = new TreeMap<>();//TreeMap方便查詢且可排序
	@Override
	public void add(Employee emp) throws DAOException {		
		int id = emp.getId();
		if(employees.containsKey(id))
			throw new DAOException(id+"號員工已存在,資料新增失敗!");
		employees.put(id, emp);			
	}

	@Override
	public void update(Employee emp) throws DAOException {
		int id = emp.getId();
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在,資料更新失敗!");
		employees.put(id, emp);			
	}

	@Override
	public void delete(int id) throws DAOException {
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在,資料刪除失敗!");
		employees.remove(id);			
	}

	@Override
	public Employee findById(int id) throws DAOException {
		Employee emp = employees.get(id);
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在,資料查詢失敗!");
		return emp;
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		return employees.values().toArray(new Employee[0]);
	}

	@Override
	public void close() throws Exception {
		System.out.print("程式結束,關閉資源!");		
	}
}
