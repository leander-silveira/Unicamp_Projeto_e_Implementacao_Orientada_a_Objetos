package br.unicamp.ic.inf319;

/**
 * Representa o número único de identificação de uma peça
 * Implementa Comparable para permitir ordenação com base no número
 */

public class PartNumber {

    private final int number;

    /**
     * Cria um número de identificação para uma peça
     *
     * @param theNumber Valor numérico da identificação
     */
    public PartNumber(int theNumber) {
    	this.number = theNumber;
    }

    /**
     * Retorna o valor do número de identificação
     *
     * @return Valor inteiro do número de identificação
     */
    public int getNumber() {
        return number;
    }

    public int compareTo(PartNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PartNumber)) return false;
        PartNumber other = (PartNumber) obj;
        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}
