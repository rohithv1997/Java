#include<stdio.h> 
int main() {     
int a[3]={-1,-1,-1},n=0,pf=0,i=0,j=0;     
printf("Enter number of frames: ");     
scanf("%d",&n);     
for(i=0;i<=19;i++)     {         
scanf("%d",&n);         
if(n!=a[0] && n!=a[1] && n!=a[2])         {             
a[j]=n;             
if(j<2)                 
j++;             
else                 
j=0;             
pf++;         }     }     
printf("Total Page Faults: %d",pf);     
getch();
return 0; } 
