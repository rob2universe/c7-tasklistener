package com.camunda.example.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyTasklistener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {

      log.info("Tasklistener: {}",delegateTask);
      log.info("ID from Tasklistener: {}",delegateTask.getId());

    }
}
