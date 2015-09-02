import java.util.Arrays;

/**
 * http://www.careercup.com/question?id=5106425965576192
 * You are given with an array of 1s and 0s. And you are given with an integer m, which signifies number of flips allowed.
 * <p>
 * find the position of zeros which when flipped will produce maximum continuous series of 1s.
 * <p>
 * e.g.
 * input:
 * arr={1 1 0 1 1 0 0 1 1 1 } m=1
 * output={1 1 1 1 1 0 0 1 1 1} position=2
 * <p>
 * arr={1 1 0 1 1 0 0 1 1 1 } m=2
 * output={1 1 0 1 1 1 1 1 1 1} position=5,6
 *
 * @author alisovenko 26.10.14
 */
public class Longest1sWithKFlips {
    public static void flip(int[] arr, int m) {
        int maxLength = 0;
        int start = 0;

        int curZerosCnt = 0, curStart = 0, curLength = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                curZerosCnt++;
            }
            if (arr[i] == 0 && curZerosCnt > m) {
                int nStart = findLeftMostZeroInclusive(arr, curStart);
                curLength -= nStart - curStart - 1;
                curStart = nStart;
                curZerosCnt--;
                continue;
            }
            if (++curLength > maxLength) {
                start = curStart;
                maxLength = curLength;
            }

        }

        // Move from start, flip m zero elements to 1
        for (int i = start, p = m; i < arr.length && p > 0; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                p--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int findLeftMostZeroInclusive(int[] arr, int curStart) {
        int i = curStart;
        while (arr[i] != 0 && arr.length > i - 1) {
            i++;
        }

        // returning the next element after 0
        return i + 1;
    }

    public static void main(String[] args) {
        flip(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1}, 1);
        flip(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1}, 2);
    }
}