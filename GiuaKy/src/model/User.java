package model;

public class User {
	private String cusId;
	private String cusName;
	private String cusAcc;
	private String cusPass;
	private String cusTel;
	public User(String cusId, String cusName, String cusAcc, String cusPass, String cusTel) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAcc = cusAcc;
		this.cusPass = cusPass;
		this.cusTel = cusTel;
	}
	
	public User(String cusId, String cusName, String cusAcc, String cusTel) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAcc = cusAcc;
		this.cusTel = cusTel;
	}

	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusAcc() {
		return cusAcc;
	}
	public void setCusAcc(String cusAcc) {
		this.cusAcc = cusAcc;
	}
	public String getCusPass() {
		return cusPass;
	}
	public void setCusPass(String cusPass) {
		this.cusPass = cusPass;
	}
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	@Override
	public String toString() {
		return "User [cusId=" + cusId + ", cusName=" + cusName + ", cusAcc=" + cusAcc + ", cusPass=" + cusPass
				+ ", cusTel=" + cusTel + "]" + "\n";
	}
	
}
