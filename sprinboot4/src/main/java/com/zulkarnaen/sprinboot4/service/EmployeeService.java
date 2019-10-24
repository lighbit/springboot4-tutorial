package com.zulkarnaen.sprinboot4.service;

import java.util.List;

import com.zulkarnaen.sprinboot4.model.Employee;

public interface EmployeeService {
	void registerEmployee(Employee employee);

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);

	Employee findBySsn(String ssn);

	void updateEmployee(Employee employee);
}
