package dados;

public class Pessoa {
    private String nome;
    private int cpf;
    
    public Pessoa(String nome, int cpf) {
        this.setNome(nome);
        this.setCpf(cpf);   
    }
       
    public void mostrarDados(){
        System.out.println("NOME: "+getNome() + "\nCPF: " + getCpf());
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
}