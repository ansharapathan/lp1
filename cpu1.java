import java.util.*;
class cpu1
{   //burst time
    public static int[] burst(int n)
    {
        int bt[]=new int[10];
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
        int ct[]=new int[10];
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
    //turn around
     public static int[] turn(int[]ct,int n)
    {
        int tat[]=new int[10];
        for(int i=0;i<n;i++)
        {
            tat[i]=ct[i]-(i);
            }
            return tat;
        }
        
      

    
    //waiting 
     public static int[] waiting(int[]tat,int[]bt,int n)
    {
        int wt[]=new int[10];
        for(int i=0;i<n;i++)
        {
            wt[i]=tat[i]-bt[i];
            }
              return wt;
        }
        
    

    
    //display
     public static void display(int[]bt,int[]ct,int[]tat,int[]wt,int n)
    {
        System.out.println("pid\tarrival\tburst\tct\ttat\twt");
        for(int i=0;i<n;i++)
        {
            System.out.println("p"+(i+1)+"\t"+i+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }
    }
    
    
 public static void main(String[] args)
    {
        
        int[] p;
        int[] q;
        int[] r;
        int[] s;
        Scanner sc=new Scanner(System.in);

        System.out.println("how many processes:");
        int n=sc.nextInt();
        
                    p=burst(n);
                    q=completion(p,n);
                    r=turn(q,n);
                    s=waiting(r,p,n);
                    System.out.println("***first come first serve***");
                    display(p,q,r,s,n);
  }      
}
