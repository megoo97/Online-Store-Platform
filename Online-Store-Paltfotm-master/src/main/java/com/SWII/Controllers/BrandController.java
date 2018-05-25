package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWII.Entity.BrandEntity;
import com.SWII.Repositories.BrandRepository;

@Controller
@RequestMapping("brand")
public class BrandController {
	@Autowired
	BrandRepository brandRepository;
	
	@RequestMapping(value="/addbrand",method=RequestMethod.POST)
	public boolean addBrand(Model model ,@ModelAttribute BrandEntity brand) {
		model.addAttribute("brand", new BrandEntity());
		if(brandRepository.existsById(brand.getName())){
			return false;
		}else {
			brandRepository.save(brand);
			return true;
		}
	
	}
}
