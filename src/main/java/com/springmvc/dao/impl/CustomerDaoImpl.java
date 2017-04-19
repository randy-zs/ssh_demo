package com.springmvc.dao.impl;

import com.springmvc.dao.CustomerDao;
import com.springmvc.dto.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao {

    @Override
    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

}
