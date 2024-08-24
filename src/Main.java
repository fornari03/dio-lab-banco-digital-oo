
public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco("BancoNew");
		Cliente venilton = new Cliente("Venilton", "000.000.000-00");
		Cliente junior = new Cliente("Junior", "111.111.111-00");
		
		Conta contaVenilton = new ContaCorrente(venilton, 550, 1000);
		Conta contaJunior = new ContaPoupanca(junior, 0.01);
		banco.addConta(contaVenilton);
		banco.addConta(contaJunior);

		banco.listarTodasContas();

		contaVenilton.transferir(100, contaJunior);
		System.out.println();
		
		banco.listarTodasContas();

		contaJunior.depositar(50);
		((ContaPoupanca) contaJunior).render();

		banco.listarTodasContas();
		
	}

}
