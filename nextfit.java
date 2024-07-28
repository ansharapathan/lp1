import java.util.*;
class nextfit{
	public static void main(String[]args)
	{
		int mb[]=new int[]{200,400,300}; //j
		int mr[]=new int[3];              //i
		int status[]=new int[3];
		int flag[]=new int[3];
		
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++){
		System.out.println("enter  job"+i);
		mr[i]=sc.nextInt();
	}
	for(int i=0;i<3;i++)//mr
	{
		for(int j=i;j<3;j++) //mb
		{
			if(mb[j]>=mr[i]&& flag[j]!=1)
			{
                status[i]=j+1;
                flag[j]=1;
                 break;
			}
         

		}
	}
	System.out.print("mb\t mr\t status\n");
	for(int i=0;i<3;i++){
	System.out.print(""+mb[i]+"\t"+mr[i]+"\t");
	if(status[i]!=0)
	   System.out.print(status[i]);
	else
		System.out.print("not allocated");
	System.out.println("");


	
}

	}


}