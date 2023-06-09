package dados;
import java.util.ArrayList;

public class Cliente extends Pessoa{
	private String loginCli;
    private int senhaCli;
    public ArrayList<Veiculo> veiculos;
    
    public Cliente(String nome ,int cpf,String loginCli, int senhaCli) {
    	   super(nome,cpf);
    	   this.loginCli = loginCli;
           this.senhaCli = senhaCli;
           this.veiculos = new ArrayList<Veiculo>();    }
    
    public int getsenhaCli() {
        return senhaCli;
    }

    public void setsenhaCli(int senha) {
        this.senhaCli = senha;
    }
    
    @Override
	public void mostrarDados(){
        System.out.println("NOME: "+ getNome() + " CPF: " + getCpf() + " LOGIN: " + getLoginCli() + " SENHA: " + getsenhaCli());
    }
    
	public String getLoginCli() {
		return loginCli;
	}

	public void setLoginCli(String loginCli) {
		this.loginCli = loginCli;
	}
}