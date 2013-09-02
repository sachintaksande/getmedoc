package com.square.getmedoc.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.repositories.AppuserRepository;
import com.square.getmedoc.services.AppuserService;

@Service("appuserService")
@Transactional
public class AppuserServiceImpl implements AppuserService {
	
	@Autowired
	private AppuserRepository appuserRepository;
	
	@PersistenceContext
	private EntityManager em;

	public List<Appuser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Appuser> findAll(Sort paramSort) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Appuser> List<S> save(Iterable<S> paramIterable) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
	}

	
	public Appuser saveAndFlush(Appuser paramT) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteInBatch(Iterable<Appuser> paramIterable) {
		// TODO Auto-generated method stub

	}

	
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	
	public Page<Appuser> findAll(Pageable paramPageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Appuser> S save(S paramS) {
		return appuserRepository.save(paramS);
	}

	
	public Appuser findOne(Long paramID) {
		return appuserRepository.findOne(paramID);
	}

	
	public boolean exists(Long paramID) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterable<Appuser> findAll(Iterable<Long> paramIterable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long count() {
		return appuserRepository.count();
	}

	
	public void delete(Long paramID) {
		// TODO Auto-generated method stub

	}

	
	public void delete(Appuser paramT) {
		// TODO Auto-generated method stub

	}

	
	public void delete(Iterable<? extends Appuser> paramIterable) {
		// TODO Auto-generated method stub

	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	
	public Appuser findByUsername(String username) {
		List<Appuser> appusers = appuserRepository.findByUsername(username);
		if(appusers != null && appusers.size() > 0)
			return appusers.get(0);
		return null;
	}
	
	
	public Appuser findByUsernameAndPassword(String username, String password) {
		List<Appuser> appusers = appuserRepository.findByUsernameAndPassword(username, password);
		if(appusers != null && appusers.size() > 0)
			return appusers.get(0);
		return null;
	}
	
	
	public List<Appuser> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Appuser> cq = criteriaBuilder.createQuery(Appuser.class);
		
		Root<Appuser> from = cq.from(Appuser.class);
		
		CriteriaQuery<Appuser> select = cq.select(from);
		
		if (sortField != null && !sortField.isEmpty()) {
			 if (sortOrder != null && sortOrder.equals(SortOrder.ASCENDING)) {
				 select.orderBy(criteriaBuilder.asc(from.get(sortField)));
			 } else if (sortOrder != null && sortOrder.equals(SortOrder.DESCENDING)){
				 select.orderBy(criteriaBuilder.desc(from.get(sortField)));
			 }
		}
		if (!filters.isEmpty()) {
			List<Predicate> predicates = new ArrayList<Predicate>();
			Iterator<Entry<String, String>> iterator = filters.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> entry = iterator.next();
				if((String) entry.getValue() == null || (String) entry.getValue().trim() == "")
					continue;
				Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(from.get((String)entry.getKey()).as(String.class)), "%"+((String) entry.getValue())+"%".toUpperCase());
				predicates.add(predicate);
			}
			Predicate[] arr = new Predicate[predicates.size()];
			predicates.toArray(arr);
			select.where(arr);
		}
		TypedQuery<Appuser> qry = em.createQuery(select);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		return qry.getResultList();
	}

	@Override
	public List<Appuser> findByUsertype(Integer type) {
		return appuserRepository.findByUsertype(type);
	}
}
