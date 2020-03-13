package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	@Override
	public void saca(double valor) {
		if	(valor	<	0)	{
			throw new	IllegalArgumentException("Você tentou sacar um valor negativo");
		}
		if	(this.saldo	<	valor)	{
			throw new	SaldoInsuficienteException();
		}
this.saldo	-=	(valor	+	0.10);
	}
	
	public String getTipo() {
		return "ContaCorrente";
	}
	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.1;
	}
}
