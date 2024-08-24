
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public Conta(Cliente cliente, double saldo) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	@Override
    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
			return true;
		}
        System.out.println("Saldo insuficiente na conta.");
		return false;
    }

	@Override
	public void depositar(double valor) {
		saldo += valor;
		System.out.printf("Depósito de R$%.2f realizado na conta de %s\n", valor, this.cliente.getNome());
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (this.sacar(valor)) {
			System.out.printf("Transferência de R$%.2f realizada de %s para %s\n", valor, this.cliente.getNome(), ((Conta) contaDestino).getCliente().getNome());
			contaDestino.depositar(valor);
		}
		else {
			System.out.println("Não foi possível realizar a transferência.");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	protected void imprimirInfosComuns() {
		this.cliente.mostrarDados();
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: R$%.2f\n", this.saldo));
	}
}
