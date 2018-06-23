#include<stdio.h>


void merge(int a[],int l,int r){
	int i;
	int m = (l+r)/2;
	if(l<r){
		merge(a,l,m);
		merge(a,m+1,r);
		for(i=l;i<=r;i++){
			printf("%d ",a[i]);
		}
		printf("\n");
		mergesort(a,l,m,r);
		printf("Sorted\n");
		for(i=l;i<=r;i++){
			printf("%d ",a[i]);
		}
		printf("\n");
	}
}

void mergesort(int a[],int l,int m,int r){
	int n1 = m-l+1;
	int n2 = r-m;
	int a1[n1];
	int a2[n2];
	int i=0,j=0,k=l;
	for(i=0;i<n1;i++){
		a1[i] = a[l+i];
	}
	for(i=0;i<n2;i++){
		a2[i] = a[m+1+i];
	}
	printf("\n");
	printf("\n");
	for(i=0;i<n1;i++){
		printf("%d ",a1[i]);
	}
	printf("\n");
	for(i=0;i<n2;i++){
		printf("%d ",a2[i]);
	}
	printf("\n");
	printf("\n");
	i=0;
	j=0;
	while(i<n1 && j<n2){
		if(a1[i]<a2[j]){
			a[k] = a1[i];
			k++;
			i++;
		}
		else{
			a[k] = a2[j];
			k++;
			j++;
		}
	}
	while(i<n1){
		a[k] = a1[i];
		i++;
		k++;
	}
	while(j<n2){
		a[k] = a2[j];
		j++;
		k++;
	}
}

int main(){
	printf("Enter number of elements into the array\n");
	int n,i;
	scanf("%d",&n);
	int a[n];
	for(i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	merge(a,0,n-1);
	printf("Sorted array is \n");
	for(i=0;i<n;i++){
		printf("%d\n",a[i]);
	}
	return 0;
}
