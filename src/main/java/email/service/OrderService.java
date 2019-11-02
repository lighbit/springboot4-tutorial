package email.service;

import email.model.ProductOrder;

public interface OrderService {

	public void sendOrderConfirmation(ProductOrder productOrder);
	
}
