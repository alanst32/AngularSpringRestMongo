package com.rocketOzzy.dao;

import java.util.List;

import com.rocketOzzy.collection.Client;

/**
 * 
 * @author alan
 *
 */
public interface ClientDAO {

	public List<Client> getAllClients();
	
	public List<Client> getClientByName(Client client);
	
	public boolean insertClient(Client client);
	
	public boolean updateClient(Client client);
	
	public boolean deleteClient(Client client);
	
	public boolean deleteClientsByNumber(List<String> cliNumbers);
	
}
