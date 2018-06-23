#include<stdio.h>
#include<malloc.h>

struct node{
	int data;
	struct node * next;
};

struct node * head = NULL;

//Loop detecting by the use of hashing
int detecting(struct node* a[]){
	int number;
	if(head!=NULL){
		struct node * ptr = head;
		while(ptr!=NULL){
			number = hashing(ptr);

			if (a[number]==NULL){
				a[number]=1;
			}
			else{
				printf("Loop present\n");
				return 0;
			}
			ptr=ptr->next;
		}

	}
	else{
		printf("Empty linked list\n");
	}
}
// hashing function with high collision rate
int hashing(struct node * ptr){
	int sum=0;
	int number=ptr;
	while (number!=0){
		sum=sum+number%10;
		number=number/10;
	}
	return sum;
}

int main(){
    int i;
	struct node * arr[1000];
	for(i=0;i<1000;i++){
		arr[i]=NULL;
	}
		printf("Press 2 for Detecting loop\n");
	}
	return 0;
}
