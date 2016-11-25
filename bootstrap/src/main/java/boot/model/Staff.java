package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="staffs")
public class Staff implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean gender;
	@Column(length=50)
	private String jobTitle;
	@Column(length=30)
	private String firstName;
	@Column(length=30)
	private String middelName;
	@Column(length=30)
	private String lastName;
	@Temporal(TemporalType.DATE)
	@Column(name="birth_day")
	private Date birthDay;
	@Column(length=50)
	private String otherDetails;
	
	
	public Staff(boolean gender, String jobTitle, String firstName, 
			String middelName, String lastName, Date birthDay, String otherDetails ) {
		super();
		this.gender = gender;
		this.jobTitle = jobTitle;
		this.firstName = firstName;
		this.middelName = middelName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.otherDetails = otherDetails;
	}
	
	public Staff() {
		this(false,"", "", "", "", new Date(), "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddelName() {
		return middelName;
	}

	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", gender=" + gender + ", jobTitle=" + jobTitle + ", firstName=" + firstName
				+ ", middelName=" + middelName + ", lastName=" + lastName + ", birthDay=" + birthDay + ", otherDetails="
				+ otherDetails + "]";
	}
	
	
	

}
