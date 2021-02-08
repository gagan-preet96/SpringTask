package com.specification.increment.service;

import com.specification.increment.dao.NumberDao;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

    public NumberService(){

    }
    private NumberDao numberDao;

    @Autowired
    public NumberService(NumberDao theNumberDao){
        numberDao = theNumberDao;
    }
    public int incrementNumberForId(){

        int result =0;
        try{
            result = numberDao.incrementValueWithLock();
            System.out.println("data saved.....");
        }
        catch(StaleObjectStateException e){
            System.out.println("race condition occured try again");
        }
        catch(Exception e){
          throw e;
        }

        return result;
    }
}
