package repositorio;
import java.util.ArrayList;
import java.util.List;

import dados.veiculo;

public class repositoriocarro {
    public List<veiculo> veiculos =  new ArrayList<veiculo>();
    
    public repositoriocarro() {
    	veiculo v = new veiculo("volks", "gol", "1fj6");
    	veiculos.add(v);
    }
    
    public void cadastrarVeiculo(veiculo veiculo) {
        veiculos.add(veiculo);
        // println tirado pois devera ser informado nas telas de menu
        //System.out.println("\n\033[0;32mVeiculo Cadastrado!\033[0m");
    }

    public void deletarVeiculo(String placa){
        for(veiculo veiculo : veiculos){
            if(veiculo.getplaca().equals(placa)){
            	veiculos.remove(veiculo);
                //println tirado pois devera ser informado nas telas de menu
				//System.out.println("\n\033[0;32mVeiculo Removido!\033[0m");
				break;
            }
        }
    }
    // a função listar devera ser dessa forma as condicoes serao tratadas fora como erro
    public void listar(){
        for (int i = 0; i <veiculos.size(); i++) {

            System.out.println("MODELO: " + veiculos.get(i).getModelo() + " MARCA: " + veiculos.get(i).getMarca() + " PLACA: " + veiculos.get(i).getplaca() + " DISPONIVEL: " + veiculos.get(i).isDisponivel());
        }
    }
        // retirar pq println fica fora 
    	//System.out.println("VEICULOS DA LOJA:");
        //	if(veiculos.size() > 0) {
    	//	for (int i = 0; i <veiculos.size(); i++) {

    	//		System.out.println("MODELO: " + veiculos.get(i).getModelo() + " MARCA: " + veiculos.get(i).getMarca() + " PLACA: " + veiculos.get(i).getplaca() + " DISPONIVEL: " + veiculos.get(i).isDisponivel());
    	//	}
        //	}else {
            // retirar pq println fica fora 
             //lancar a excessao de erro
    	//	System.out.println("\033[0;31mNENHUM VEICULO NA LOJA\033[0m");
        //	}
       //  }

}
