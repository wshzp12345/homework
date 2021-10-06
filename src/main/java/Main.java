import java.util.List;

import static java.util.Collections.swap;

public class Main {


    public static void main(String [] ss) {


    }

    void quickSort(List ints) {
        int i = 0;
        int end = ints.size()-1;

        quickSort(ints,0,end);
    }

    private void quickSort(List<Integer> ints, int s, int end) {
        int start = ints.get(s);
        int is = s;
        for(int i=end,j=s; i>-0;i--) {
            if(ints.get(i)<start) {
                swap(ints,is,i);
            }else {

            }
        }
    }


}

