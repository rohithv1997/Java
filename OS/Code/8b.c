#include <stdio.h> 
#include <stdlib.h> 
#include <process.h> 
#include <sys/types.h> 
#include <dirent.h> 
#include <string.h> 
int main(){     
DIR *d;     
struct dirent *dir;     
int choice, count=0, index=0, check, i, choice2;     
FILE *f = NULL;     
char fname[50], dname[50], name[256][256];     
printf("Folders Present in the Folder 'Multiple' are: \n");     
printf("1) DBMS\t\t2) OS\n");     
do    {         
char loc1[50]="dir D:\\Multiple\\", loc[50]="D:\\Multiple\\";         
printf("Enter Folder name to save the file into: ");         
scanf("%s",&dname);         
if(strcmp(dname,"dbms")!=0 && strcmp(dname,"os")!=0)        {             
printf("Wrong Directory name Entered..!!\nEnter one of these:\n");             
printf("1) DBMS\t\t2) OS\n");             
goto last;         }         
strcat(loc,dname);         
strcat(loc,"\\");         
printf("Enter Filename to save (with the extension): ");         
scanf("%s",&fname);         
d = opendir(loc);         
if(d)        {             
while((dir = readdir(d)) != NULL)            {                 
strcpy(name[count], dir->d_name);                 
count++;             }             
closedir(d);         }         
for(i=0; i<count; i++)        {             
check = strcmp(fname, name[i]);             
if(check==0)            {                 
printf("File already present!!\n");                 
goto last; 
	
}         }         
strcat(loc,fname);         
f = fopen(loc,"w+");         
if(f!=NULL)             
printf("File Saved\n");         
else             
printf("File not Saved\n");         
printf("Want to see the files in this directory? (1/0)");         
scanf("%d", &choice2);         
if(choice2==1)        {             
strcat(loc1,dname);             
printf(" Files in Directory: \n");             
system(loc1);         }     
last:         printf(" Want to save another file? (1/0): ");         
scanf("%d",&choice);     } 
while(choice==1);     
return 0; } 
