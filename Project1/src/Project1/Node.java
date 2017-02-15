/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**
 *
 * @author vanth
 */
public class Node {
    
    private String processID;
    private int priority, timeSlice;
    
    public Node(String processID, int priority, int timeSlice){
        
        this.processID = processID;
        this.priority = priority;
        this.timeSlice = timeSlice;
    }
    
    public String getProcessID(){
        
        String process_id = this.processID;
        return process_id;
    }
    
    public int getPriority(){
        
        int prio = this.priority;
        return prio;
    }
    
    public int getTimeSlice(){
        
        int time = this.timeSlice;
        return time;
    }
}
