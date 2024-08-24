import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public  Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void addConta(Conta conta) {
		this.contas.add(conta);
	}

	public void listarTodasContas() {
		this.contas.stream().forEach(Conta::imprimirExtrato);
	}

}
