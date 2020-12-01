package com.sample.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sample.student.dao.OAuthDao;
import com.sample.student.entity.CustomUser;
import com.sample.student.entity.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	OAuthDao oauthDao;

	@Override
	public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserEntity userEntity = null;
		try {
			userEntity = oauthDao.getUserDetails(username);
			CustomUser customUser = new CustomUser(userEntity);
			return customUser;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
	}

}
