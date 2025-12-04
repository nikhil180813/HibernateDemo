package com.jspiders.project.bms.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OnetoOneDemo {
    private  static SessionFactory sessionFactory = null;

    static{
        System.out.println("1. Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        System.out.println("2. Create sessionFactory");
        sessionFactory = config.buildSessionFactory();
    }

    public static void main(String[] args) {
        System.out.println("Program starts...");

        Session session = sessionFactory.openSession();

        System.out.println("3. close session");
        session.close();

        System.out.println("4. Close session Factory");
        sessionFactory.close();

        System.out.println("Program ends...");
    }
}
