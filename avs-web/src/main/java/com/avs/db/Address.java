package com.avs.db;

public class Address {

	private String locality;
	private int pincode;
	private String subDistname;
	private String districtname;
	private String stateName;

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getSubDistname() {
		return subDistname;
	}

	public void setSubDistname(String subDistname) {
		this.subDistname = subDistname;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
