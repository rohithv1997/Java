#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
	int p[100], bt[100], wt[100], tat[100],n,i; int wait=0;
	cout<<"\n enter the no. of processes : "; cin>>n;
	cout<<"\n enter the burst time ";
	for(i=1;i<=n;i++)
	{
		cout<<"\n p"<<i<<" = "; cin>>bt[i];
	}
	cout<<"\n WAITING TIME ";
	for(i=1;i<=n;i++)
	{
		wt[i]= wait;
		cout<<"\n p"<<i<<" = "<<wt[i];
		wait = wait + bt[i];
		
	}
	cout<<"\n TURN AROUND TIME";
	for(i=1;i<=n;i++)
	{
		tat[i]=bt[i]+wt[i];
		cout<<"\n p["<<i<<"] = "<<tat[i];
	}
	cout<<"\n GAMIT CHART \n|";
	for(i=1;i<=n;i++)
	{
	cout<<"	p"<<i<<"\t|";
	}
	cout<<"\n";
	for(i=1;i<=n;i++)
	{
	cout<<"   \t\t"<<tat[i];
 	}
	getch();
	return 0;
}

