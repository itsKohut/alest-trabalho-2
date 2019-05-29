public class Main {

    public static void main(String[] args) {
        TXTFileChooser txtChooser = new TXTFileChooser();
        String filePath = txtChooser.getPath();

        Graph graph = new Graph(new In(filePath));
        System.out.println("It`ll be possible to conquer "+ graph.conquered() + " castles!");
     }
}
