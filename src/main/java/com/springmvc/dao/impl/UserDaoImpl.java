package com.springmvc.dao.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.dto.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public User getUser(String id) {

        String hql = "from User u where u.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);

        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getAllUser() {

        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public boolean delUser(String id) {

        String hql = "delete User u where u.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);

        return (query.executeUpdate() > 0);
    }

    @Override
    public boolean updateUser(User user) {

        String hql = "update User u set u.userName = ?,u.age=? where u.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, user.getUserName());
        query.setString(1, user.getAge());
        query.setString(2, user.getId());

        return (query.executeUpdate() > 0);
    }


    @Override
    public boolean login(String username, String password) {
        // TODO Auto-generated method stub
        if(username==null){
            username="";
        }
        if(password==null){
            password="";
        }
        List<User> list = null;
        String hql="select user.userName ,user.password from User as user where user.userName='"+username+"' and user.password = '"+password+"'";

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query =session.createQuery(hql);
            System.out.println("@@@@@@@@@");
            list = query.list();

        } catch (DataAccessException e) {
            // TODO: handle exception
            return false;
        }

        if(list.isEmpty()){
            return false;
        }
        return true;
    }

}
