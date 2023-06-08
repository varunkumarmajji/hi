
package com.cglia.user.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.springframework.stereotype.Service;

import com.cglia.user.model.CustomerRestCall;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServiceImplementedClass implements CustomerService {

	@Override
	public String createCustomer(CustomerRestCall c) throws IOException, InterruptedException {
               ObjectMapper om=new ObjectMapper();
               String resquestbody=om.writeValueAsString(c);
		String url="http://192.168.60.60:8520/save";
		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(resquestbody)).header("Content-Type", "application/json")
				  .uri(URI.create(url))
				  .build();
		HttpClient client=HttpClient.newBuilder().build();
		HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

		return response.body()+" "+ response.statusCode();
	}

	@Override
	public String retriveCustomer(Integer customerId) throws IOException, InterruptedException {

		String url="http://192.168.60.60:8520/get/"+customerId;
		HttpRequest request = HttpRequest.newBuilder().GET()
				  .uri(URI.create(url))
				  .build();
		HttpClient client=HttpClient.newBuilder().build();
		HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
		return response.body();
	}

	@Override
	public String updateCustomer(CustomerRestCall c, Integer customerId) throws IOException, InterruptedException {
		 ObjectMapper om=new ObjectMapper();
         String resquestbody=om.writeValueAsString(c);
	String url="http://192.168.60.60:8520/put/"+customerId;
	HttpRequest request = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(resquestbody)).header("Content-Type", "application/json")
			  .uri(URI.create(url))
			  .build();
	HttpClient client=HttpClient.newBuilder().build();
	HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

	return response.body()+" "+ response.statusCode();
	}

	@Override
	public String deleteCustomer(Integer customerId)  throws IOException, InterruptedException  {

		String url="http://192.168.60.60:8520/delete/"+customerId;
		HttpRequest request = HttpRequest.newBuilder().DELETE()
				  .uri(URI.create(url))
				  .build();
		HttpClient client=HttpClient.newBuilder().build();
		HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
	
		return response.body()+" " + response.statusCode();
	}

}
