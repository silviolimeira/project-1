package com.sl.batch.model;

public enum OperationMode {

	GET(1), POST(2);

	private final int valor;
	
	OperationMode(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}	
	
}
