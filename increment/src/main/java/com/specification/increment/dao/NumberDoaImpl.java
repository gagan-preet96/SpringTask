package com.specification.increment.dao;

import com.specification.increment.entity.NumberClass;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NumberDoaImpl implements NumberDao{

    public NumberDoaImpl(){

    }
    @Autowired
    SessionFactory sessionFactory;

    private NumberDao numberDao;

    @Autowired
    public NumberDoaImpl(NumberDao theNumberDao){
            numberDao = theNumberDao;
    }

    @Override
    public int incrementValueWithLock() {

        System.out.println(" saving increment");
        Session session = sessionFactory.getCurrentSession();
        int data =0;
        try{
            session.beginTransaction();

            NumberClass num = (NumberClass) session.get(NumberClass.class,1, LockOptions.UPGRADE);

            num.setId(num.getId() + 1);
            num = (NumberClass) session.merge(num);
            data = num.getId();
            session.getTransaction().commit();
        }
        catch (org.hibernate.StaleObjectStateException e){
                session.getTransaction().rollback();
                throw e;
        }
        catch (Exception e){
            throw e;
        }
        return data;
    }
}
