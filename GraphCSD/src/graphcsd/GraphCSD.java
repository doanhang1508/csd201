/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphcsd;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Thanh Hang
 */
public class GraphCSD {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
    public void printGraph(){
        System.out.println(adjList);
    }
    public boolean addVertex(String vertex){
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }
    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }
    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }
    public boolean removeVertex(String vertex) {
        if(adjList.get(vertex) == null) return false;
        for(String otherVertex: adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphCSD myGraph = new GraphCSD();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        
        
    }
    
}
