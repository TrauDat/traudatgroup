package com.traudat.traudatgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.traudat.traudatgroup.models.User;
import com.traudat.traudatgroup.services.ProfileService;

@Controller
public class UserController {

	@Autowired
	private ProfileService profilerService;

	@GetMapping("/users")
	public String getUser() {
		return "User";
	}
	
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		profilerService.save(user);

		RedirectView redirectView = new RedirectView("/login", true);

		redir.addFlashAttribute("message", "You successfully registerd! You can now login!");

		return redirectView;
	}
}
