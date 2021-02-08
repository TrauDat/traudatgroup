package com.traudat.traudatgroup.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.User;
import com.traudat.traudatgroup.models.UserPrincipal;
import com.traudat.traudatgroup.repositories.UserRepository;
import com.traudat.traudatgroup.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//check User exist in DB?
 		User user = userRepository.findUserByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("User Not found with -> username or email: " + username));
		
//		if (user == null) {
//			throw new UsernameNotFoundException(username);
//		}
		
		return new UserPrincipal(user);
	}

}
