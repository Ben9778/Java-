package Gonggong;
import java.util.*;
public class User implements java.io.Serializable {
	private String UserID;
	private String Password;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
