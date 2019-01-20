import java.util.Scanner;

class MFT
{   public static void main(String args[])
    {   Scanner me=new Scanner(System.in);
	System.out.print("Enter Total memory (MB):\t");
	int mem=me.nextInt();
        System.out.print("Enter No. of Partitions:\t");
        int n=me.nextInt(), size=mem/n, ef=(mem%n), x, inf;
        System.out.print("Partition Size(MB) = "+size);
	for(int i=1;i<=n;i++)
	{   System.out.print("\nEnter Process"+i+" Requirement (MB) \t:");
            x=me.nextInt();
            if(x>size)
                System.out.println("Process"+i+" cannot be accomodated!");
            else
            {   inf=(size-x);
		System.out.println("Process"+i+" Accomodated!\nInternal fragmentation (MB) = "+inf);
            }
	}
        System.out.print("External Fragmentation (MB) = "+ef);
        me.close();
    }
}