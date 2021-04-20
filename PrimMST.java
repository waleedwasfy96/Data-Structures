package com.example.welo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimMST {
    static class Edge implements Comparable{
        int from;
        int to;
        int weight;

        public Edge(int from,int to, int weight){
            this.to=to;
            this.from=from;
            this.weight=weight;
        }

        public int compareTo(Object o){
            Edge e = (Edge) o;
            if(this.weight==e.weight) return 0;
            else if(this.weight<e.weight)return -1;
            else return 1;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static ArrayList<Edge> getMST(ArrayList<Edge>[] graph, int nodes,int start){
        ArrayList<Edge> mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int [] visited=new int[nodes+1];
        for(int i=0;i<graph[start].size();i++){
            pq.add(graph[start].get(i));
        }
        visited[start]=1;
        while(!pq.isEmpty()){
            Edge cur=pq.poll();
            if(visited[cur.to]==1){
                continue;
            }
            mst.add(cur);
            visited[cur.to]=1;
            for(int i=0;i<graph[cur.to].size();i++){
                pq.add(graph[cur.to].get(i));
            }

        }
        return mst;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int nodes=Integer.parseInt(st.nextToken());
        int edges=Integer.parseInt(st.nextToken());
        ArrayList<Edge> [] graph=new ArrayList[nodes+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(from,to,weight));
            graph[to].add(new Edge(to,from,weight));
        }
        int start=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        ArrayList<Edge> mst= getMST(graph,nodes,start);
        int sum=0;
        for (Edge e:mst) {
            System.out.println(e);
            sum+=e.weight;
        }
        System.out.println(sum);
    }
}
