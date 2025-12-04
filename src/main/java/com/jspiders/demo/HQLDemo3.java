package com.jspiders.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class HQLDemo3 {
    public static void login(){
        System.out.println("Program starts...");

        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("SessionFactory created");

        //get session from session factory
        Session session = sessionFactory.openSession();//connect to db
        System.out.println("Session created");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mobile number");
        String mobile = sc.next();
        System.out.println("Enter the password");
        String password = sc.next();

        String findUserByMobileAndPassword_HQL = "FROM Users usr WHERE usr.mobile = :mobile AND usr.password = :password";
        Query<Users> query = session.createQuery(findUserByMobileAndPassword_HQL, Users.class);
        query.setParameter("mobile",mobile);
        query.setParameter("password",password);
        Users users = query.uniqueResult();
        if(users != null){
            System.out.println();
            System.out.println("Login successful!!!");
            System.out.println();
        }
        else{
            System.out.println();
            System.err.println("Login Failed!!!");
            System.out.println();
        }

        //close session
        session.close();
        System.out.println("Session closed");
        //close session factory
        sessionFactory.close();
        System.out.println("SessionFactory closed");


        System.out.println("Program ends...");
    }
    public static void main(String[] args) {
        login();
    }
}
