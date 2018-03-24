package assignment1;
// Save as file Account.java

public final class Account {

		private int accID;
		private String FName;
		private String SName;
		private int Age; 
		private String Status;
		private String Image;

		public Account(int accID, String FName, String SName, int Age, String Status, String Image) {
			this.setID(accID);
			this.setFName(FName);
			this.setSName(SName);
			this.setAge(Age);
			this.setStatus(Status);
			this.setImage(Image);
		}

		public int getID() {
	        return accID;
	    }

	    public void setID(int accID) {
	        this.accID = accID;
	    }

	    public String getFName() {
	        return FName;
	    }

	    public void setFName(String FName) {
	        this.FName = FName;
	    }
	    
	    public String getSName() {
	        return SName;
	    }
	    
	    public void setSName(String SName) {
	        this.SName = SName;
	    }

	    public int getAge() {
	        return Age;
	    }

	    public void setAge(int Age) {
	        this.Age = Age;
	    }
	    
	    public String getStatus() {
	    	return Status;
	    }
	    
	    public void setStatus(String Status) {
	    	this.Status = Status;
	    }
	    
	    public String getImage() {
	    	return Image;
	    }
	    
	    public void setImage(String Image) {
	    	this.Image = Image;
	    }
	
/*
    public Account(String accID,
		  String firstName, String surName, int age, 
  	          double amount) {

        this.accID   = accID;
        this.cus = new Customer(firstName, surName, age);
				
        if (amount < 0)   balance = 0;
        else balance = Math.round(amount);
    }
    ...
    */
}
