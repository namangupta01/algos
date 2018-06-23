//Program for showing merging two sorted linked list

#include<stdio.h>
#include<malloc.h>
struct node
{
	int data;
	struct node * next;
};
struct node * head1 = NULL;
struct node * head2 = NULL;

int insertion(struct node ** headptr){
	if(*headptr==NULL){
		*headptr = (struct node *)malloc(sizeof(struct node));
		printf("Enter the value of data\n");
		scanf("%d",&((*headptr)->data));
		(*headptr)->next=NULL;
	}
	else{
		struct node * temp;
		temp=*headptr;
		while(temp->next!=NULL){
			temp=temp->next;
		}
		temp->next=(struct node *)malloc(sizeof(struct node));
		temp=temp->next;
		printf("Enter the value of data\n");
		scanf("%d",&(temp->data));
		temp->next=NULL;
	}
}

int show(){
	printf("List 1\n");
	struct node * ptr = head1;
	while(ptr!=NULL){
		printf("%d ",ptr->data);
		ptr=ptr->next;
	}
	printf("\n");
	ptr=head2;
	while(ptr!=NULL){
		printf("%d ",ptr->data);
		ptr=ptr->next;
	}
	printf("\n");
}

int mergeing(){
	struct node * ptr1 = head1;
	struct node * ptr2 =head2;
	while(ptr1!=NULL && ptr2!=NULL){
		if(ptr1->data > ptr2->data){
			printf("%d ",ptr2->data );
			ptr2=ptr2->next;
		}
		else{
			printf("%d ",ptr1->data );
			ptr1=ptr1->next;
		}
	}
	if(ptr1==NULL){
		while(ptr2!=NULL){
			printf("%d ",ptr2->data);
			ptr2=ptr2->next;
		}
	}
	else{
		while(ptr1!=NULL){
			printf("%d ",ptr1->data);
			ptr1=ptr1->next;
		}
	}
}
int main(){
	int choice=1;
	printf("Insert linked list 1 in sorted order\n");
	while(choice==1){
		printf("Enter element\n");
		insertion(&head1);
		printf("Press 1 to continue adding element to the list\n");
		scanf("%d",&choice);
	}
	choice=1;
	printf("Insert linked list 2 in sorted order\n");
	while(choice==1){
		printf("Enter element\n");
		insertion(&head2);
		printf("Press 1 to continue adding element to the list\n");
		scanf("%d",&choice);
	}
	choice=1;
	while(choice!=0){
		printf("Press 1 for Mergeing\nAnd Press 2 for Showing two list\n");
		scanf("%d",&choice);
		if(choice==1){
			mergeing();
		}
		else if(choice==2){
			show();
		}
	}
	return 0;
}
