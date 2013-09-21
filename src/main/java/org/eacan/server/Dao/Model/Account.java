package org.eacan.server.Dao.Model;

import com.google.protobuf.Message;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-18
 * 类描述:
 * 版本:
 */
public class Account {
    private  String name;

    private  String password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account(Message message){

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
