
public class ContaPoupanca extends Conta {

	private double taxaRendimento;
	
	public ContaPoupanca(Cliente cliente, double taxaRendimento) {
		super(cliente);
		this.taxaRendimento = taxaRendimento;
	}

	public ContaPoupanca(Cliente cliente, double saldo, double taxaRendimento) {
		super(cliente, saldo);
		this.taxaRendimento = taxaRendimento;
	}
	
	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public void render() {
		System.out.printf("Rendimento realizado na conta de %s\n", this.cliente.getNome());
		this.saldo += saldo * taxaRendimento;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
