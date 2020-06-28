package com.Services;

import java.util.ArrayList;

import com.Model.Client;

public interface ClientService {
	public Boolean saveClient(Client client);
	public Boolean updateClient(Client client);
	public Boolean deleteClient(int idClient, int idUser);
	public Client readClient(Client client);
	public Client readClient(int id);
	public ArrayList<Client> readClients();
}
