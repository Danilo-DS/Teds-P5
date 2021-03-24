package br.com.aulacarlos.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aulacarlos.application.domain.Client;
import br.com.aulacarlos.application.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findClientById(@PathVariable Long id) throws Exception{
		return ResponseEntity.ok(service.findClient(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable Long id){
		service.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveClient(@RequestBody Client client){
		service.save(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> clientUpdate(@PathVariable Long id, @RequestBody Client client){
		return ResponseEntity.ok(service.update(id, client));
	} 
}
