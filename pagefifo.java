import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


class pagefifo
{

    public static void main(String args[])
    {
        int incomingStream[] = {7, 0, 1, 2, 0 , 3, 0, 4, 2, 3, 0, 3, 2, 1};
        int pageFaults = 0;
        int frames = 3;
        int m, n, s, pages;

        pages = incomingStream.length;

        System.out.println("Incoming \t Frame 1 \t Frame 2 \t Frame 3");
        int temp[] = new int[frames];
        for(m = 0; m < frames; m++)
        {
            temp[m] = -1;
        }

        for(m = 0; m < pages; m++)
        {
            s = 0;

            for(n = 0; n < frames; n++)
            {
                if(incomingStream[m] == temp[n])
                {
                    s++;
                    pageFaults--;
                }
            }
            pageFaults++;

            if((pageFaults <= frames) && (s == 0))
            {
                temp[m] = incomingStream[m];
            }
            else if(s == 0)
            {
                temp[(pageFaults - 1) % frames] = incomingStream[m];
            }

            System.out.println();
            System.out.print(incomingStream[m] + "\t\t\t");
            for(n = 0; n < frames; n++)
            {
                if(temp[n] != -1)
                    System.out.print(temp[n] + "\t\t\t");
                else
                    System.out.print(" - \t\t\t");
            }
        }

        System.out.println("\nTotal Page Faults:\t" + pageFaults);
    }
}