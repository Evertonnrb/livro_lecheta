package br.com.main;

import br.com.util.Connector;

public class MainTests {
	public static void main(String[] args) {
		if(Connector.connectar()!=null) {
			System.out.println("Conectado");
		}
	}
}
