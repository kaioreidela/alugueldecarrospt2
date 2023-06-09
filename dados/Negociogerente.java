package dados;

import repositorio.Repositorioclientes;

public class Negociogerente {
	private Repositorioclientes Repositorioclientes;
	
	public Negociogerente(Repositorioclientes Repositorioclientes){
        this.Repositorioclientes = Repositorioclientes;
    }
	
	public void listar() throws Exception {
    	if (Repositorioclientes.clientes.size() > 0) {
    		for (int i = 0; i < Repositorioclientes.clientes.size(); i++) {
    	           Repositorioclientes.clientes.get(i).mostrarDados();
    		}
        } else {
        	throw new Exceptions.loja_sem_cliente();
        }
    }
}