#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<malloc.h>

struct node{
int data;
struct node *next;
};


int main(){
struct node *start= NULL;
struct node *newnode ,*ptr;
int n,a;
char ch;
do{

printf("process name:"); scanf("%s",&a);
printf("process size:"); scanf("%d",&n);

while(n>0){
newnode=(struct node*)malloc(sizeof(struct node));
newnode -> data=n;

if(start==NULL){
newnode->next=NULL;
start=newnode;
}

else{
ptr=start;
while(ptr->next!=NULL)
ptr=ptr->next;
ptr->next=newnode;
newnode->next=NULL;
}
printf("address: %u ",ptr);
printf("\n");
n--;
}
printf("press y to continue");scanf("%s",&ch);
}while(ch=='y');

getch();
return 0;
}

