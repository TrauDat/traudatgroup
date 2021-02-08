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

import com.traudat.traudatgroup.models.VehicleStatus;
import com.traudat.traudatgroup.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	@Autowired
	private VehicleStatusService vehicleStatusService;
	
	@GetMapping(value = "/vehicleStatuses")
	public String getVehicleStatus(Model model) {
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
		
		return "vehicleStatus";
	}
	
	@PostMapping(value = "/vehicleStatuses/addNew")
	public String addNew(VehicleStatus VehicleStatus) {
		vehicleStatusService.save(VehicleStatus);
		
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping(value = "vehicleStatuses/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleStatus(VehicleStatus VehicleStatus) {
		vehicleStatusService.save(VehicleStatus);
		
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping(value = "/vehicleStatuses/delete")
	public String deleteVehicleStatus(int id) {
		vehicleStatusService.deleteById(id);
		
		return "redirect:/vehicleStatuses";
	}
}
