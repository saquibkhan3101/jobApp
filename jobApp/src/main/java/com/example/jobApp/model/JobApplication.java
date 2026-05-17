package com.example.jobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
    private int postId;
    private String applicantName;
    private String applicantEmail;
    private String phoneNumber;
    private String resumeLink;
    private String coverLetter;
}
