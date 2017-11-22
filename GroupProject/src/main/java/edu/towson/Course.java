package edu.towson;
public class Course {
	private String courseId;
	private String courseStartDate;
	private String couseDesc;
	private String courseTitle;
	private String courseEndDate;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public String getCouseDesc() {
		return couseDesc;
	}
	public void setCouseDesc(String couseDesc) {
		this.couseDesc = couseDesc;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getOfferingDept() {
		return offeringDept;
	}
	public void setOfferingDept(String offeringDept) {
		this.offeringDept = offeringDept;
	}
	private String offeringDept;
	
}
