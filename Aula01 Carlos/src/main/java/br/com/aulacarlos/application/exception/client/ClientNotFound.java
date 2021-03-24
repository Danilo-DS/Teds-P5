package br.com.aulacarlos.application.exception.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ClientNotFound(String msg) {
		super(msg);
	}
	
}
