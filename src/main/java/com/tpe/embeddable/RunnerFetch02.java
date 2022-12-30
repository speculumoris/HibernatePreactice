package com.tpe.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer02.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*1- id=1 olan developerın tüm bilgilerini yazdırınız.

        String hqlQuery1 = "FROM Developer02 dev WHERE dev.id=1";
        List<Developer02> resultList2 = session.createQuery(hqlQuery1).getResultList();

        System.out.println(resultList2);
        //2- id=1 olan developerın sadece eğitim bilgilerini yazdırınız.
        String hqlQuery2 = "Select dev.education FROM Developer02 dev WHERE dev.id=1";
        List<Education>resultlist3=session.createQuery(hqlQuery2).getResultList();
        System.out.println(resultList2);
         */

        //1- id=1 olan developerın tüm bilgilerini yazdırınız.
        Developer02 dev=session.get(Developer02.class,1L);
        System.out.println(dev);

        //2- id=1 olan developerın sadece eğitim bilgilerini yazdırınız.
        System.out.println(dev.getEducation());


        tx.commit();
        session.close();
        sf.close();
    }
}
