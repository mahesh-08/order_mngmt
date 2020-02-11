package com.novogold.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.novogold.bean.User;

@Repository
@Transactional
public class UserDaoService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		System.out.println(user);
		entityManager.persist(user);
		return user.getUser_id();
	}
	
}
