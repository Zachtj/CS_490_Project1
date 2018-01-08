/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Zach Johnson
 */
public class Node {
    
    //create variables to hold node information
    private int processID;
    private int priority, timeSlice;
    
    //Node constructor that initializes the information variables
    public Node(int processID, int priority, int timeSlice){
        
        this.processID = processID;
        this.priority = priority;
        this.timeSlice = timeSlice;
    }
    
    //Getter for the process id
    public int getProcessID(){
        
        int process_id = this.processID;
        return process_id;
    }
    
    //Getter for the priority
    public int getPriority(){
        
        int prio = this.priority;
        return prio;
    }
    
    //Getter for the Time Slice of the node
    public int getTimeSlice(){
        
        int time = this.timeSlice;
        return time;
    }
    
    //Print the node's information and the time it "completed"
    public void printNode(){
        
        System.out.println("ProcessID: " + this.processID + " Priority: " +
                this.priority + " Time Completed: " + LocalDateTime.now().
                        format(DateTimeFormatter.ofPattern("hh:mm:ss:SSS")));
    }
}
