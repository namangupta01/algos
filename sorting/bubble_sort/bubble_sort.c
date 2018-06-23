#include<stdio.h>


int bubblesort(int a[],int n){
	int i,j;
	for(i=0;i<n-1;i++){
		int swapped = 0;
		for(j=0;j<n-1-i;j++){
			if(a[j]>a[j+1]){
				int temp = a[j];	//Swaping
				a[j] = a[j+1];
				a[j+1] = temp;
				swapped = 1;
			}
		}
		if(swapped == 0){
			return 0;
		}
	}
}

int main(){
	printf("Enter the number of Elements\n");
	int n,i;
	scanf("%d",&n);
	int a[n];
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	bubblesort(a,n);
	printf("Sorted array is :\n");
	for(i=0;i<n;i++){
		printf("%d ",a[i]);
		printf("\n");
	}
}
