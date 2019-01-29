package br.com.tareffa.fileupload.enums;

public enum Errors {

	USER_NOT_FOUND("Não foi possível encontrar um usuário para o código identificador informado.");

	private String name;

	private Errors(String errorName) {
		name = errorName;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
