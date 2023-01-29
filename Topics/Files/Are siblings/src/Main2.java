import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\pc\\downloads\\dataset_91022.txt");

        ArrayList<Integer> arrayList = new ArrayList<>();
        int x=0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
               if(scanner.nextInt()>=9999){
                   x+=1;
               }

            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        System.out.println(x);
    }
}
