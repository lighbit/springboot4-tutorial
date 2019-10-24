package com.zulkarnaen.sprinboot4.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zulkarnaen.sprinboot4.dao.EmployeeDao;
import com.zulkarnaen.sprinboot4.model.Employee;
import com.zulkarnaen.sprinboot4.service.DateService;
import com.zulkarnaen.sprinboot4.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}

	public Employee findBySsn(String ssn) {
		return dao.findBySsn(ssn);
	}

	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	@Autowired
	private DateService dateService;

	@Autowired
	private EmployeeDao employeeDao;

	public void registerEmployee(Employee employee) {
		employee.setAssessmentDate(dateService.getNextAssessmentDate());
		employeeDao.saveInDatabase(employee);
	}

}
