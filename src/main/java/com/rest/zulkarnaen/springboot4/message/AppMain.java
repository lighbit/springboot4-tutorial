package com.rest.zulkarnaen.springboot4.message;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rest.zulkarnaen.springboot4.model.Application;
import com.rest.zulkarnaen.springboot4.model.Communication;
import com.rest.zulkarnaen.springboot4.model.Driver;
import com.rest.zulkarnaen.springboot4.model.Employee;
import com.rest.zulkarnaen.springboot4.model.Performer;
import com.rest.zulkarnaen.springboot4.service.HelloWorldservice;

public class AppMain {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorldservice bean = (HelloWorldservice) context.getBean("helloWorldBean");
		bean.sayHello("Spring 4");
		context.close();

		AbstractApplicationContext contextXml = new ClassPathXmlApplicationContext("SpringbootConfiguration.xml");
		Communication app = (Communication) contextXml.getBean("communication");
		app.communicate();

		// autowire=byName
		Application application = (Application) contextXml.getBean("application");
		System.out.println("Application Details : " + application);

		// autowire=byType
		Employee employee = (Employee) contextXml.getBean("employee");
		System.out.println("Employee Details : " + employee);

		// autowire=constructor
		Performer performer = (Performer) contextXml.getBean("performer");
		System.out.println("Performer Details : " + performer);

		// autowire=default
		Driver driver = (Driver) contextXml.getBean("driver");
		System.out.println("Driver Details : " + driver);

		// TODO: CLOSE XML READ
		contextXml.close();
	}

	/*
	 * TODO: LIAT springbootconfiguration.xml
	 * 
	 * TODO:AnnotationConfigApplicationContext membuat Spring Application Context
	 * menerima input sebagai kelas konfigurasi kami yang dijelaskan
	 * dengan @Configuration, mendaftarkan semua bean yang dihasilkan oleh kelas
	 * konfigurasi dalam runtime Spring. Setelah kita mengkonfigurasi konteks, kita
	 * dapat menggunakan metode getBean untuk mengambil bean tertentu dari konteks
	 * aplikasi Spring dan melakukan beberapa tindakan pada itu
	 */

	/*
	 * TODO: DIFERENT AUTOWIRE BY NAME, BY TYPE, CONSTRUCTOR, DEFAULT Dalam
	 * pendekatan ini, bean dapat secara otomatis kabel menggunakan fitur Spring
	 * autowire. Ada 4 opsi yang didukung untuk autowiring.
	 * 
	 * autowire = "byName": Autowiring menggunakan nama properti. Jika bean
	 * ditemukan dengan nama yang sama dengan properti bean lainnya, bean ini akan
	 * ditransfer ke properti bean lainnya. maksudnya jika id nya tidak sama dengan
	 * nama parameternya maka akan null. see :
	 * https://www.mkyong.com/spring/spring-autowiring-by-name/
	 * 
	 * autowire = "byType": Jika bean ditemukan dengan jenis yang sama dengan jenis
	 * properti bean lainnya, bean ini akan ditransfer ke properti bean lainnya.
	 * maksudnya adalah tidak apa apa id nya asal yang penting type nya tidak sama
	 * dengan yang lain. see:
	 * https://www.mkyong.com/spring/spring-autowiring-by-type/
	 * 
	 * autowire = "constructor": Jika bean ditemukan dengan tipe yang sama dengan
	 * argumen konstruktor bean lain, bean ini akan ditransfer ke konstruktor bean
	 * lainnya
	 * 
	 * autowire = "no": No Autowiring. Sama seperti bean yang ditentukan secara
	 * eksplisit menggunakan atribut ‘ref’ Mari kita bahas masing-masing autowiring
	 * dengan sebuah contoh:
	 */

}