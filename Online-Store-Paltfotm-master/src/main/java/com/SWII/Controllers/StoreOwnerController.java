package com.SWII.Controllers;

;

import com.SWII.Services.StoreOwnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SWII.Entity.StoreOwnerEntity;
import com.SWII.Repositories.StoreOwnerRepository;

@RestController
@CrossOrigin
@RequestMapping("storeowner")
public class StoreOwnerController {
	@Autowired
	StoreOwnerRepository storeOwnerRepo;
	@Autowired
	StoreOwnerServices storeOwnerServices;
	@RequestMapping(value="/signin",method= RequestMethod.POST)
	public StoreOwnerEntity SignIn(String name, String password) {
		System.out.println("email"+" "+name+" "+"password"+" "+password);
		System.out.println();
		System.out.println();System.out.println();
		System.out.println();System.out.println();System.out.println();System.out.println();

		if(storeOwnerServices.loadUserByUserName(name, password)){
			return storeOwnerRepo.findByUserName(name);
		}
		return null;
	}


}

