package com.springmvc.dto;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by randy on 17-3-11.
 */
@Entity
//创建的数据库表名称
@Table(name = "user")
public class User {

    @Id
    //关键字生成模式
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String userName;

    @Column(length = 32)
    private String age;

    @Column(length = 32)
    private String tele;

    @Column(length = 32)
    private String password;

    @Column(length = 32)
    private String sex;

    public User(String keyId, String name, Object o) {
        super();
        this.id = id;
        this.userName = name;
        this.password = password;
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
