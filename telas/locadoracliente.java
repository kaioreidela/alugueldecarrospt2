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
    repositoriocarro repositoriocarro = new repositoriocarro();
    repositorioclientes repositorioclientes = new repositorioclientes();
    negociocliente negociocliente = new negociocliente();
    negociogerente negociogerente = new negociogerente();
   
    public locadoracliente(){
       negociocliente negociocliente = new negociocliente();
       negociogerente negociogerente = new negociogerente();
       repositoriocarro repositoriocarro = new repositoriocarro();
       repositorioclientes repositorioclientes = new repositorioclientes();
    }
    public void loginCliente(String login2,int senha2 ){
        cliente c = negociocliente.login(login2, senha2); 
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


    
}
