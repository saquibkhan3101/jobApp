package com.example.jobApp.service;

import com.example.jobApp.model.JobPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final List<JobPost> jobs = new ArrayList<>();

    public JobService() {
        jobs.add(new JobPost(
                1,
                "Java Developer",
                "Build and maintain Spring Boot web applications for business teams.",
                2,
                List.of("Java", "Spring Boot", "Thymeleaf", "MySQL")
        ));
        jobs.add(new JobPost(
                2,
                "Frontend Developer",
                "Create responsive user interfaces and connect them with REST APIs.",
                1,
                List.of("HTML5", "CSS3", "JavaScript", "Bootstrap")
        ));
        jobs.add(new JobPost(
                3,
                "DevOps Engineer",
                "Automate builds, deployments, and cloud infrastructure monitoring.",
                3,
                List.of("Docker", "Kubernetes", "AWS", "DevOps")
        ));
    }

    public List<JobPost> getAllJobs() {
        return Collections.unmodifiableList(jobs);
    }

    public List<JobPost> searchJobs(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getAllJobs();
        }

        String normalizedKeyword = keyword.trim().toLowerCase();
        return jobs.stream()
                .filter(job -> matches(job, normalizedKeyword))
                .toList();
    }

    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public Optional<JobPost> getJobById(int postId) {
        return jobs.stream()
                .filter(job -> job.getPostId() == postId)
                .findFirst();
    }

    private boolean matches(JobPost job, String keyword) {
        return contains(job.getPostProfile(), keyword)
                || contains(job.getPostDesc(), keyword)
                || job.getPostTechStack().stream().anyMatch(tech -> contains(tech, keyword));
    }

    private boolean contains(String value, String keyword) {
        return value != null && value.toLowerCase().contains(keyword);
    }
}
