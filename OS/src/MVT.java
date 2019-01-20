import java.util.Scanner;

class MVT
{   public static void main(String args[])
    {	Scanner me=new Scanner(System.in);
	System.out.print("Enter total memory (MB):\t");
	int mem=me.nextInt();
	int x, i=1;
        System.out.println("Enter -1 to stop");
	while(true)
	{   System.out.println("\nEnter Process"+i+" requirement (MB):\t");
            x=me.nextInt();
            if(x==-1) break;
            else if(x<mem)
            {   mem-=x;
		System.out.println("Process"+i+" Accomodated!");
            }
            else
		System.out.println("Process"+i+" cannot be accomodated!");
            System.out.println("Remaining Memory (MB) = "+mem);
            i++;
	}
        System.out.println("\nTotal External Fragmentation (MB) = "+mem);
        me.close(); 
    }
}