package com.traudat.traudatgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traudat.traudatgroup.models.State;
import com.traudat.traudatgroup.services.CountryService;
import com.traudat.traudatgroup.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping(value = "/states")
	public String getListState(Model model) {
		model.addAttribute("listState", stateService.getListState());
		model.addAttribute("countries", countryService.listCountries());
		
		return "State";
	}
	
	@PostMapping(value = "/state/createstate")
	public String createState(State state, Model model) {
		model.addAttribute("countries", countryService.listCountries());
		stateService.save(state);
		
		return "redirect:/states";
	}
	
	@RequestMapping(value = "state/findById")
	@ResponseBody
	public State findById(int id) {
		return stateService.findById(id);
	}
	
	@RequestMapping(value = "/state/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateState(State state) {
		stateService.save(state);
		
		return "redirect:/states";
	}
	
	@RequestMapping(value = "/state/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteState(int id) {
		stateService.deleteById(id);
		
		return "redirect:/states";
	}
}
