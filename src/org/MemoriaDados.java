package org;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class MemoriaDados {

	private HashMap<Integer, Integer> valores = new HashMap<>();
	private Deque<Integer> ultimosEnderecosUtlizados = new LinkedList<Integer>();

	public void carregarMemoria(String endereco) throws IOException {
		Charset ENCODING = StandardCharsets.UTF_8;
		int i = 0;
		Path path = Paths.get(endereco);
		try (Scanner scanner = new Scanner(path, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				String dados = scanner.nextLine();
				int valorx = Integer.parseInt(dados.substring(0, 4).trim());
				int valory = Integer.parseInt(dados.substring(5, 9).trim());
				setValue(5000 + i, valory);
				setValue(1000 + i, valorx);
				i++;
			}
		}
	}

	public int getValue(int endereco) {
		if (valores.containsKey(endereco))
			return valores.get(endereco);
		return 0;
	}

	public void setValue(int endereco, int value) {
		if (ultimosEnderecosUtlizados.contains(endereco)) {
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
