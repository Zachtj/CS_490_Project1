/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Zach Johnson
 */
public class Main {
    
    public static void main(String[] args){
        
        //Create heap to store nodes
        Heap instance = Heap.getInstance();
        
        //Create producers and consumers
        Producer produce = new Producer(instance);
        Consumer consume1 = new Consumer(instance);
        Consumer consume2 = new Consumer(instance);
        
        //start the threads
        produce.start();
        
        //Create a timer
        Timer t = new Timer();
        
        //schedule a task to delay the start of the consumers for 4 sec
        t.schedule(new TimerTask(){
           
            @Override
            public void run(){
                
                consume1.start();
                consume2.start();
            }
        }, 4000);
        
        t.schedule(new TimerTask(){
            
            @Override
            public void run(){
                
                if(produce.getisDone() && instance.heapEmpty()){
                    
                    //if the heap is empty and producer is finished stop the
                    //consumers and cancel the timer
                    consume1.setDone();
                    consume2.setDone();
                    t.cancel();
                }
            }
        }, 2000, 2000); //Check happens every 2 seconds
    }
}
