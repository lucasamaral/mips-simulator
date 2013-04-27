package org;

import java.util.HashMap;

public class CentralSinais {
	
	
	private HashMap<String, Boolean> sinals = new HashMap<>();

	public boolean getSinal(String nome){
		return sinals.get(nome);
	}
	
	public void setSinal(String nome, boolean valor){
		sinals.put(nome, valor);
	}
}
