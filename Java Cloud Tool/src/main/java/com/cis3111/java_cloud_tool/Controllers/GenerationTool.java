package com.cis3111.java_cloud_tool.Controllers;

import com.cis3111.java_cloud_tool.Entities.Entries;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class GenerationTool {

    //Variables
    private Set<Integer> generatedNumbers = new HashSet<Integer>();
    private int largestNumber;
    private int smallestNumber;
    private Random rand = new Random();

    //Constructor

    public GenerationTool() {
        generatedNumbers = new HashSet<Integer>();
        rand = new Random();
    }

    //Getters
    public int getLargestNumber() {
        return largestNumber;
    }

    public Set<Integer> getGeneratedNumbers() {
        return generatedNumbers;
    }

    public int getSmallestNumber() {
        return smallestNumber;
    }


    //Methods
    public void generateNumbers(){
        while(generatedNumbers.size() != 1000){
            int num = rand.nextInt(100000+1);
            if(!generatedNumbers.contains(num)){
                generatedNumbers.add(num);
            }
        }
        largestAndSmallest();
    }

    public void largestAndSmallest(){
        largestNumber = Collections.max(generatedNumbers);
        smallestNumber = Collections.min(generatedNumbers);
    }

    public ResponseEntity<Object> largestGenerated(List<Entries> entries){
        if (entries.size()!=0) {
            long largest = 0;
            String name = "";
            for (Entries entry : entries) {
                if (entry.getLargest() > largest) {
                    largest = entry.getLargest();
                    name = entry.getInstance();
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("Instance Name: ", name);
            map.put("Largest Value: ", largest);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Object> smallestGenerated(List<Entries> entries) {
        if (entries.size() != 0) {
            long smallest = 100000;
            String name = "";
            for (Entries entry : entries) {
                if (entry.getSmallest() < smallest) {
                    smallest = entry.getSmallest();
                    name = entry.getInstance();
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("Instance Name: ", name);
            map.put("Smallest Value: ", smallest);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
    }


}
