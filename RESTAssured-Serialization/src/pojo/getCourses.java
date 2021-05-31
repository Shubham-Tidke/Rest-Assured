package pojo;

import java.util.List;

//since courses is a nested json,separate class is created
public class getCourses {
	List<getWebAutomation> webAutomation; //since webAutomation is a nested json,separate class is created which return arr  
	List<getApi> api;	//since api is a nested json,separate class is created which return arr
	List<getMobile> mobile;	//since mobile is a nested json,separate class is created which return arr
	public List<getWebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<getWebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<getApi> getApi() {
		return api;
	}
	public void setApi(List<getApi> api) {
		this.api = api;
	}
	public List<getMobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<getMobile> mobile) {
		this.mobile = mobile;
	}
	
	
	
}
