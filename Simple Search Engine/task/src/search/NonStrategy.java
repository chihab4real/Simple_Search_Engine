package search;

import java.util.ArrayList;
import java.util.Hashtable;

public class NonStrategy extends SearchStrategy {

    NonStrategy(String searchInputs,ArrayList<String> inputs, Hashtable<String, ArrayList<Integer>> hashtable) {
        super(searchInputs,inputs, hashtable);
    }

    @Override
    public void Search() {


        ArrayList<Integer> founds = new ArrayList<>();
        for (String w : onlyWords) {
            if (hashtable.containsKey(w)) {
                for (int i = 0; i < hashtable.get(w).size(); i++) {
                    if (!founds.contains(hashtable.get(w).get(i))) {
                        founds.add(hashtable.get(w).get(i));
                    }
                }

            }
        }

        if (!founds.isEmpty()) {

            System.out.println("\n" + (inputs.size() - founds.size()) + " persons found:");
            for (int i = 0; i < inputs.size(); i++) {
                if (!founds.contains(i)) {
                    System.out.println(inputs.get(i));
                }

            }
        } else {
            System.out.println("No matching people found.");
        }


    }
}
