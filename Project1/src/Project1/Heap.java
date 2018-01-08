/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Zach Johnson
 */
public class Heap {
    
    private ArrayList<Node> heap;   //create the array list
    private static Heap instance = null;    //create the single class instance
    
    private Heap(){
        
        //private constructor for Singleton
        heap = new ArrayList<>();
    }
    
    //Get the singleton instance of the heap
    public static Heap getInstance(){
        
        if(instance == null){
            
            instance = new Heap(); 
        }
        
        return instance;
    }
    
    //Create the min heap
    public void makeHeap(int p){
        
        //heapify the left side
        if((2 * p + 1) <= heap.size() - 1){
            
            makeHeap(2 * p + 1);
        }
        
        //heapify the right side
        if((2 * p + 2) <= heap.size() - 1){
            
            makeHeap(2 * p + 2);
        }
        
        fixHeapNode(p);
    }
    
    //fix any nodes that are out of place
    public void fixHeapNode(int p){
        
        int c;
        
        //Get the left child
        if((2 * p + 1) <= heap.size() - 1){
            
            c = 2 * p + 1;
            
            //Get the right child if there is one
            if((2 * p + 2) <= heap.size() - 1){
                
                if(heap.get(2 * p + 2).getPriority() < 
                        heap.get(2 * p + 1).getPriority()){
                    
                    c = 2 * p + 2;
                }
            }
            
            //if the current node is smaller than the parent swap them
            if(heap.get(p).getPriority() > heap.get(c).getPriority()){
                
                Collections.swap(heap, p, c);
                fixHeapNode(c);
            }
        }
    }
    
    //Function to print the heap
    public void printHeap(){
        
        if(!heap.isEmpty()){
            
            for(int i = 0; i < heap.size(); i++)
                heap.get(i).printNode();
        }
        else
            System.out.println("Heap is empty");
        
    }
    
    //add a node to the heap
    public synchronized void addNode(Node node){
        
        heap.add(node);//add the node to the end of the heap
        makeHeap(0);//recreate the heap
    }
    
    public synchronized Node getWork(){
        
        //check to see if the heap is empty
        if(!heap.isEmpty()){
            
            //if it's not, set the node to be returned equal to the root.
            Node work = heap.get(0);
            
            //swap the root with the last node of the heap and remove the root
            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            makeHeap(0);//remake the heap to fix the changes
            
            //return the work to the ocnsumer
            return work;
        }
        else //if heap is empty return null
            return null;
    }
    
    public boolean heapEmpty(){
        
        //return the status of the heap
        return heap.isEmpty();
    }
}
