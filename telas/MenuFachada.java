package telas;

import java.util.Scanner;

import dados.Cliente;
import dados.Gerente;
import dados.Pessoa;
import repositorio.Repositoriocarro;
import repositorio.Repositorioclientes;

public class MenuFachada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        Repositorioclientes repositoriocliente = new Repositorioclientes();
        Repositoriocarro repositoriocarro = new Repositoriocarro();
        Locadora locadora = new Locadora();
        Locadoracliente locadoraCliente = new Locadoracliente(repositoriocliente,repositoriocarro);
        Locadoragerente locadoraGerente = new Locadoragerente(repositoriocliente,repositoriocarro);
        System.out.println("\033[0;33mSEJA BEM VINDO AO LOGIN INICIAL\033[0m");
        System.out.println("\033[0;33mPRIMEIRAMENTE CADASTRE-SE COMO UM CIDADÃO\033[0m\n");
        System.out.println("DIGITE SEU NOME:");
        String nome = scanner.nextLine();
        System.out.println("DIGITE SEU CPF:");
        int cpf = Integer.valueOf(scanner.nextLine());
        Pessoa pessoa = locadora.cadastrarPessoa(nome, cpf);

        System.out.println("\n\033[0;32mCadastro de Cidadão Concluído:\033[0m");
        System.out.println("NOME: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf());
        System.out.println("\n\033[0;33mAgora cadastre-se como um Gerente\033[0m");
        System.out.println("\nDIGITE O LOGIN QUE DESEJA CADASTRAR:");
        String loginGer = scanner.nextLine();
        System.out.println("DIGITE A SENHA(PIN) QUE DESEJA CADASTRAR:");
        int senhaGer = Integer.valueOf(scanner.nextLine());
        Gerente gerente = locadora.cadastrarGerente(nome, cpf, loginGer, senhaGer);
        System.out.println("\n\033[0;32mCadastro de Gerente Concluído!\033[0m");
        System.out.println("\n\033[0;33mAviso: O programa já começa com um veiculo e um cliente cadastrado apenas para facilitar a visualização do programa\033[0m");
        System.out.println("CLIENTES DA LOJA:");
        try {
            locadoraGerente.getNegociogerente().listar();
        } catch (Exception e) {
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
        System.out.println("VEICULOS DA LOJA:");
        try {
            locadoraGerente.repositoriocarro.listar();
        } catch (Exception ex) {
            System.out.println("Mensagem de erro: " + ex.getMessage());
        }

        do {
            System.out.println(
                    "\n\033[0;32mSEJA BEM VINDO A LOCALIZA 2.0\033[0m\n" + "Por favor, informe seu tipo de usuário selecionando um número (gerente ou cliente)\n"
                            + "Digite 1 para: Gerente \n" + "Digite 2 para: Cliente  \n" + "Digite 3 para: Sair do programa");
            int opcao = Integer.valueOf(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("\n\033[0;33mVocê escolheu a opção Gerente\033[0m");
                    System.out.println("Digite o login do gerente:");
                    String login = scanner.nextLine();
                    System.out.println("Digite a senha (PIN) do gerente:");
                    int senha = Integer.valueOf(scanner.nextLine());
                    if (login.equals(gerente.getLoginGer()) && senha == gerente.getsenhaGer()) {
                        boolean sairGerente = false;
                        do {
                            System.out.println(
                                    "\nGerente,escolha uma opção:\n" + "1 - Cadastrar veículo\n" + "2 - Remover veículo\n" + "3 - Listar veículos\n"
                                            + "4 - Cadastrar cliente\n" + "5 - Remover cliente\n" + "6 - Listar clientes\n" + "7 - Mudar seu login ou senha\n" + "8 - Sair");
                            int opcaoGerente = Integer.valueOf(scanner.nextLine());
                            switch (opcaoGerente) {
                                case 1:
                                    System.out.println("\n\033[0;33mCadastro de Veículo\033[0m");
                                    System.out.println("Digite o modelo do veículo:");
                                    String modelo = scanner.nextLine();
                                    System.out.println("Digite o nome da marca:");
        							String marca = scanner.nextLine();
                                    System.out.println("Digite a placa do veículo:");
                                    String placa = scanner.nextLine(); 
                                    System.out.println("\nVEICULOS DA LOJA:");
                                    try {
                                    	locadoraGerente.cadastrarVeiculo(modelo, marca, placa);
                                    }catch (Exception e1) {
                                    	System.out.println("Mensagem de erro: " + e1.getMessage());
                                    }   
                                    System.out.println("\n\033[0;32mVeículo cadastrado com sucesso!\033[0m");
                                    break;
                                case 2:
                                    System.out.println("\n\033[0;33mRemover Veículo\033[0m");
                                    System.out.println("Digite a placa do veículo que deseja remover:");
                                    String placaRemover = scanner.nextLine();
                                    System.out.println("\nVEICULOS DA LOJA:");
                                    try {
                                    	locadoraGerente.removerVeiculo(placaRemover);
                                    }catch(Exception e2) {
                                    	System.out.println("Mensagem de erro: " + e2.getMessage());
                                    } 
                                    System.out.println("\n\033[0;32mVeículo removido com sucesso!\033[0m");
                                    break;
                                case 3:
                                    System.out.println("\n\033[0;33mListagem de Veículos\033[0m");
                                    try {
                                        locadoraGerente.listarVeículos();
                                    } catch (Exception e3) {
                                        System.out.println("Mensagem de erro: " + e3.getMessage());
                                    }
                                    break;
                                case 4:
                                    System.out.println("\n\033[0;33mCadastro de Cliente\033[0m");
                                    System.out.println("Digite o nome do cliente:");
                                    String nomeCliente = scanner.nextLine();
                                    System.out.println("Digite o CPF do cliente:");
                                    int cpfCliente = Integer.valueOf(scanner.nextLine());
                                    System.out.println("Digite o login para quando desejar entrar no sistema:");
        							String loginCli = scanner.nextLine();
        							System.out.println("Digite a senha(pin):");
        							int senhaCli = Integer.valueOf(scanner.nextLine());
        							System.out.println("\nCLIENTES DA LOJA:");
        							try {
        								locadoraGerente.cadastrarCliente(nomeCliente, cpfCliente, loginCli, senhaCli);
        							} catch (Exception e4) {
        								System.out.println("Mensagem de erro: " + e4.getMessage());
        							}
        							System.out.println("\n\033[0;32mCliente cadastrado com sucesso!\033[0m");
                                    break;
                                case 5:
                                    System.out.println("\n\033[0;33mRemover Cliente\033[0m");
                                    System.out.println("Digite o CPF do cliente que deseja remover:");
                                    int cpfRemover = Integer.valueOf(scanner.nextLine());
                                    try {
                                    	locadoraGerente.removerCliente(cpfRemover);
                                    } catch (Exception e5) {
                                    	System.out.println("Mensagem de erro: " + e5.getMessage());
                                    }
                                    System.out.println("\n\033[0;32mCliente removido com sucesso!\033[0m");
                                    break;
                                case 6:
                                    System.out.println("\n\033[0;33mListagem de Clientes\033[0m");
                                    try {
                                        locadoraGerente.listarClientes();
                                    } catch (Exception e) {
                                        System.out.println("Mensagem de erro: " + e.getMessage());
                                    }
                                    break;
                                case 7:
                                	System.out.println("\n\033[0;33mVocê escolheu mudar login ou senha\033[0m");
            						System.out.println("1-login ou 2-senha");
            						int l_s = Integer.valueOf(scanner.nextLine());
            						if(l_s == 1) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar login\033[0m");
            							System.out.println("Digite seu novo login:");
            							String novologin = scanner.nextLine();
            							gerente.setLoginGer(novologin);
            							System.out.println("\n\033[0;32mLogin mudado com sucesso!\033[0m");
            						}else if(l_s == 2) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar senha\033[0m");
            							System.out.println("Digite sua nova senha(pin):");
            							int novasenha = Integer.valueOf(scanner.nextLine());
            							gerente.setsenhaGer(novasenha);
            							System.out.println("\n\033[0;32mSenha mudada com sucesso!\033[0m");
            						}else {
            							System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
            						}
            						break;
                                case 8:
                                    sairGerente = true;
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                        } while (!sairGerente);
                    } else {
                        System.out.println("\nLogin ou senha inválidos!");
                    }
                    break;
                case 2:
                    System.out.println("\n\033[0;33mVocê escolheu a opção Cliente\033[0m");
                    System.out.println("Digite o login do cliente:");
                    String login2 = scanner.nextLine();
                    System.out.println("Digite a senha(pin) do cliente:");
                    int senha2 = Integer.valueOf(scanner.nextLine());
                    Cliente cliente = locadoraCliente.loginCliente(login2, senha2);
                    if (cliente != null) {
                        boolean sairCliente = false;
                        do {
                            System.out.println("\nCliente,escolha uma opção:\n" + "1 - Alugar veículo\n" + "2 - Devolver veículo\n" + "3 - Ver veiculos disponiveis\n" + "4 - Mudar login ou senha\n" + "5 - Sair");
                            int opcaoCliente = Integer.valueOf(scanner.nextLine());
                            switch (opcaoCliente) {
                                case 1:
                                	System.out.println("\n\033[0;33mAlugar Veículo\033[0m");
                                	System.out.println("VEICULOS DISPONIVEIS:");
                                	try {
                                		locadoraCliente.listardisponibilidade();
                                	}catch(Exception e1) {
                                		System.out.println("Erro: " + e1.getMessage());
                                	}
                                    System.out.println("\nDigite a placa do veículo que deseja alugar:");
                                    String placaAlugar = scanner.nextLine();
                                    System.out.println("\nLISTA DE CARROS ALUGADOS POR: " + cliente.getNome());
                                    try {
                                    	locadoraCliente.alugarVeiculo(placaAlugar, cliente);
                                    }catch(Exception e1) {
                                    	System.out.println("Erro: " + e1.getMessage());
                                    }
                                    break;
                                case 2:
                                    System.out.println("\n\033[0;33mDevolver Veículo\033[0m");
                                    System.out.println("\nLISTA DE CARROS ALUGADOS POR: " + cliente.getNome());
                                    try {
                                    	locadoraCliente.verCarrosAlugados(cliente);
                                    } catch (Exception e2) {
                                    	System.out.println("Erro: " + e2.getMessage());
                                    }
                                    System.out.println("\nDigite a placa do veículo que deseja devolver:");
                                    String placaDevolver = scanner.nextLine();
                                    System.out.println("\nLISTA DE CARROS ALUGADOS POR: " + cliente.getNome());
                                    try {
                                    	locadoraCliente.devolverVeiculo(placaDevolver, cliente);
                                    }catch(Exception e2) {
                                    	System.out.println("Erro: " + e2.getMessage());
            						}
                                    break;
                                case 3:
                                	try {
            							System.out.println("\n\033[0;33mVocê escolheu ver veiculos disponiveis\033[0m");
            							System.out.println("VEICULOS DISPONIVEIS:");
            							locadoraCliente.listardisponibilidade();
            						}catch (Exception e3) {
            							System.out.println("Erro: " + e3.getMessage());
            						}
            						break;
                                case 4:
                                	System.out.println("\n\033[0;33mVocê escolheu mudar login ou senha\033[0m");
            						System.out.println("1-login ou 2-senha");
            						int l_s = Integer.valueOf(scanner.nextLine());
            						if(l_s == 1) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar login\033[0m");
            							System.out.println("Digite seu novo login:");
            							String login4 = scanner.nextLine();
            							cliente.setLoginCli(login4);
            							System.out.println("\n\033[0;32mLogin mudado com sucesso!\033[0m");
            						}else if(l_s == 2) {
            							System.out.println("\n\033[0;33mVocê escolheu mudar senha\033[0m");
            							System.out.println("Digite sua nova senha(pin):");
            							int senha4 = Integer.valueOf(scanner.nextLine());
            							cliente.setsenhaCli(senha4);
            							System.out.println("\n\033[0;32mSenha mudada com sucesso!\033[0m");
            						}else {
            							System.out.println("\n\033[0;31mOPÇÃO NÃO EXISTE!\033[0m");
            						}
            						break;
            						
                                case 5:
                                    sairCliente = true;
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                        } while (!sairCliente);
                    } else {
                    	System.out.println("\n\033[0;31mLogin ou Senha errado\033[0m");
                    }
                    break;
                    
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!sair);

        scanner.close();
    } 
}