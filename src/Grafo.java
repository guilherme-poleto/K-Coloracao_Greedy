import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private int numVertices;
    private List<List<Integer>> adjList;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}