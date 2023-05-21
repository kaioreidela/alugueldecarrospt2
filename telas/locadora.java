package telas;

import repositorio.repositoriocarro;
import repositorio.repositorioclientes;
import dados.gerente;
import dados.pessoa;
import dados.cliente;
import dados.veiculo;
import dados.negociocliente;
import dados.negociogerente;



public class locadora {
   repositoriocarro repositoriocarro = new repositoriocarro();

   public locadora(){
      negociocliente negociocliente = new negociocliente();
      negociogerente negociogerente = new negociogerente();
      repositoriocarro repositoriocarro = new repositoriocarro();
      repositorioclientes repositorioclientes = new repositorioclientes();

   }

   public void cadastrarPessoa( String nome ,int cpf){
      pessoa pessoa = new pessoa(nome,cpf);
   }
 
  
   public void cadastrarGerente( String nome ,int cpf ,String loginGer , int senhaGer){
      gerente gerente = new gerente(nome, cpf, loginGer, senhaGer);
   }

   public void cadastrarCliente(String nome3, int cpf3, String loginCli, int senhaCli){
      cliente cliente = new cliente(nome3, cpf3,loginCli, senhaCli);
   }

   public void cadastrarVeiculo( String modelo, String marca,  String codigo){
      veiculo veiculo = new veiculo(modelo,marca,codigo);
      repositoriocarro.veiculos.add(veiculo);
      
   }

}
