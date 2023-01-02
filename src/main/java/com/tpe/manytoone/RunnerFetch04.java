package com.tpe.manytoone;

import com.tpe.onetoone.Computer;
import com.tpe.onetoone.Developer03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

       Developer04 ses1=session.get(Developer04.class,2L);
        System.out.println(ses1);
        System.out.println("********************");
        System.out.println(ses1.getCompany());
        System.out.println("********************");
        System.out.println("********************");


        String hqlQuery ="SELECT s.name,d.companyname FROM t_developer04 s INNER JOIN company d on s.id=d.id ";
        List<Object[]>obj1=session.createSQLQuery(hqlQuery).getResultList();
        obj1.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });



        //3--Googleda çalışan developerların ismini ve branchini görüntüleyiniz.***ÖDEV***



        tx.commit();
        session.close();
        sf.close();


    }
}
