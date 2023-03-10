package com.bug.note.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bug.note.entity.User;
import com.bug.note.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalUserDetailsService implements UserDetailsService {
	
	private final UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUsername(username);
		
		return new PrincipalUserDetails(user);
	}

}
