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
    public void addEdge(int source , int destination , int weight){
        edges[currentEdge++] = new Edge(source, destination, weight);
    }
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
    private Comparator<Edge> weightComparator = new Comparator<Edge>() {
        @Override
        public int compare(Edge e1 , Edge e2){
            return e1.weight - e2.weight;
        }
    };
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
    private int find(int[] parent , int currentVertex){
        while(parent[currentVertex] != currentVertex){
            currentVertex = parent[currentVertex];
        }
        return currentVertex;
    }
    private void findUnion(int[] parent , int vertex1 , int vertex2){
        int vertex1Set = find(parent, vertex1);
        int vertex2Set = find(parent, vertex2);
        parent[vertex2Set] = vertex1Set;
    }
    @Override
    public int shortestPath(int a, int b) {
        int[] distance = new int[vertex];
        int minDist = 0;
        for(int index = 0 ; index < vertex ; index ++){
            if(index == a){
                distance[index] = 0;
            }
            distance[index] = Integer.MAX_VALUE;
        }
        return minDist;
    }
}
