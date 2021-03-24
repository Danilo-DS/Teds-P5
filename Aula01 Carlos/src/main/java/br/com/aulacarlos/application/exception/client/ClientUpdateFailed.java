package br.com.aulacarlos.application.exception.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClientUpdateFailed extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ClientUpdateFailed(String msg) {
		super(msg);
	}
}
