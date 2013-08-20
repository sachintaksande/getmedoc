package com.square.getmedoc.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
/**
 * Every Repository interface should extend this interface
 * @author STaksande
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface CustomBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QueryDslPredicateExecutor<T> {
}
