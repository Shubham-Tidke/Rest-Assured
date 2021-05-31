package pojo;
//using pojo classes for deserialization (converting response payload to JSON object)
public class getResponse {
	String url;
	String services;
	String expertise;
	getCourses courses; // value comes from getCourses.java
	String instructor;
	String linkedIn;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public getCourses getCourses() {
		return courses;
	}
	public void setCourses(getCourses courses) {
		this.courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedin() {
		return linkedIn;
	}
	public void setLinkedin(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
}
