package com.Services;

import java.util.ArrayList;

import com.Dao.ClientDao;

import com.Model.Client;
import com.Model.User;

public class ClientServiceImpl implements ClientService{
	ClientDao cd;
	
	public ClientServiceImpl(ClientDao dCli) {
		cd = dCli;
	}
	
	public Boolean saveClient(Client client) {
		return cd.insertClient(client);
	}

	public Boolean updateClient(Client client) {
		return cd.updateClient(client);
	}
	
	public Boolean deleteClient(int idClient,int idUser) {
		return (cd.deleteClient(idClient) && cd.deleteUser(idUser));
	}

	public Client readClient(int id) {
		return cd.getClient(id);
	}

	public ArrayList<Client> readClients() {

		ArrayList<Client> clients = cd.getClients();
		return clients;
	}

	public Client readClient(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean emailExist(String email) {
		return cd.emailExist(email);
	}

	public Client readClientByUserId(User user) {
		return cd.getClientByUserId(user);
	}

	public Boolean dniExist(String dni) {
		return cd.dniExist(dni);
	}

}
