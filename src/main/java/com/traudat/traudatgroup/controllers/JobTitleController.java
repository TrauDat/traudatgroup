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

import com.traudat.traudatgroup.models.JobTitle;
import com.traudat.traudatgroup.services.JobTitleService;

@Controller
public class JobTitleController {
	@Autowired
	private JobTitleService jobTitleService;
	
	@GetMapping(value = "/jobTitles")
	public String getJobTitle(Model model) {
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());
		
		return "JobTitle";
	}
	
	@PostMapping(value = "/jobTitles/addNew")
	public String addNew(JobTitle JobTitle) {
		jobTitleService.save(JobTitle);
		
		return "redirect:/jobTitles";
	}
	
	@RequestMapping(value = "jobTitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(int id) {
		return jobTitleService.findById(id);
	}
	
	@RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateJobTitle(JobTitle JobTitle) {
		jobTitleService.save(JobTitle);
		
		return "redirect:/jobTitles";
	}
	
	@RequestMapping(value = "/JobTitles/delete")
	public String deleteJobTitle(int id) {
		jobTitleService.deleteById(id);
		
		return "redirect:/jobTitles";
	}
}
