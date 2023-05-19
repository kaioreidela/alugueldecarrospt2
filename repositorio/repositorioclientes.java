package repositorio;
import java.util.ArrayList;
import java.util.List;
import dados.cliente;

public class repositorioclientes {
    public List<cliente> clientes =  new ArrayList<cliente>();
    
    public repositorioclientes() {
    	cliente c = new cliente("fulano", 12345, "ful", 321);
    	clientes.add(c);
    }
    
    public void cadastrarCliente(cliente cliente) {
        clientes.add(cliente);   
        // retirar pq println fica fora 
        // System.out.println("\n\033[0;32mCliente cadastrado com sucesso!\033[0m");
    }

    public void deletarCliente(int cpf){
        for(cliente cliente  : clientes){       	
            if(cliente.getCpf() == cpf){
            	clientes.remove(cliente);
                break;
            }
                // retirar pq println fica fora 
            	//System.out.println("\n\033[0;32mCliente Removido!\033[0m");
        }
    }
    public void listar(){
        for (int i = 0; i <clientes.size(); i++) {
           clientes.get(i).mostrarDados();
        }  
    }
    // a funcaão abaixo como era antes. as condicoes de else devem ser tratadas como exeçoes

    
        // println tirado pois devera ser informado nas telas de menu
    	//System.out.println("CLIENTES CADASTRADOS:");
    	//if(repositorioclientes.clientes.size() > 0) {
    	//	for (int i = 0; i <repositorioclientes.clientes.size(); i++) {
        //        repositorioclientes.clientes.get(i).mostrarDados();
    	//	}   
       // }else {
            // retirar pq println fica fora 
            //lancar a excessao de erro
        //	System.out.println("\n\033[0;31mNENHUM CLIENTE CADASTRADO NA LOJA\033[0m");
    //    }
 
}
