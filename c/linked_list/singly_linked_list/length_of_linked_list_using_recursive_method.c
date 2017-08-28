#include<stdio.h>

struct node{
	int data;
	struct node * next;
};

struct node * head =NULL;

int iterative_count=0;
int recursive_count=0;

int insertion(){
	printf("Enter the number of elements you want to enter\n");
	int number,i;
	scanf("%d",&number);
	struct node * ptr;
	head = (struct node*)malloc(sizeof(struct node));
	ptr = head;
	for(i=0;i<number;i++){
		printf("Enter the Element\n");
		scanf("%d",&(ptr->data));
		if(i==number-1){
			ptr->next = NULL;
			return 0;
		}
		ptr->next = (struct node*)malloc(sizeof(struct node));
		ptr = ptr->next;
	}
	return 0;
}

int display(){
	struct node * ptr;
	ptr = head;
	while(ptr!=NULL){
		printf("%d \n",ptr->data);
		ptr = ptr->next;
	}
	return 0;
}

int count_recursive(struct node * ptr){
	if(ptr!=NULL){
		recursive_count++;
		count_recursive(ptr->next);
	}
		return 0;
}

int count_iterative(){
	struct node * ptr = head;
	while(ptr!=NULL){
		iterative_count++;
		ptr=ptr->next;
	}
	return 0;
}

int main(){
	insertion();
	display();
	count_recursive(head);
	printf("Length of linked list using recursive method is %d\n",recursive_count);
	count_iterative();
	printf("Length of linked list using iterative method is %d\n",iterative_count);
	return 0;
}
