package com.forms;

public class workdayDTO {
	String Month;
    int Year;
    int Workdays;
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getWorkdays() {
		return Workdays;
	}
	public void setWorkdays(int workdays) {
		Workdays = workdays;
	}
	@Override
	public String toString() {
		return "workdayDTO [Month=" + Month + ", Year=" + Year + ", Workdays=" + Workdays + "]";
	}
	public workdayDTO(String month, int year, int workdays) {
		super();
		Month = month;
		Year = year;
		Workdays = workdays;
	}
	public workdayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
