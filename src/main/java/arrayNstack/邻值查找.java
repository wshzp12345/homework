package arrayNstack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 给定一个长度为 n 的序列 A，A 中的数各不相同。
 *
 * 对于 A 中的每一个数 Ai，求：
 *
 * min1≤j<i|Ai−Aj|
 * 以及令上式取到最小值的 j（记为 Pi）。若最小值点不唯一，则选择使 Aj 较小的那个。
 *
 * 输入格式
 * 第一行输入整数 n，代表序列长度。
 *
 * 第二行输入 n 个整数A1…An,代表序列的具体数值，数值之间用空格隔开。
 *
 * 输出格式
 * 输出共 n−1 行，每行输出两个整数，数值之间用空格隔开。
 *
 * 分别表示当 i 取 2∼n 时，对应的 min1≤j<i|Ai−Aj| 和 Pi 的值。
 */
public class 邻值查找 {

    public static void main(String[] args) {
        System.out.println("个数");
        Scanner sc= new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        System.out.println("数组");
        String sin2 = sc.nextLine();
        int [] A = new int[n];
        Integer [] rank = new Integer[n];
        String s[]= sin2.split(" ");
        for(int i=0; i<s.length;i++) {
            A[i] = Integer.parseInt(s[i]);
            rank[i] = i;
        }
        Arrays.sort(rank,(rki, rkj) ->{ return A[rki] - A[ rkj];});
        // 建立链表
        ListNode [] pos = new ListNode[n];
        ListNode head = new ListNode(A[rank[0]]-1e9);
        ListNode tail = new ListNode(A[rank[n-1]]+1e9);
        head.pre = tail;
        tail.next = head;
        for(int i = 0; i < n; i++) {
            pos[rank[0]] = AddNode();
        }


    }

    private static ListNode AddNode() {
        return  null;
    }
}
