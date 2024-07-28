import java.util.*;

class bf{
public static void main(String[]args){





	int n=5;
int status[]=new int[n];
int prcs[]=new int[]{912,121,417,315,100};
int mb[]=new int[]{200,500,100,600,300};
int stts[]=new int[n];
int ifr[]=new int[n];

for(int i=0;i<n;i++)
{
	stts[i]=-1;
}

for(int i=0;i<n;i++) //prcs
{
    int ind=-1;

	for(int j=0;j<n;j++)//mb
	{
         
	   if(prcs[i]<=mb[j] )
	   {
	      if(ind==-1)
	      	ind=j;
	        
	      if (mb[ind]>mb[j])
	      	ind=j;
	        
	   }

	}
	if(ind!=-1)
	{
		stts[i]=ind;
		mb[ind]-=prcs[i];
	}


	
}
 System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + prcs[i] + "\t\t"); 
            if (stts[i] != -1) 
                System.out.print(stts[i] + 1); 
            else
                System.out.print("Not Allocated");


            System.out.println(); 
        } 
    } 
}

