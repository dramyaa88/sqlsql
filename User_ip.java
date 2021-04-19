package UserDetails;
public class User_ip {
      private String name;
      private String email;
      private double phoNo;
      private String password;
      public void setName(String name) {
  		this.name=name;
  	  }
  	  public void setEmail(String email) {
  		this.email=email;
  	  }
  	  public void set_phoNo(double phoNo) {
    	  this.phoNo=phoNo;
        }
  	  public void setPassword(String password) {
    	  this.password=password;
       }
  	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getphoNo() {
		return phoNo;
	}
  	public String getPassword() {
  		return password;
  	}
}