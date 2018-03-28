package assignment1.Objects;
// Save as file Account.java

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

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
		
		/*
		public Account(int accID, String FName, String SName, int Age, String Status) {
			this.setID(accID);
			this.setFName(FName);
			this.setSName(SName);
			this.setAge(Age);
			this.setStatus(Status);
			this.setImage("");
		}

		public Account(int accID, String FName, String SName, int Age) {
			this.setID(accID);
			this.setFName(FName);
			this.setSName(SName);
			this.setAge(Age);
			this.setStatus("");			
			this.setImage("");
		}
		*/
		
		public Account() {
			// Do Nothing
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
		public String DisplayUsers() {
		    List<Account> copy = new ArrayList<Account>();
		    for (Account person : personer) {
		        copy.add(person);
		    }

		    return copy;
	}
	    
	*/    
}
