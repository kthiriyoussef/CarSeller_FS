package com.youssef.users.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youssef.users.entities.User;
import com.youssef.users.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	
	

	@Override
	public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
		User user = userService.findUserByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException("Utilisateur introuvable !");
		List<GrantedAuthority> auths = new ArrayList<>();
		user.getRoles().forEach(role -> {
			GrantedAuthority auhority = new SimpleGrantedAuthority(role.getRole());
			auths.add(auhority);
		});
		return new org.springframework.security.core.userdetails.User(	user.getUsername(), user.getPassword(), auths);
	}
}
