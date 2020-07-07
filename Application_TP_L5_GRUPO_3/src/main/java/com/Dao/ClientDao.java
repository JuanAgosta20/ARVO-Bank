package com.Dao;

import java.util.ArrayList;

import com.Model.Client;
import com.Model.User;

public interface ClientDao{
	public Boolean insertClient(Client client);
	public Boolean updateClient(Client client);
	public Boolean deleteClient(int id);
	public Boolean deleteUser(int id);
	public Client getClient(Integer id);
	public Client getClient(User user);
	public Client getClient(String dni);
	public Client getClientByUserId(User user);
	public ArrayList<Client> getClients();
	public Boolean emailExist(String email);
	public Boolean dniExist(String dni);
}
