#include <iostream>
using namespace std;

//Function to build the segment tree
void buildTree(int *arr, int *tree, int start, int end, int treeNode){
	if(start == end){
		tree[treeNode] = arr[start];
		return ;
	}
	int mid = (start+end)/2;
	buildTree(arr, tree, start, mid, treeNode*2);
	buildTree(arr, tree, mid+1, end, (treeNode*2)+1);
	tree[treeNode] = tree[treeNode*2] + tree[treeNode*2+1];
	return ;
}

//Funtion to update value
void updateTree(int *arr, int *tree, int start, int end, int treeNode, int index, int value){
	if(start == end){
		arr[index] = value;
		tree[treeNode] = value;
		return;
	}
	int mid = (start+end)/2;
	if (index > mid){
		updateTree(arr, tree, mid+1, end, treeNode*2+1, index, value);
	}
	else{
		updateTree(arr, tree, start, mid, treeNode*2, index, value);
	}
	tree[treeNode] = tree[treeNode*2] + tree[treeNode*2+1];
	return ;
}

// To find the sum of the interval or range
int sumOfInterval(int *tree, int start, int end, int treeNode, int left, int right){
	// There are three cases here
	// 1. Completely lies outside the given range
	// 2. Completely lies inside the given range
	// 3. Partially lies in the given range

	// 1. Completely lies outside the given range
	if (start > right || end < left){
		return 0;
	}

	// 2. Completely lies inside the given range
	if (start >= left && end <= right){
		return tree[treeNode];
	}
	// 3. Partially lies inside and outside the given range	
	int mid = (start + end)/2;
	int sum1 = sumOfInterval(tree, start, mid, treeNode*2, left, right);
	int sum2 = sumOfInterval(tree, mid+1, end, treeNode*2+1, left, right);
	int sum = sum1 + sum2;
	return sum;
}

int main(){
	int arr[] = {1,2,3,4,5,6,7,8,9};
	int* tree = new int[18]; //Two times that of the number of elements in the array
	buildTree(arr, tree, 0, 8, 1);
	updateTree(arr, tree, 0, 9, 1, 5, 20);
	int sum = sumOfInterval(tree, 0, 8, 1, 3, 7);
	cout << "Sum of range is " << sum << endl;
	return 0;
}