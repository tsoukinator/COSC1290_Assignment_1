package assignment1.Objects;

import java.util.ArrayList;

public class Infant extends Account {
	private ArrayList<Integer> Parents;
	
	public Infant(int accID, String FName, String SName, int Age, String Status, String Image, ArrayList<Integer> Parents) {
	        super(accID, FName, SName, Age, Status, Image);
	        this.setParents(Parents);
	        }
		// TODO Auto-generated constructor stub
	
    public ArrayList<Integer> getParents() {
    	return Parents;
    }
    
    public void setParents(ArrayList<Integer> Parents) {
    	this.Parents = Parents;
    }
	
}
