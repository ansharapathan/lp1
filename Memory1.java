/*
    Name :Atharva Thakkar
    Div : A  
    Roll No : 71

*/

import java.util.Scanner;

class Task2 {
    int id, P_size, R_size , B_No;
    Task2(int id, int P_size)
    {
        this.id = id;
        this.P_size = P_size;
    }
    public void display() {
        System.out.println("P" + id + "\t\t" + P_size + "\t\t" + B_No + "\t\t" + R_size);
    }
}

class List2 {
    int n, m , count=0;
    Task2 Tasks[];
    int M_size[];
    int A[];
    Scanner sc = new Scanner(System.in);
   
    public void getData() {
        System.out.println("Enter The No Of Process : ");
        n = sc.nextInt();
        Tasks = new Task2[n];
        
        for(int i=0; i<n; i++)
        {
            System.out.println("Enter Id of process " + (i+1));
            int Id = sc.nextInt();
            System.out.println("Enter The size of process " + (i+1));
            int psize = sc.nextInt();
            Tasks[i] = new Task2(Id, psize);
        }

        System.out.println("Enter The No Of Blocks : ");
        m = sc.nextInt();
        M_size = new int[m];

        for(int i=0; i<m; i++)
        {
            System.out.println("Enter The size of Block " + (i+1));
            M_size[i] = sc.nextInt();
        }

    }
   
    public void displayData() {
        System.out.println("Process\t" + "Process_Size\t" + "Memory_Block\t" + "Remaining_Size");
        for(int i=0; i<n; i++)
        {
            Tasks[i].display();
        }
    }

    public void FirstFit() {
        
        for(int i=0; i<n; i++)
        {
            boolean empty = false;
            for(int j=0; j<m; j++)
            {
                if(Tasks[i].P_size <= M_size[j])
                {
                    Tasks[i].B_No = j+1;
                    M_size[j] -= Tasks[i].P_size;
                    empty = true;
                    break;
                }
            }
            if(empty==false) 
            {
                Tasks[i].P_size = 0;
                Tasks[i].B_No = 0;
                Tasks[i].R_size = 0;
            }
        }
    }

    public void BestFit() {
        
        A = new int[m];
        for(int i=0; i<m; i++)
        {
            A[i] = M_size[i];
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++)
            {
                int tmp = 0;
                if (A[i] > A[j]) 
                {
                    tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            boolean empty = false;
            for(int j=0; j<m; j++)
            {
                if(Tasks[i].P_size <= A[j])
                {
                    int temp = A[j];
                    for(int k=0; k<m; k++)
                    {
                        if(temp == M_size[k])
                        {
                            Tasks[i].B_No = k+1;
                            A[j] -= Tasks[i].P_size;
                            M_size[k] = A[j];
                            empty = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if(empty==false) 
            {
                Tasks[i].P_size = 0;
                Tasks[i].B_No = 0;
                Tasks[i].R_size = 0;
            }
        }   
    }

    public void WorstFit() {
        A = new int[m];
        for(int i=0; i<m; i++)
        {
            A[i] = M_size[i];
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++)
            {
                int tmp = 0;
                if (A[i] < A[j]) 
                {
                    tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            boolean empty = false;
            for(int j=0; j<m; j++)
            {
                if(Tasks[i].P_size <= A[j])
                {
                    int temp = A[j];
                    for(int k=0; k<m; k++)
                    {
                        if(temp == M_size[k])
                        {
                            Tasks[i].B_No = k+1;
                            A[j] -= Tasks[i].P_size;
                            M_size[k] = A[j];
                            empty = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if(empty==false) 
            {
                Tasks[i].P_size = 0;
                Tasks[i].B_No = 0;
                Tasks[i].R_size = 0;
            }
        }
    }

    public void nextFit() {
        int i=0;
        for(int j=0; j<m; j=(j+1)%m)
        {
            count++;
            if(Tasks[i].P_size <= M_size[j])
            {
                Tasks[i].B_No = j+1;
                M_size[j] -= Tasks[i].P_size;
                i++;
                count = 0;
            }
                
            if(count == m)
            {
                Tasks[i].B_No = 0;
                Tasks[i].R_size = 0;
                if(i==n)
                 break;
                else
                  i++;
            }
            if(i == n)
                break;
            
        }
    }
    public void RemainingSize() {
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(Tasks[i].B_No == (j+1))
                {
                        Tasks[i].R_size = M_size[j];
                        break;
                }
            }
        }
    }
}
 
class Memory1 {
    public static void main(String[] args) {
        List2 obj = new List2();
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1 : First FIt");
            System.out.println("2 : Best  FIt");
            System.out.println("3 : Worst FIt");
            System.out.println("4 : Next  FIt");
            System.out.println("5 : Exit");
            System.out.println("Enter the Choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.getData();
                    obj.FirstFit();
                    obj.RemainingSize();
                    obj.displayData();
                    break;

                case 2:
                    obj.getData();
                    obj.BestFit();
                    obj.RemainingSize();
                    obj.displayData();
                    break;

                case 3:
                    obj.getData();
                    obj.WorstFit();
                    obj.RemainingSize();
                    obj.displayData();
                    break;

                case 4:
                    obj.getData();
                    obj.nextFit();
                    obj.RemainingSize();
                    obj.displayData();
                    break;
                
                case 5:
                    System.out.println("End Of Program");
                    System.exit(0);
            }
        
         }while(ch<=5);

    }
}



