#include<stdio.h> 
int main() 
{     
int a[3]={-1,-1,-1},b[3]={4,3,2},i,j,p,pf=0,n;     
printf("Enter frame size: ");        
scanf("%d",&n);     
for(i=0;i<20;i++)   
{	scanf("%d",&p);         
	if(a[0]!=p && a[1]!=p && a[2]!=p)     
	{	if(b[0]>b[1] && b[0]>b[2])            
		{                 
			a[0]=p;                 
			b[0]=1;                 
			b[1]++;                 
			b[2]++;           
		}             
		else if(b[1]>b[0] && b[1]>b[2])     
		{                 
		a[1]=p;                 
		b[1]=1;                 
		b[0]++;                 
		b[2]++;          
		}             
else           
{                 
a[2]=p;                 
b[2]=1;                 
b[0]++;                 
b[1]++;           
}             
pf++;       
}         
else       
{             
for(j=0;j<n;j++)           
{                 
b[j]++;                 
if(a[j]==p)               
{                     
b[j]=1;                
}            
}        
}    
}     
printf("Number of page faults: %d",pf);     
getch();
return 0;
}
