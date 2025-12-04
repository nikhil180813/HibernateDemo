package com.jspiders.project.bms.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mainclass {
    private  static SessionFactory sessionFactory = null;

    static{
        System.out.println("1. Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        System.out.println("2. Create sessionFactory");
        sessionFactory = config.buildSessionFactory();
    }
}
