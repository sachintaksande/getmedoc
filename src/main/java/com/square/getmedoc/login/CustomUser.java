package com.square.getmedoc.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.util.UserUtil;

public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Appuser userInfo;

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, 
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Appuser userInfo) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,accountNonLocked, authorities);
		setUserInfo(userInfo);
	}
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Appuser userInfo) {
        super(username, password, true, true, true, true, authorities);
        setUserInfo(userInfo);
    }

	public Appuser getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Appuser userInfo) {
		this.userInfo = userInfo;
	}
	
	public CustomUser(Appuser user){
		super(user.getUsername(), user.getPassword(), UserUtil.getAuthorities(user));
		setUserInfo(user);
	}
}
