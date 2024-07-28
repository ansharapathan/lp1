import java.util.Scanner;

public class rr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("how many precesses?");
        int n=sc.nextInt();

       // int pid[] = new int[n];
       // int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int k[] = new int[n];
        int flag=0;

        for(int i=0;i<n;i++)
        {
            ct[i]=-1;
        }
System.out.println("enter process ");
for(int i=0;i<n;i++)
{
    bt[i]=sc.nextInt();
    k[i]=bt[i];
}

System.out.println("enter time quantum");
int qt=sc.nextInt();

while(k[n-1]!=0){

    for(int i=0;i<n;i++){
    if(k[i]!=0)
    {
        k[i]=k[i]-qt;
        flag=flag+qt;

    }

    if(k[i]<=0)
    {
        if(ct[i]==-1)
          ct[i]=flag;
    }
}
}
for(int i=0;i<n;i++){
System.out.println("bt \t completion time");
System.out.println(bt[i]+"\t"+ct[i]);
}


        
    }
}
