package com.chen.rpc.Dao.Imp;

import com.chen.rpc.Dao.IUserMapper;
import com.chen.rpc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chen on 2017/6/10.
 */
@Component
public class IUserMapperImpl {

    @Autowired
    private IUserMapper iUserMapper;

    public void addBlock() {
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

}
