package com.example.jobApp;

import com.example.jobApp.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @RequestMapping("addjob")
    public String addjob() {
        return "addjob";
    }

    @RequestMapping("/handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost, Model model) {

        model.addAttribute("jobPost", jobPost);
        return "success";
    }
}
