package com.square.getmedoc.services;

import java.util.List;
import java.util.Map;

import javax.swing.SortOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.square.getmedoc.db.model.Appuser;

@NoRepositoryBean
public interface AppuserService extends JpaRepository<Appuser, Long> {
	public Appuser findByUsername(String username);
	public Appuser findByUsernameAndPassword(String username, String password);
	public List<Appuser> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters);
}
