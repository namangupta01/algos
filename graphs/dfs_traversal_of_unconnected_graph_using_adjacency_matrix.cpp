#include <iostream>
using namespace std;

// Funtion to traverse graph in DFS 
void printVertices(int **edges, int number_of_vertices, int* visited_nodes, int starting_vertex){
	cout<<starting_vertex<< endl;
	visited_nodes[starting_vertex] = 1;
	for(int i=0; i<number_of_vertices; i++){
		if(i==starting_vertex){
			continue;
		}
		if(edges[i][starting_vertex] ==1 && visited_nodes[i]==0){
			printVertices(edges, number_of_vertices, visited_nodes, i);
		}
	}
}

// Function to find unconnected graph and call printVertices on that sub graph 
void DFS(int** edges, int number_of_vertices){
	int* visited_nodes = new int[number_of_vertices];
	for(int i=0;i< number_of_vertices; i++){
		visited_nodes[i] = 0; // Zero indicated unvisited nodes
	}
	for(int i=0;i<number_of_vertices; i++){
		if(visited_nodes[i]==0){
			cout << "DFS Traversal :" << endl;
			printVertices(edges, number_of_vertices, visited_nodes, i);
		}
	}
}
int main(){
	int number_of_vertices;
	int number_of_edges;
	cout << "Enter the number of vertices" << endl;
	cin >> number_of_vertices;
	cout << "Enter the number of edges" << endl;
	cin >> number_of_edges;
	int ** edges = new int*[number_of_vertices];
	for(int i=0; i< number_of_vertices; i++){
		edges[i] = new int[number_of_vertices];
		for(int j=0; j< number_of_vertices; j++){
			edges[i][j] = 0; // Zero indicated there is no edge netween i and j
		}
	}
	cout << "Enter the Edges "<< endl;
	int l,r;
	for(int i=0; i< number_of_edges; i++){
		cin>>l>>r;
		edges[l][r] = 1;
		edges[r][l] = 1;
	}
	DFS(edges, number_of_vertices);

}

// Input/Output

// Enter the number of vertices
// 12
// Enter the number of edges
// 14
// Enter the Edges 
// 1 2
// 2 3
// 3 4
// 3 5
// 4 5
// 5 6
// 2 6
// 7 8 
// 8 9
// 9 10
// 10 11
// 11 7
// 8 11
// 9 11 
// DFS Traversal
// 0
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// 11