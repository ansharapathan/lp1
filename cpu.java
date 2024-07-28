
//1)FFCFS 2)SJF(PREEMPTIVE) 3)PRIORITY (NON PREEMPTIVE) 4)ROUND ROBIN (PREEMPTIVE)
import java.util.*;
class cpu
{   //burst time
    public static int[] burst(int n)
    {
        int bt[]=new int[n];
        Scanner sc=new Scanner(System.in);
        

       
        for(int i=0;i<n;i++)
        {
             System.out.println("enter burst time of process"+(i+1)+":");
            bt[i]=sc.nextInt();
        }
        return bt;

    }
     //completion time
    public static int[] completion(int[]bt,int n)
    {
        int ct[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i==0)
                ct[i]=bt[i];
            else{
                ct[i]=ct[i-1]+bt[i];
            }
        }
        
      return ct;

    }

     





    //shell sorting for priority
    public static void priority(int n)
            {
        int bt1[]=new int[n];
        int pt[]=new int[n];
        Scanner sc=new Scanner(System.in);
        

       
        for(int i=0;i<n;i++)
        {
            System.out.println("enter burst time  of process"+(i+1)+":");
            bt1[i]=sc.nextInt();
             System.out.println("enter priority of process"+(i+1)+":");
            pt[i]=sc.nextInt();
        }
        /////////////////////////////
    

        // Bubble Sort for sorting according to priority
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (pt[j] > pt[j + 1]) {
                    // Swap pt[j] and pt[j + 1]
                    int temp = pt[j];
                    pt[j] = pt[j + 1];
                    pt[j + 1] = temp;

                    // Swap bt1[j] and bt1[j + 1] accordingly
                    temp = bt1[j];
                    bt1[j] = bt1[j + 1];
                    bt1[j + 1] = temp;
                }
            }
        }


        //////////////////////////////
                int []ct1=new int[10];
                ct1=completion(bt1, n);

               System.out.println("pid\tarrival\tpriority\tburst\tcompletion");
        for(int i=0;i<n;i++)
        {
            System.out.println(""+i+"\t"+"0"+"\t"+pt[i]+"\t\t"+bt1[i]+"\t\t"+ct1[i]);
        } 

            }

    //display
    public static void display(int[]bt,int[]ct,int n)
    {
        System.out.println("pid\tarrival\tburst\tcompletion");
        for(int i=0;i<n;i++)
        {
            System.out.println(""+i+"\t"+"0\t"+""+bt[i]+"\t"+ct[i]);
        }
    }

    public static void rr(int n)
    {

    	Scanner sc=new Scanner(System.in);
 int pid[] = new int[n]; // it takes pid of process
int at[] = new int[n]; // at means arrival time
int bt[] = new int[n]; // bt means burst time
int ct[] = new int[n]; // ct means complete time
int ta[] = new int[n];// ta means turn around time
int wt[] = new int[n];  // wt means waiting time
int f[] = new int[n];  // f means it is flag it checks process is completed or not
int k[]= new int[n];   // it is also stores brust time
    int i, st=0; //st is continuously incremented as the processes are being executed in a preemptive manner.
                 // Each iteration of the loop represents a time unit or time slice. 
            



    int tot=0;  //tot is counting completed process
    float avgwt=0, avgta=0;
 
    for (i=0;i<n;i++)
    {
     pid[i]= i+1;
     System.out.println ("enter process " +(i+1)+ " arrival time:");
     at[i]= sc.nextInt();
     System.out.println("enter process " +(i+1)+ " burst time:");
     bt[i]= sc.nextInt();
     k[i]= bt[i];
     f[i]= 0;
    }
    System.out.println("enter time quantum");
    int tq=sc.nextInt();

    while(true)
    {
         int min=99,c=n;
         if (tot==n)
         break;
        
         for ( i=0;i<n;i++)
         {
            if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
             {
             min=bt[i];
             c=i;
             }
         }
        
         if (c==n)
            st+=tq;
         else
             {
             bt[c]-=tq;
             st+=tq;

             //The burst time of the selected process is decremented,and st is incremented to simulate the passage of time.

             if (bt[c]<=0) 
                 {
                 ct[c]= st;
                 f[c]=1;
                 tot++;
                 }
             }
    }
    
    for(i=0;i<n;i++)
    {
     ta[i] = ct[i] - at[i];
     wt[i] = ta[i] - k[i];
     avgwt+= wt[i];
     avgta+= ta[i];
    }
    
    System.out.println("pid  arrival  burst  complete turn waiting");
    for(i=0;i<n;i++)
    {
     System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
    }
    
    System.out.println("\naverage tat is "+ (float)(avgta/n));
    System.out.println("average wt is "+ (float)(avgwt/n));
    sc.close();

       

    }


    public static void sjfpre(int n)
    {
Scanner sc=new Scanner(System.in);
int pid[] = new int[n]; // it takes pid of process
int at[] = new int[n]; // at means arrival time
int bt[] = new int[n]; // bt means burst time
int ct[] = new int[n]; // ct means complete time
int ta[] = new int[n];// ta means turn around time
int wt[] = new int[n];  // wt means waiting time
int f[] = new int[n];  // f means it is flag it checks process is completed or not
int k[]= new int[n];   // it is also stores brust time
    int i, st=0; //st is continuously incremented as the processes are being executed in a preemptive manner.
                 // Each iteration of the loop represents a time unit or time slice. 
                 //



    int tot=0;  //tot is counting completed process
    float avgwt=0, avgta=0;
 
    for (i=0;i<n;i++)
    {
     pid[i]= i+1;
     System.out.println ("enter process " +(i+1)+ " arrival time:");
     at[i]= sc.nextInt();
     System.out.println("enter process " +(i+1)+ " burst time:");
     bt[i]= sc.nextInt();
     k[i]= bt[i];
     f[i]= 0;
    }
    
    while(true)
    {
         int min=99,c=n;
         if (tot==n)
         break;
        
         for ( i=0;i<n;i++)
         {
            if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
             {
             min=bt[i];
             c=i;
             }
         }
        
         if (c==n)
            st++;
         else
             {
             bt[c]--;
             st++;

             //The burst time of the selected process is decremented,and st is incremented to simulate the passage of time.

             if (bt[c]==0) 
                 {
                 ct[c]= st;
                 f[c]=1;
                 tot++;
                 }
             }
    }
    
    for(i=0;i<n;i++)
    {
     ta[i] = ct[i] - at[i];
     wt[i] = ta[i] - k[i];
     avgwt+= wt[i];
     avgta+= ta[i];
    }
    
    System.out.println("pid  arrival  burst  complete turn waiting");
    for(i=0;i<n;i++)
    {
     System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
    }
    
    System.out.println("\naverage tat is "+ (float)(avgta/n));
    System.out.println("average wt is "+ (float)(avgwt/n));
    sc.close();

    }

    
    public static void main(String[]args)
    {
        
        int[] p;
        int[] q;

        System.out.println("enter your choice:");
        System.out.println("1.fcfs\t2.priority(non-preemptive)\t3.sjf (preemptive)\t4.roundrobin (preemptive)");
         Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        System.out.println("how many processes:");
        int n=sc.nextInt();
        switch(ch)
        {
            case 1: p=burst(n);
                    q=completion(p,n);
                    System.out.println("***first come first serve***");
                    display(p,q,n);
                    break;
            case 2: 
                    System.out.println("***priority***");
                    priority(n);
                    //display(p,q,n);
                    break;
            case 3:
                   System.out.println("***sjf preemptive***");
                   sjfpre(n);
                   break;
            case 4:
                   System.out.println("***round-robin***");
               
                   rr(n);
                   break;
        } 


    }
}