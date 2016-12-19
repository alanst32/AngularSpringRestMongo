package com.rocketOzzy.collection;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection="client")
public class Client {

	@Id
	@Field("cliNumber")
	private String cliNumber;
	
	@Field("cliName")
	private String cliName;
	
	@Field("cliLastname")
	private String cliLastname;
	
	@Field("cliDatebirth")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonSerialize(using = com.rocketOzzy.util.JSONSerializer.class)
	@JsonDeserialize(using = com.rocketOzzy.util.JSONDeserialize.class)
	private Date cliDatebirth;
	
	@Field("cliRegister")
	private String cliRegister;
	
	@Field("cliCountry")
	private String cliCountry;

	public String getCliNumber() {
		return cliNumber;
		
	}

	public void setCliNumber(String cliNumber) {
		this.cliNumber = cliNumber;
	}

	public String getCliName() {
		return cliName;
	}

	public void setCliName(String cliName) {
		this.cliName = cliName;
	}

	public String getCliLastname() {
		return cliLastname;
	}

	public void setCliLastname(String cliLastname) {
		this.cliLastname = cliLastname;
	}

	public Date getCliDatebirth() {
		return cliDatebirth;
	}

	public void setCliDatebirth(Date cliDatebirth) {
		this.cliDatebirth = cliDatebirth;
	}

	public String getCliRegister() {
		return cliRegister;
	}

	public void setCliRegister(String cliRegister) {
		this.cliRegister = cliRegister;
	}

	public String getCliCountry() {
		return cliCountry;
	}

	public void setCliCountry(String cliCountry) {
		this.cliCountry = cliCountry;
	}
	
}
