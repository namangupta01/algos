#include <iostream>
using namespace std;

// To traverse graph using BFS
void printVertices(int **edges, int number_of_vertices, int *visited_nodes, int vertex){
	int* queue = new int[number_of_vertices];
	int queue_push_index = 0;
	int queue_pop_index = 0;
	queue[queue_push_index] = vertex;
	queue_push_index++;
	visited_nodes[vertex] = 1;
	while(queue_push_index>queue_pop_index){
		vertex = queue[queue_pop_index];
		queue_pop_index++;
		cout<< vertex << endl;
		for(int i=0; i<number_of_vertices; i++){
			if(i==vertex){
				continue;
			}
			if(edges[i][vertex] == 1 && visited_nodes[i] == 0){
				queue[queue_push_index] = i;
				queue_push_index++;
				visited_nodes[i] = 1;
			}
		}
	}
}

// To find out unconnected sub-graph and call printVertices functions on them
void BFS(int **edges, int number_of_vertices){
	int* visited_nodes = new int[number_of_vertices];
	for(int i=0; i<number_of_vertices; i++){
		visited_nodes[i] = 0; //Zero indicates nodes are not visited
	}
	cout << "BFS Traversal for Unconnected Graph :" << endl;
	for(int i=0; i<number_of_vertices; i++){
		if(visited_nodes[i] == 0){
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
		for(int j=0; j<number_of_vertices; j++){
			edges[i][j]=0;
		}
	}
	int l,r;
	cout<< "Enter the Edges" << endl;
	for(int i=0; i< number_of_edges; i++){
		cin>>l>>r;
		edges[l][r] = 1;
		edges[r][l] = 1;
	}
	BFS(edges, number_of_vertices);
}

//	Input/Output
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
// BFS Traversal for Unconnected Graph :
// 0
// 1
// 2
// 3
// 6
// 4
// 5
// 7
// 8
// 11
// 9
// 10
