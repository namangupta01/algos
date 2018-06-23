//Time complexity for this is O(n) and takes O(1) extra space.
#include<stdio.h>
#include<malloc.h>

struct node {
	int data;
	struct node * next;
};

struct node * head;
struct node * mid_pointer;
struct node * mid_reverse_pointer;
int count;

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
		printf("%p\n",ptr);
		ptr=ptr->next;
	}
	printf("\n");
	return 0;
}

int count_nodes(){
	count=0;
	struct node * ptr = head;
	while(ptr!=NULL){
		count++;
		ptr=ptr->next;
	}
}

struct node * get_middle_address(){
	if(count%2==0){
		int c=0;
		struct node * ptr = head;
		while(c < (count/2)){
			ptr=ptr->next;
			c++;
		}
		return ptr;
	}
	else{
		int c=0;
		struct node * ptr = head;
		while(c<(count+1)/2){
			ptr=ptr->next;
			c++;
		}
		return ptr;
	}
}

int reverse(struct node * ptr_back,struct node * ptr){
	if(ptr->next==NULL){
		ptr->next = ptr_back;
		mid_reverse_pointer = ptr;
	}
	else{
		reverse(ptr,ptr->next);
		ptr->next = ptr_back;
	}
}

int reverse_half(){
	count_nodes();
	struct node  * ptr = get_middle_address();
	reverse(NULL,ptr);
}

int check(){
	reverse_half();
	struct node * ptr = head;
	struct node * reverse_ptr = mid_reverse_pointer;
	int c=0;
	if(count%2==0){
		while(c<count/2){
			if(ptr->data!=reverse_ptr->data){
				return 1;
			}
			else{
				ptr=ptr->next;
				reverse_ptr = reverse_ptr -> next;
				c++;
			}
		}
		return 0;
	}
	else{
		while(c<(count-1)/2){
			if(ptr->data!=reverse_ptr->data){
				return 1;
			}
			else{
				ptr=ptr->next;
				reverse_ptr = reverse_ptr -> next;
				c++;
			}
		}
		return 0;
	}
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
			reverse(NULL,mid_reverse_pointer);
		}
	}
	return 0 ;
}
