package org;

public class BancoDeRegistradores {
	
	private int R0;
	private int R1;
	private int R2;
	private int R3;
	private int R4;
	private int R5;
	private int R6;
	private int R7;
	private int R8;
	private int R9;
	private int R10;
	private int R11;
	private int R12;
	private int R13;
	private int R14;
	private int R15;
	private int R16;
	
	public BancoDeRegistradores() {
		R0 = 0; R1 = 0;	R2 = 0;
		R3 = 0;	R4 = 0;	R5 = 0;
		R6 = 0;	R7 = 0;	R8 = 0;
		R9 = 0;	R10 = 0; R11 = 0;
		R12 = 0; R13 = 0; R14 = 0;
		R15 = 0; R16 = 0;
	}
	
	public void writeRegister(String regNumber, int value) throws Exception{
		switch (regNumber) {
		case "00000":
			R0 = value;
			break;
		case "00001":
			R1 = value;
			break;
		case "00010":
			R2 = value;
			break;
		case "00011":
			R3 = value;
			break;
		case "00100":
			R4 = value;
			break;
		case "00101":
			R5 = value;
			break;
		case "00110":
			R6 = value;
			break;
		case "00111":
			R7 = value;
			break;
		case "01000":
			R8 = value;
			break;
		case "01001":
			R9 = value;
			break;
		case "01010":
			R10 = value;
			break;
		case "01011":
			R11 = value;
			break;
		case "01100":
			R12 = value;
			break;
		case "01101":
			R13 = value;
			break;
		case "01110":
			R14 = value;
			break;
		case "01111":
			R15 = value;
			break;
		case "10000":
			R16 = value;
			break;
		default:
			throw new Exception("Valor inválido de registrador");
		}
	}
	
	public int readRegister(String regNumber) throws Exception{
		switch (regNumber) {
		case "00000":
			return R0;
		case "00001":
			return R1;
		case "00010":
			return R2;
		case "00011":
			return R3;
		case "00100":
			return R4;
		case "00101":
			return R5;
		case "00110":
			return R6;
		case "00111":
			return R7;
		case "01000":
			return R8;
		case "01001":
			return R9;
		case "01010":
			return R10;
		case "01011":
			return R11;
		case "01100":
			return R12;
		case "01101":
			return R13;
		case "01110":
			return R14;
		case "01111":
			return R15;
		case "10000":
			return R16;
		default:
			throw new Exception("Valor inválido de registrador");
		}
	}
}
