package org;

import java.util.HashMap;

public class CentralSinais {
	
	
	private HashMap<String, Boolean> sinals;

	public boolean getSinal(String nome){
		return sinals.get(nome);
	}
	
	public void setSinal(String nome, boolean valor){
		
	}
}
