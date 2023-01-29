package search;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public abstract class SearchStrategy {

        String searchInputs;
        ArrayList<String> inputs;
        Hashtable<String,ArrayList<Integer>> hashtable;

        ArrayList<String> onlyWords;

        SearchStrategy(String searchInputs,ArrayList<String> inputs,Hashtable<String,ArrayList<Integer>> hashtable){

            this.searchInputs= searchInputs;


            this.inputs= inputs;
            this.hashtable= hashtable;
            this.onlyWords = new ArrayList<String>(List.of(searchInputs.split(" ")));
        }

        public abstract void Search();

    }


