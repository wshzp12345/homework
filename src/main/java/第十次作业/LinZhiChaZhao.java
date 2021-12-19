package 第十次作业;
import java.util.*;
public class LinZhiChaZhao {


     class Main {
        static TreeMap<Integer,Integer> set = new TreeMap<>();
        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int cur ;

            for(int i = 0; i < n; i ++) {
                cur = scanner.nextInt();
                if(i > 0) {
                    Integer h = set.higherKey(cur);
                    Integer l = set.lowerKey(cur);
                    if(h == null || l == null){
                        if(h == null) System.out.println(cur - l+" "+ set.get(l));
                        else System.out.println(h - cur+" "+ set.get(h));
                    }else {
                        if(h - cur < cur - l) {
                            System.out.println(h - cur+" "+ set.get(h));
                        } else {
                            System.out.println(cur - l+" "+ set.get(l));
                        }
                    }
                }
                set.put(cur,i+1);
            }
        }
    }
}
