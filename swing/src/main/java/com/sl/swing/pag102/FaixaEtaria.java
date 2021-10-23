package pag102;

import java.util.ArrayList;
import java.util.List;

public class FaixaEtaria {

    class Periodo {

        int inicio;
        int fim;
        String mensagem;

        public Periodo(int inicio, int fim, String mensagem) {
            this.inicio = inicio;
            this.fim = fim;
            this.mensagem = mensagem;
        }
    }

    List<Periodo> faixasEtarias;

    public FaixaEtaria() {
        faixasEtarias = new ArrayList<>();
        faixasEtarias.add(new Periodo(0,2, "Bebê"));
        faixasEtarias.add(new Periodo(3,11, "Criança"));
        faixasEtarias.add(new Periodo(12,19, "Adolescente"));
        faixasEtarias.add(new Periodo(20,30, "Jovem"));
        faixasEtarias.add(new Periodo(31,60, "Adulto"));
    }

    public String mensagemFaixaEtaria(int idade) {
        for (Periodo faixaEtaria : faixasEtarias) {
            if (idade >= faixaEtaria.inicio && idade <= faixaEtaria.fim)
                return faixaEtaria.mensagem;
        }
        return "Idoso";
    }

}
