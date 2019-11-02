package email.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;

import email.model.ProductOrder;
import freemarker.template.Configuration;

@SuppressWarnings("deprecation")
@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	VelocityEngine velocityEngine;

	@Autowired
	Configuration freemarkerConfiguration;

	public void sendEmail(Object object) {

		ProductOrder order = (ProductOrder) object;

		MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(order);

		try {
			// TODO: SEND WITH FILE
//			mailSender.send(preparator);
			System.out.println("Message With Attachement has been sent.............................");

			// TODO: SEND WITH IMAGE INSIDE
			preparator = getContentAsInlineResourceMessagePreparator(order);
//			mailSender.send(preparator);
			System.out.println("Message With Inline Resource has been sent.........................");

			// TODO: SEND WITH TEMPLATE
			preparator = getMessagePreparator(order);
			mailSender.send(preparator);
			System.out.println("Message With Inline Resource has been sent.........................");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getContentWtihAttachementMessagePreparator(final ProductOrder order) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setSubject("Your order on Demoapp with attachement");
				helper.setFrom("customerserivces@yourshop.com");
				helper.setTo(order.getCustomerInfo().getEmail());
				String content = "Dear " + order.getCustomerInfo().getName()
						+ ", thank you for placing order. Your order id is " + order.getOrderId() + ".";

				helper.setText(content);

				// Add a resource as an attachment
				helper.addAttachment("tokopedia.gif", new ClassPathResource("tokopedia.gif"));

			}
		};
		return preparator;
	}

	private MimeMessagePreparator getContentAsInlineResourceMessagePreparator(final ProductOrder order) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				helper.setSubject("Your order on Demoapp with Inline resource");
				helper.setFrom("customerserivces@yourshop.com");
				helper.setTo(order.getCustomerInfo().getEmail());

				String content = "Dear " + order.getCustomerInfo().getName()
						+ ", thank you for placing order. Your order id is " + order.getOrderId() + ".";

				// Add an inline resource.
				// use the true flag to indicate you need a multipart message
				helper.setText("<html><body><p>" + content + "</p><img src='cid:tokopedia'></body></html>", true);
				helper.addInline("tokopedia", new ClassPathResource("tokopedia.gif"));
			}
		};
		return preparator;
	}

	private MimeMessagePreparator getMessagePreparator(final ProductOrder order) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setSubject("Your order on Demoapp with Templates");
				helper.setFrom("customerserivces@yourshop.com");
				helper.setTo(order.getCustomerInfo().getEmail());

				Map<String, Object> model = new HashMap<String, Object>();
				model.put("order", order);

				String text = geFreeMarkerTemplateContent(model);// Use Freemarker or Velocity
				System.out.println("Template content : " + text);

				// use the true flag to indicate you need a multipart message
				helper.setText("<html><body><p>" + text + "</p><img src='cid:tokopedia'></body></html>", true);

				// Additionally, let's add a resource as an attachment as well.
				helper.addInline("tokopedia", new ClassPathResource("tokopedia.gif"));

			}
		};
		return preparator;
	}

	public String geVelocityTemplateContent(Map<String, Object> model) {
		StringBuffer content = new StringBuffer();
		try {
			content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					"/vmtemplates/velocity_mailTemplate.vm", model));
			return content.toString();
		} catch (Exception e) {
			System.out.println("Exception occured while processing velocity template:" + e.getMessage());
		}
		return "";
	}

	public String geFreeMarkerTemplateContent(Map<String, Object> model) {
		StringBuffer content = new StringBuffer();
		try {
			content.append(FreeMarkerTemplateUtils
					.processTemplateIntoString(freemarkerConfiguration.getTemplate("fm_mailTemplate.txt"), model));
			return content.toString();
		} catch (Exception e) {
			System.out.println("Exception occured while processing fmtemplate:" + e.getMessage());
		}
		return "";
	}

}
