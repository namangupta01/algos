#include<iostream>

using namespace std;

int main(){
	cout << "Enter number of Elements to sort" << endl;
	int n;
	cin >> n;
	int a[n];
	cout << "Enter Elements" << endl;
	for(int i=0; i<n ;i++){
		cin >> a[i];
	}

	// Bubble Sort begins
	for (int i = 0; i < n-1; i++){
		for (int j = 1; j < n-i; j++){
			if(a[j-1]>a[j]){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}

		}
	}
	// Bubble Sort ends
	cout << "Sorted array is: " ;
	for(int i=0; i<n ;i++){
		cout << a[i] << " " ;
	}
	return 0;
}