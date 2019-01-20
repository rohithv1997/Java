#include<stdio.h>

int main()
{
	int a[20][20];
	int b[20][20];
	int avail[20];
	int m;
	int i;
	int j;
	int f;
	int t1;
	int t=0;
	int work[20];
	int finish[20];
    int y=0;
	int n;
	printf("enter the the number of processes:");
	scanf("%d",&n);
	printf("enter the number of resources:");
	scanf("%d",&m);
	printf("enter the allocation for the processes for each resource");
	for(i=0;i<=n;i++)
	{
		for(j=0;j<m;j++)
		{
			scanf("%d",&a[i][j]);
		}
		printf("\n");
	}
	printf("enter the required for the processes for each resource");
	for(i=0;i<=n;i++)
	{
		for(j=0;j<m;j++)
		{
			scanf("%d",&b[i][j]);
		}
		printf("\n");
}
	printf("enter the available resources");
	for(i=0;i<m;i++)
	{
		scanf("%d",&avail[i]);
		work[i]=avail[i];
	}
	for(i=0;i<=n;i++)
	{
		for(j=0;j<m;j++)
		{
			if(a[i][j]!=0)
			{
				t++;
			}
		}
		if(t>0)
		{
			finish[i]=0;
		}
		else
		{
			finish[i]=1;
		}
		if(finish[i]==0)
		{
			t1=0;
				for(j=0;j<m;j++)
				{
					
					if(b[i][j]>work[j])
					{
					
					t1++;
				    }
				}
				
			
		       if(t1==0)
		       {
						for(j=0;j<m;j++)
						{
								work[j]=work[j]+a[i][j];
			
						}	
			
							finish[i]=1;
							printf("process %d executed \n",i);
		
		
				}
						if(t1>0)
								{
								finish[i]=0;
								
								}
		
		
		}
		
		
	}
		for(i=0;i<=n;i++)
		{
			if(finish[i]==0)
			
		{
				for(j=0;j<m;j++)
				{
					if(b[i][j]>work[j])
					t1++;
				}
				
			
		if(t1==0)
		{
			for(j=0;j<m;j++)
			{
			work[j]=work[j]+a[i][j];
			
				}	
			
			finish[i]=1;
			printf("process %d executed \n",i);
		}
		if(t1>0)
		{
			finish[i]=0;
		}
		}
		
		}
	
    for(i=0;i<=n;i++)
    {
    	if(finish[i]==0)
    	{
    		y++;
		}
	}
	if(y>0)
	{
		printf("the system is in deadlock \n");
		
	}
	else
	{
		printf("the system is not in deadlock \n");
	}
	getch();
return 0;
}
