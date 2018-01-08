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
public class Consumer extends Thread {
    
    private Heap heapInstance;//Consumer's heap instance passed in from main
    private Node currentWork;//Current work node the consumer is processing
    //Variable to signal the consumer that there will be no more work and it can
    //stop
    private volatile boolean done;
    
    //Constructor to initialize the heap and the end variable
    public Consumer(Heap instance){
        
        this.heapInstance = instance;
        this.done = false;
    }
    
    @Override //Entry point for the consumer thread
    public void run(){
        
        //retrieve the highest priority node from the heap if one is available
        currentWork = heapInstance.getWork();
        
        //keep going till not done
        if(!done){
            //if there was work on the heap
            if(currentWork != null){
                
                //"Process" the node
                try{
                    //sleep for the node's time slice
                    Thread.sleep(currentWork.getTimeSlice());
                }
                catch(Exception e){

                }
                //Print the node when the work is finished
                currentWork.printNode();
                run();//repeat the run function
            }
            else{//if there was no work on the heap

                try{
                    //go to sleep for 3 sec and then check again
                    Thread.sleep(3000);
                }
                catch(Exception e){

                }
                run();
            }
        }
    }
    
    //Setter for the done variable
    public void setDone(){
        
        if(!done){
            
            done = true;
        }
    }
}
