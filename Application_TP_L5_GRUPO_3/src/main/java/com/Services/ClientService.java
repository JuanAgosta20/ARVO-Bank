package com.Services;

import java.util.ArrayList;

import com.Model.Client;
import com.Model.User;

public interface ClientService {
	public Boolean saveClient(Client client);
	public Boolean updateClient(Client client);
	public Client readClient(Integer id);
	public Client readClientByUserId(User user);
	public Boolean deleteClient(int idClient, int idUser);
	public Client readClient(int id);
	public ArrayList<Client> readClients();
	public Boolean emailExist(String email);
	public Boolean dniExist(String dni);
}
