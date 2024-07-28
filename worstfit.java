import java.util.*;

class worstfit{
public static void main(String[]args){

	int n=5;
int status[]=new int[n];
int prcs[]=new int[]{212,417,112,426,100};
int mb[]=new int[]{100,500,200,300,600};
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
         
	   if(mb[j]>=prcs[i]  )
	   {
	      if(ind==-1)
	      	ind=j;
	        
	      else if (mb[ind]<mb[j])
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

