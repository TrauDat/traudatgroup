package com.traudat.traudatgroup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traudat.traudatgroup.models.Country;
import com.traudat.traudatgroup.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	
	@GetMapping("/countries")
	public String getCountries(Model model) {
		
		List<Country> countries = countryService.listCountries();
		model.addAttribute("countries", countries);
		return "Country";
	}
	
	@PostMapping("/countries/addNew")
	public String addCountry(Country country) {
		countryService.save(country);
		
		return "redirect:/countries";
	}
	
	@RequestMapping("/countries/findById")
	@ResponseBody
	public Country findCountry(int id) {
		return countryService.findById(id);
	}
	
	@RequestMapping(value ="/countries/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateCountry(Country country) {
		countryService.save(country);
		
		return "redirect:/countries";
	}
	
	@RequestMapping(value ="/countries/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteCountry(Integer id) {
		countryService.deleteById(id);
		
		return "redirect:/countries";
	}
	
}
