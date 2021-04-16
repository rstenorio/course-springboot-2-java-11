package com.rstenorio.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rstenorio.course.entities.Category;
import com.rstenorio.course.entities.Order;
import com.rstenorio.course.entities.Product;
import com.rstenorio.course.entities.User;
import com.rstenorio.course.entities.enums.OrderStatus;
import com.rstenorio.course.repositories.CategoryRepository;
import com.rstenorio.course.repositories.OrderRepository;
import com.rstenorio.course.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Book");
		Category cat2 = new Category(null, "Uomini");
		Category cat3 = new Category(null, "Donne");

		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		
		User u1 = new User(null, "RodrigoS", "rodrigoS@gmail.com", "9999-8888", "0000");
		User u2 = new User(null, "RodrigoT", "rodrigoT@gmail.com", "9999-7777", "0001");
		
		Order o1 = new Order(null, Instant.parse("2021-04-14T09:54:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-04-13T09:54:07Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-04-12T09:54:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	
	}
	
}
