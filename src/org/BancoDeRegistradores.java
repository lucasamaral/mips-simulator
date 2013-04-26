package org;

public class BancoDeRegistradores {

	private int[] registros = new int[32];

	public void writeRegister(String regNumber, int value) {
		writeRegister(Integer.parseInt(regNumber, 2), value);
	}

	private void writeRegister(int endereco, int value) {
		System.out.println("Escrevendo no registrador - " + endereco + " - "
				+ value);
		registros[endereco] = value;
	}

	private int readRegister(int endereco) {
		System.out.println("Lendo no registrador - " + endereco + " - "
				+ registros[endereco]);
		return registros[endereco];
	}

	public int readRegister(String regNumber) {
		return readRegister(Integer.parseInt(regNumber, 2));
	}
}
