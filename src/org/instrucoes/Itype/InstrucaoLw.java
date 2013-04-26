package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoLw extends InstrucaoItype {

	int posicaoMemoria;
	
	public InstrucaoLw(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.LW;
		posicaoMemoria = 0;
	}

	@Override
	public void execute(Processador proc) {
		// rt = MEM[rs+int(imm)]
		// parte de acesso à memoria e escrita no registrador deverá ser feita depois
		BancoDeRegistradores banco = proc.getRegistradores();
		int rsValue = banco.readRegister(rsCode);
		posicaoMemoria = rsValue+ Integer.parseInt(immCode, 2);
	}

	@Override
	public void decode(Processador proc) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void memory(MemoriaDados memoria) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void writeBack(BancoDeRegistradores banco,int valorULA,int valorMem) {
		banco.writeRegister(rtCode, valorMem);
	}

	public String getRtCode() {
		return rtCode;
	}

}
