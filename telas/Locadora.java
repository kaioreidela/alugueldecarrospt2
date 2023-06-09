package telas;

import dados.Gerente;
import dados.Negociocliente;
import dados.Negociogerente;
import dados.Pessoa;
import repositorio.Repositoriocarro;
import repositorio.Repositorioclientes;

public class Locadora {
    private Negociocliente negociocliente;
    private Negociogerente negociogerente;
    Repositoriocarro repositoriocarro = new Repositoriocarro();
    Repositorioclientes repositorioclientes = new Repositorioclientes();
   
   
    public Locadora(){
       this.setNegociocliente(new Negociocliente(repositorioclientes, repositoriocarro));
       this.setNegociogerente(new Negociogerente(repositorioclientes));
    
    }
   

   public Pessoa cadastrarPessoa( String nome ,int cpf){
      Pessoa pessoa = new Pessoa(nome,cpf);
      return pessoa;
   }
 
  
   public Gerente cadastrarGerente( String nome ,int cpf ,String loginGer , int senhaGer){
      Gerente gerente = new Gerente(nome, cpf, loginGer, senhaGer);
      return gerente;
   }


public Negociocliente getNegociocliente() {
	return negociocliente;
}


public void setNegociocliente(Negociocliente negociocliente) {
	this.negociocliente = negociocliente;
}


public Negociogerente getNegociogerente() {
	return negociogerente;
}


public void setNegociogerente(Negociogerente negociogerente) {
	this.negociogerente = negociogerente;
}


public void cadastrarVeiculo(String modelo, String marca, String codigo) {
	
}

}