package com.rz.service;

import java.util.List;

import com.rz.domain.User;

public interface UserService {
	
	/**
	 * 新增用户
	 * @param name
	 * @param age
	 */
	void create(User user);
	
	/**
	 * 根据名字删除用户
	 * @param name
	 */
	void deleteByName(String name);
	/**
	 * 根据Id删除用户
	 * @param name
	 */
	void deleteById(int id);
	 
	/**
	 * 获取用户总数量
	 * @return
	 */
	int getAllUsers();
	
	/**
	 * 获取用户集合
	 * @return
	 */
	List<User> getUserList();
	
	/**
	 * 获取指定id用户
	 * @return
	 */
	User getUser(String id);
	
	/**
	 * 删除所有用户
	 */
	void deleteAllUsers();

}
