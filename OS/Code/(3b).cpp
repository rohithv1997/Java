#include<stdio.h>
#include<conio.h>
int main()
{
char a[100], n; int s, i; int last = 0;
for(i=0;i<100;i++)
a[i]= '0';
printf("\n memory size is 100.. Enter the name and size of the file : ");
scanf("%c %d", &n, &s); 
for(i=0;i<s;i++)
a[i] = n;
for(i=0;i<100;i++)
printf(" \t %c", a[i]);
last = last + s;
printf("\n External fragmentation : %d", (100 - last));
getch();
return 0;
}
