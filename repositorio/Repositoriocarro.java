package repositorio;
import java.util.ArrayList;
import java.util.List;

import dados.Exceptions;
import dados.Veiculo;

public class Repositoriocarro {
    public List<Veiculo> veiculos =  new ArrayList<Veiculo>();
    
    public Repositoriocarro() {
    	Veiculo v = new Veiculo("volks", "gol", "1fj6");
    	veiculos.add(v);
    }
    
    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
    
    public void deletarVeiculo(String placa) throws Exception {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getplaca().equals(placa)) {
                veiculos.remove(veiculo);
                return;
            }
        }
        throw new Exceptions.veiculo_nao_encontrado(placa);
    }
    
    public void listar() throws Exception {
        if (veiculos.size() > 0) {
            for (int i = 0; i < veiculos.size(); i++) {
                System.out.println("MODELO: " + veiculos.get(i).getModelo() + " MARCA: " + veiculos.get(i).getMarca()
                        + " PLACA: " + veiculos.get(i).getplaca() + " DISPONIVEL: " + veiculos.get(i).isDisponivel());
            }
        } else {
            throw new Exceptions.repositoriocarro_vazio();
        }
    }


}