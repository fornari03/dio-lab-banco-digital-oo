
public class ContaCorrente extends Conta {

	private double limite;

	public ContaCorrente(Cliente cliente, double limite) {
		super(cliente);
		this.limite = limite;
	}

	public ContaCorrente(Cliente cliente, double saldo, double limite) {
		super(cliente, saldo);
		this.limite = limite;
	}
		
	@Override
    public boolean sacar(double valor) {
        if (this.saldo - valor >= -limite) {
            this.saldo -= valor;
			return true;
		}
        System.out.println("Saldo insuficiente na conta.");
		return false;
    }

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
