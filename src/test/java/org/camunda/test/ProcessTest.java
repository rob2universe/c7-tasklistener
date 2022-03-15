package org.camunda.test;

import com.camunda.example.service.LoggerDelegate;
import com.camunda.example.service.MyTasklistener;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Before;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

@Deployment(resources = "process.bpmn")
public class ProcessTest extends AbstractProcessEngineRuleTest {

    @Before
    public void setUp() {
        Mocks.register("logger", new LoggerDelegate());
        Mocks.register("myTasklistener", new MyTasklistener());
    }

    @Test
    public void testHappyPath() {
        ProcessInstance pi = runtimeService().startProcessInstanceByKey("example-process", withVariables("myVar", "myVarValue"));
    }

}
