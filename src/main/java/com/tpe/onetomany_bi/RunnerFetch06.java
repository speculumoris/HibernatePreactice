package com.tpe.onetomany_bi;

import com.tpe.onetomany.Company2;
import com.tpe.onetomany.Developer05;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1--Amazonda çalışan developer bilgilerini getiriniz.
       // String hqlQuery="From Company3 s  where s.companyname='Amazon'";
       // Company3 com1=session.createQuery(hqlQuery,Company3.class).uniqueResult();
       // System.out.println("********************************************");
       // com1.getDevs().forEach(System.out::println);
       // System.out.println("********************************************");


        //2--"Gandalf"ın çalıştığı company bilgilerini getiriniz.
        String hqlQuery1="From Developer06 s where s.name='Gandalf'";
        Developer06 com2=session.createQuery(hqlQuery1,Developer06.class).uniqueResult();
        System.out.println(com2.getCompany());

        //3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.
        String hqlQuery2="From Company3 c where c.id=33";
        Developer06 dev3=session.get(Developer06.class,3L);

        Company3 company=session.get(Company3.class,22L);
        company.getDevs().remove(dev3);

        //4--id 11 olan company i sil
        Company3 company1=session.get(Company3.class,11L);
        session.delete(company1);

        tx.commit();
        session.close();
        sf.close();






    }
}
