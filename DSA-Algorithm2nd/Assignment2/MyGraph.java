package Assignment2;

import java.util.Arrays;
import java.util.Comparator;

import Assignment1.UndirectedWeightedGraph;

public class MyGraph implements UndirectedWeightedGraph{
    Edge[] edges;
    int vertex;
    int maxEdges;
    int currentEdge;
    public MyGraph(int vertex , int maxEgdes){
        this.edges = new Edge[maxEgdes];
        this.vertex = vertex;
        this.maxEdges = maxEgdes;
        this.currentEdge = 0;
    }
    /**
     * adds new edge to the array of edge
     * @param source start node of edge
     * @param destination end node of edge
     * @param weight associated weight for that edge
     */
    public void addEdge(int source , int destination , int weight){
        edges[currentEdge++] = new Edge(source, destination, weight);
    }
    /**
     * perfroms dfs traversal using stack
     * @param node start noe where dfs traversal starts 
     * @param visited sets to true if that node gets visited
     */
    public void dfs(int node , boolean[] visited){
        int[] stack = new int[vertex];
        int top = -1;
        stack[++top] = node;
        while(top >= 0){
            int currentVertex = stack[top];
            top--;
            if(visited[currentVertex] == false){
                visited[currentVertex] = true;
            }
            for(int index = 0 ; index < edges.length ; index ++){
                if(edges[index].source == currentVertex && visited[edges[index].destination] == false){
                    stack[++top] = edges[index].destination;
                }
                else if(edges[index].destination == currentVertex && visited[edges[index].source] == false){
                    stack[++top] = edges[index].source;
                }
            }
        }
    }
    /**
     * checks if all the vertices has at least one edge associated with it
     * @return true if all the vertex has atleast one edge associated with it
     */
    @Override
    public boolean isConnected() {
        boolean[] visited = new boolean[vertex];
        dfs(0 , visited);
        for(boolean result : visited){
            if(result == false){
                return false;
            }
        }
        return true;
    }
    /**
     * it finds all the nodes that are reachable from a node named a
     * @param a node for which we have to find connected nodes
     * @return array of nodes that can be reached from node a
     */
    @Override
    public int[] reachable(int a) {
        boolean[] visited = new boolean[vertex];
        dfs(a , visited);
        int[] visitedNode = new int[vertex];
        for(int index = 0 ; index < vertex && index != a; index ++){
            if(visited[index]){
                visitedNode[index] = 1;
            }
        }
        return visitedNode;
    }
    /**
     * created an object of comparator which sorts the array according to weight
     */
    private Comparator<Edge> weightComparator = new Comparator<Edge>() {
        @Override
        public int compare(Edge e1 , Edge e2){
            return e1.weight - e2.weight;
        }
    };
    /**
     * implements krushkal's algorithm to find minimum spanning tree
     * @return tree having list of edges
     */
    @Override
    public Edge[] minimumSpanningTree() {
        Edge[] sortedEdges = new Edge[maxEdges];
        for(int index = 0 ; index < edges.length ; index ++){
            sortedEdges[index] = edges[index];
        }
        Arrays.sort(sortedEdges , weightComparator);
        Edge[] result = new Edge[vertex - 1];
        int[] parent = new int[vertex];
        for(int index = 0 ; index < vertex ; index ++){
            parent[index] = index;
        }
        int edgeCount = 0 ;
        int index = 0;
        while(edgeCount < vertex - 1 && index < edges.length){
            Edge nextEdge = sortedEdges[index ++];

            int srcRoot = find(parent, nextEdge.source);
            int destRoot = find(parent, nextEdge.destination);

            if(srcRoot != destRoot){
                result[edgeCount++] = nextEdge;
                findUnion(parent, srcRoot, destRoot);
            }
        }
        return result;
    }
    /**
     * finds the ultimate parent of that node
     * @param parent array which stores ultimate parent of all nodes
     * @param currentVertex which we are currently on
     * @return node which is the ultimate parent of the currentvertex
     */
    private int find(int[] parent , int currentVertex){
        while(parent[currentVertex] != currentVertex){
            currentVertex = parent[currentVertex];
        }
        return currentVertex;
    }
    /**
     * takes a edge into consideration
     * @param parent stores ultimate parent of all nodes
     * @param vertex1 first node
     * @param vertex2 second node
     */
    private void findUnion(int[] parent , int vertex1 , int vertex2){
        int vertex1Set = find(parent, vertex1);
        int vertex2Set = find(parent, vertex2);
        parent[vertex2Set] = vertex1Set;
    }
    /**
     * implementing dijkstra algorithm
     * @param src node from where we have to start
     * @param dest node where we have to reach
     */
    @Override
    public void shortestPath(int src, int dest) {
        int[] dist = new int[vertex];
        boolean[] visited = new boolean[vertex];
        int[] parent = new int[vertex];

        // loop for assigning max value in the distance and visited false

        for (int index = 0; index < vertex ; index++) {
            dist[index] = Integer.MAX_VALUE;
            visited[index] = false;
            parent[index] = -1;
        }

        dist[src] = 0; // distance of source from source is always zero

        for (int count = 0; count < vertex - 1; count++) {

            int u = minDistance(dist, visited);
            if (u == -1)
                break; // Remaining vertices are unreachable
            visited[u] = true;

            // loop for traversing edgelist on find minimum distance
            for (int index = 0 ; index < maxEdges ; index++) {

                if (edges[index].source == u) {

                    int v = edges[index].destination;
                    int weight = edges[index].weight;

                    if (!visited[v] && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        parent[v] = u;
                    }
                } else if (edges[index].destination == u) {

                    int v = edges[index].source;
                    int weight = edges[index].weight;

                    if (!visited[v] && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        parent[v] = u;
                    }
                }
            }
        }

        // Print shortest distance and path
        if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + src + " to " + dest);
        } else {
            System.out.println("Shortest Distance from " + src + " to " + dest + " is: " + dist[dest]);
            System.out.print("Path: ");
            printPath(parent, dest);
            System.out.println();
        }
    }

    /**
     * Method to find minimum distance
     * @param dist array that store minimum
     * @param visited mark vertex visited
     * @return minimum distance from source to the vertex
     */
    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Method to print the path from source to destination
     * @param parent contains the parent of the each vertex
     */
    public void printPath(int[] parent, int j) {
        if (j == -1)
            return;
        printPath(parent, parent[j]);
        System.out.print(j + " ");
    }
}
