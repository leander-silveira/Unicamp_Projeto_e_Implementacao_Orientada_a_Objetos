package br.unicamp.ic.inf319;

/**
 * Classe abstrata para representar uma peça ou montagem com número de identificação e descrição
 * Define métodos abstratos para calcular o custo e gerar uma listagem
 */
public abstract class Part implements Comparable<Part> {

    private String description;
    private final PartNumber partNumber;

    /**
     * Construtor para criar uma peça com número de identificação e descrição
     *
     * @param number Número de identificação da peça
     * @param description Descrição da peça
     */
    public Part(PartNumber number, String description) {
        this.partNumber = number;
        this.description = description;
    }

    /**
     * Método abstrato para calcular o custo da peça ou montagem
     *
     * @return Custo como double
     */
    public abstract double cost();

    /**
     * Retorna a descrição da peça
     *
     * @return Descrição da peça
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define uma nova descrição para a peça
     *
     * @param description Nova descrição
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o número de identificação da peça
     *
     * @return Número da peça
     */
    public PartNumber getPartNumber() {
        return partNumber;
    }

    /**
     * Método abstrato para gerar a listagem de componentes
     *
     * @param level Nível de recuo para formatação da listagem
     * @return String com a listagem hierárquica da peça
     */
    public abstract String generateList(int level);

    @Override
    public int compareTo(Part other) {
        return Integer.compare(this.getPartNumber().getNumber(), other.getPartNumber().getNumber());
    }

	/**
	 * Retorna uma representação hierárquica da montagem e seus componentes
	 *
	 * @return String com a lista hierárquica de componentes
	 */
	public String generateList() {
		// TODO Auto-generated method stub
		return null;
	}
}
