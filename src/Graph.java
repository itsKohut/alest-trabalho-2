import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    int vertex;
    List<Castle> castles[];

    public Graph(int vertex) {
        this.vertex = vertex;
        castles = new LinkedList[vertex]; // It will be populated from txt file
        castles = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) { //
            castles[i] = new LinkedList<>();
        }
    }

    // Street that connects two castles (undirected graph)
    public void addEdge(Castle origin, Castle end) {
        castles[origin.getCastle()].add(end);
        castles[end.getCastle()].add(origin);
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            if (castles[i].size() > 0) {
                System.out.print("Castle " + i + " has roads to: ");
                for (Castle c : castles[i]) {
                    System.out.print(c.getCastle() + " ");
                }
                System.out.println();
            }
        }
    }

}



