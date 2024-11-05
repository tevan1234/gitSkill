package com.example.dao;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.model.Employee;

public class EmployeeDAOFileImpl implements EmployeeDAO{

	private static SortedMap<Integer, Employee>employees = new TreeMap<>();
	private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy",Locale.US);
	private String fileName;
	
	public EmployeeDAOFileImpl(String fileName) {
		this.fileName = fileName;
	}
	
	private void syncData() throws DAOException{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			employees.clear();
			String data;
			while ((data = br.readLine())!= null && data.trim().length() != 0){//trim 刪除前後的空格
				try {
					String []detail = data.split("\\|");
					int id = Integer.parseInt(detail[0]);
					String firstname = detail[1];
					String lastname = detail[2];
					Date bDate = df.parse(detail[3]);//throw ParseException
					float salary = Float.parseFloat(detail[4]);
					Employee emp = new Employee(id, firstname, lastname, bDate, salary);
					employees.put(id, emp);
				}
				catch (ParseException |NumberFormatException e) {//|ArrayIndexOutOfBounds
					System.err.println("檔案轉換失敗:"+data);
				}
			}			
		} catch (IOException ex) {
			throw new DAOException("資料讀取失敗",ex);
		}
	}
	
	public void commit() throws DAOException{
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
			Set<Integer> index = employees.keySet();
			for(Integer i:index) {
				Employee emp = employees.get(i);
				String detail = String.format("%d|%s|%s|%s|%.2f",
						emp.getId(),emp.getFirstName(),
						emp.getLastName(),df.format(emp.getBirthDate()),
						emp.getSalary());
				pw.println(detail);
			}
			pw.flush();
		} catch (IOException ex) {
			throw new DAOException("資料寫出失敗",ex);
		}
	}
	
	@Override
	public void add(Employee emp) throws DAOException {
		int id = emp.getId();
		if(employees.containsKey(id))
			throw new DAOException(id+"號員工已存在,資料新增失敗!");
		employees.put(id, emp);
		commit();
	}
	@Override
	public void update(Employee emp) throws DAOException {
		int id = emp.getId();
		if(employees.containsKey(id))
			throw new DAOException(id+"號員工已存在,資料更新失敗!");
		employees.put(id, emp);	
		commit();
	}
	@Override
	public void delete(int id) throws DAOException {
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在,資料刪除失敗!");
		employees.remove(id);	
		commit();
	}
	@Override
	public Employee findById(int id) throws DAOException {
		syncData();
		Employee emp = employees.get(id);
		if(emp == null)
			throw new DAOException(id+"號員工不存在,資料刪除失敗!");
		return emp;
	}
	@Override
	public Employee[] getAllEmployees() throws DAOException {
		syncData();
		Collection<Employee>emps = employees.values();
		return emps.toArray(new Employee[0]);
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
