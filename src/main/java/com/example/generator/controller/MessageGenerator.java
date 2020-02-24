package com.example.generator.controller;

import com.example.generator.entity.Address;
import com.example.generator.entity.BasicProfile;
import com.example.generator.entity.Order;
import com.example.generator.entity.Product;
import com.example.generator.entity.Recipient;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

@RestController
public class MessageGenerator {

	@GetMapping("/hi")
	public @ResponseBody Order generator() throws IOException, TimeoutException {

		Order order1 = createSampleOrder1();

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setVirtualHost("/hello");
		try (Connection connection = factory.newConnection();
				Channel channel = connection.createChannel()) {
			channel.queueDeclare("Assignment1", false, false, false, null);
			channel.basicPublish("", "Assignment1", null, order1.toString().getBytes());
			System.out.println(" [x] Sent ");
		}
		return order1;
	}

	private Order createSampleOrder1() {
		Order order = new Order();
		Recipient recipient = new Recipient();
		Product product1 = new Product();
		Product product2 = new Product();
		BasicProfile basicProfile = new BasicProfile();
		Address address1 = new Address();
		Address address2 = new Address();

		basicProfile.setEmail("shashwat@upgrad.com");
		basicProfile.setName("Shashwat");
		basicProfile.setPhoneNumber("9876543210");

		address1.setAddressType(Address.AddressType.BILLING);
		address1.setLine1("A1Line1");
		address1.setLine2("A1Line2");
		address1.setCity("Ahmedabad");
		address1.setState("Gujarat");
		address1.setCountry("India");

		address2.setAddressType(Address.AddressType.DELIVERY);
		address2.setLine1("A2Line1");
		address2.setLine2("A2Line2");
		address2.setCity("Mumbai");
		address2.setState("Maharashtra");
		address2.setCountry("India");

		recipient.setBasicProfile(basicProfile);
		recipient.setAddresses(new ArrayList<>());
		recipient.getAddresses().add(address1);
		recipient.getAddresses().add(address2);

		order.setOrderId("123");
		order.setRecipient(recipient);

		return order;
	}

	private Order createSampleOrder2() {
		Order order = new Order();
		Recipient recipient = new Recipient();
		Product product1 = new Product();
		Product product2 = new Product();
		BasicProfile basicProfile = new BasicProfile();
		Address address1 = new Address();
		Address address2 = new Address();

		basicProfile.setEmail("mehta@gmail.com");
		basicProfile.setName("Mehta");
		basicProfile.setPhoneNumber("9876543210");

		address1.setAddressType(Address.AddressType.BILLING);
		address1.setLine1("A1Line1");
		address1.setLine2("A1Line2");
		address1.setCity("Ahmedabad");
		address1.setState("Gujarat");
		address1.setCountry("India");

		address2.setAddressType(Address.AddressType.DELIVERY);
		address2.setLine1("A2Line1");
		address2.setLine2("A2Line2");
		address2.setCity("Mumbai");
		address2.setState("Maharashtra");
		address2.setCountry("India");

		recipient.setBasicProfile(basicProfile);
		recipient.setAddresses(new ArrayList<>());
		recipient.getAddresses().add(address1);
		recipient.getAddresses().add(address2);

		order.setOrderId("345");
		order.setRecipient(recipient);

		return order;
	}
}
