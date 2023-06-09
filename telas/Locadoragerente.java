package telas;

import dados.Cliente;
import dados.Negociocliente;
import dados.Negociogerente;
import dados.Veiculo;
import repositorio.Repositoriocarro;
import repositorio.Repositorioclientes;

public class Locadoragerente {
   private Negociocliente negociocliente;
   private Negociogerente negociogerente;
   Repositoriocarro repositoriocarro = new Repositoriocarro();
   Repositorioclientes repositorioclientes = new Repositorioclientes();
  
  
   public Locadoragerente(Repositorioclientes repositorioclientes, Repositoriocarro repositoriocarro){
	   this.repositoriocarro = repositoriocarro;
	   this.repositorioclientes = repositorioclientes;
	   this.setNegociogerente(new Negociogerente(repositorioclientes));
   
   }
   


   public void cadastrarCliente(String nome3, int cpf3, String loginCli, int senhaCli) throws Exception{
      Cliente cliente = new Cliente(nome3, cpf3,loginCli, senhaCli);
      repositorioclientes.cadastrarCliente(cliente);
      negociogerente.listar();
   }

   public void removerCliente(int delCpf) throws Exception{
      repositorioclientes.deletarCliente(delCpf);
      negociogerente.listar();
   }

   public void cadastrarVeiculo( String modelo, String marca,  String codigo) throws Exception{
      Veiculo veiculo = new Veiculo(modelo,marca,codigo);
      repositoriocarro.cadastrarVeiculo(veiculo);
      repositoriocarro.listar();      
   }   
   public void removerVeiculo(String cod) throws Exception{    							
      repositoriocarro.deletarVeiculo(cod);
      repositoriocarro.listar();
   }
   
   public void listarClientes() throws Exception{
      negociogerente.listar();
   }
   
   public void listarVeículos() throws Exception{
	   repositoriocarro.listar();
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

}