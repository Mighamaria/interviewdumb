package com.USTInterviewScheduler.FeedBackForm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "interviewresult_tab")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private LocalDate interviewDate;

    private LocalTime interviewTime;

    private String interviewerName;

    private String interviewResult;

//    @Column(length = 500)
    private String interviewComments;
//
//    private String interviewerSignature;
//
//    private LocalDate interviewResultDate;
}












