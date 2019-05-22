import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    public static int count;

    private int vertices;
    private List<Castle> roadsOfCastle[];

    private Map<Integer, Castle> castle;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.roadsOfCastle = new LinkedList[vertices]; // It will be populated from txt file
        for (int i = 0; i < vertices; i++) { //
            roadsOfCastle[i] = new LinkedList<>();
        }

        this.castle = new HashMap<>(vertices);
    }

    // Street that connects two castles (undirected graph)
    public void addEdge(Castle origin, Castle end) {
        roadsOfCastle[origin.getCastleNumber()].add(end);
        roadsOfCastle[end.getCastleNumber()].add(origin);
    }

    public List<Castle> adj(int target){
        return roadsOfCastle[target];
    }

    public int conquered(){

        int temp = 0;
        int castle = 0;
        boolean []visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++){
            visited[i] = false;
        }

        conquered(castle, visited, temp);

        return Graph.count;
    }

    private void conquered(int target, boolean[] visited, int temp) {

        visited[target] = true;

        for (Castle c : adj(target)) {
            int cn = c.getCastleNumber();
            if (!visited[cn] && hasEnoughKnights(target, cn)) {
                temp++;
                conquered(cn, visited, temp);
            }
        }

        visited[target] = false;
        updateCastlesConquered(temp);

    }

    private void updateCastlesConquered(int temp) {
        if (temp > count){
            count = temp;
        }
    }

    private boolean hasEnoughKnights(int to, int from) {

        boolean sucessulAtack = false;

        Castle atk = this.castle.get(to);
        Castle def = this.castle.get(from);

        int survived = atk.getRemainingKnights() - ((def.getInitialKnights() * 2) - 50);

        if (survived >= 0) {
            def.setRemainingKnights(survived);
            sucessulAtack = true;
        }

        return sucessulAtack;

    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            if (roadsOfCastle[i].size() > 0) {
                System.out.print("Castle " + i + " has roads to: ");
                for (Castle c : roadsOfCastle[i]) {
                    System.out.print(c.getCastleNumber() + " ");
                }
                System.out.println();
            }
        }
    }

}



