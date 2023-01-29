import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        ArrayList<String> arrayList = new ArrayList<>(List.of(s.split("\\s+")));
        System.out.println(arrayList);
    }
}