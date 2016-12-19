package com.rocketOzzy.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rocketOzzy.collection.Client;
import com.rocketOzzy.service.ClientService;

@RestController
public class RestServiceController {

	@Autowired
	private ClientService clientService;
	
	/**
	 * http://localhost:5050/AngularSpringRestMongo/mongoGetAllClients
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mongoGetAllClients", method = RequestMethod.GET)
	public List<Client> mongoGetAllClients(){
		
		List<Client> clients = clientService.getAllClients();
		
		
		return clients;
	}
	
	/**
	 * http://localhost:5050/AngularSpringRestMongo/mgGetClientByName?name=John83
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/mgGetClientByName", method = RequestMethod.POST)
	public List<Client> getClientByName( @QueryParam("name") String name){
		
		Client client = new Client();
		client.setCliName(name);
		
		List<Client> clients = clientService.getClientByName(client);
		
		return clients;
		
	}
	 
	/**
	 * http://localhost:5050/AngularSpringRestMongo/insertClient?name=John83&lastname=Doe83&dateBirth=01/12/1984&register=3112222222&&country=AUSTRALIA
	 * 
	 * @param name
	 * @param lastname
	 * @param dateBirth
	 * @param register
	 * @param country
	 * @return
	 */
	@RequestMapping(value = "/insertClient", method = RequestMethod.POST)
	public boolean insertClient( @QueryParam("name") String name,
			                       @QueryParam("lastname") String lastname,
			                       @QueryParam("dateBirth") String dateBirth,
			                       @QueryParam("register") String register,
			                       @QueryParam("country") String country      ){
		 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Client client = new Client();
		
		boolean bol = false;
		
		try {
			client.setCliName(name);
			client.setCliLastname(lastname);
			client.setCliDatebirth(dateFormat.parse(dateBirth));
			client.setCliRegister(register);
			client.setCliCountry(country);
			
			bol = clientService.insertClient(client);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return bol;
	}
	
	/**
	 * http://localhost:5050/AngularSpringRestMongo/updateClient?name=John83&lastname=Doe83&dateBirth=01/12/1984&register=3112222222&&country=AUSTRALIA
	 * 
	 * @param name
	 * @param lastname
	 * @param dateBirth
	 * @param register
	 * @param country
	 * @return
	 */
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	public boolean updateClient( @QueryParam("name") String name,
			                       @QueryParam("lastname") String lastname,
			                       @QueryParam("dateBirth") String dateBirth,
			                       @QueryParam("register") String register,
			                       @QueryParam("country") String country      ){
		 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Client client = new Client();
		
		boolean bol = false;
		
		try {
			client.setCliName(name);
			client.setCliLastname(lastname);
			client.setCliDatebirth(dateFormat.parse(dateBirth));
			client.setCliRegister(register);
			client.setCliCountry(country);
			
			bol = clientService.insertClient(client);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return bol;
	}
	
	
	/**
	 * http://localhost:5050/AngularSpringRestMongo/deleteClient?name=John83&lastname=Doe83&dateBirth=01/12/1984&register=3112222222&&country=AUSTRALIA
	 * 
	 * @param name
	 * @param lastname
	 * @param dateBirth
	 * @param register
	 * @param country
	 * @return
	 */
	@RequestMapping(value = "/deleteClientByNumbers", method = RequestMethod.POST)
	public boolean deleteClientByNumbers( @QueryParam("checked") String checked      ){
		 
		
		boolean bol = false;
		
		try {
			
			ArrayList<String> decArray = new ArrayList<String>();
			
			for( String s : checked.split(",") ){
				decArray.add( s );
			}
			
			bol = clientService.deleteClientsByNumber(decArray);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return bol;
	}
	
	/**
	 * http://localhost:5050/AngularSpringRestMongo/mgGetClientByName?clientNumbers=?,?,?,?,?
	 * 
	 * @param clientNumbers
	 * @return
	 */
	@RequestMapping(value = "/deleteClientsByNumber", method = RequestMethod.POST)
	public boolean deleteClientsByNumber( @QueryParam("clientNumbers") String clientNumbers){
		 
		ArrayList<String> list = new ArrayList<String>();
		
		boolean bol = false;
		
		for( String s : clientNumbers.split(",")){
			list.add(s);
		}
		
		try {
			bol = clientService.deleteClientsByNumber(list);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return bol;
	}
	
}
