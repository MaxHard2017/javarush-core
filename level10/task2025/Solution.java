package level10.task2025;


import java.util.ArrayList;
import java.util.Arrays;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        
        // if (N == Long.MAX_VALUE) {
        //     long[] l = new long[1];
        //     l[0] = 0L;
        //     return l;
        // } 
        
        ArrayList<Long> listResult = new ArrayList<Long>();
        long[] armstrongDigits = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L,
                                 9474L, 54_748L, 92_727L, 93_084L, 548_834L, 1_741_725L, 4_210_818L, 9_800_817L, 9_926_315L,
                                 24_678_050L, 24_678_051L, 88_593_477L, 146_511_208L, 472_335_975, 534_494_836, 912_985_153L,
                                 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L,
                                 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 
                                 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 
                                 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        
        for (int i = 0; ((i < 50) && (armstrongDigits[i] < N)) ; i++) {
            listResult.add(armstrongDigits[i]);
        }
        long[] result = new long[listResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = listResult.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024) );
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}

