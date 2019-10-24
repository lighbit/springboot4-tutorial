package com.zulkarnaen.sprinboot4.dao;

import java.util.List;

import com.zulkarnaen.sprinboot4.model.Employee;

public interface EmployeeDao {
	void saveInDatabase(Employee employee);

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);
}
