package telas;

import java.util.Scanner;
import repositorio.repositoriocarro;
import repositorio.repositorioclientes;
import dados.cliente;
import dados.gerente;
import dados.negociocliente;
import dados.pessoa;
import dados.veiculo;

public class menufachada {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        locadora locadora = new locadora();
        locadoracliente locadoracliente = new locadoracliente();
        locadoragerente locadoragerente = new locadoragerente();
		System.out.println("\033[0;33mSEJA BEM VINDO AO LOGIN INICIAL\033[0m");
		System.out.println("\033[0;33mPRIMEIRAMENTE CADASTRE-SE COMO UM CIDADÃO\033[0m\n");
		System.out.println("DIGITE SEU NOME:");
		String nome = scanner.nextLine();
		System.out.println("DIGITE SEU CPF:");
		int cpf = Integer.valueOf(scanner.nextLine());
		pessoa pessoa = locadora.cadastrarPessoa(nome, cpf);
    
		System.out.println("\n\033[0;32mCadastro de Cidadão Concluído:\033[0m");
		System.out.println("NOME: "+ pessoa.getNome() + "\nCPF: " + pessoa.getCpf());
		System.out.println("\n\033[0;33mAgora cadastre-se como um Gerente\033[0m");
		System.out.println("\nDIGITE O LOGIN QUE DESEJA CADASTRAR:");
		String loginGer = scanner.nextLine();
		System.out.println("DIGITE A SENHA(PIN) QUE DESEJA CADASTRAR:");
		int senhaGer = Integer.valueOf(scanner.nextLine());
		gerente gerente = locadora.cadastrarGerente(nome, cpf, loginGer, senhaGer);
		System.out.println("\n\033[0;32mCadastro de Gerente Concluído!\033[0m");
		System.out.println("\n\033[0;33mAviso: O programa já começa com um veiculo e um cliente cadastrado apenas para facilitar a visualização do programa\033[0m");
	    locadoracliente.repositorioclientes.listar();
        locadoragerente.repositoriocarro.listar();
		
        do {
        	System.out.println("\n\033[0;32mSEJA BEM VINDO A LOCALIZA 2.0\033[0m\n"
        	+ "Por favor, informe seu tipo de usuário selecionando um número (gerente/cliente)\n"
        	+ "Digite 1 para: Gerente \n"
        	+ "Digite 2 para: Cliente  \n"
        	+ "Digite 3 para: Sair do programa");
        	int opcao = Integer.valueOf(scanner.nextLine());
        	switch(opcao){
        		case 1:  
        			System.out.println("\n\033[0;33mVocê escolheu a opção Gerente\033[0m");
        			System.out.println("Digite o login do gerente:");
        			String loginteste = scanner.nextLine();
        			System.out.println("Digite a senha(pin) do gerente:");
        			int senhateste = Integer.valueOf(scanner.nextLine());
        			if (loginteste.equals(gerente.getLoginGer()) && senhateste == gerente.getsenhaGer()) {
        				System.out.println("\n\033[0;32mLogin de gerente bem-sucedido!\033[0m");
        				boolean sair1 = false;
        				do {
        					System.out.println("\n\033[0;33mGerente, o que deseja fazer?\033[0m\n"
        					+ "Digite 1 para: Cadastrar Veiculo \n"
        					+ "Digite 2 para: Remover Veiculo \n"
        					+ "Digite 3 para: Cadastrar Cliente \n"
        					+ "Digite 4 para: Remover Cliente \n" 
        					+ "Digite 5 para: Listar Clientes \n"
        					+ "Digite 6 para: Mudar seu login ou senha\n"
        					+ "Digite 7 para: Sair do menu gerente"); 
        					int opcao1 = Integer.valueOf(scanner.nextLine());
        					switch(opcao1){
        						case 1:
        							System.out.println("\n\033[0;33mVocê escolheu Cadastrar Veiculo\033[0m");
        							System.out.println("Digite o nome do modelo:");
        							String modelo = scanner.nextLine();
        							System.out.println("Digite o nome da marca:");
        							String marca = scanner.nextLine();
        							System.out.println("Digite a placa:");
        							String codigo = scanner.nextLine();
        							locadoragerente.cadastrarVeiculo(modelo, marca, codigo);
        							break;

        						case 2:
        							System.out.println("\n\033[0;33mVocê escolheu Remover Veiculo\033[0m");
        							System.out.println("Digite a placa do veiculo:");
        							String cod = scanner.nextLine();    							
        							locadoragerente.removerVeiculo(cod);
        							break;

        						case 3:
        							System.out.println("\n\033[0;33mVocê escolheu Cadastrar Cliente\033[0m");
        							System.out.println("Digite o nome completo do cliente:");
        							String nome3 = scanner.nextLine();
        							System.out.println("Digite o CPF do cliente:");
        							int cpf3 = Integer.valueOf(scanner.nextLine());
        							System.out.println("Digite o login para quando desejar entrar no sistema:");
        							String loginCli = scanner.nextLine();
        							System.out.println("Digite a senha(pin):");
        							int senhaCli = Integer.valueOf(scanner.nextLine());
                                    locadoragerente.cadastrarCliente(nome3, cpf3, loginCli, senhaCli);
        							break;

        						case 4:
        							System.out.println("\n\033[0;33mVocê escolheu Remover Cliente\033[0m");									
        							System.out.println("Digite o CPF do cliente:");
        							int delCpf = Integer.valueOf(scanner.nextLine());
        							locadoragerente.removerCliente(delCpf);
        							break;
        						
        						case 5:
        							System.out.println("\n\033[0;33mLISTA DE CLIENTES:\033[0m");
        							locadoragerente.listarClientes();
        							break;
        							
        						case 6:
        							System.out.println("\n\033[0;33mVocê escolheu mudar login/senha\033[0m");
            						System.out.println("1-login / 2-senha");
            						int opcao6 = Integer.valueOf(scanner.nextLine());
            						if(opcao6 == 1) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar login\033[0m");
            							System.out.println("Digite seu novo login:");
            							String novologin = scanner.nextLine();
            							gerente.setLoginGer(novologin);
            							System.out.println("\n\033[0;32mLogin mudado com sucesso!\033[0m");
            						}else if(opcao6 == 2) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar senha\033[0m");
            							System.out.println("Digite sua nova senha(pin):");
            							int novasenha = Integer.valueOf(scanner.nextLine());
            							gerente.setsenhaGer(novasenha);
            							System.out.println("\n\033[0;32mSenha mudada com sucesso!\033[0m");
            						}else {
            							System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
            						}
            						break;       							
        							
        						case 7:
        							System.out.println("\n\033[0;32mSAINDO DO MENU GERENTE...\033[0m");
        							sair1 = true;
        							break;
        							
        						default:
        							System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
        		        			break;
        					}
        				}while(!sair1);
        			}else{
        				System.out.println("\n\033[0;31mLogin ou Senha errado!\033[0m");
        			}
        			break;
          
        		case 2:
        			System.out.println("\n\033[0;33mVocê escolheu a opção Cliente\033[0m");
        			System.out.println("Digite o login do cliente:");
        			String login2 = scanner.nextLine();
        			System.out.println("Digite a senha(pin) do cliente:");
        			int senha2 = Integer.valueOf(scanner.nextLine());
                    cliente cliente = locadoracliente.loginCliente(login2, senha2);
        			if (cliente != null) {
        				System.out.println("\n\033[0;32mLogin de Cliente bem-sucedido!\033[0m");
        				boolean sair2 = false;
        				do {
        					System.out.println("\n\033[0;33mCliente, o que deseja fazer?\033[0m\n"
        					+ "Digite 1 para: Alugar veiculo \n"
        					+ "Digite 2 para: Devolver veiculo\n"
        					+ "Digite 3 para: Ver veiculos disponiveis\n"
        					+ "Digite 4 para: Mudar login ou senha\n"
        					+ "Digite 5 para: Sair do menu cliente");                
        					int opcao2 = Integer.valueOf(scanner.nextLine());
        					switch(opcao2){            
            					case 1:
            						System.out.println("\n\033[0;33mVocê escolheu Alugar veiculo\033[0m");
            						if(locadoracliente.listardisponibilidade() == 1) {
            							break;
            						}
            						System.out.println("\nDigite a placa:");
            						String placa = scanner.nextLine();
            						locadoracliente.alugarVeiculo(placa, cliente);
            						break;
            					
            					case 2: 
            						System.out.println("\n\033[0;33mVocê escolheu devolver veiculo\033[0m");       						
            						System.out.println("\nDigite a placa:");
            						String placa2 = scanner.nextLine();
									locadoracliente.devolverVeiculo(placa2, cliente);
            						break;
            					
            					case 3:
            						System.out.println("\n\033[0;33mVocê escolheu ver veiculos disponiveis\033[0m");
									locadoracliente.listardisponibilidade();
            						break;
            					
            					case 4:
            						System.out.println("\n\033[0;33mVocê escolheu mudar login/senha\033[0m");
            						System.out.println("1-login / 2-senha");
            						int opcao4 = Integer.valueOf(scanner.nextLine());
            						if(opcao4 == 1) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar login\033[0m");
            							System.out.println("Digite seu novo login:");
            							String login = scanner.nextLine();
            							cliente.setLoginCli(login);
            							System.out.println("\n\033[0;32mLogin mudado com sucesso!\033[0m");
            						}else if(opcao4 == 2) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar senha\033[0m");
            							System.out.println("Digite sua nova senha(pin):");
            							int senha = Integer.valueOf(scanner.nextLine());
            							cliente.setsenhaCli(senha);
            							System.out.println("\n\033[0;32mSenha mudada com sucesso!\033[0m");
            						}else {
            							System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
            						}
            						break;
            						          						
            					case 5:
            						System.out.println("\n\033[0;32mSAINDO DO MENU CLIENTE...\033[0m");
        							sair2 = true;
        							break;        							
            					default:
            						System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
        		        			break;
        					}
        				}while(!sair2);
        			}else{
        				System.out.println("\n\033[0;31mLogin ou Senha errado\033[0m");
        			}
        			break;       			
        		case 3:
        			System.out.println("\n\033[0;32mFIM DO PROGRAMA, SAINDO...\033[0m");
        			sair = true;
        			break;
        		default:
        			System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
        			break;
        	} 
        }while(!sair);
        scanner.close();
	}
}
