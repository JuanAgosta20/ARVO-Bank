package com.Dao;

import com.Model.Client;

public interface ClientDao{
	public Boolean insertClient(Client client);
	public Boolean updateClient(Client client);
	public Client getClient(Integer id);
	public Client getClient(String dni);
}
