package com.graph;

import java.util.Stack;

class Vertex{
    public char label;
    public boolean wasVisited;

    public Vertex(char label){
        this.label = label;
        wasVisited = false;
    }
}

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private Stack<Integer> a;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        a = new Stack<Integer>();
    }

    public void addVertex(char label){
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int vertex){
        for(int i=0;i<nVerts;i++){
            if(adjMat[vertex][i]==1 &&
                    !vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        a.push(0);

        while(!a.isEmpty()){
            int v = getAdjUnvisitedVertex(a.peek());

            if(v == -1){
                a.pop();
            }else{
                vertexList[v].wasVisited = true;
                displayVertex(v);
                a.push(v);
            }
        }

    }

}
