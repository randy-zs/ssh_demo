package com.springmvc.dao.impl;

import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by randy on 17-3-11.
 */
public abstract class BaseDaoImpl {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

}
