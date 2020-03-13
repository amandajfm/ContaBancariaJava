package br.com.caelum.contas.modelo;

public abstract class Conta {
	protected double saldo;
	String titular;
	int numero;
	String agencia;
	
	@Override
	public String toString() {
		return "[titular=" + titular + ", numero= " + numero + ", agência = " + agencia + "]";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null) {
			return false;
		}
		
		Conta outraConta = (Conta) obj;
		
		return this.numero == outraConta.numero &&
				this.agencia.equals(outraConta.agencia);
	}
	
	public void deposita(double valor){
		if (valor < 0) {
			throw new IllegalArgumentException("você tentou depositar um valor negativo");
		} else {
		this.saldo+=valor;
		}
	}
	
	public void saca(double valor){
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		} else {
		this.saldo-=valor;
		}
		
	}
	
	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTitular() {
		return titular;
	}

	public abstract String getTipo();
	
}
