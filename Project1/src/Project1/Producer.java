/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**
 *
 * @author Zach Johnson
 */
public class Producer extends Thread {
    
    private Heap heapInstance;//Instance to the heap that is passed from main
    private boolean isDone = false;//Variable to signal the producer is done
    
    //constructor to initiate the heap instance
    public Producer(Heap instance){
        
        this.heapInstance = instance;
    }
    
    @Override //Entry point for the thread that contains the production logic
    public void run(){
        
        //Create a certain number of nodes
        for(int i = 1; i <= 25; i++){
            
            //Generate a random priority between 0 and 5
            int prio = (int)(Math.random() * 6);
            //Generate a random time slice between .5 sec to 5 sec
            int timeSlice = (int)(Math.random() * 5000 + 500);
            
            //create the new node passing it the prio and timeslice and using the
            //current count of the for loop for priority
            Node node = new Node(i, prio, timeSlice);
            
            //add the node to the heap
            heapInstance.addNode(node);
            
            //after 4 nodes have been made sleep between each creation
            if(i >= 4){
            //go to sleep for 2 sec
                try{
                    Thread.sleep(2000);
                }
                catch(Exception E){

                }
            }
        }
        
        //once the loop is over set the producer to done
        isDone = true;
    }
    
    //Getter for the done check
    public boolean getisDone(){
        
        return isDone;
    }
}
