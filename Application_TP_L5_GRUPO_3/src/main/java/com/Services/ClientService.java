package com.Services;

import java.util.ArrayList;

import com.Model.Client;

public interface ClientService {
	public Boolean saveClient(Client client);
	public Boolean updateClient(Client client);
	public Client readClient(Integer id);
	public ArrayList<Client> readClients();
	public Boolean emailExist(String email);
}
