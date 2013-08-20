package com.square.getmedoc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.db.model.Userrole;

public class UserUtil {
	
	public static Collection<? extends GrantedAuthority> getAuthorities(Appuser user) {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		if(user != null && user.getUserroles() != null && user.getUserroles().size() > 0){
			Iterator<Userrole> itr = user.getUserroles().iterator();
			while(itr.hasNext()){
				Userrole r = itr.next();
				roles.add(new SimpleGrantedAuthority(r.getRolename()));
			}
		}
		return roles;
	}

}
