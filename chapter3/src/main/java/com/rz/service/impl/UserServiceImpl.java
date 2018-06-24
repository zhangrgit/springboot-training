package com.rz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rz.entity.User;
import com.rz.repository.UserRepository;
import com.rz.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
         userRepository.save(user);
	}

	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
           userRepository.save(user);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
          userRepository.deleteById(id);
	}

}
