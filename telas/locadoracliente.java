package telas;
import repositorio.repositoriocarro;
import repositorio.repositorioclientes;
import dados.gerente;
import dados.pessoa;
import dados.cliente;
import dados.veiculo;
import dados.negociocliente;
import dados.negociogerente;

//+ "Digite 1 para: Alugar veiculo \n"
//+ "Digite 2 para: Devolver veiculo\n"
// "Digite 3 para: Ver veiculos disponiveis\n"
public class locadoracliente {
    private negociocliente negociocliente;
    private negociogerente negociogerente;
    repositoriocarro repositoriocarro = new repositoriocarro();
    repositorioclientes repositorioclientes = new repositorioclientes();
   
   
    public locadoracliente(){
       this.negociocliente = new negociocliente(repositorioclientes, repositoriocarro);
    
    }
    
    public cliente loginCliente(String login2,int senha2 ){
        cliente cliente = negociocliente.login(login2, senha2); 
        return cliente;
    }
    

    public void alugarVeiculo(String placa, cliente cliente){
        negociocliente.alugarVeiculo(placa, cliente);
        negociocliente.verCarrosAlugados(cliente);

    }

    public void devolverVeiculo(String placa2,cliente cliente){
        negociocliente.verCarrosAlugados(cliente);          						
        negociocliente.devolverVeiculo(placa2, cliente);
        negociocliente.verCarrosAlugados(cliente);

    }

    public void veiculosDisponiveis(){
        negociocliente.listardisponibilidade();

    }

    public void verCarrosAlugados(cliente cliente){
        negociocliente.verCarrosAlugados(cliente);
    }
    
    public int listardisponibilidade(){
        return negociocliente.listardisponibilidade();
    }



    
}
