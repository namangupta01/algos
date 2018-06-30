// Sort a large set of floating point numbers which are in the range from 0.0 to 1.0

#include<iostream>

using namespace std;

void counting_sort(double a[], int n){
	double b[10][n];
	int index[10];

	for(int i=0; i<10; i++){
		index[i] = 0;
	}

	for (int i =0; i<n; i++){
		int number = a[i]*10;
		int j;
		for(j=0; j<index[number]; j++){
			if(b[number][j] >= a[i]){
				break;
			}
		}
		double pre = a[i];
		for(int k = j; j<index[number]; j++){
			double temp = b[number][j];
			b[number][j] = pre;
			pre = temp;
		}
		b[number][j] = pre;
		index[number]++;
	}
	int k = 0;
	for( int i=0; i<10; i++){
		for(int j = 0; j<index[i]; j++){
			a[k] = b[i][j];
			k++;	
		}
	}
}

int main(){
	cout << "Enter the numbers to be sorted: " << endl;
	int n;
	cin >> n;
	double a[n];

	for(int i=0;i<n;i++){
		cin >> a[i];
	}

	counting_sort(a, n);
	cout << "Sorted array is: " << endl;
	for(int i =0; i<n; i++){
		cout << a[i] << " ";
	}
	cout << endl;
	return 0;
}