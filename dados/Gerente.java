package dados;

public class Gerente extends Pessoa {
	private String loginGer;
	private int senhaGer;

	public Gerente(String nome, int cpf, String loginGer, int senhaGer){
		super(nome,cpf);
		this.loginGer = loginGer;
		this.senhaGer = senhaGer;
	}

	public int getsenhaGer() {
		return senhaGer;
	}

	public void setsenhaGer(int senhaGer) {
		this.senhaGer = senhaGer;
	}

	public String getLoginGer() {
		return loginGer;
	}

	public void setLoginGer(String loginGer) {
		this.loginGer = loginGer;
	}
}