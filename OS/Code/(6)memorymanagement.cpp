#include<stdio.h>
#include<conio.h>
#include<malloc.h>

int main() 
{     
int n,p,i;     
printf("Enter number of pages: ");     
scanf("%d",&n);     
printf("Enter page size: ");     
scanf("%d",&p);     
for(i=0;i<n;i++)     
{         
//malloc(p);        
printf("Page %d Address %u\n",i+1,malloc(p));     
}     
getch();
return 0; 
} 
