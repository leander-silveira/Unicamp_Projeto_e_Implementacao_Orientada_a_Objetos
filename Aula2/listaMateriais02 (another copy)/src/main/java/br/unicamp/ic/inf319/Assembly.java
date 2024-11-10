package br.unicamp.ic.inf319;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Representa uma montagem composta por várias partes, que pode incluir outras montagens ou peças individuais
 * Fornece métodos para calcular o custo total e gerar uma listagem hierárquica dos componentes
 */

public class Assembly extends Part implements Comparable<Part>{

    private final TreeSet<Part> components;

    /**
     * Cria uma montagem com um número e uma descrição
     *
     * @param number Número de identificação da montagem
     * @param description Descrição da montagem
     */
    public Assembly(PartNumber number, String description) {
        super(number, description);
        this.components = new TreeSet<>();
    }

    /**
     * Calcula o custo total da montagem, somando o custo de cada componente individual e subcomponentes
     *
     * @return Custo total da montagem
     */
    @Override
    public double cost() {
        return components.stream().mapToDouble(Part::cost).sum();
    }

    /**
     * Adiciona uma parte à montagem
     *
     * @param part A parte a ser adicionada à montagem
     */
    public void addPart(Part part) {
        components.add(part);
    }

    /**
     * Retorna uma representação hierárquica da montagem e seus componentes
     *
     * @return String com a lista hierárquica de componentes
     */
    @Override
    public String generateList() {
        return generateList(0);
    }

    /**
     * Método auxiliar para gerar a listagem com recuo
     *
     * @param level Nível de recuo para o componente atual
     * @return String formatada com a listagem da montagem e seus componentes
     */
    public String generateList(int level) {
        StringBuilder sb = new StringBuilder();
        String indent = " ".repeat(level);

        sb.append(indent)
          .append("Parte: ").append(getPartNumber().getNumber())
          .append("; Descrição: ").append(getDescription())
          .append("; Custo: ").append(String.format("%.2f", cost()))
          .append("\n");

        for (Part part : components) {
            sb.append(part.generateList(level + 1));
        }
        return sb.toString();
    }
}