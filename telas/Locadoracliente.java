package telas;

import dados.Cliente;
import dados.Negociocliente;
import repositorio.Repositoriocarro;
import repositorio.Repositorioclientes;

public class Locadoracliente {
    private Negociocliente negociocliente;
    private Negociocliente negociogerente;
   
   
    public Locadoracliente(Repositorioclientes repositorioclientes,Repositoriocarro repositoriocarro){
       this.negociocliente = new Negociocliente(repositorioclientes, repositoriocarro);
    
    }
    
    public Cliente loginCliente(String login2,int senha2 ){
        Cliente cliente = negociocliente.login(login2, senha2); 
        return cliente;
    }
    

    public void alugarVeiculo(String placa, Cliente cliente) throws Exception{
        negociocliente.alugarVeiculo(placa, cliente);
        negociocliente.verCarrosAlugados(cliente);

    }

    public void devolverVeiculo(String placa2,Cliente cliente) throws Exception{          						
        negociocliente.devolverVeiculo(placa2, cliente);
        negociocliente.verCarrosAlugados(cliente);

    }

    public void veiculosDisponiveis() throws Exception{
        negociocliente.listardisponibilidade();

    }

    public void verCarrosAlugados(Cliente cliente) throws Exception{
        negociocliente.verCarrosAlugados(cliente);
    }
    
    public void listardisponibilidade() throws Exception{
        negociocliente.listardisponibilidade();
    }

	public Negociocliente getNegociogerente() {
		return negociogerente;
	}

	public void setNegociogerente(Negociocliente negociogerente) {
		this.negociogerente = negociogerente;
	}
    
}