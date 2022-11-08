package com.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.entities.User;
import com.workshopmongo.repositories.UserRepositoy;

@Service
public class UserService {
	
	@Autowired
	private UserRepositoy reposiroty;
	
	public List<User> findAll(){
		return reposiroty.findAll();
	}
}
