package dados;

import repositorio.Repositoriocarro;
import repositorio.Repositorioclientes;


public class Negociocliente {
    private Repositoriocarro repositoriocarro;
    private Repositorioclientes repositorioclientes;
   

    public Negociocliente(Repositorioclientes repositorioclientes, Repositoriocarro repositoriocarro){
        this.repositorioclientes = repositorioclientes;
        this.repositoriocarro = repositoriocarro;
    }
    
    public void listardisponibilidade() throws Exception {
        if (repositoriocarro.veiculos.size() > 0) {
            for (int i = 0; i < repositoriocarro.veiculos.size(); i++) {
                if (repositoriocarro.veiculos.get(i).isDisponivel()) {
                    System.out.println("modelo:" + repositoriocarro.veiculos.get(i).getModelo() + ",  " + "marca:"
                            + repositoriocarro.veiculos.get(i).getMarca() + ",  " + "placa:"
                            + repositoriocarro.veiculos.get(i).getplaca() + ",  " + "disponivel:"
                            + repositoriocarro.veiculos.get(i).isDisponivel());
                }
            }
        }
        else {
        	throw new Exceptions.nenhum_veiculo_disponivel();
        }
    }

       
        public Veiculo buscarVeiculoDisponivel(String placa) {
            for (Veiculo veiculo : repositoriocarro.veiculos) {
                if (veiculo.getplaca().equals(placa) && veiculo.isDisponivel()) {
                    return veiculo;
                }
            }
            return null;
        }

    public void alugarVeiculo(String placa, Cliente cliente) throws Exception {
        Veiculo veiculo = buscarVeiculoDisponivel(placa);
    
        if (veiculo != null && cliente != null) {
            veiculo.setDisponivel(false);
            adicionarVeiculonaListadoCliente(veiculo,cliente);
            repositoriocarro.veiculos.remove(veiculo);      
        }else {
        	throw new Exceptions.veiculo_ou_cliente_nao_encontrado();
        }
	}
    
  
    public void devolverVeiculo(String placa, Cliente cliente) throws Exception {
    	Veiculo veiculo = buscarVeiculoalugado(placa,cliente);

    	if (veiculo != null && !veiculo.isDisponivel()) {
    		veiculo.setDisponivel(true);
    		removerVeiculonalistadoCliente(veiculo,cliente);
    		repositoriocarro.veiculos.add(veiculo);
    	}
    	else {
    		throw new Exceptions.veiculo_listacliente_nao_encontrado(placa);
    	}
    }
    
       
  		public void verCarrosAlugados(Cliente cliente) throws Exception {
  			if (cliente.veiculos.size() > 0) {
  	            for (int i = 0; i < cliente.veiculos.size(); i++) {
  	                System.out.println("MODELO: " + cliente.veiculos.get(i).getModelo() + " MARCA: " + cliente.veiculos.get(i).getMarca()
  	                        + " PLACA: " + cliente.veiculos.get(i).getplaca() + " DISPONIVEL: " + cliente.veiculos.get(i).isDisponivel());
  	            }
  	        } else {
  	            throw new Exceptions.cliente_sem_veiculo_alugado(cliente.getNome());
  	        }
  	    }
    
    public Cliente login(String login, int senha) {
    	for (Cliente cliente :repositorioclientes.clientes) {
    		if(cliente.getLoginCli().equals(login) && cliente.getsenhaCli() == senha) {
    			return cliente;
    		}	
    	}
    	return null;
    }
    
    public void adicionarVeiculonaListadoCliente(Veiculo veiculo, Cliente cliente) {
        if (veiculo != null) {
            cliente.veiculos.add(veiculo);
        }
    }
    
    public void removerVeiculonalistadoCliente(Veiculo veiculo, Cliente cliente) {
        if(veiculo != null) {
            cliente.veiculos.remove(veiculo);
        }
    }
    
    public Veiculo buscarVeiculoalugado(String placa, Cliente cliente) {
        for (Veiculo veiculo : cliente.veiculos) {
            if (veiculo.getplaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

  
}

    
