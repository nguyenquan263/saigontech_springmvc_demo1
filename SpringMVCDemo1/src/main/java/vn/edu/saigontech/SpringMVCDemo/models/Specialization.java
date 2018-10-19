package vn.edu.saigontech.SpringMVCDemo.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "specializations")
public class Specialization {

	private  Integer ID;
	private String Name;
	private Integer numberCredit;

	public Specialization(Integer iD, String name, Integer numberCredit) {
		super();
		ID = iD;
		Name = name;
		this.numberCredit = numberCredit;
	}

	public Specialization(String name, Integer numberCredit) {
		super();
		Name = name;
		this.numberCredit = numberCredit;
	}

	public Specialization() {
		super();
	}

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Column(name = "NumberCredit", nullable = false)
	public Integer getNumberCredit() {
		return numberCredit;
	}

	public void setNumberCredit(Integer numberCredit) {
		this.numberCredit = numberCredit;
	}

	@Override
	public String toString() {
		return "Specialization [ID=" + ID + ", Name=" + Name + ", numberCredit=" + numberCredit + "]";
	}
	@Transient
	public boolean isValidForAdding() {
		boolean result = true;

		if (this.Name == "" || this.Name == null)
			result = false;
		if (this.numberCredit == null || this.numberCredit < 1)
			result = false;

		return result;
	}
	@Transient
	public boolean isValidForUpdating() {
		boolean result = true;
		if (this.ID == null || this.ID < 1)
			result = false;
		if (this.Name == "" || this.Name == null)
			result = false;
		if (this.numberCredit == null || this.numberCredit < 1)
			result = false;

		return result;
	}

}
