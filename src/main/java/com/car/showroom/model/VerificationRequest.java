package com.car.showroom.model;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class VerificationRequest implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		Map<String, Object> processVariables = new HashMap<String, Object>();
		processVariables.put("parentBussinesKey", execution.getProcessInstanceId());
		processVariables.put("carValue", execution.getVariable("carValue"));
		processVariables.put("repaymentPeriod", execution.getVariable("repaymentPeriod"));
		processVariables.put("monthlyIncome", execution.getVariable("monthlyIncome"));
		processVariables.put("peopleNumber", execution.getVariable("peopleNumber"));
		processVariables.put("monthlyInstallmentsSum", execution.getVariable("monthlyInstallmentsSum"));
		runtimeService.startProcessInstanceByMessage("VerificationRequest", processVariables);
	}

}
