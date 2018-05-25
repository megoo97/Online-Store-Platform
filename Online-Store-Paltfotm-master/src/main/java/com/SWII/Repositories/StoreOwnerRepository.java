package com.SWII.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.StoreOwnerEntity;

public interface StoreOwnerRepository extends CrudRepository<StoreOwnerEntity,Integer> {
    boolean existsByPassword(String password);
    boolean existsByUserName(String name);
    StoreOwnerEntity findByUserName(String name);
}
