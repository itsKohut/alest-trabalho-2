import java.io.File;
import java.util.Scanner;

public class TXTFileChooser {

    File folder = new File("./cases");

    public TXTFileChooser(){

    }

    public String getPath() {

        String path;
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if(listOfFiles[i].getName().contains("caso")) {
                System.out.println((i+1) + ". " + listOfFiles[i].getName());
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nChoose the number of the file that you want to read: ");

        int choose = (sc.nextInt());
        path = "./cases/"+listOfFiles[(choose-1)].getName();

        return path;
    }
}