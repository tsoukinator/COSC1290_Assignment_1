package assignment1.Objects;

import java.util.ArrayList;

public class Adult extends Account {
	private int partnerID;
	private ArrayList Friends;
	private ArrayList Children;
	
	public Adult(int accID, String FName, String SName, int Age, String Status, String Image, ArrayList<Integer> Friends, ArrayList<Integer> Children) {
	        super(accID, FName, SName, Age, Status, Image);
	this.setFriends(Friends);
	this.setParents(Children);
	}
		// TODO Auto-generated constructor stub
	
	
    public ArrayList getChildren() {
    	return Children;
    }
    
    public void setParents(ArrayList<Integer> Parents) {
    	this.Children = Children;
    }	
	
    public ArrayList getFriends() {
    	return Friends;
    }
    
    public void setFriends(ArrayList<Integer> Friends) {
    	this.Friends = Friends;
}
    
}