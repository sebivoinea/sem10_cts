package clase;

import teste.MatematicaTest;

import java.util.ArrayList;
import java.util.List;

public class Matematica {
    private static Matematica instantaMatematica = null;

    private Matematica(){}

    public static Matematica getInstantaMatematica() {
        if(instantaMatematica == null){
            instantaMatematica = new Matematica();
        }
        return instantaMatematica;
    }

    public int suma(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public double raport(int numarator, int numitor) {
        if (numitor != 0) {
            return (double) numarator / numitor;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public boolean estePar(int numar) {
        return numar % 2 == 0;
    }

    public List<Integer> nNumerePare(int n) {
        if (n > 0) {
            List<Integer> lista = new ArrayList<Integer>();
            for (int i = 0; i < n; i++)
                lista.add(i * 2);
            return lista;
        } else  if(n<0){
            throw new IllegalArgumentException();
        } else {
            return null;
        }
    }
}
