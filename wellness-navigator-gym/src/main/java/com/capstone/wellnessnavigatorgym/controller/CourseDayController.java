package com.capstone.wellnessnavigatorgym.controller;

import com.capstone.wellnessnavigatorgym.dto.course.CourseDetail;
import com.capstone.wellnessnavigatorgym.entity.CourseDay;
import com.capstone.wellnessnavigatorgym.service.ICourseDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course-day")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseDayController {

    @Autowired
    private ICourseDay courseDay;

    @GetMapping("/")
    public ResponseEntity<List<CourseDetail>> getAllCourseDetails() {
        List<CourseDetail> courseDetails = courseDay.findAllCourseDetails();
        if (courseDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courseDetails, HttpStatus.OK);
    }
}
