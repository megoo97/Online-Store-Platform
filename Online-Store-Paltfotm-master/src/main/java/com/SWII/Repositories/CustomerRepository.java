package com.SWII.Repositories;

import com.SWII.Entity.StoreOwnerEntity;
import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity,String> {
		public CustomerEntity findByEmail(String email);
		boolean existsByPassword(String password);
		boolean existsByUserName(String name);
	CustomerEntity findByUserName(String name);
}
