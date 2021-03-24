package br.com.aulacarlos.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import br.com.aulacarlos.application.domain.Client;
import br.com.aulacarlos.application.repository.ClientRepository;

@Configuration
public class LoadingDataBase implements ApplicationRunner{
	
	@Autowired
	private ClientRepository respository;
		
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		if(respository.findAll().isEmpty()){
			respository.save(new Client(null, "Zueca", "zueca@gmail.com", "54612355446"));
			respository.save(new Client(null,  "danilo", "danilo@gmail.com", "15423546654"));
			respository.save(new Client(null, "carlos", "carlos@gmail.com", "12354544656"));
			respository.save(new Client(null, "marleide", "marleide@gmail.com", "12354554466"));
		}
	}
}
