package assignment1.Objects;

import java.util.ArrayList;

public class Child extends Account {
	private ArrayList<Integer> Parents;
	private ArrayList<Integer> Friends;
	
	public Child(int accID, String FName, String SName, int Age, String Status, String Image, ArrayList<Integer> Parents) {
        super(accID, FName, SName, Age, Status, Image);
        this.setFriends(Friends);
        this.setParents(Parents);
        }
	// TODO Auto-generated constructor stub

	public ArrayList<Integer> getParents() {
    	return Parents;
    }
    
    public void setParents(ArrayList<Integer> Parents) {
    	this.Parents = Parents;
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



}

/*
public Child(int accID, String FName, String SName, int Age, String Status, String Image, ArrayList<Integer> Parents) {
    super(accID, FName, SName, Age, Status, Image);
    }
// TODO Auto-generated constructor stub
*/