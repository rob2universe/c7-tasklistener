package com.camunda.example.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.camunda.bpm.engine.delegate.DelegateTask;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class TaskInfoDTO {

    private String assignee;
    private String taskDescription;
    private String taskDefinitionKey;
    private String processInstanceId;
    private String processDefinitionName;
    private String processDefinitionKey;
    private Map<String, Object> variables;
    private String startTime;

    public TaskInfoDTO(DelegateTask task) {
        assignee = task.getAssignee();
        taskDescription = task.getDescription();
        taskDefinitionKey = task.getTaskDefinitionKey();
        processInstanceId = task.getProcessInstanceId();
        processDefinitionKey = task.getProcessDefinitionId();
        processDefinitionName = task.getProcessEngineServices().getRepositoryService()
                .getProcessDefinition(processDefinitionKey).getName();
        variables = task.getVariables();
        startTime = LocalDateTime.now().toString();
    }

    @JsonIgnore
    public String getAsJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}