package com.tpe.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

       Developer03 ses1=session.get(Developer03.class,1L);
        System.out.println(ses1);
        System.out.println("********************");

        Computer com1=session.get(Computer.class,33L);
        System.out.println(com1);
        System.out.println("********************");
        System.out.println(com1.getDeveloper());

        //id=22 olan computerı kullanan dev bilgilerini getiriniz.



        tx.commit();
        session.close();
        sf.close();


    }
}
