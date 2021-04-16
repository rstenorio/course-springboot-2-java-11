package com.rstenorio.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rstenorio.course.entities.Category;
import com.rstenorio.course.entities.Order;
import com.rstenorio.course.entities.User;
import com.rstenorio.course.entities.enums.OrderStatus;
import com.rstenorio.course.repositories.CategoryRepository;
import com.rstenorio.course.repositories.OrderRepository;
import com.rstenorio.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Book");
		Category cat2 = new Category(null, "Uomini");
		Category cat3 = new Category(null, "Donne");

		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "RodrigoS", "rodrigoS@gmail.com", "9999-8888", "0000");
		User u2 = new User(null, "RodrigoT", "rodrigoT@gmail.com", "9999-7777", "0001");
		
		Order o1 = new Order(null, Instant.parse("2021-04-14T09:54:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-04-13T09:54:07Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-04-12T09:54:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	
	}
	
}
