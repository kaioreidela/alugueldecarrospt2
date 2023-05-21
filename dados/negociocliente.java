package dados;

import java.util.ArrayList;
import java.util.List;
import repositorio.repositoriocarro;
import repositorio.repositorioclientes;


public class negociocliente {
    repositoriocarro repositoriocarro = new repositoriocarro();
    repositorioclientes repositorioclientes = new repositorioclientes();
    

    // funcoes de veiculo do cliente
    public int listardisponibilidade(){
        // retirar pq println fica fora 
    	// System.out.println("VEICULOS DISPONIVEIS:");
    	if(repositoriocarro.veiculos.size() > 0) {
    		for (int i = 0; i < repositoriocarro.veiculos.size(); i++) {
            	if(repositoriocarro.veiculos.get(i).isDisponivel() == true) {       		
                System.out.println( "modelo:" + repositoriocarro.veiculos.get(i).getModelo() +",  " + "marca:" + repositoriocarro.veiculos.get(i).getMarca() + ",  " + "placa:" + repositoriocarro.veiculos.get(i).getplaca() + ",  " + "disponivel:" + repositoriocarro.veiculos.get(i).isDisponivel());
            	} 
    		}
    		return 0;
    	}
             // retirar pq println fica fora 
             //lancar a excessao de erro
    	//System.out.println("\033[0;31mNENHUM VEICULO DISPONIVEL NA LOJA\033[0m");
    	return 1;
    }
       
        public veiculo buscarVeiculoDisponivel(String placa) {
            for (veiculo veiculo : repositoriocarro.veiculos) {
                if (veiculo.getplaca().equals(placa) && veiculo.isDisponivel()) {
                    return veiculo;
                }
            }
            return null;
        }

    public void alugarVeiculo(String placa, cliente cliente) {
        veiculo veiculo = buscarVeiculoDisponivel(placa);
    
        if (veiculo != null && cliente != null) {
            veiculo.setDisponivel(false);
            adicionarVeiculonaListadoCliente(veiculo);
            repositoriocarro.veiculos.remove(veiculo);
            //funcao deve ser tratado no menu
            //System.out.println("\n\033[0;32mVeículo com placa:" + veiculo.getplaca() + "," + " alugado para o cliente " + cliente.getNome()+ "\033[0m");      
        }
    }
        // o else deve ser tratado como erro
        // else {
               // retirar pq println fica fora 
             //lancar a excessao de erro
         //   System.out.println("\n\033[0;31mVeículo não disponível ou cliente não encontrado\033[0m");
      //  }
    
  
  public void devolverVeiculo(String placa, cliente cliente) {
    veiculo veiculo = buscarVeiculoalugado(placa);

    if (veiculo != null && !veiculo.isDisponivel()) {
        veiculo.setDisponivel(true);
        removerVeiculonalistadoCliente(veiculo);
        repositoriocarro.veiculos.add(veiculo);
         //funcao deve ser tratado no menu
        //System.out.println("\n\033[0;33Veículo " + veiculo.getModelo() + " devolvido.\033[0m");
    }
    }
    // o else deve ser tratado como exception
    // else {
          // retirar pq println fica fora 
         //lancar a excessao de erro
    //    System.out.println("\n\033[0;31mVeículo não encontrado\033[0m");
    //}
    
       
    public void verCarrosAlugados(cliente cliente) {
            System.out.println(cliente.veiculos);
            // retirar pq println fica fora 
            // System.out.println("\nCARROS ALUGADOS POR VOCÊ:");
        }

        public veiculo buscarVeiculoalugado(String placa) {
            for (veiculo veiculo : repositoriocarro.veiculos) {
                if (veiculo.getplaca().equals(placa)) {
                    return veiculo;
                }
            }
            return null;
        } 
       
        public void adicionarVeiculonaListadoCliente(veiculo veiculo) {
            if (veiculo != null) {
                repositoriocarro.veiculos.add(veiculo);
            }
        }
    
        public void removerVeiculonalistadoCliente(veiculo veiculo) {
            if(veiculo != null) {
                repositoriocarro.veiculos.remove(veiculo);
            }
        }    
    // funcoes de veiculo do cliente
    
    public cliente login(String login, int senha) {
    	for (cliente cliente :repositorioclientes.clientes) {
    		if(cliente.getLoginCli().equals(login) && cliente.getsenhaCli() == senha) {
    			return cliente;
    		}	
    	}
    	return null;
    }

  
}

    

