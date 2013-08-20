package com.square.getmedoc.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.services.AppuserService;

@Transactional
@Service(value="customUserService")
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	private AppuserService appuserService;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if(com.mysql.jdbc.StringUtils.isNullOrEmpty(userName))
			throw new UsernameNotFoundException("User Name not found.");
		Appuser user = appuserService.findByUsername(userName);
		if(user == null)
			throw new UsernameNotFoundException("User Name not found.");
		return new CustomUser(user);
	}

	public AppuserService getAppuserService() {
		return appuserService;
	}

	public void setAppuserService(AppuserService appuserService) {
		this.appuserService = appuserService;
	}
}
