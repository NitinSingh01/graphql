package customer;



public class Customer {
	int Cust_ID;
	String First_Name;
	String Last_Name;
	String Email;
	String Password;
	String Address;
	String City;
	String State;
	int Zipcode;
	String UID;
	public int getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(int cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getZipcode() {
		return Zipcode;
	}
	public void setZipcode(int zipcode) {
		Zipcode = zipcode;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public Customer(int cust_ID, String first_Name, String last_Name, String email, String password, String address,
			String city, String state, int zipcode, String uID) {
		super();
		Cust_ID = cust_ID;
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
		Password = password;
		Address = address;
		City = city;
		State = state;
		Zipcode = zipcode;
		UID = uID;
	}
	
	public Customer() {}

}
