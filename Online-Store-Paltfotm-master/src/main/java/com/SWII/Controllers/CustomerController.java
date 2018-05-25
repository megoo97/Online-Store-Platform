package com.SWII.Controllers;

import com.SWII.Entity.StoreEntity;
import com.SWII.Repositories.CustomerRepository;
import com.SWII.Services.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SWII.Entity.CustomerEntity;
import com.SWII.Entity.ProductEntity;
import com.SWII.Services.CutomerServices;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CutomerServices customerService;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
    StoreServices storeServices;
	@RequestMapping(value="/signin",method= RequestMethod.POST)
	public CustomerEntity SignIn(String name, String password) {
		System.out.println("email"+" "+name+" "+"password"+" "+password);
		System.out.println();
		System.out.println();System.out.println();
		System.out.println();System.out.println();System.out.println();System.out.println();

		if(customerService.loadUserByUserName(name, password)){
			return customerRepository.findByUserName(name);
		}
		return null;
	}
    @RequestMapping(value="/showstores",method= RequestMethod.POST)
        public Set<StoreEntity> showStores() {

	        return storeServices.showAcceptedStores();
            }
	@RequestMapping(value="/Register", method=RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("customer",new CustomerEntity());
		return "CustomerRegister";
	}

    @RequestMapping(value="/Register",  method=RequestMethod.POST)
	public  String register(Model model,@ModelAttribute  CustomerEntity customer) {
		model.addAttribute("customer",new CustomerEntity());
		if(customerService.saveCustomer(customer)) {
			return "Done";
		}else {
			return "UserNameExists";
		}
    	
	}
    
    
    /******************************/
    
  /* @RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signInForm(Model model) {
		model.addAttribute("customer",new CustomerEntity());
		return "CustomerSignIn";
		
	}
	
    @RequestMapping(value="/signin",  method=RequestMethod.POST)
	public  String signIn(Model model,@ModelAttribute  CustomerEntity customer) {
		model.addAttribute("customer",new CustomerEntity());
		if(customerService.getCustomerByUserName(customer.getUserName(),customer.getPassword()) != null
				||customerService.getCustomerByEmail(customer.getUserName(),customer.getPassword()) != null){
			return "SignedIn";
		}else {
			return "Wrong";
		}
	}
    */
    @RequestMapping(value="/home",  method=RequestMethod.GET)
    public String showProducts(Model model , @ModelAttribute ProductEntity product) {
    	return "Buy";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
