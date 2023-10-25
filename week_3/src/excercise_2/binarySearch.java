package excercise_2;

public class binarySearch {
    public static int binarySearch(int[] a, int number) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l - (l - r) / 2;
            if (a[m] == number) return m;
            else if (a[m] < number) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int number = 9;
        System.out.println(binarySearch(a, number));
    }
}
