package com.springmvc.service;


import com.springmvc.dto.User;

import java.util.List;

public interface UserService {

	public User getUser(String id);

	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public boolean updateUser(User user);

	public boolean login(String username, String password);
}
