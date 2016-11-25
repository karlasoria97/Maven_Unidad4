
package boot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="songs")
public class Song implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50)
	private String name;
	@Column(length=30)
	private String gender;
	@Column(length=50)
	private String artist;
	@Column(length=20)
	private String year;
	
	
	
	public Song(String name, String gender, String artist, String year) {
		super();
		this.name = name;
		this.gender = gender;
		this.artist = artist;
		this.year = year;
	}
	
	public Song() {
		this("","","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", gender=" + gender + ", artist=" + artist + ", year=" + year
				+ "]";
	}

	
	
	
}
