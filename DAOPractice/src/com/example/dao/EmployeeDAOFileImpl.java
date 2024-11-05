package com.example.dao;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.model.Employee;

public class EmployeeDAOFileImpl implements EmployeeDAO {

	static Map<Integer,Employee>employees;
	private SimpleDateFormat df = new SimpleDateFormat("MMM d,yyyy");
	private String FileName;
	
	public EmployeeDAOFileImpl(String fileName) {
		super();
		this.employees = new TreeMap<>();
		this.FileName = fileName;
	}
	
	private void syncData() throws DAOException{
		try (BufferedReader br = new BufferedReader(new FileReader(FileName))){
			employees.clear();
			String line;
			while((line = br.readLine()) != null && line.trim().length()!=0) {
				String [] data = line.split("\\|");
				try {
					int id = Integer.parseInt(data[0]);
					String fname = data[1];
					String lname = data[2];
					Date bDate = df.parse(data[3]);
					float salary = Float.parseFloat(data[4]); 
					Employee emp = new Employee(id, fname, lname, bDate, salary);
					employees.put(id, emp);
				}catch (ParseException|NumberFormatException|ArrayIndexOutOfBoundsException e) {
					System.err.println("本列資料錯誤"+line);
				}
			}
		} catch (IOException e) {
			throw new DAOException("檔案讀取失敗!");
		}
	}
	
	private void commit() throws DAOException{
		try (PrintWriter pw = new PrintWriter(FileName)){
			Set <Integer> index = employees.keySet();
			for(Integer i:index) {
				Employee emp = employees.get(i);
				pw.printf("%d|%s|%s|%s%.2f", emp.getId(),emp.getFirstName(),emp.getLastName(),df.format(emp.getBirthDate()),emp.getSalary());
			}
			pw.flush();
		} catch (IOException e) {
			throw new DAOException("檔案輸出失敗!");
		}
	}
	@Override
	public void add(Employee emp) throws DAOException {
		int id = emp.getId();
		if(employees.containsKey(id))
			throw new DAOException(id+"號員工已存在，新增失敗!");
		employees.put(id, emp);	
		this.commit();
	}

	@Override
	public void update(Employee emp) throws DAOException {
		int id = emp.getId();
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在，更新失敗!");
		employees.put(id, emp);	
		this.commit();
	}

	@Override
	public void delete(int id) throws DAOException {
		if(!employees.containsKey(id))
			throw new DAOException(id+"號員工不存在，刪除失敗!");
		employees.remove(id);	
		this.commit();
	}

	@Override
	public Employee findById(int id) throws DAOException {
		this.syncData();
		return employees.get(id);
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		this.syncData();
		Collection<Employee>emps = employees.values();
		return emps.toArray(new Employee[emps.size()]);
	}

	@Override
	public void close() throws Exception {
		System.out.println("關閉資源");
		
	}
}
