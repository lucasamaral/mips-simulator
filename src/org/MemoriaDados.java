package org;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class MemoriaDados {

	private HashMap<Integer,Integer> valores = new HashMap<>();
	private Deque<Integer> ultimosEnderecosUtlizados = new LinkedList<>();
	
	public int getValue(int endereco) {
		return valores.get(endereco);
	}

	public void setValue(int endereco, int value) {
		ultimosEnderecosUtlizados.add(endereco);
		valores.put(endereco, value);
	}

}
