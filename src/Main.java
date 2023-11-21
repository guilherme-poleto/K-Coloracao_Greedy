import java.util.*;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = gerarGrafoAleatorio(12000);

        long tempoInicial = System.currentTimeMillis();
        int[] coresBacktracking = Coloracao.backTracking(grafo);
        System.out.println("Numero cromático: " + Arrays.stream(coresBacktracking).max().getAsInt());
        double tempoFinal = (System.currentTimeMillis() - tempoInicial) / 1000.0;
        System.out.println("O método foi executado em " + tempoFinal + " s");

        tempoInicial = System.currentTimeMillis();
        int[] coresGulosa = Coloracao.coloracaoGulosa(grafo);
        System.out.println("Numero cromático: " + Arrays.stream(coresGulosa).max().getAsInt());
        tempoFinal = (System.currentTimeMillis() - tempoInicial) / 1000.0;
        System.out.println("O método foi executado em " + tempoFinal + " s");
    }

    private static Grafo gerarGrafoAleatorio(int numVertices) {
        Grafo grafo = new Grafo(numVertices);
        Random random = new Random();

        for (int u = 0; u < numVertices; u++) {
            for (int v = u + 1; v < numVertices; v++) {
                if (random.nextDouble() < 0.9) {  // probabilidade de 50% de conter aresta
                    grafo.adicionarAresta(u, v);
                }
            }
        }
        return grafo;
    }
}
