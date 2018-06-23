#include <iostream>
using namespace std;

// BFS traversal using adjacency matrix
void printVertices(int **edges, int number_of_vertices, int vertex){
	int* queue = new int[number_of_vertices];
	int queue_push_index = 0;
	int queue_pop_index = -1;
	queue[queue_push_index] = vertex;
	queue_push_index++;
	queue_pop_index++;
	int *visited_nodes = new int[number_of_vertices];
	for(int i=0; i<number_of_vertices; i++){
		visited_nodes[i] = 0;
	}
	visited_nodes[0] = 1;
	while(queue_pop_index<queue_push_index){
		vertex = queue[queue_pop_index];
		cout<< vertex << endl;
		queue_pop_index++;
		for (int i=0; i<number_of_vertices; i++){
			if(i==vertex){
				continue;
			}
			if(visited_nodes[i]==0 && edges[i][vertex] ==1){
				queue[queue_push_index] = i;
				queue_push_index++;
				visited_nodes[i] = 1;
			}
		}
	}

	//Delete the memory allocated
	delete [] queue;
	delete [] visited_nodes;
}

int main(){
	int number_of_vertices;
	int number_of_edges;
	cout << "Enter the number of Vertices" << endl;
	cin >> number_of_vertices;
	cout << "Enter the number of Edges" << endl;
	cin >> number_of_edges;
	cout << "Enter the Edges" << endl;
	int **edges = new int*[number_of_vertices];
	for(int i=0; i<number_of_edges; i++){	
		edges[i] = new int[number_of_vertices];
		for (int j=0; j < number_of_vertices; j++){
			edges[i][j] = 0;
		}
	}
	int l,r;
	for(int i=0; i<number_of_edges; i++){
		cin >> l >> r;
		edges[l][r] = 1;
		edges[r][l] = 1;
	}
	cout << "Traversed nodes are :" << endl;
	printVertices(edges, number_of_vertices, 0);

	//Delete the memory allocated
	for(int i=0; i<number_of_vertices; i++){
		delete [] edges[i];
	}
	delete [] edges;

}

// Input/Output
// Enter the number of Vertices
// 8
// Enter the number of Edges
// 10
// Enter the Edges
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
// Traversed nodes are :
// 0
// 1
// 3
// 6
// 2
// 4
// 5
// 7
