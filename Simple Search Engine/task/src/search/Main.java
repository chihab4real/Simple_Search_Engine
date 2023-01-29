package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {



        start(args[1]);

    }

    public static void start(String filename) throws FileNotFoundException {

        File file = new File(filename);
        ArrayList<String> inputs = readFromInput(file);
        Hashtable<String,ArrayList<Integer>> hashtable = transformArrayToHashTable(inputs);
        int choice=-1;

        do {
            Scanner scanner = new Scanner(System.in);
            PrintMenu();
            choice=scanner.nextInt();

            while(choice<0 || choice>2){

                System.out.println("Incorrect option! Try again.");
                choice= scanner.nextInt();

            }

            scanner.nextLine();

            switch (choice){
                case 0:
                    exit();
                    break;

                case 1:

                    System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
                    String strategy = scanner.nextLine();
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    String search = scanner.nextLine();
                    searchByStrategy(strategy,search,inputs,hashtable);
                    break;

                case 2:
                    PrintAllPeople(inputs);
                    break;
            }

        }while (choice!=0);

    }

    public static ArrayList<String> readFromInput(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        ArrayList<String> arrayList = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String s = scanner.nextLine();

            arrayList.add(s);

        }
        scanner.close();

        return arrayList;
    }

    public static Hashtable<String,ArrayList<Integer>> transformArrayToHashTable(ArrayList<String> inputs){
        Hashtable<String ,ArrayList<Integer>> hashtable = new Hashtable<>();

        for(int i=0;i<inputs.size();i++){

            ArrayList<String> onlyWords = new ArrayList<String>(List.of(inputs.get(i).split(" ")));


            for(int j =0;j<onlyWords.size();j++){

                if(hashtable.containsKey(onlyWords.get(j).toLowerCase())){

                    ArrayList<Integer> x = hashtable.get(onlyWords.get(j).toLowerCase());

                    x.add(i);

                    hashtable.replace(onlyWords.get(j).toLowerCase(),x);

                }else{

                    ArrayList<Integer> x =new ArrayList<>();

                    x.add(i);

                    hashtable.put(onlyWords.get(j).toLowerCase(),x);

                }
            }


        }



        return hashtable;
    }

    public static void FindAPerson(String person,ArrayList<String> inputs,Hashtable<String,ArrayList<Integer>> hashtable){

        if(hashtable.containsKey(person.toLowerCase())){

            ArrayList<Integer> indexes = hashtable.get(person.toLowerCase());
            System.out.println(indexes.size()+" persons found:");
            for(int i:indexes){
                System.out.println(inputs.get(i));
            }

        }else{
            System.out.println("No matching people found.");
        }


    }

    public static void PrintAllPeople(ArrayList<String> inputs){

        for(String s : inputs){
            System.out.println(s);
        }
    }

    public static void PrintMenu(){
        System.out.println("\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit");
    }

    public static void exit(){
        System.out.println("Bye!");
    }




    public static void searchByStrategy(String strategy,String search,ArrayList<String> inputs, Hashtable<String, ArrayList<Integer>> hashtable){



            switch (strategy){
                case "ALL":


                    SearchStrategy all = new AllStrategy(search,inputs,hashtable);
                    all.Search();
                    break;
                case "ANY":
                    SearchStrategy any = new AnyStrategy(search,inputs,hashtable);
                    any.Search();
                    break;

                case "NONE":

                    SearchStrategy none = new NonStrategy(search,inputs,hashtable);
                    none.Search();

                    break;
            }



    }






}
