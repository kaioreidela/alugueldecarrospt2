package dados;

public class Exceptions {
	
	public static class nenhum_veiculo_disponivel extends Exception {
		@Override
		public String getMessage() {
			return "\033[0;31mNENHUM VEICULO DISPONIVEL NA LOJA\033[0m";
		}
	}
	
	public static class veiculo_ou_cliente_nao_encontrado extends Exception {
		@Override
		public String getMessage() {
			return "\033[0;31mVeículo não disponível ou cliente não encontrado\033[0m";
		}
	}
	
	public static class veiculo_listacliente_nao_encontrado extends Exception {
		private String placaVeiculo;
		
		public veiculo_listacliente_nao_encontrado(String placaVeiculo) {
			this.placaVeiculo = placaVeiculo;
		}
		@Override
		public String getMessage() {
			return "\033[0;31mVeículo com placa: " + placaVeiculo + " não encontrado\033[0m";
		}
	}
	
	public static class cliente_sem_veiculo_alugado extends Exception {
		private String nomeCliente;
		
		public cliente_sem_veiculo_alugado(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		@Override
		public String getMessage() {
			return "\033[0;31mNENHUM VEICULO ALUGADO POR " + nomeCliente + "\033[0m";
		}
	}
	
	public static class loja_sem_cliente extends Exception{
		@Override
		public String getMessage() {
			return "\033[0;31mNENHUM CLIENTE CADASTRADO NA LOJA\033[0m";
		}
	}
	
	public static class veiculo_nao_encontrado extends Exception{
		private String placaVeiculo;
		
		public veiculo_nao_encontrado(String placaVeiculo) {
			this.placaVeiculo = placaVeiculo;
		}
		@Override
		public String getMessage() {
			return "\033[0;31mVeículo com placa: " + placaVeiculo + " não encontrado\033[0m";
		}
	}
	
	public static class repositoriocarro_vazio extends Exception{
		@Override
		public String getMessage() {
			return "\033[0;31mNENHUM VEICULO NA LOJA\033[0m";
		}
	}
	
	public static class cliente_nao_encontrado extends Exception{
		private int cpfCliente;
		
		public cliente_nao_encontrado(int cpfCliente) {
			this.cpfCliente = cpfCliente;
		}
		@Override
		public String getMessage() {
			return "\033[0;31mCliente com cpf: " + cpfCliente + " não encontrado\033[0m";
		}
	}
}