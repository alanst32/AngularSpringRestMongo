package com.rocketOzzy.service;

import java.util.List;

import com.rocketOzzy.collection.Client;

/**
 * 
 * @author alan
 *
 */
public interface ClientService {

	
	public List<Client> getAllClients();
	
	public List<Client> getClientByName(Client name);
	
	public boolean insertClient(Client client) throws Exception;
	
	public boolean updateClient(Client client) throws Exception;
	
	public boolean deleteClient(Client client) throws Exception;
	
	public boolean deleteClientsByNumber(List<String> cliNumbers) throws Exception;
}
