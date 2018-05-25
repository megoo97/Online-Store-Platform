package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreOwnerEntity;
import com.SWII.Repositories.StoreRepository;
import java.util.HashSet;
import java.util.Set;


@Service
public class StoreServices {

	@Autowired
	StoreRepository storeRepo;

	@Autowired
	StoreOwnerServices ownerService;

	public boolean saveStore(StoreEntity store) {
		if (ownerService.exist(store.getStoreOwner().getUserId())) {
			storeRepo.save(store);
			return true;
		}
		return false;
	}
	
	public StoreEntity getStoreByName(String name){
		StoreEntity store= storeRepo.findByName(name);
		if(store == null)
			return null;
		return store;
	}
	
	public List<StoreEntity> getStores(StoreOwnerEntity owner){
		return storeRepo.findByStoreOwner(owner);
	}
	
		private Set<StoreEntity> generateSetStore(Iterable<StoreEntity> iterable)
	{
		Set<StoreEntity> storeList = new HashSet<StoreEntity>();
		for(StoreEntity store : iterable)
		{
			storeList.add(store);
		}
		return storeList;
	}

	public Set<StoreEntity> showStores()
	{
		Iterable<StoreEntity> iter=storeRepo.findAll();
		return generateSetStore(iter);
	}
	
	public Set<StoreEntity> showAcceptedStores()
    {
        Set<StoreEntity> storeList = new HashSet<StoreEntity>();
        Set<StoreEntity> acceptedStoreList = new HashSet<StoreEntity>();
        Iterable<StoreEntity> iter=storeRepo.findAll();
        storeList=generateSetStore(iter);
        for(StoreEntity it:storeList)
        {
            if(it.getStatus()==false)
                acceptedStoreList.add(it);
        }
        return acceptedStoreList;
    }
	
}
