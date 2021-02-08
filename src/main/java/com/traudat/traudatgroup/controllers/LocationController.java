package com.traudat.traudatgroup.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traudat.traudatgroup.models.Location;
import com.traudat.traudatgroup.services.CountryService;
import com.traudat.traudatgroup.services.LocationService;
import com.traudat.traudatgroup.services.StateService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	
	
	@GetMapping(value = "/locations")
	public String getLocation(Model model) {
		model.addAttribute("countries", countryService.listCountries());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("states", stateService.getListState());
		
		
		return "Location";
	}
	
	@PostMapping(value = "/locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		
		return "redirect:/locations";
	}
	
	@RequestMapping(value = "locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		return locationService.findById(id);
	}
	
	@RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateLocation(Location location) {
		locationService.save(location);
		
		return "redirect:/locations";
	}
	
	@RequestMapping(value = "/locations/delete")
	public String deleteLocation(int id) {
		locationService.deleteById(id);
		
		return "redirect:/locations";
	}
}
