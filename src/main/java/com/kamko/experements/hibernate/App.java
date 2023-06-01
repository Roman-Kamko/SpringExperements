package com.kamko.experements.hibernate;

import com.kamko.experements.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();
            session.beginTransaction();
            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);
            session.save(emp);
            session.getTransaction().commit();
        }
    }
}
