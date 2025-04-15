package Assignment1;

import Assignment2.Edge;

public interface UndirectedWeightedGraph {
    boolean isConnected();
    int[] reachable(int a);
    Edge[] minimumSpanningTree();
    int shortestPath(int a , int b);
}
