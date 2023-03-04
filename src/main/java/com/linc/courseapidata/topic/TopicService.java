package com.linc.courseapidata.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepository;

  public List<Topic> getAllTopics() {
    List<Topic> topics = new ArrayList<>();
    topicRepository.findAll()
      .forEach(topics::add);
    return topics;
  }

  public Optional<Topic> getTopic(String id) {
    return this.topicRepository.findById(id);
  }

  public void addTopic(Topic topic) {
    this.topicRepository.save(topic);
  }

  public void updateTopic(Topic topic, String id) {
    this.topicRepository.save(topic);
  }

  public void deleteTopic(String id) {
    this.topicRepository.deleteById(id);
  }
}
