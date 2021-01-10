package com.car.showroom.model;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class VerificationResponse implements JavaDelegate {
	
	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("VerificationResponse")
				.processInstanceId(execution.getVariable("parentBussinesKey").toString())
				.setVariable("carValue", execution.getVariable("carValue"))
				.setVariable("repaymentPeriod", execution.getVariable("repaymentPeriod"))
				.setVariable("monthlyIncome", execution.getVariable("monthlyIncome"))
				.setVariable("peopleNumber", execution.getVariable("peopleNumber"))
				.setVariable("monthlyInstallmentsSum", execution.getVariable("monthlyInstallmentsSum"))
				.setVariable("correct", execution.getVariable("correct"))
				.correlateWithResult();
	}
	
}
