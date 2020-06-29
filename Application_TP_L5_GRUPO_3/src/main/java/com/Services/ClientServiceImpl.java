package com.Services;

import java.util.ArrayList;

import com.Dao.ClientDao;
import com.Dao.ClientDaoImpl;
import com.Dao.SessionHandler;
import com.Model.Client;

public class ClientServiceImpl implements ClientService{
	SessionHandler sHand = new SessionHandler();
	ClientDao cd = new ClientDaoImpl();
	
	public Boolean saveClient(Client client) {
			
		return null;
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
		@SuppressWarnings("unchecked")
		ArrayList<Client> clients = (ArrayList<Client>) sHand.getAllData(Client.class);
		return clients;
	}

	public Client readClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
