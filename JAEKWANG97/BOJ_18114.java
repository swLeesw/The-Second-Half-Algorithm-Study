import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);

        if (check(data, n, c)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        scanner.close();
    }

    private static boolean binarySearch(int[] data, int left, int right, int diff) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == diff) {
                return true;
            } else if (data[mid] > diff) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private static boolean check(int[] data, int n, int c) {
        if (Arrays.binarySearch(data, c) >= 0) {
            return true;
        }
        int i = 0, j = n - 1;
        while (i < j) {
            int total = data[i] + data[j];
            if (total > c) {
                j--;
            } else if (total == c) {
                return true;
            } else {
                int diff = c - total;
                // 세 번째 무게 찾기, 현재 무게가 아닌 다른 위치에서 찾아야 함
                if (data[i] != diff && data[j] != diff && binarySearch(data, i + 1, j - 1, diff)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
