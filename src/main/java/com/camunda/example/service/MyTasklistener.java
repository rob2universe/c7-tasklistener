package com.camunda.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class MyTasklistener implements TaskListener {

    @Override
    public void notify(DelegateTask task) {

        log.info("Tasklistener: {}", task);
        log.info("ID from Tasklistener: {}", task.getId());

        TaskInfoDTO taskInfo = new TaskInfoDTO(task);

        try {
            log.info(taskInfo.getAsJSON());
            task.setVariable("taskDTO", taskInfo.getAsJSON());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
