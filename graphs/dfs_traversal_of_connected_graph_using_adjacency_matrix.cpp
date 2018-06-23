//Depth first search traversal using adjacency matrix

#include <iostream>
using namespace std;

// This function print the nodes or verties of the graph in the DFS form. i.e gets deeper and deeper in one direction till we cant go any further
void printVertices(int **edges, int starting_vertex_node, int *visited_vertex, int number_of_vertices){
	cout << starting_vertex_node << endl;
	visited_vertex[starting_vertex_node] = 1;
	for(int i=0; i<number_of_vertices; i++){
		if(i==starting_vertex_node){
			continue;
		}
		if(edges[starting_vertex_node][i] == 1 && visited_vertex[i]==0){
			printVertices(edges, i, visited_vertex, number_of_vertices);
		}
	}
}

int main(){
	int number_of_vertices;
	int number_of_edges;
	cout << "Enter number of vertices" << endl;
	cin >> number_of_vertices;
	cout << "Enter number of edges" << endl;
	cin >> number_of_edges;
	int* vertices = new int[number_of_vertices];
	cout << "Enter edges : "<< endl;
	int** edges = new int*[number_of_vertices];
	for(int i=0; i<number_of_vertices; i++){
		edges[i] = new int[number_of_vertices];
		for(int j=0; j<number_of_vertices; j++){
			edges[i][j] = 0; //By-Default 0 value for showing no edge
		}
	}
	int l,r;
	for (int i=0; i<number_of_edges; i++){
		cin >> l >> r;
		edges[l][r] = 1;
		edges[r][l] = 1;
	}
	int *visited_vertex = new int[number_of_vertices];
	for(int i=0; i<number_of_vertices; i++){
		visited_vertex[i] = 0; //Zero indicates unvisited node and one represent visited node
	}
	cout << "Traverse vertices or nodes in DFS:"<< endl;
	printVertices(edges, 0, visited_vertex, number_of_vertices);
}

// Input to run:
// Enter number of vertices
// 8
// Enter number of edges
// 10
// Enter edges : 
// 0 1
// 1 2
// 2 5
// 5 7
// 6 7
// 6 0
// 0 3
// 3 5
// 5 4
// 4 1
// Traverse vertices or nodes in DFS:
// 0
// 1
// 2
// 5
// 3
// 4
// 7
// 6
