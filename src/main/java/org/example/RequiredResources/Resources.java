package org.example.RequiredResources;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class Resources {

    //gettting session factory object
    public SessionFactory getFactory(){
        return new Configuration().configure().buildSessionFactory();
    }

    //getting session object
    public Session getSessionObject(){
       return getFactory().openSession();
    }


    public void close() {
        getFactory().close();
    }
}
