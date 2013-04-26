package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;


public class InstrucaoBeq extends InstrucaoItype {

	public InstrucaoBeq(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BEQ;
	}

	@Override
	public void execute(Processador proc) {
		// if(rs==rt) { PC = PC + 4 + int(imm) }
		BancoDeRegistradores banco = proc.getRegistradores();
		int rsValue = banco.readRegister(rsCode);
		int rtValue = banco.readRegister(rtCode);
		if(rsValue == rtValue){
			int pcNow = proc.getPc();
			proc.setPc(pcNow + 4 + Integer.parseInt(immCode, 2));
		}
	}

	@Override
	public void decode(Processador proc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memory(MemoriaDados memoria) {
		// TODO Auto-generated method stub
	}
	
	public boolean isBranch() {
		return true;
	}

}
