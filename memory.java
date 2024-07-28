//write a program to simulate memory placement stratergies 1)first fit  2)best fit 3)worst fit 4)next fit

import java.util.*;
class memory{


public static void main(String []args)
{

int ml[]=new int[4];
int mb[]=new int[]{200,30,700,50};
int job[]=new int [4];
int size[]=new int[4];
int ifr[]=new int[4];
int mer[]=new int[4];

Scanner sc=new Scanner(System.in);

//memory required input
for(int i=0;i<4;i++)
{
System.out.println("enter memory requirement for job j"+(i+1)+":");
mer[i]=sc.nextInt();

}

//memory locations predefined

for(int i=0;i<4;i++)
{
	if(i==0)
		ml[i]=1000;
	else
	{
	  ml[i]=ml[0]+mb[i-1];
	
	}
}

//internal fragmentation
for(int i=0;i<4;i++){
	if ( mer[i]<=mb[i])
	{
		ifr[i]=mb[i]-mer[i];

	}
	else
	 ifr[i]=mb[i];
}

System.out.println("***output***");
System.out.println("location block\tjob\tsize\tinternal fragmentation");
for(int i=0;i<4;i++)
{
System.out.println(""+ml[i]+"\t"+mb[i]+"\t"+"j"+(i+1)+"\t"+mer[i]+"\t"+ifr[i]);
}

System.out.println("total internal fragmentation:"+ Arrays.stream(ifr).sum());


}


}
