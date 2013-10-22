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
import org.springframework.util.StringUtils;

import com.mysema.query.jpa.impl.JPAQuery;
import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.db.model.QAddress;
import com.square.getmedoc.db.model.QAppuser;
import com.square.getmedoc.db.model.QSpecializations;
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
	
	public List<Appuser> loadDoctors(int pageNo, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
		return load(pageNo, pageSize, sortField, sortOrder, filters, 1);
	}
	
	//type 1: doctor, 0:normal user
	public List<Appuser> load1(int pageNo, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters, int type) {
		
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
			Predicate typeCond = criteriaBuilder.equal(from.get("usertype"), type);
			predicates.add(typeCond);
			Predicate[] arr = new Predicate[predicates.size()];
			predicates.toArray(arr);
			select.where(arr);
		}
		TypedQuery<Appuser> qry = em.createQuery(select);
		qry.setFirstResult(pageNo*pageSize);
		qry.setMaxResults(pageSize);
		return qry.getResultList();
	}
	
	//type 1: doctor, 0:normal user
	public List<Appuser> load(int pageNo, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters, int type) {
		
		QAppuser appuser = QAppuser.appuser;
		//QSpecializations specializations = QSpecializations.specializations;
		//QAddress address = QAddress.address;
		
		//Create Query
		JPAQuery query = new JPAQuery(em);
		query.from(appuser);//.leftJoin(appuser.specializationses, specializations).leftJoin(appuser.addresses, address);
		

		//Apply Conditions
		//Name
		if(!StringUtils.isEmpty(filters.get("name"))){
			query.where(appuser.username.containsIgnoreCase(filters.get("name")));
		}
		//city
		if(!StringUtils.isEmpty(filters.get("city"))){
			query.where(appuser.addresses.any().city.containsIgnoreCase(filters.get("city")));
		}
		//zip
		if(!StringUtils.isEmpty(filters.get("zip"))){
			query.where(appuser.addresses.any().zip.containsIgnoreCase(filters.get("zip")));
		}
		//specialization
		if(!StringUtils.isEmpty(filters.get("spcl"))){
			query.where(appuser.specializationses.any().choice.description.containsIgnoreCase(filters.get("spcl")));
		}
		
		//sorting applied on Name
		if (!StringUtils.isEmpty(sortField)){
			 if (!StringUtils.isEmpty(sortOrder) && sortOrder.equals(SortOrder.DESCENDING)) {
				 query.orderBy(appuser.username.desc());
			 } else {
				 query.orderBy(appuser.username.asc());
			 }
		}
		
		//Pagination
		query.offset(pageNo*pageSize);
		query.limit(pageSize);
		return query.listResults(appuser).getResults();
		
		
		
		/*CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Appuser> cq = criteriaBuilder.createQuery(Appuser.class);
		
		Root<Appuser> from = cq.from(Appuser.class);
		
		CriteriaQuery<Appuser> select = cq.select(from).l;
		
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
			Predicate typeCond = criteriaBuilder.equal(from.get("usertype"), type);
			predicates.add(typeCond);
			Predicate[] arr = new Predicate[predicates.size()];
			predicates.toArray(arr);
			select.where(arr);
		}
		TypedQuery<Appuser> qry = em.createQuery(select);
		qry.setFirstResult(pageNo*pageSize);
		qry.setMaxResults(pageSize);
		return qry.getResultList();*/
	}

	@Override
	public List<Appuser> findByUsertype(Integer type) {
		return appuserRepository.findByUsertype(type);
	}
}
