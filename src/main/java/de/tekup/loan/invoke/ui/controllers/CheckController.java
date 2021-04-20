package de.tekup.loan.invoke.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.tekup.loan.soap.api.consume.loaneligebilty.CustomerRequest;

@Controller
public class CheckController {
	
	@GetMapping("/check/customer")
	public String checkForm(Model model) {
		CustomerRequest request = new CustomerRequest();
		request.setCibilScore(500);
		model.addAttribute("request", request);
		return "request";
	}

}
