import java.util.Scanner;

public class lru {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int noofpages, capacity;

        int hit = 0, fault = 0;
        double faultRatio, hitRatio;

        System.out.print("Enter the number of pages you want to enter: ");
        noofpages = sc.nextInt();

        int pages[] = new int[noofpages];
        System.out.print("Enter pages: ");
        for (int i = 0; i < noofpages; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter the capacity of frame: ");
        capacity = sc.nextInt();

        int frame[] = new int[capacity];
        int accessTime[] = new int[capacity];
        int table[][] = new int[noofpages][capacity];

        System.out.println("\n----------------------------------------------------------------------");
        for (int i = 0; i < noofpages; i++) {
            int search = -1;
            for (int j = 0; j < capacity; j++) {
                if (frame[j] == pages[i]) {
                    search = j;
                    hit++;
                    System.out.printf("%4s", "H");
                    break;
                }
            }
            if (search == -1) {
                int lruIndex = findLRUIndex(accessTime);
                frame[lruIndex] = pages[i];
                accessTime[lruIndex] = i;
                fault++;
                System.out.printf("%4s", "F");
            }
            System.arraycopy(frame, 0, table[i], 0, capacity);
        }
        System.out.println("\n----------------------------------------------------------------------");
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < noofpages; j++)
                System.out.printf("%3d ", table[j][i]);
            System.out.println();
        }

        System.out.println("------------------------------------------------------------------------");
        faultRatio = ((double) fault / noofpages) * 100;
        hitRatio = ((double) hit / noofpages) * 100;
        System.out.println("Page Fault: " + fault + "\nPage Hit: " + hit);
        System.out.printf("Hit Ratio:%.2f \nFault Ratio:%.2f ", hitRatio, faultRatio);
    }

    private static int findLRUIndex(int[] accessTime) {
        int minIndex = 0;
        int minValue = accessTime[0];

        for (int i = 1; i < accessTime.length; i++) {
            if (accessTime[i] < minValue) {
                minValue = accessTime[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
