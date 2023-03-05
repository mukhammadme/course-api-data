package com.linc.courseapidata.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linc.courseapidata.topic.Topic;

@RestController
public class CourseController {
  @Autowired
  private CourseService courseService;

  @RequestMapping("/topics/{topicId}/courses")
  public List<Course> getAllCourses(@PathVariable String topicId) {
    System.out.println("Calling getAllCourses");
    return this.courseService.getAllCourses(topicId);
  }

  @RequestMapping("/topics/{topicId}/courses/{id}")
  public Optional<Course> getCourse(@PathVariable String id) {
    System.out.println("Calling getCourse");
    return this.courseService.getCourse(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
  public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
    course.setTopic(new Topic(topicId, "", ""));
    this.courseService.addCourse(course);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
  public void updateCourse(
    @RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
    course.setTopic(new Topic(topicId, "", ""));
    this.courseService.updateCourse(course);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
  public void deleteCourse(@PathVariable String id) {
    this.courseService.deleteCourse(id);
  }
}
