public class FloydWarshall {
    static final int INF = 99999; // Represents infinity for unreachable vertices

    // Function to perform Floyd-Warshall algorithm
    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // Initialize the distance matrix with the given graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Iterate over all vertices and find the shortest path
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the final distance matrix
        printSolution(dist, V);
    }

    // Function to print the distance matrix
    static void printSolution(int[][] dist, int V) {
        System.out.println("Shortest distances between vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };

        floydWarshall(graph, V);
    }
}
