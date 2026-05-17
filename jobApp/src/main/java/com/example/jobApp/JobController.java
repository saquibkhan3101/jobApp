package com.example.jobApp;

import com.example.jobApp.model.JobPost;
import com.example.jobApp.model.JobApplication;
import com.example.jobApp.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @RequestMapping("addjob")
    public String addjob() {
        return "addJob";
    }

    @RequestMapping("/handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost, Model model) {

        jobService.addJob(jobPost);
        model.addAttribute("jobPost", jobPost);
        return "success";
    }

    @RequestMapping("viewalljobs")
    public String viewAllJobs(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("jobPosts", jobService.searchJobs(keyword));
        model.addAttribute("keyword", keyword == null ? "" : keyword);
        return "viewalljobs";
    }

    @RequestMapping("job-details/{postId}")
    public String jobDetails(@PathVariable int postId, Model model) {
        return jobService.getJobById(postId)
                .map(jobPost -> {
                    model.addAttribute("jobPost", jobPost);
                    return "success";
                })
                .orElse("redirect:/viewalljobs");
    }

    @RequestMapping("apply/{postId}")
    public String apply(@PathVariable int postId, Model model) {
        return jobService.getJobById(postId)
                .map(jobPost -> {
                    JobApplication jobApplication = new JobApplication();
                    jobApplication.setPostId(postId);
                    model.addAttribute("jobPost", jobPost);
                    model.addAttribute("jobApplication", jobApplication);
                    return "apply";
                })
                .orElse("redirect:/viewalljobs");
    }

    @RequestMapping("submitApplication")
    public String submitApplication(@ModelAttribute JobApplication jobApplication, Model model) {
        JobPost jobPost = jobService.getJobById(jobApplication.getPostId()).orElse(null);
        model.addAttribute("jobPost", jobPost);
        model.addAttribute("jobApplication", jobApplication);
        return "applicationSuccess";
    }
}
