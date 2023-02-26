package com.CabWalla.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Driver extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer driverId;
	
	@Column(unique = true)
	private String licenseNo;

	
	@Max(value=5,message = "Rating must be <= 5")
	@Min(value=0,message = "Rating must be more than 0")
	private Float rating;
	
	@Embedded
	private Cab cab;
	
	@JsonIgnore
	@OneToMany(mappedBy = "driver")
	private Set<TripBooking> tripBookings = new HashSet<>();
	
	public Driver(String userName, String password, String address, String mobileNo, String email, Integer driverId,
			String licenseNo, Cab cab, Float rating) {
		super(userName, password, address, mobileNo, email);
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	}

	public Driver(String userName, String password, String address, String mobileNo, String email, String licenseNo,
			Cab cab, Float rating) {
		super(userName, password, address, mobileNo, email);
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenseNo=" + licenseNo + ", rating=" + rating + ", cab=" + cab
				+ ", tripBookings=" + tripBookings + "]";
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Set<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(Set<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	public Driver(Integer driverId, String licenseNo,
			@Max(value = 5, message = "Rating must be <= 5") @Min(value = 0, message = "Rating must be more than 0") Float rating,
			Cab cab, Set<TripBooking> tripBookings) {
		super();
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.rating = rating;
		this.cab = cab;
		this.tripBookings = tripBookings;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(@Size(max = 15, min = 3) String userName,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit") String password,
			String address, @Pattern(regexp = "^[789]\\d{9}$") String mobileNo, @Email String email) {
		super(userName, password, address, mobileNo, email);


	}

	
	
	
}