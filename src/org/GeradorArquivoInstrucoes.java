package org;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GeradorArquivoInstrucoes {

	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void gerarArquivo(String enderecoEntrada, String enderecoSaida) {
		Path pathEntrada = Paths.get(enderecoEntrada);
		Path pathSaida = Paths.get(enderecoSaida);
		try (Scanner scanner = new Scanner(pathEntrada, ENCODING.name())) {
			try (BufferedWriter writer = Files.newBufferedWriter(pathSaida,
					ENCODING)) {
				while (scanner.hasNextLine()) {
					writer.write(processarLinha(scanner.nextLine()));
					writer.newLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String processarLinha(String line) {
		System.out.println(line);
		if (line.indexOf(";") != -1)
			line = line.split(";")[0];
		String content = line.split(" ")[1];
		switch (line.substring(0, 3).toUpperCase()) {
		case "MUL":
			return processarMUL(content) + " ; " + line;
		case "ADD":
			switch (line.substring(0, 4).toUpperCase()) {
			case "ADDI":
				return processarADDI(content) + " ; " + line;
			default:
				return processarADD(content) + " ; " + line;
			}
		case "SUB":
			return processarSUB(content) + " ; " + line;
		case "LW ":
			return processarLW(content) + " ; " + line;
		case "SW ":
			return processarSW(content) + " ; " + line;
		case "LI ":
			return processarLI(content) + " ; " + line;
		case "BEQ":
			return processarBEQ(content) + " ; " + line;
		case "BLE":
			return processarBLE(content) + " ; " + line;
		case "BNE":
			return processarBNE(content) + " ; " + line;
		case "JMP":
			return processarJMP(content) + " ; " + line;
		case "NOP":
			return processarNOP(content) + " ; " + line;
		default:
			break;
		}
		System.out.println(line);
		return null;
	}

	private static String reg(String substring) {
		return gerarStringBinaria(substring.substring(1), 5);
	}

	private static String gerarStringBinaria(String substring, int tamanho) {
		String a = Integer.toBinaryString(Integer.parseInt(substring));
		while (a.length() < tamanho) {
			a = "0" + a;
		}
		return a;
	}

	private static String processarRType(String code, String line) {
		String[] content = line.split(",");
		return "000000" + reg(content[1]) + reg(content[2]) + reg(content[0])
				+ "00000" + code;
	}

	private static String processarMUL(String line) {
		return processarRType("011000", line);
	}

	private static String processarADD(String line) {
		return processarRType("100000", line);
	}

	private static String processarADDI(String line) {
		return instrucaoTipoI("001000", line);
	}

	private static String instrucaoTipoI(String code, String line) {
		String[] content = line.split(",");
		return code + reg(content[1]) + reg(content[0])
				+ gerarStringBinaria(content[2], 16);
	}

	private static String processarLW(String line) {
		String[] content = line.split(",");
		String[] content2 = content[1].split("\\(");
		return "100011"
				+ reg(content2[1].substring(0, content2[1].length() - 1))
				+ reg(content[0]) + gerarStringBinaria(content2[0], 16);
	}

	private static String processarSUB(String line) {
		return processarRType("100010", line);
	}

	private static String processarSW(String line) {
		String[] content = line.split(",");
		String[] content2 = content[1].split("\\(");
		return "101011"
				+ reg(content2[1].substring(0, content2[1].length() - 1))
				+ reg(content[0]) + gerarStringBinaria(content2[0], 16);
	}

	private static String processarBEQ(String line) {
		String code = "000101";
		String[] content = line.split(",");
		return code + reg(content[0]) + reg(content[1])
				+ gerarStringBinaria(content[2], 16);
	}

	private static String processarLI(String line) {
		String[] content = line.split(",");
		return "001000" + "00000" + reg(content[0])
				+ gerarStringBinaria(content[1], 16);
	}

	private static String processarBLE(String line) {
		String code = "000111";
		String[] content = line.split(",");
		return code + reg(content[0]) + reg(content[1])
				+ gerarStringBinaria(content[2], 16);
	}

	private static String processarBNE(String line) {
		String code = "000100";
		String[] content = line.split(",");
		return code + reg(content[0]) + reg(content[1])
				+ gerarStringBinaria(content[2], 16);
	}

	private static String processarJMP(String line) {
		return "000010" + gerarStringBinaria(line, 24);
	}

	private static String processarNOP(String line) {
		return "00000000000000000000000000000000";
	}

}
