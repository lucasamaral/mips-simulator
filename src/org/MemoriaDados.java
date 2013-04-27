package org;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class MemoriaDados {

	private HashMap<Integer, Integer> valores = new HashMap<>();
	private Deque<Integer> ultimosEnderecosUtlizados = new LinkedList<Integer>();

	public int getValue(int endereco) {
		if (valores.containsKey(endereco))
			return valores.get(endereco);
		return 0;
	}

	public void setValue(int endereco, int value) {
		if(ultimosEnderecosUtlizados.contains(endereco)){
			ultimosEnderecosUtlizados.remove(endereco);
		}
		ultimosEnderecosUtlizados.add(endereco);
		valores.put(endereco, value);
	}

	public Set<Integer> getEnderecosUtilizados() {
		return valores.keySet();
	}
	
	public Iterator<Integer> getUltimosEnderecos() {
		return ultimosEnderecosUtlizados.descendingIterator();
		
	}

}
