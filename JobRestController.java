package com.telusko.spring_boot_rest;

import com.telusko.spring_boot_rest.model.JobPost;
import com.telusko.spring_boot_rest.model.StudentPost;
import com.telusko.spring_boot_rest.repo.StudentRepo;
import com.telusko.spring_boot_rest.service.JobService;
import com.telusko.spring_boot_rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @Autowired
    private StudentService studService;

    @GetMapping(path="jobPosts", produces = {"application/json"}) //content negotiation
//    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getalljobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        service.addjobs(jobPost);  
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);

    }

    //Students Data Entry

    @PostMapping("addPost")
    public String addStudent(@RequestBody StudentPost studentPost){
        studService.addStudent(studentPost);
        return "success";
    }

}
