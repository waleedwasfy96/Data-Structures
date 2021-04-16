package com.example.welo;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    public static class Node{
        char c;
        Node [] children;

        public Node(char c){
            this.c=c;
            children=new Node[26];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "c=" + c +
                    '}';
        }
    }
    Node root;
    public Trie(Node root){
        this.root=root;
    }
    public void insert(String s){
        Node cur=this.root;
        for(int i=0;i<s.length();i++){
            if(cur.children[s.charAt(i)-'a']==null){
                cur.children[s.charAt(i)-'a']=new Node(s.charAt(i));
            }
            cur=cur.children[s.charAt(i)-'a'];
        }
    }
    public boolean find(String s){
        Node cur=this.root;
        for(int i=0;i<s.length();i++){
            if(cur.children[s.charAt(i)-'a']==null){
                return false;
            }
            cur=cur.children[s.charAt(i)-'a'];
        }
        for(int i=0;i<26;i++){
            if(cur.children[i]!=null){
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String s){
        Node cur=this.root;
        for(int i=0;i<s.length();i++){
            if(cur.children[s.charAt(i)-'a']==null){
                return false;
            }
            cur=cur.children[s.charAt(i)-'a'];
        }

        return true;
    }

    public static void main(String []args){
        Node x=new Node('x');
        Trie t=new Trie(x);
        t.insert("waleed");
        t.insert("wasfy");
        t.insert("rana");
        t.insert("rula");
        System.out.println(t.startsWith("r"));

    }
}
