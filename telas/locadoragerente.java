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

public class locadoragerente {
   private negociocliente negociocliente;
   private negociogerente negociogerente;
   repositoriocarro repositoriocarro = new repositoriocarro();
   repositorioclientes repositorioclientes = new repositorioclientes();
  
  
   public locadoragerente(){
      this.negociogerente = new negociogerente(repositorioclientes);
   
   }
   


   public cliente cadastrarCliente(String nome3, int cpf3, String loginCli, int senhaCli){
      cliente cliente = new cliente(nome3, cpf3,loginCli, senhaCli);
      repositorioclientes.clientes.add(cliente);
      repositorioclientes.listar();
      return cliente;
   }

   public void removerCliente(int delCpf){
      repositorioclientes.deletarCliente(delCpf);
      repositorioclientes.listar();
   }

   public veiculo cadastrarVeiculo( String modelo, String marca,  String codigo){
      veiculo veiculo = new veiculo(modelo,marca,codigo);
      repositoriocarro.veiculos.add(veiculo);
      repositoriocarro.listar();
      return veiculo;
      
   }   
   public void removerVeiculo(String cod){    							
      repositoriocarro.deletarVeiculo(cod);
      repositoriocarro.listar();
   }
   public void listarClientes(){
      repositorioclientes.listar();
   }

}
