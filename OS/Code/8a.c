#include <stdio.h> 
#include <stdlib.h> 
#include <process.h> 
#include <dirent.h>
#include <sys/types.h> 
#include <string.h> 
int main() {     
DIR *d;     
struct dirent *dir;     
int choice, count=0, index=0, check, i;     
FILE *f = NULL;     
char fname[50], name[256][256];     
do    {         
char loc[50] ="D:\\oslab\\";         
printf("Enter Filename to save (with the extension): ");         
scanf("%s",&fname);          
d = opendir("D:\\oslab\\");         
if(d)        {             
while((dir = readdir(d)) != NULL)            {                 
strcpy(name[count], dir->d_name);                 
count++;             }             
closedir(d);         }         
for(i=0; i<count; i++)        {             
check = strcmp(fname, name[i]);             
if(check==0)            {                 
printf("File already present!!\n");                 
goto last;             }         }         
strcat(loc,fname);         
printf("%s", &loc);         
f = fopen(loc,"w+");         
if(f!=NULL)             
printf("File Saved\n");         
else             
printf("File not Saved\n");         
printf(" Files in Directory: \n");         
system("dir D:\\oslab\\");     
last:        
 printf(" Want to save another file? (1/0): ");         
 scanf("%d",&choice);     } 
 while(choice==1);     
 return 0;}          
