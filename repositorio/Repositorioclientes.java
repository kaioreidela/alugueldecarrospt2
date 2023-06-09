package repositorio;
import java.util.ArrayList;
import java.util.List;

import dados.Cliente;
import dados.Exceptions;

public class Repositorioclientes {
    public List<Cliente> clientes =  new ArrayList<Cliente>();
    
    public Repositorioclientes() {
    	Cliente c = new Cliente("fulano", 12345, "ful", 321);
    	clientes.add(c);
    }
    
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);   
    }

    public void deletarCliente(int cpf) throws Exception {
        for(Cliente cliente  : clientes){       	
            if(cliente.getCpf() == cpf){
            	clientes.remove(cliente);
            	return;
            }
        }
        throw new Exceptions.cliente_nao_encontrado(cpf);
    }
}