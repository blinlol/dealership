package com.dealership.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dealership.models.Brand;

import static java.lang.System.out;

import junit.framework.TestCase;


public class BrandTests extends TestCase {
    private SessionFactory sessionFactory;
    
    @Override
    protected void setUp() {
        final StandardServiceRegistry registry =
				new StandardServiceRegistryBuilder()
						.build();
		try {
			sessionFactory =    
					new MetadataSources(registry)
							.addAnnotatedClass(Brand.class)
							.buildMetadata()
							.buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we
			// had trouble building the SessionFactory so destroy it manually.
            out.println("Error: " + e.getMessage());
			StandardServiceRegistryBuilder.destroy(registry);
		}
    }

    @Override
	protected void tearDown() {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	// public void testGetId(){

	// }

    public void testSelect() {
		// // create a couple of events...
		// sessionFactory.inTransaction(session -> {
		// 	session.persist(new Event("Our very first event!", now()));
		// 	session.persist(new Event("A follow up event", now()));
		// });

		// now lets pull events from the database and list them
		sessionFactory.inTransaction(session -> {
			session.createSelectionQuery("from Brand", Brand.class).getResultList()
					.forEach(brand -> out.println("Brand (" + brand.getId() + ") : " + brand.getName()));
		});
	}
}
