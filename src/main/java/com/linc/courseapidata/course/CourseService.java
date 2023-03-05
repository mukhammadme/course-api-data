package com.linc.courseapidata.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAllCourses(String topicId) {
    return this.courseRepository.findByTopicId(topicId);
  }

  public Optional<Course> getCourse(String id) {
    return this.courseRepository.findById(id);
  }

  public void addCourse(Course course) {
    this.courseRepository.save(course);
  }

  public void updateCourse(Course course) {
    this.courseRepository.save(course);
  }

  public void deleteCourse(String id) {
    this.courseRepository.deleteById(id);
  }
}
