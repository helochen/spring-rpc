package com.chen.rpc.Dao;

import com.chen.rpc.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Chen on 2017/6/4.
 */
public interface IUserMapper {
    User selectUser(String id);
    void getUserCount(Map getUserCountMap);
    List<User> selectAll();
    void addUser(User u);
}
