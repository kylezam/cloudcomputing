package com.cis3111.java_cloud_tool.Services;

import com.cis3111.java_cloud_tool.Controllers.GenerationTool;
import com.cis3111.java_cloud_tool.Entities.Entries;
import com.cis3111.java_cloud_tool.Repositories.EntriesRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class GenerationService {

    @Autowired
    EntriesRepository entriesRepository;

    Entries entries;

    String instanceName =  setInstanceName();

    GenerationTool generateNumbers = new GenerationTool();

    String setInstanceName(){
      return System.getenv("GAE_INSTANCE") == null ? "N/A" : System.getenv("GAE_INSTANCE");
    }


    @GetMapping("/")
    ResponseEntity<String> getGreeting(){
        return ResponseEntity.ok("Testing");
    }

    //Get Largest Generated Number
    @GetMapping("/get-largest")
    ResponseEntity<Object> getLargest(){
        return generateNumbers.largestGenerated(entriesRepository.findAll());
    }

    //Get Smallest Generated Number
    @GetMapping("/get-smallest")
    ResponseEntity<Object> getSmallest(){
        return generateNumbers.smallestGenerated(entriesRepository.findAll());
    }

    @GetMapping("/get-results")
    List<Entries> getResults(){
        return (List<Entries>) entriesRepository.findAll();
    }

    //Generate and Save results
    @PostMapping("/generate")
    ResponseEntity<Object> newGeneration(){
        //create a new object and generate the random numbers
        generateNumbers = new GenerationTool();
        generateNumbers.generateNumbers();

        //create a new entry storing the largest and smallest generated number in a given instance and save that to the repository
        entries = new Entries(instanceName, generateNumbers.getLargestNumber(),generateNumbers.getSmallestNumber());
        entriesRepository.save(entries);

        //create json object
        JSONObject obj = new JSONObject();
        obj.put("Instance name: ", instanceName);
        obj.put("Total generated numbers", generateNumbers.getGeneratedNumbers().size());
        obj.put("Generated numbers: ",generateNumbers.getGeneratedNumbers());

        //Return the list of generated numbers:
        return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
    }

    @PostMapping("/clear")
    ResponseEntity<String> clearDatabase(){
        //Empty Repository
        entriesRepository.deleteAll();
        return ResponseEntity.ok("Database Cleared");
    }

}
