package de.tekup.loan.invoke.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.client.SoapClient;
import de.tekup.loan.soap.api.consume.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.api.consume.loaneligebilty.WsResponse;

@Controller
public class CheckController {
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/customer")
	public String checkForm(Model model) {
		CustomerRequest request = new CustomerRequest();
		request.setCibilScore(500);
		model.addAttribute("request", request);
		return "request";
	}
	
	@PostMapping("/check/customer")
	public String LaonEligebel(@ModelAttribute("request") CustomerRequest request,
			Model model) {
		WsResponse response = client.getLoanStatus(request);
		model.addAttribute("response",response);
		return "response";
	}

}
