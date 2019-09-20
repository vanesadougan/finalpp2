package org.bienestar.cocina.controller.navigation;

public class ApplicationContext {
	private ActionRequest actionReq;

	public ApplicationContext(ActionRequest actionReq) {
		this.setActionReq(actionReq);
	}

	public ActionRequest getActionReq() {
		return actionReq;
	}

	public void setActionReq(ActionRequest actionReq) {
		this.actionReq = actionReq;
	}
}
