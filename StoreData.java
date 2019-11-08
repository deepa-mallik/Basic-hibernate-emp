package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
public static void main(String[] args) {
	
	//creating configuration object
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
	
	//creating session factory object
	SessionFactory factory=cfg.buildSessionFactory();
	
	//creating session object
	Session session=factory.openSession();
	
	//creating transaction object
	Transaction t=session.beginTransaction();
		
	Employee employee=new Employee(); // can also keep instance null- Employee employee = null; as we are creating instance while session.get() 
	
//	employee.setId(104);                           Data already present in the database no need of creating while fetching
//	employee.setFirstName("Roshan");
//	employee.setLastName("Marlia");
	
	//session.persist(employee);//persisting the object
	
	employee = (Employee)session.get(Employee.class, 103);    //fetch data from data base
	
	t.commit();//transaction is commited
	session.close();
	
	System.out.println(employee);
	System.out.println("successfully saved");
	
}
}

