import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        int counter1=0,counter2=0;
        for(int x : list1){
            if(x==elem){
                counter1+=1;
            }
        }

        for(int x : list2){
            if(x==elem){
                counter2+=1;
            }
        }

        if(counter1==counter2) return true;
        return false;
    }
}