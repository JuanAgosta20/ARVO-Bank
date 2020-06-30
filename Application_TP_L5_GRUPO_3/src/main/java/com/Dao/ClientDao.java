package com.Dao;

import java.util.ArrayList;

import com.Model.Client;
import com.Model.User;

public interface ClientDao{
	public Boolean insertClient(Client client);
	public Boolean updateClient(Client client);
	public Client getClient(Integer id);
	public Client getClient(User user);
	public Client getClient(String dni);
	public ArrayList<Client> getClients();
	public Boolean emailExist(String email);
}
