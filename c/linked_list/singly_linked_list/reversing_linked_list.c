#include<stdio.h>
#include<malloc.h>


struct node{
	int data;
	struct node* next;
};

struct node * head=NULL;


// for reversing a linked list
int reverse(struct node * ptr,struct node * ptr2){

	if(ptr->next!= NULL){
		struct node * temp = ptr->next;
		ptr->next=ptr2;
		reverse(temp,ptr);
	}
	else{
		head=ptr;
		ptr->next=ptr2;
		return 0;
	}
}

int insertion(){
	if(head==NULL){
		head=(struct node *)malloc(sizeof(struct node));
		printf("Enter the data value\n");
		scanf("%d",&(head->data));
		head->next=NULL;
	}
	else{
		struct node * ptr;
		ptr=head;
		while(ptr->next!=NULL){
			ptr=ptr->next;
		}
		ptr->next=(struct node * )malloc(sizeof(struct node));
		ptr=ptr->next;
		printf("Enter the data value\n");
		scanf("%d",&(ptr->data));
		ptr->next=NULL;
	}
	printf("Insertion performed\n");
}
int display(){
    struct node * ptr=head;
    while(ptr!=NULL){
        printf("Value is %d\n",ptr->data);
        ptr=ptr->next;
    }
}

int main(){
	int choice=1;
	while(choice!=0){
		printf("Press 0 for Exit\n");
		printf("Press 1 for Insertion\n");
		printf("Press 2 for Reverse\n");
		printf("Press 3 for Display\n");
		scanf("%d",&choice);
		if(choice==1){
			insertion()	;
		}
		else if(choice==2){
			reverse(head,NULL);
		}
		else if(choice==3){
			display();
		}
	}
	return 0;
}
