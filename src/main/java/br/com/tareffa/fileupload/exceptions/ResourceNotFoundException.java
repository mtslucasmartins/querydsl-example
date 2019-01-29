package br.com.tareffa.fileupload.exceptions;

import br.com.tareffa.fileupload.enums.Errors;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Errors error) {
		super(error.toString());
	}

}
