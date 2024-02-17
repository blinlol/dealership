package com.dealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import static java.lang.System.out;

import java.time.Instant;

import com.dealership.DAO.Brand;

@SpringBootApplication
public class DealershipApplication {
	public static void main(String[] args) {
		SpringApplication.run(DealershipApplication.class, args);
	
		// SessionFactory sessionFactory;
		// // A SessionFactory is set up once for an application!
		// final StandardServiceRegistry registry =
		// new StandardServiceRegistryBuilder()
		// 		.build();
		// try {
		// 	sessionFactory =
		// 			new MetadataSources(registry)
		// 					.addAnnotatedClass(Brand.class)
		// 					.buildMetadata()
		// 					.buildSessionFactory();
		// 	Brand oneBrand = new Brand("time: " + Instant.now().toString());
		// 	// var sessionFactory.getCurrentSession().byId("3");  //  .persist(oneBrand);
		// 	// System.out.println(null);
		// 	sessionFactory.inTransaction(session -> {   
		// 		session.persist(new Brand("Timed1: " + Instant.now()));   
		// 		session.persist(new Brand("Timed2: " + Instant.now()));
		// 	});

		// 	sessionFactory.inTransaction(session -> {
		// 		session.createSelectionQuery("from Brand", Brand.class)   
		// 				.getResultList()   
		// 				.forEach(b -> out.println("Brand (" + b.getId() + ") : " + b.getName()));
		// 	});
		// }
		// catch (Exception e) {
		// 	e.printStackTrace();
		// 	StandardServiceRegistryBuilder.destroy(registry);
		// }

	}

}
