package br.unicamp.ic.inf319;

/**
 * Representa uma peça individual com um custo associado
 */
public class PiecePart extends Part implements Comparable<Part>{

    private double cost;

    /**
     * Construtor para criar uma peça com número, descrição e custo
     *
     * @param number Número de identificação
     * @param description Descrição da peça
     * @param cost Valor do custo
     */
    public PiecePart(PartNumber number, String description, double cost) {
        super(number, description);
        this.cost = cost;
    }

    /**
     * Retorna o custo da peça
     *
     * @return Custo como double
     */
    @Override
    public double cost() {
        return cost;
    }

    /**
     * Define um novo custo para a peça
     *
     * @param cost Novo valor do custo
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String generateList(int level) {
        String indent = " ".repeat(level);
        return indent + "Parte: " + getPartNumber().getNumber() +
               "; Descrição: " + getDescription() +
               "; Custo: " + String.format("%.2f", cost()) + "\n";
    }
}
