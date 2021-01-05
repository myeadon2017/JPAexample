package com.dempapp.springbootDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	
	@Autowired
	private UserDao userDao;
	
	//ArrayList<User> ul = new ArrayList<>();
	public boolean loginValid(String uname, String pass) {
		if(uname.equals("admin")&& pass.equals("manager")){
			return true;	
	}
		return false;
	}
	
	public boolean addUser(String uname, String pass, String city) {
		
		userDao.save(new User(uname, pass, city));
		
		return true;
	
	}
	
	public List<User> loadUsers(){
			List<User> ul=(List) userDao.findAll();
			return ul;
		}
		
	public boolean findUser(String uname) {
		userDao.findById(uname);
		
		return true;
	}
	
public boolean updateUser(String uname, String city) {
	Optional<User> u = userDao.findById(uname);
	if (u.isPresent()) {
		u.get().setCity(city);
		userDao.save(u.get());
		return true;
	}
	return false;
}

public boolean deleteUser(String uname) {
	try{
        userDao.deleteById(uname);
    } catch (IllegalArgumentException e){
        return false;
    }
    return true;
}}



