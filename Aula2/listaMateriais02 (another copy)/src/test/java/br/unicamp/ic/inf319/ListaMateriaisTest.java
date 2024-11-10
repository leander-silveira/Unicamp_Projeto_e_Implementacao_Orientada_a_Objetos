package br.unicamp.ic.inf319;

import junit.framework.TestCase;
import org.junit.Test;

public class ListaMateriaisTest extends TestCase {

    @Test
    public void testPart() {
        PartNumber number = new PartNumber(42);
        Part part = new PiecePart(number, "description", 23.0);
        assertEquals(42, part.getPartNumber().getNumber());
        assertEquals("description", part.getDescription());
        part.setDescription("new description");
        assertEquals("new description", part.getDescription());
    }

    @Test
    public void testPiecePart() {
        PartNumber number = new PartNumber(42);
        PiecePart part = new PiecePart(number, "description", 23.0);
        assertEquals(23.0, part.cost(), 0.0);
        part.setCost(5.0);
        assertEquals(5.0, part.cost(), 0.0);
    }

    @Test
    public void testAssembly() {
        PartNumber number1 = new PartNumber(23);
        PartNumber number2 = new PartNumber(42);
        PartNumber number3 = new PartNumber(69);

        Assembly assembly1 = new Assembly(number1, "assembly1");
        Assembly assembly2 = new Assembly(number2, "assembly2");
        Assembly assembly3 = new Assembly(number3, "assembly3");

        for (int i = 0; i < 10; i++) {
            assembly1.addPart(new PiecePart(new PartNumber(i), "component" + i, i));
        }
        assertEquals(45.0, assembly1.cost(), 0.0);  // Somatório de 0 a 9

        for (int i = 10; i < 20; i++) {
            assembly2.addPart(new PiecePart(new PartNumber(i), "component" + i, i));
        }
        assertEquals(145.0, assembly2.cost(), 0.0);  // Somatório de 10 a 19

        assembly3.addPart(assembly1);
        assembly3.addPart(assembly2);
        assertEquals(190.0, assembly3.cost(), 0.0);  // Somatório de ambos
    }

    @Test
    public void testList() {

        // Peças para a roda dianteira
        PiecePart aroDianteiro = new PiecePart(new PartNumber(51), "Aro Dianteiro", 20.0);
        PiecePart cuboDianteiro = new PiecePart(new PartNumber(52), "Cubo Dianteiro", 30.0);
        PiecePart raiosDianteiro = new PiecePart(new PartNumber(53), "Raios Dianteiro", 5.0);
        PiecePart pneuDianteiro = new PiecePart(new PartNumber(54), "Pneu Dianteiro", 15.0);

        // Montagem da roda dianteira
        Assembly rodaDianteira = new Assembly(new PartNumber(5), "Roda Dianteira");
        rodaDianteira.addPart(aroDianteiro);
        rodaDianteira.addPart(cuboDianteiro);
        rodaDianteira.addPart(raiosDianteiro);
        rodaDianteira.addPart(pneuDianteiro);

        // Peças para a roda traseira
        PiecePart aroTraseiro = new PiecePart(new PartNumber(61), "Aro Traseiro", 20.0);
        PiecePart cuboTraseiro = new PiecePart(new PartNumber(62), "Cubo Traseiro", 30.0);
        PiecePart raiosTraseiro = new PiecePart(new PartNumber(63), "Raios Traseiro", 5.0);
        PiecePart pneuTraseiro = new PiecePart(new PartNumber(64), "Pneu Traseiro", 15.0);

        // Montagem da roda traseira
        Assembly rodaTraseira = new Assembly(new PartNumber(6), "Roda Traseira");
        rodaTraseira.addPart(aroTraseiro);
        rodaTraseira.addPart(cuboTraseiro);
        rodaTraseira.addPart(raiosTraseiro);
        rodaTraseira.addPart(pneuTraseiro);

        Assembly motocicleta = new Assembly(new PartNumber(7), "Motocicleta");
        motocicleta.addPart(rodaDianteira);
        motocicleta.addPart(rodaTraseira);

        // Custo total esperado das rodas dianteira e traseira
        assertEquals(140.0, motocicleta.cost(), 0.0);
    }

    @Test
    public void testListAssembly() {
        // Criação de componentes
        PiecePart discoMagnetico = new PiecePart(new PartNumber(6), "Disco magnetico", 15.0);
        PiecePart anelTracao = new PiecePart(new PartNumber(5), "Anel de tracao", 2.0);
        PiecePart folhaAluminio = new PiecePart(new PartNumber(3), "Folha de aluminio", 3.0);
        PiecePart mola = new PiecePart(new PartNumber(4), "Mola", 1.0);

        // Montagem da estrutura de disquete
        Assembly disco = new Assembly(new PartNumber(11), "Disco");
        disco.addPart(discoMagnetico);
        disco.addPart(anelTracao);

        Assembly tampaCorredica = new Assembly(new PartNumber(13), "Tampa corredica");
        tampaCorredica.addPart(folhaAluminio);
        tampaCorredica.addPart(mola);

        Assembly disquete = new Assembly(new PartNumber(1), "Disquete");
        disquete.addPart(disco);
        disquete.addPart(new PiecePart(new PartNumber(12), "Caixa plastica", 5));
        disquete.addPart(tampaCorredica);

        // String esperada com a estrutura hierárquica
        String expected = 
              "Parte: 1; Descrição: Disquete; Custo: 26.00\n" +
              " Parte: 11; Descrição: Disco; Custo: 17.00\n" +
              "  Parte: 5; Descrição: Anel de tracao; Custo: 2.00\n" +
              "  Parte: 6; Descrição: Disco magnetico; Custo: 15.00\n" +
              " Parte: 12; Descrição: Caixa plastica; Custo: 5.00\n" +
              " Parte: 13; Descrição: Tampa corredica; Custo: 4.00\n" +
              "  Parte: 3; Descrição: Folha de aluminio; Custo: 3.00\n" +
              "  Parte: 4; Descrição: Mola; Custo: 1.00\n";

        // Saída real de generateList()
        System.out.println("Real Output:\n" + disquete.generateList());

        // Comparação com a saída esperada
        assertEquals("A saída do método generateList() não corresponde à esperada.", expected, disquete.generateList());

    }
}
