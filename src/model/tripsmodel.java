package model;

import java.util.Date;

public class tripsmodel {
	String src;
	String dest;
	Date date;
	int cars_available;
	int vacant_seats;
	int cost;
	String desc;
	long user_id;
	long trip_id;
	String user_email;
	
	
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(long trip_id) {
		this.trip_id = trip_id;
	}
	public String getDesc() {
		return desc;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public tripsmodel() {
		super();
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCars_available() {
		return cars_available;
	}
	public void setCars_available(int cars_available) {
		this.cars_available = cars_available;
	}
	public int getVacant_seats() {
		return vacant_seats;
	}
	public void setVacant_seats(int vacant_seats) {
		this.vacant_seats = vacant_seats;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
