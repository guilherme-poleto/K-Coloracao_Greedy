import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coloracao {
    public static int[] backTracking(Grafo grafo) {
        int numVertices = grafo.getNumVertices();
        int[] cores = new int[numVertices];
        Arrays.fill(cores, -1);

        // Começa a coloração do vértice 0
        BacktrackingUtil(grafo, 0, cores);
        return cores;
    }

    private static boolean BacktrackingUtil(Grafo grafo, int vertice, int[] cores) {
        int numVertices = grafo.getNumVertices();
        List<List<Integer>> adjList = grafo.getAdjList();

        if (vertice == numVertices) {
            return true; // Todos os vértices foram coloridos
        }

        for (int cor = 0; cor < numVertices; cor++) {
            if (isSafe(grafo, vertice, cor, cores)) {
                cores[vertice] = cor;

                if (BacktrackingUtil(grafo, vertice + 1, cores)) {
                    return true; // Se a recursão retorna true, a coloração é possível
                }

                // Se a coloração não for possível, tenta outra cor
                cores[vertice] = -1;
            }
        }

        return false; // Não foi possível colorir o vértice atual
    }

    private static boolean isSafe(Grafo grafo, int vertice, int cor, int[] cores) {
        List<Integer> vizinhos = grafo.getAdjList().get(vertice);
        for (Integer vizinho : vizinhos) {
            if (cores[vizinho] == cor) {
                return false; // A cor já está sendo usada por um vizinho
            }
        }
        return true;
    }

    // Algoritmo de Coloração Guloso
    public static int[] coloracaoGulosa(Grafo grafo) {
        int numVertices = grafo.getNumVertices();
        int[] cores = new int[numVertices];
        Arrays.fill(cores, -1);

        for (int vertice = 0; vertice < numVertices; vertice++) {
            Set<Integer> coresVizinhos = new HashSet<>();
            List<Integer> vizinhos = grafo.getAdjList().get(vertice);

            // Verifica as cores dos vizinhos
            for (Integer vizinho : vizinhos) {
                if (cores[vizinho] != -1) {
                    coresVizinhos.add(cores[vizinho]);
                }
            }

            // Escolhe a cor mais baixa disponível
            int cor = 0;
            while (coresVizinhos.contains(cor)) {
                cor++;
            }

            cores[vertice] = cor;
        }

        return cores;
    }
}