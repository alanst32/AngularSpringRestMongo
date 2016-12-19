package com.rocketOzzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketOzzy.collection.Client;
import com.rocketOzzy.dao.ClientDAO;
import com.rocketOzzy.service.ClientService;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	public List<Client> getAllClients() {
		
		return clientDAO.getAllClients();
	}

	public List<Client> getClientByName(Client client) {
		 return clientDAO.getClientByName(client);
	}

	public boolean insertClient(Client client) throws Exception {
		return clientDAO.insertClient(client);
	}

	public boolean updateClient(Client client) throws Exception {
		return clientDAO.updateClient(client);
	}

	public boolean deleteClient(Client client) throws Exception {
		return clientDAO.deleteClient(client);
	}

	public boolean deleteClientsByNumber(List<String> cliNumbers) throws Exception {
		return clientDAO.deleteClientsByNumber(cliNumbers);
	}

}
