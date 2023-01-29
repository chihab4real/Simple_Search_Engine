package search;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AllStrategy extends SearchStrategy {

    AllStrategy(String searchInputs,ArrayList<String> inputs, Hashtable<String, ArrayList<Integer>> hashtable) {
        super(searchInputs,inputs, hashtable);
    }

    @Override
    public void Search() {

        List<ArrayList<Integer>> ListArrayList = new ArrayList<>();

        for (String w : onlyWords) {
            if (hashtable.containsKey(w)) {
                ListArrayList.add(hashtable.get(w));
            }
        }

        if (!ListArrayList.isEmpty()) {
            ArrayList<String> founds = new ArrayList<>();
            for (int i = 0; i < ListArrayList.get(0).size(); i++) {
                if (ListArrayList.contains(ListArrayList.get(0).get(i))) {
                    founds.add(inputs.get(i));

                }
            }


            System.out.println("\n" + founds.size() + " persons found:");
            for (String s : founds) {
                System.out.println(s);
            }
        } else {
            System.out.println("No matching people found.");
        }


    }
}
