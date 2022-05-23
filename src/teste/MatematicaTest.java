package teste;

import clase.Matematica;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MatematicaTest {

    private Matematica matematica;
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
    }

    @Before
    public void setUp() {
        this.matematica = Matematica.getInstantaMatematica();
    }

    @Test
    public void testSumaCorecta() {
        assertEquals(8, matematica.suma(3, 5));
    }

    @Test
    public void testSumaNrIdentice() {
        int numar = 3;
        assertEquals(6, matematica.suma(numar, numar));
    }

    @Test
    public void testRaportCorect() {
        assertEquals(2, matematica.raport(4, 2), 0.01);
    }

    @Test
    public void testRaportCuRezultatNrReal() {
        assertEquals(2.5, matematica.raport(5, 2), 0.01);
    }


    @Test
    public void testRaportShouldThrowException() {
        try {
            matematica.raport(56, 0);
            fail("Metoda raport nu arunca exceptie!");
        } catch (IllegalArgumentException exceptie) {
            assertTrue(true);
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRaportThrowException(){
        matematica.raport(46,0);
    }

    @Test
    public void testVerificaPar(){
        assertTrue(matematica.estePar(2));
        assertFalse(matematica.estePar(3));
        assertTrue(matematica.estePar(0));
        assertTrue(matematica.estePar(-2));
        assertFalse(matematica.estePar(-5));
    }

    @Test
    public void testReturneazaListaNrPare(){
        assertEquals(4,matematica.nNumerePare(4).size());
    }

    @Test
    public void testListaNumerePare(){
        List<Integer> lista = matematica.nNumerePare(4);
        for (int i = 0; i< 4; i++){
            assertTrue(matematica.estePar(lista.get(i)));
        }
    }
    @Test
    public void testListaNul(){
        assertNull(matematica.nNumerePare(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListaNrNegativ(){
        matematica.nNumerePare(-3);
    }
    @Test
    public void testListaNrCrescatoare(){
        List<Integer> lista = matematica.nNumerePare(4);
        for(int i = 0; i<lista.size()-1;i++){
            assertTrue(lista.get(i)< lista.get(i+1));
        }
    }

    @Test
    public void testSingletoneMatematica(){
        Matematica m = Matematica.getInstantaMatematica();
        assertSame(matematica, m);
    }
}
