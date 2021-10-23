package com.sl.javafuncional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Soma {

    private enum TypeVencimento {
        PROVENTO, DESCONTO
    }

    static class Vencimento {

        TypeVencimento tipo;
        Double informado;
        Double valor;

        public Vencimento(TypeVencimento tipo, Double valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        public TypeVencimento getTipo() {
            return tipo;
        }

        public Double getInformado() {
            return informado;
        }

        public Double getValor() {
            return valor;
        }

        public void setValor(Double valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Vencimento{" +
                    "tipo=" + tipo +
                    ", informado=" + informado +
                    ", valor=" + valor +
                    '}';
        }
    }

    public static void main(String[] args) {
        Soma soma = new Soma();

        List<Vencimento> lancamentos = new ArrayList<>();
        lancamentos.add(new Vencimento(TypeVencimento.PROVENTO, 100.0));
        lancamentos.add(new Vencimento(TypeVencimento.PROVENTO, 33.3));
        lancamentos.add(new Vencimento(TypeVencimento.DESCONTO, 3.3));

        Predicate<Vencimento> proventoPredicate = p -> TypeVencimento.PROVENTO.equals(p.getTipo());


        Double sumProventos = lancamentos.stream().filter(proventoPredicate).mapToDouble(Vencimento::getValor).sum();
        Double sumDescontos = lancamentos.stream().filter(d -> TypeVencimento.DESCONTO.equals(d.getTipo())).mapToDouble(Vencimento::getValor).sum();
        Double liquido = lancamentos.stream()
                .map(v -> {
                    if (TypeVencimento.DESCONTO.equals(v.getTipo()))
                        v.setValor(v.getValor() * -1);

                    return v;
                })
                .mapToDouble(Vencimento::getValor)
                .sum();

        System.out.println("Proventos: " + sumProventos);
        System.out.println("Descontos: " + sumDescontos);
        System.out.println("Liquido: " + liquido);

        List<Vencimento> filtroProventos = lancamentos.stream().filter(proventoPredicate).collect(Collectors.toList());

        System.out.println("\nProventos: " + filtroProventos);

        System.out.println("\nLancamentos: " + lancamentos);
    }
}
