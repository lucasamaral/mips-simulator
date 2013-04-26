package org.instrucoes.Itype;

import org.BancoDeRegistradores;
import org.MemoriaDados;
import org.Processador;
import org.instrucoes.CodigoInstrucao;

public class InstrucaoBle extends InstrucaoItype {

	public InstrucaoBle(String entrada) {
		super(entrada);
		codigo = CodigoInstrucao.BLE;
	}

	@Override
	public void execute(Processador proc) {
		// if(rs<=rt) { PC = int(imm) }
		BancoDeRegistradores banco = proc.getRegistradores();
		int rsValue = banco.readRegister(rsCode);
		int rtValue = banco.readRegister(rtCode);
		if(rsValue <= rtValue){
			proc.setPc(Integer.parseInt(immCode, 2));
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

}
