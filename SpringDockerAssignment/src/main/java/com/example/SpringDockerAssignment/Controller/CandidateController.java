package com.example.SpringDockerAssignment.Controller;

import com.example.SpringDockerAssignment.Model.Candidate;
import com.example.SpringDockerAssignment.Service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    Logger logger = LoggerFactory.getLogger(CandidateController.class);
    private String errorMessage = "ID or Age is negative";

    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/candidates")
    public List<Candidate> getAll()
    {
       return candidateService.getAllCandidates();
    }

    @RequestMapping("/candidates/{id}")
    public Object getByID(@PathVariable int id) {
        if(id>0)
            return candidateService.getCandidate(id);
        return errorMessage;

    }

    @PostMapping(value="/candidates")
    public String add(@RequestBody Candidate candidate,@Value("${sbpg.init.logging}") String logging)
    {
        if(candidate.getId()>0 && candidate.getAge()>0)
        {
            String loggingMessage = "Candidate Added with ID : %d";
            if(logging.equals("DEBUG"))
                logger.debug(loggingMessage,candidate.getId());
            else if(logging.equals("INFO"))
                logger.info(loggingMessage,candidate.getId());

            return candidateService.addCandidate(candidate);
        }
        return errorMessage;
    }

    @PutMapping(value="/candidates/{id}")
    public String update(@RequestBody Candidate candidate, @PathVariable int id,@Value("${sbpg.init.logging}") String logging){
        if(id>0 && candidate.getAge()>0)
        {
            String loggingMessage = "Candidate Updated with ID : %d";

            if(logging.equals("DEBUG"))
                logger.debug(loggingMessage,id);
            else if(logging.equals("INFO"))
                logger.info(loggingMessage,id);

            return candidateService.updateCandidate(candidate);
        }

        return errorMessage;
    }

    @DeleteMapping(value="/candidates/{id}")
    public String delete(@PathVariable int id){

        if(id>0)
        {
            return candidateService.deleteCandidate(id);
        }
        return errorMessage;
    }

}
