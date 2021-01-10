package com.car.showroom.model;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class VerificationResponse implements JavaDelegate {
	
	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("VerificationResponse")
				.processInstanceId(execution.getVariable("parentBussinesKey").toString())
				.setVariable("correct", execution.getVariable("correct"))
				.correlateWithResult();
	}
	
}
