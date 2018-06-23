//This is the fastest method. Traverse linked list using two pointers.  Move one pointer by one and other pointer by two.  If these pointers meet at some node then there is a loop.  If pointers do not meet then linked list doesn’t have loop.
#include<stdio.h>
#include<conio.h>

struct node {
	int data;
	struct node * next;
}
struct node * head;
	head=NULL;

int checking_loop(){
	if(head!=NULL){
	struct node * ptr1;
	struct node * ptr2;
	ptr1=head;
	ptr2=head->next;
	}
	else{
		printf("Empty Linked List\n");
	}
	while(ptr1!=ptr2 && ptr1==NULL && ptr2==NULL){
		ptr1=ptr->next;
		if((ptr2->next)->next!=NULL){
			ptr2=(ptr2->next)->next;
		}
		else{
			ptr2=NULL;
		}
	}
	if(ptr1==ptr2){
		printf("Loop present\n");
	}
	else{
		printf("Loop is not present\n");
	}
	
}

int main(){
	checking_loop();
	return 0;
}