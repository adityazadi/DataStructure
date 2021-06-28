package com.graph;

import java.util.LinkedList;
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
    private LinkedList<Integer> q;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        a = new Stack<Integer>();
        q = new LinkedList<>();
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

    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        q.add(0);
        int v2;

        while(!q.isEmpty()){
            int v1 = q.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                q.add(v2);
            }
        }

    }

}
