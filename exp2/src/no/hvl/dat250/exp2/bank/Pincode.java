package no.hvl.dat250.exp2.bank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pincode {
	
	@Id
	private int id;
	
	private String pincode;
	private int count;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Pincode [id=" + id + ", pincode=" + pincode + ", count=" + count + "]";
	}



	
	
	
	
}
