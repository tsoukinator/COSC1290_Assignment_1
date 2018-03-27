package assignment1.Objects;

import java.util.ArrayList;

public class Adult extends Account {
	private int partnerID;
	private ArrayList<Integer> Friends;
	private ArrayList<Integer> Children;

	public Adult(int accID, String FName, String SName, int Age, String Status, String Image, ArrayList<Integer> Friends, ArrayList<Integer> Children) {
	        super(accID, FName, SName, Age, Status, Image);
	        
	this.setFriends(Friends);
	this.setChildren(Children);
//	this.setFriend(-1);
//	this.setChildren(-1);
	
	}
		// TODO Auto-generated constructor stub
	
    public ArrayList<Integer> getChildren() {
    	return Children;
    }
    
    public void setChildren(ArrayList<Integer> Children) {
    	this.Children = Children;
    }	
	
    public ArrayList<Integer> getFriends() {
    	return Friends;
    }
    
    public void setFriends(ArrayList<Integer> Friends) {
    	this.Friends = Friends;
}
    
    public void setFriend(int f1) {
    	this.Friends.add(f1);
    }
    
    public void setChildren(int f1) {
    	this.Children.add(f1);
    }
    
}