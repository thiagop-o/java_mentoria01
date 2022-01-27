import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class MainTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void DeveValidarEntradaErradaERealizarSoma(){
        systemInMock.provideLines("s","1","1", "2", "3", "n", "n", "n");

        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("não é um valor numerico"));
        assertTrue(saida.contains("Soma"));
        assertTrue(saida.contains("5.0"));

    }

    @Test
    public void DeveValidarOpcaoForaDasOpcoesERealizarSoma(){
        systemInMock.provideLines("5","1","1", "2", "3", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("digitar uma opção válida"));
        assertTrue(saida.contains("Soma"));
        assertTrue(saida.contains("5.0"));
    }

    @Test
    public void deveChamarPadraoERealizarSubtracao(){
        systemInMock.provideLines("1","2", "3", "2", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Subtração"));
        assertTrue(saida.contains("1.0"));
    }

    @Test
    public void deveChamarPadraoERealizarMultiplicacao(){
        systemInMock.provideLines("1","3", "3", "2", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Multiplicacão"));
        assertTrue(saida.contains("6.0"));
    }

    @Test
    public void deveChamarPadraoERealizarDivisao(){
        systemInMock.provideLines("1","4", "4", "2", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Divisão"));
        assertTrue(saida.contains("2.0"));
    }

    @Test
    public void deveChamarPadraoERealizarDivisaoERetornarErro0(){
        systemInMock.provideLines("1","4", "4", "0", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Impossivel dividir por 0"));


    }

    @Test
    public void deveChamarPadraoERealizarPotenciacao(){
        systemInMock.provideLines("1","5", "3", "2", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Potenciação"));
        assertTrue(saida.contains("9.0"));
    }

    @Test
    public void deveChamarPadraoValidarErroERealizarPotenciacao(){
        systemInMock.provideLines("1", "s","5", "3", "2", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("não é um valor numerico"));
        assertTrue(saida.contains("Potenciação"));
        assertTrue(saida.contains("9.0"));
    }

    @Test
    public void deveChamarPadraoValidarOpcaoForaDasOpcoesERealizarPotenciacao(){
        systemInMock.provideLines("1", "10","5", "3", "2", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("digitar uma opção válida"));
        assertTrue(saida.contains("Potenciação"));
        assertTrue(saida.contains("9.0"));
    }

    @Test
    public void deveChamarIMCERetornarMagrezaIII(){
        systemInMock.provideLines("2", "40", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("MAGREZA GRAU III"));
        assertTrue(saida.contains("13,52"));
    }

    @Test
    public void deveChamarIMCERetornarMagrezaII(){
        systemInMock.provideLines("2", "49", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("MAGREZA GRAU II"));
        assertTrue(saida.contains("16,56"));
    }

    @Test
    public void deveChamarIMCERetornarMagrezaI(){
        systemInMock.provideLines("2", "54", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("MAGREZA GRAU I"));
        assertTrue(saida.contains("18,25"));
    }

    @Test
    public void deveChamarIMCERetornarNormal(){
        systemInMock.provideLines("2", "60", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("NORMAL"));
        assertTrue(saida.contains("20,28"));
    }

    @Test
    public void deveChamarIMCERetornarPreObeso(){
        systemInMock.provideLines("2", "85", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("PRE-OBESO"));
        assertTrue(saida.contains("28,73"));
    }

    @Test
    public void deveChamarIMCERetornarOBESIDADEI(){
        systemInMock.provideLines("2", "100", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("OBESIDADE GRAU I"));
        assertTrue(saida.contains("33,80"));
    }

    @Test
    public void deveChamarIMCERetornarOBESIDADEII(){
        systemInMock.provideLines("2", "110", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("OBESIDADE GRAU II"));
        assertTrue(saida.contains("37,18"));
    }

    @Test
    public void deveChamarIMCERetornarOBESIDADEIII(){
        systemInMock.provideLines("2", "130", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("OBESIDADE GRAU III"));
        assertTrue(saida.contains("43,94"));
    }

    @Test
    public void deveChamarIMCERetornarAreaCirculo(){
        systemInMock.provideLines("3", "1" , "2", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("área do circulo"));
        assertTrue(saida.contains("12,57"));
    }

    @Test
    public void deveChamarAreaERetornarAreaCirculo(){
        systemInMock.provideLines("3", "1" , "2", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("área do circulo"));
        assertTrue(saida.contains("12,57"));
    }

    @Test
    public void deveChamarAreaERetornarAreaQuadrado(){
        systemInMock.provideLines("3", "2" , "2", "1,72", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("área do quadrado"));
        assertTrue(saida.contains("4,00"));
    }

    @Test
    public void deveChamarAreaERetornarAreaRetangulo(){
        systemInMock.provideLines("3", "3" , "2", "3", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("área do retangulo"));
        assertTrue(saida.contains("6,00"));
    }

    @Test
    public void deveChamarAreaEValidarOpcaoRetornarAreaRetangulo(){
        systemInMock.provideLines("3", "5" ,"3" , "2", "3", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("digitar uma opção válida"));
        assertTrue(saida.contains("área do retangulo"));
        assertTrue(saida.contains("6,00"));
    }

    @Test
    public void deveChamarAreaEValidarErroRetornarAreaRetangulo(){
        systemInMock.provideLines("3", "s" ,"3" , "2", "3", "n", "n", "n");
        String[] args = null;
        Main.main(args);
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("valor numerico"));
        assertTrue(saida.contains("área do retangulo"));
        assertTrue(saida.contains("6,00"));
    }
}
