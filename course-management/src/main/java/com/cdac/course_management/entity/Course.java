package com.cdac.course_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_management")
public class Course {

    @Id
    @SequenceGenerator(name = "course_management_course_id_seq_gen", sequenceName = "course_management_course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_management_course_id_seq_gen")
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "instructor", nullable = false)
    private String instructor;

    @Column(name = "duration", nullable = false)
    private Integer duration; // in hours

    @Column(name = "fee", nullable = false)
    private Integer fee;

    @Column(name = "course_type", nullable = false)
    private String courseType; // Online, Offline, Hybrid

    public Course() {}

    // Getters and Setters
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Integer getFee() { return fee; }
    public void setFee(Integer fee) { this.fee = fee; }

    public String getCourseType() { return courseType; }
    public void setCourseType(String courseType) { this.courseType = courseType; }
}
