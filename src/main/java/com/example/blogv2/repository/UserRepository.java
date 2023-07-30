package com.example.blogv2.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.blogv2.dto.JoinDTO;

@Repository
public class UserRepository {

		@Autowired
		private EntityManager em;
		
		@Transactional
	    public void save(JoinDTO joinDTO){
	        Query query = em.createNativeQuery("insert into user_tb(username, password, email) values(:username, :password, :email)");
	        query.setParameter("username", joinDTO.getUsername());
	        query.setParameter("password", joinDTO.getPassword());
	        query.setParameter("email", joinDTO.getEmail());
	        query.executeUpdate();
	    }
}
