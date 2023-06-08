
package com.cglia.user.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.user.model.CustomerRestCall;

import com.cglia.user.service.CustomerService;

@RestController
public class RestCalls {
	@Autowired
	private CustomerService er;

	@GetMapping("/get/{customerId}")
	public String getCustomer(@PathVariable Integer customerId)
			throws IOException, InterruptedException, URISyntaxException {

		return er.retriveCustomer(customerId);

	}

	@PostMapping("/add")
	public String addCustomer(@RequestBody CustomerRestCall cr) throws IOException, InterruptedException {
		er.createCustomer(cr);

		return er.createCustomer(cr);

	}

	@PutMapping("/update/{customerId}")
	public String updateCustomer(@RequestBody CustomerRestCall cr, @PathVariable Integer customerId)
			throws IOException, InterruptedException, URISyntaxException {

		return er.updateCustomer(cr, customerId);

	}

	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable Integer customerId)
			throws IOException, InterruptedException, URISyntaxException {

		return er.deleteCustomer(customerId);

	}
	@GetMapping("/get")
	public String get()
			throws IOException, InterruptedException, URISyntaxException {
		String url="http://192.168.60.60:8080/get";
		HttpRequest request = HttpRequest.newBuilder().GET()
				  .uri(URI.create(url))
				  .header("Authorization", "Basic " +Base64.getEncoder().encodeToString(("cheetha" + ":" + "Cheetha@12").getBytes()))
				  .build();
		HttpClient client=HttpClient.newBuilder().build();
		HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

}
