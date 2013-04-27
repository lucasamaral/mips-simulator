package org;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GeradorInstrucoesPrograma {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static String[] gerarProgramaPadrao() {
		return new String[] {
				"00100000000010100000000000000100 ;I1: addi R10,R0,100",
				"10101100000000000000000000011000			; I2: sw R0,24(R0)",
				"10101100000000000000000000011100			; I3: sw R0,28(R0)",
				"10001100000001100000000000011100			; I4: lw R6,28(R0)",
				"00000000110001100011100000011000			; I5: mul R7,R6,R6",
				"10001100000000010000000000011000			; I6: lw R1,24(R0)",
				"00000000001001110100100000100000			; I7: add R9,R1,R7",
				"10101100000010010000000000011000			; I8: sw R9,24(R0)",
				"00100000110001100000000000000001			; I9: addi R6,R6,1",
				"10101100000001100000000000011100			; I10: sw R6,28(R0)",
				"00011100110010100000000000001100			; I11: ble R6,R10,12" };
	}

	public static String[] gerarProgramadeArquivo(String endereco) {
		List<String> linhas = new ArrayList<>();
		Path path = Paths.get(endereco);
		try (Scanner scanner = new Scanner(path, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				linhas.add(scanner.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] resultado = new String[linhas.size()];
		int i=0;
		for(String linha : linhas){
			resultado[i++] = linha;
		}
		return resultado;
	}

}
