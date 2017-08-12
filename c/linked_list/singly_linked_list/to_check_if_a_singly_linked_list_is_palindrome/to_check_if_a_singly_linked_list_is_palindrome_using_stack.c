//Time complexity for this is O(n) and takes O(n) extra space in stack method
#include<stdio.h>
#include<malloc.h>

struct node {
	int data;
	struct node * next;
};

struct node * head;
struct node * stack_head;

int insertion(){
	printf("Enter the data\n");
	int data;
	scanf("%d",&data);
	if(head==NULL){
		head=(struct node *)malloc(sizeof(struct node));
		head->data = data;
		head->next = NULL;
	}
	else{
		struct node * ptr = head;
		while(ptr->next!=NULL){
			ptr=ptr->next;
		}
		ptr->next = (struct node *)malloc(sizeof(struct node));
		ptr=ptr->next;
		ptr->data=data;
		ptr->next=NULL;
	}
	return 0;
}

int show(){
	if(head == NULL){
		printf("List is empty\n");
		return 0;
	}
	struct node * ptr =head;
	while(ptr!=NULL){
		printf("%d ",ptr->data );
		ptr=ptr->next;
	}
	printf("\n");
	return 0;
}

int make_stack(){
	struct node * ptr = head ;
	if(head!=NULL){
		stack_head = (struct node *)malloc(sizeof(struct node));
		stack_head->data = ptr ->data;
		stack_head->next=NULL;
		ptr=ptr->next;
	}
	else{
		printf("Linked list is empty\n");
	}
	while(ptr!=NULL){
		struct node * temp=(struct node *)malloc(sizeof(struct node *));
		temp->next = stack_head;
		stack_head=temp;
		stack_head->data = ptr->data;
		ptr=ptr->next;
	}

}



int check(){
	make_stack();
	struct node * ptr = head;
	struct node * stack_ptr = stack_head;
	while(ptr!=NULL){
		if(ptr->data!=stack_ptr->data){
			return 1;
		}
		else{
			ptr=ptr->next;
			stack_ptr=stack_ptr->next;
		}
	}
	return 0;
}

int main(){
	int choice=1;
	while(choice!=0){
		printf("Enter 1 for insertion and 2 for showing linked list and 3 for Checking\n");
		scanf("%d",&choice);
		if(choice==1){
			insertion();
		}

		else if(choice==2){
			show();
		}

		else if(choice==3){
			int value=check();
			if(value==1){
				printf("Not palingdrom\n");
			}
			else{
				printf("Palingdrom\n");
			}
		}
	}
	return 0 ;
}
