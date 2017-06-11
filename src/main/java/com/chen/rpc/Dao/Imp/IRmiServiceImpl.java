package com.chen.rpc.Dao.Imp;

import com.chen.rpc.Dao.IRmiService;
import org.springframework.stereotype.Component;

/**
 * Created by Chen on 2017/6/11.
 */
@Component("iRmiServiceImpl")
public class IRmiServiceImpl implements IRmiService {
    public String printMsg() {
        System.out.println("print this msg mean call method: printMsg()");
        return "success";
    }
}
