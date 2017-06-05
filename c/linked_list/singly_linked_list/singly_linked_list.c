#include<stdio.h>
#include<malloc.h>

struct node{
	int data;
	struct node *next;
};
struct node * head; //pointer to structure
//For inserting node
int insertion(){
	if(head==NULL){
		head=(struct node*)malloc(sizeof(struct node));
		printf("Enter the data value\n");
		scanf("%d",&(head->data));
		head->next=NULL;
	}
	else{
        struct node * ptr=head;
        while(ptr->next!=NULL){
            ptr=ptr->next;
        }
        ptr->next=(struct node*)malloc(sizeof(struct node));
        ptr=ptr->next;
        printf("Enter the data value\n");
        scanf("%d",&(ptr->data));
        ptr->next=NULL;
	}
	printf("Insertion Performed\n");
}
//For deleting a node
int deletion(){
    struct node * ptr=head;
	if(ptr==NULL){
		printf("List is already empty\n");
	}
	else{
		printf("Enter the position whose value to delete\n");
		int position,counter=1;
		scanf("%d",&position);
		while(counter<position-1){
			ptr=ptr->next;
			counter++;
		}
		if(position==1){
            struct node * temp;
            temp=head;
            head=head->next;
            free(temp);
		}
		else{
            struct node * temp;
            temp=ptr->next;
            ptr->next=ptr->next->next;
            free(temp);
		}

	}
	printf("Deleted Sucessfully\n");
}
//For displaing a List
int display(){
    struct node * ptr=head;
    while(ptr!=NULL){
        printf("Value is %d\n",ptr->data);
        ptr=ptr->next;
    }
}

int main(){
	int choice=1;
	head=NULL;
	while(choice!=0){
		printf("Press 0 for Exit\n");
		printf("Press 1 for Insertion\n");
		printf("Press 2 for Deletion\n");
		printf("Press 3 for Display\n");
		scanf("%d",&choice);
		if(choice==1){
			insertion(head);
		}
		else if(choice==2){
            deletion(head);
		}
		else if(choice==3){
            display(head);
		}
	}
	return 0;
}
