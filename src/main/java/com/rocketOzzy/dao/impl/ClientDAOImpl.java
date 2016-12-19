package com.rocketOzzy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rocketOzzy.collection.Client;
import com.rocketOzzy.dao.ClientDAO;

/**
 * 
 * @author alan
 *
 */
@Repository("ClientDAO")
@SuppressWarnings("unchecked")
public class ClientDAOImpl implements ClientDAO {

	
	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public ClientDAOImpl(){
	}
			
	public List<Client> getAllClients() {
		
		List<Client> listClient = mongoTemplate.findAll(Client.class);
		
		return listClient == null ? new ArrayList<Client>() : listClient;
	}

	public List<Client> getClientByName(Client client) {
		
		Criteria criteria = Criteria.where("cliName").is(client.getCliName());
		
		Query query = new Query(criteria);
		
		List<Client> listClient = mongoTemplate.find(query, Client.class, "client");
		
		return listClient == null ? new ArrayList<Client>() : listClient;
	}
	
	

	public boolean insertClient(Client client) {
		
		try{
			mongoTemplate.save(client, "client");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean updateClient(Client client) {
		try{
			mongoTemplate.save(client, "client");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean deleteClient(Client client) {
		try{
			mongoTemplate.remove(client, "client");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean deleteClientsByNumber(List<String> cliNumbers) {
		
		Criteria criteria = Criteria.where("cliNumber").in(cliNumbers);
		
		Query query = new Query(criteria);
		
		try{
			mongoTemplate.remove(query, Client.class, "client");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	
}
