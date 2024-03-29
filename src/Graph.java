import java.util.*;

public class Graph {

    public static int count = 0;
    public Map<Integer, Castle> castle;

    private int vertices;
    private List<Castle>[] roadsOfCastle;

    public Graph(In in) {

        try {

            int myInitialKnights = in.readInt() - 50;
            this.vertices = in.readInt() + 1;
            int edges = in.readInt();

            this.castle = new HashMap<>(vertices);
            this.castle.put(0, new Castle(0, myInitialKnights));

            this.roadsOfCastle = new LinkedList[this.vertices]; // It will be populated from txt file
            for (int i = 0; i < this.vertices; i++) {
                this.roadsOfCastle[i] = new LinkedList<>();
            }

            for (int i = 1; i < this.vertices; i++) {
                int castleNumber = in.readInt();
                int castleKnights = in.readInt();
                this.castle.put(i, new Castle(castleNumber, castleKnights));
            }

            for (int i = 0; i < edges; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    // Street that connects two castles (undirected graph)
    public void addEdge(int origin, int end) {
        this.roadsOfCastle[origin].add(this.castle.get(end));
        this.roadsOfCastle[end].add(this.castle.get(origin));
    }

    public List<Castle> adj(int target){
        return this.roadsOfCastle[target];
    }

    public int conquered() {

        int temp = 0;
        int castle = 0;
        boolean []visited = new boolean[vertices];

        conquered(castle, visited, temp);

        return Graph.count;
    }

    private void conquered(int target, boolean[] visited, int temp) {

        visited[target] = true;

        for (Castle c : adj(target)) {
            int cn = c.getCastleNumber();
            if (!visited[cn] && hasEnoughKnights(target, cn)) { ;
                conquered(cn, visited, temp + 1);
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

        boolean sucessfulAttack = false;

        Castle atk = this.castle.get(to);
        Castle def = this.castle.get(from);
        int survived = atk.getRemainingKnights() - ((def.getInitialKnights() * 2) + 50);

        if (survived > 0) {
            def.setRemainingKnights(survived);
            sucessfulAttack = true;
        }

        return sucessfulAttack;
    }

}
