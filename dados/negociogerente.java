package dados;
import repositorio.repositorioclientes;

public class negociogerente {
    private repositorioclientes repositorioclientes2;
 
    public negociogerente(repositorioclientes repositorioclientes2){
        this.repositorioclientes2 = repositorioclientes2;
    }


    public void listar(){
        for (int i = 0; i <repositorioclientes2.clientes.size(); i++) {
            repositorioclientes2.clientes.get(i).mostrarDados();
            
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
