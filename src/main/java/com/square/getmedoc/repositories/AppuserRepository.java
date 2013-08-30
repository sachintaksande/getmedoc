package com.square.getmedoc.repositories;

import java.util.List;

import com.square.getmedoc.db.model.Appuser;

public interface AppuserRepository extends CustomBaseRepository<Appuser, Long> {
	
	List<Appuser> findByUsername(String username);
	List<Appuser> findByUsernameAndPassword(String username, String password);
	List<Appuser> findByUsertype(Integer type);
}
