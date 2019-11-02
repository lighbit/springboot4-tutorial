package email;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import email.model.CustomerInfo;
import email.model.ProductOrder;
import email.service.OrderService;

public class SampleEmailApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.sendOrderConfirmation(getDummyOrder());
		((AbstractApplicationContext) context).close();
	}

	public static ProductOrder getDummyOrder() {
		ProductOrder order = new ProductOrder();
		order.setOrderId("1111");
		order.setProductName("Thinkpad T510");
		order.setStatus("confirmed");

		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName("Zulkarnaen");
		customerInfo.setAddress("Kadugadung");
		customerInfo.setEmail("sekaizulka.sz@gmail.com");
		order.setCustomerInfo(customerInfo);
		return order;
	}

}
