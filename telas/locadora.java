package telas;

import repositorio.repositoriocarro;
import repositorio.repositorioclientes;
import dados.gerente;
import dados.pessoa;
import dados.cliente;
import dados.veiculo;
import dados.negociocliente;
import dados.negociogerente;

// implementar metodos na locadora
// "Digite 1 para: Cadastrar Veiculo \n"
//+ "Digite 2 para: Remover Veiculo \n"
//+ "Digite 3 para: Cadastrar Cliente \n"
//+ "Digite 4 para: Remover Cliente \n" 
//+ "Digite 5 para: Listar Clientes \n"
//+ "Digite 6 para: Mudar seu login ou senha\n"

public class locadora {
    private negociocliente negociocliente;
    private negociogerente negociogerente;
    repositoriocarro repositoriocarro = new repositoriocarro();
    repositorioclientes repositorioclientes = new repositorioclientes();
   
   
    public locadora(){
       this.negociocliente = new negociocliente(repositorioclientes, repositoriocarro);
       this.negociogerente = new negociogerente(repositorioclientes);
    
    }
   

   public pessoa cadastrarPessoa( String nome ,int cpf){
      pessoa pessoa = new pessoa(nome,cpf);
      return pessoa;
   }
 
  
   public gerente cadastrarGerente( String nome ,int cpf ,String loginGer , int senhaGer){
      gerente gerente = new gerente(nome, cpf, loginGer, senhaGer);
      return gerente;
   }

}
