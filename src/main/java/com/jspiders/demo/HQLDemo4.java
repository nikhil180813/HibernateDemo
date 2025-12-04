package com.jspiders.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.Scanner;

public class HQLDemo4 {
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

        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();

        JpaCriteriaQuery<Users> query = cb.createQuery(Users.class);

        JpaRoot<Users> table = query.from(Users.class);

        System.out.println("Enter the mobile number: ");
        String mobile = sc.next();
        JpaPredicate condition1 = cb.equal(table.get("mobile"), mobile);

        System.out.println("Enter the password: ");
        String password = sc.next();
        JpaPredicate condition2 = cb.equal(table.get("password"),password);

        query.select(table).where(condition1,condition2);

        Query<Users> query1 = session.createQuery(query);

        Users users = query1.uniqueResult();

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
