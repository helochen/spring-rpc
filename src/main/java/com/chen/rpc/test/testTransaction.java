package com.chen.rpc.test;

import com.chen.rpc.Dao.IRmiService;
import com.chen.rpc.Dao.IUserMapper;
import com.chen.rpc.Dao.Imp.IRmiServiceImpl;
import com.chen.rpc.Dao.Imp.IUserMapperImpl;
import com.chen.rpc.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * Created by Chen on 2017/6/10.
 */
public class testTransaction {

    private ApplicationContext applicationContext = null;

    @Before
    public void createApplicationContext(){
        try {
            applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @After
    public void destoryApplicationContext(){
        System.out.println("end the process");
    }

    @Test
    public void startService(){
        if(applicationContext != null){
            IRmiService iRmiService = applicationContext.getBean(IRmiServiceImpl.class);
            while (iRmiService != null){
                try {
                    Thread.currentThread().sleep(1000);
                    System.err.println("wait the request");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testBolck(){
        if(applicationContext != null){
            try{
                IUserMapperImpl userMapperImpl = applicationContext.getBean(IUserMapperImpl.class);
                userMapperImpl.addBlock();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void testTransaction(){
        try{
            if(applicationContext != null){
                IUserMapper iUserMapper = applicationContext.getBean(IUserMapper.class);
                User u = new User();
                u.setId("5");
                u.setName("popop");
                u.setPassword("1321dsfs");
                iUserMapper.addUser(u);
                User error = new User();
                error.setId("1231231231231232134234324234234213423424324242343453453453453453453454");
                error.setName("sfsdfqqwertyyuiiowqeoqjeqehqwehwebwngbsfnmgbdfnmgbwhwrhwekr");
                error.setPassword("test");
                iUserMapper.addUser(error);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
