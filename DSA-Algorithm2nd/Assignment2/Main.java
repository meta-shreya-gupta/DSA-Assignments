package Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices in graph");
        System.out.println("NOTE : vertex number startes from 0");
        int vertices = sc.nextInt();
        System.out.println("Enter number of edges in the graph");
        int edges = sc.nextInt();
        MyGraph graph = new MyGraph(vertices, edges);
        System.out.println("Enter source , destination and weight separated by space");
        for(int index = 0 ; index < edges ; index ++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(source, destination, weight);
        }
        System.out.println("graph is connected : " + graph.isConnected());
        System.out.println("Enter vertex for which you want adjacent nodes (0 - " + (vertices - 1) + ")");
        int node = sc.nextInt();
        System.out.println("visited nodes : ");
        int[] visitedNode = graph.reachable(node);
        for(int index = 0 ; index < vertices ; index ++){
            if(visitedNode[index] == 1){
                System.out.println(index);
            }
        }
        System.out.println("Minimum Spanning tree : ");
        Edge[] mst = graph.minimumSpanningTree();
        for(int index = 0 ; index < mst.length ; index ++){
            if(mst[index] != null){
                System.out.println(mst[index].source + " " + mst[index] .destination + " " + mst[index].weight);
            }
        }
        System.out.println("Enter source node (0 - " + (vertices - 1) + ")");
        int src = sc.nextInt();
        System.out.println("Enter destination node (0 - " + (vertices - 1) + ")");
        int dest = sc.nextInt();
        graph.shortestPath(src, dest);
        sc.close();
    }
}
