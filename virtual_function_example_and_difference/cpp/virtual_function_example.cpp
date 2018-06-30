#include<iostream>
using namespace std;


class Base{
	
	public:
		int a;
		virtual void print(){
			cout << "In Base::print() function \n";
		}
};

class Child : public Base{
	public:
		void print(){
			cout << "In Child::print() function \n";
		}
};

int main(){
	Base b;		
	b.print();	// Case 1

	Child c;	
	c.print();	// Case 2

	Base b1 = c; // object slicing occur
	b1.a =10;
	b1.print();		// Case 3

	Base *b2 = &c;	
	b2->print();	// Case 4
	b2->a = 1000;
	((Base)c).print();	// Case 5

	cout << sizeof(b); 
	cout << sizeof(c);
	cout << sizeof(b2)<<endl;
	cout << b1.a<< endl; 
	cout << b2->a<< endl;

	return 0;
}
