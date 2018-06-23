#include<stdio.h>
#include<malloc.h>

struct node
{
	int data;
	struct node * next;
};

struct node * head;

int insertion(){
	printf("Enter the value\n");
	int data;
	scanf("%d",&data);
	if (head==NULL){
		head = (struct node *) malloc(sizeof(struct node));
		head->data=data;
		head->next=NULL;
	}
	else{
		struct node * ptr = head;
		while(ptr->next!=NULL){
			if(ptr->data>data){
				struct node * temp = (struct node *)malloc(sizeof(struct node));
				temp->next=ptr->next;
				temp->data=ptr->data;
				ptr->next=temp;
				ptr->data=data;
				return 1;
			}
			else{
				ptr=ptr->next;
			}
		}
		if(ptr->data>data){
				struct node * temp = (struct node *)malloc(sizeof(struct node));
				temp->next=ptr->next;
				temp->data=ptr->data;
				ptr->next=temp;
				ptr->data=data;
				return 1;
		}
		else{
			struct node *temp = (struct node *)malloc(sizeof(struct node));
			ptr->next=temp;
			temp->data = data;
			temp->next = NULL;
		}
	}
	return 1;
}


int show(){
	if(head==NULL){
		printf("Linked list is empty\n");
	}
	else{
		struct node * ptr = head;
		while(ptr!=NULL){
			printf("%d ",ptr->data);
			ptr = ptr->next;
		}
		printf("\n");
	}
}

int main(){
	int choice=1;
	printf("Enter 1 for Insertion and 2 for Showing and Press 0 for exit\n");
	scanf("%d",&choice);
	while(choice!=0){
		if(choice==1){
			insertion();
		}
		else if(choice ==2){
			show();
		}
		printf("Enter 1 for Insertion and 2 for Showing and Press 0 for exit\n");
		scanf("%d",&choice);
	}
	return 1;
}
