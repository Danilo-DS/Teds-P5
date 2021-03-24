package br.com.aulacarlos.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aulacarlos.application.domain.Client;
import br.com.aulacarlos.application.exception.client.ClientDeleteFailed;
import br.com.aulacarlos.application.exception.client.ClientNotFound;
import br.com.aulacarlos.application.exception.client.ClientUpdateFailed;
import br.com.aulacarlos.application.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> listAll(){
		return repository.findAll();
	}
	
	public Client findClient(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new ClientNotFound("Error: Client Not Found"));
	}
	
	public void deleteClient(Long id) {
		if(verifyExistsClient(id)) {
			repository.deleteById(id);
		}
		else {
			throw new ClientDeleteFailed("Error: Don't Possible Delete a Client Not Existent");
		}
		
	}
	
	public Client update(Long id, Client client) {
		if(verifyExistsClient(id)) {
			Client updateClient = repository.getOne(client.getId());
			updateClient.setName(client.getName());
			updateClient.setName(client.getEmail());
			updateClient.setName(client.getPhone());
			repository.save(updateClient);
			return updateClient;
		}
		else {
			throw new ClientUpdateFailed("Error: Don't Possible Update Client Not Existent");
		}
	}
	
	public void save(Client client) {
		repository.save(client);
	}
	
	private boolean verifyExistsClient(Long id) {
		return repository.existsById(id);
	}
}
