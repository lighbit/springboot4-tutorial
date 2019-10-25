package com.zulkarnaen.sprinboot4;

import java.math.BigDecimal;
import java.util.List;
import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zulkarnaen.sprinboot4.model.Employee;
import com.zulkarnaen.sprinboot4.service.EmployeeService;
import com.zulkarnaen.sprinboot4.service.FileService;

public class AppMain {
	public static void main(String args[]) {
		// TODO: SEARCH BERDASARKAN PACKPAGE
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.zulkarnaen.sprinboot4");
		context.refresh();

		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		/*
		 * Register employee using service
		 */
		Employee employee = new Employee();
		employee.setName("Danny Theys");
		service.registerEmployee(employee);

//		context.close();

		// TODO: SEARCH BERDASARKAN APPCONFIG (BERDASARKAN PACKPAGE JUGA HANYA DARI
		// FILE)
		AbstractApplicationContext contexts = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService services = (EmployeeService) contexts.getBean("employeeService");

		/*
		 * Register employee using service
		 */
		Employee employees = new Employee();
		employees.setName("Danny Theys");
		services.registerEmployee(employees);

		contexts.close();

		// TODO: GET FILE AND SHOW WITH PROPERTY
		FileService serviceProperty = (FileService) context.getBean("fileService");
		serviceProperty.readValues();

//		context.close();

		// TODO: PROFILES
		AbstractApplicationContext contextss = new ClassPathXmlApplicationContext("dev-config-context.xml");
		// Sets the active profiles
		contextss.getEnvironment().setActiveProfiles("Database");
		/*
		 * Perform any logic here
		 */
		contextss.close();

		// TODO: INSERT DELETE SHOW DB WITH HIBERNATE
		EmployeeService serviceHibernate = (EmployeeService) context.getBean("employeeService");

		/*
		 * Create Employee1
		 */
		Employee employee1 = new Employee();
		employee1.setName("Han Yenn");
		employee1.setJoiningDate(new LocalDate(2010, 10, 10));
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("ssn00000001");

		/*
		 * Create Employee2
		 */
		Employee employee2 = new Employee();
		employee2.setName("Dan Thomas");
		employee2.setJoiningDate(new LocalDate(2012, 11, 11));
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00000002");

		serviceHibernate.deleteEmployeeBySsn("ssn00000001");

		/*
		 * Persist both Employees
		 */
		serviceHibernate.saveEmployee(employee1);
		serviceHibernate.saveEmployee(employee2);

		/*
		 * Get all employees list from database
		 */
		List<Employee> employeesHibernate = serviceHibernate.findAllEmployees();
		for (Employee emp : employeesHibernate) {
			System.out.println(emp);
		}

		/*
		 * delete an employee
		 */
		serviceHibernate.deleteEmployeeBySsn("ssn00000002");

		/*
		 * update an employee
		 */

		Employee employeeHibernates = serviceHibernate.findBySsn("ssn00000001");
		employeeHibernates.setSalary(new BigDecimal(50000));
		serviceHibernate.updateEmployee(employeeHibernates);

		/*
		 * Get all employees list from database
		 */
		List<Employee> employeeList = serviceHibernate.findAllEmployees();
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}

		context.close();

		// TODO: SCHEDULER SIMPLE
		AbstractApplicationContext contextSheduler = new ClassPathXmlApplicationContext("sheduler.xml");
//		AbstractApplicationContext contextSheduler = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(contextSheduler);
		
		// TODO: SCHEDULER QUARTZ
		AbstractApplicationContext contextQuartz = new ClassPathXmlApplicationContext("quartz-context.xml");
		System.out.println(contextQuartz);
	}

}
