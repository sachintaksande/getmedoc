package com.square.getmedoc.repositories;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;

public class BaseRepositoryImpl<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID>
		implements CustomBaseRepository<T, ID> {

	public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager, EntityPathResolver resolver) {
		super(entityInformation, entityManager, resolver);
	}
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

}
