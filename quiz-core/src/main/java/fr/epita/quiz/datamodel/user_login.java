package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class user_login {
	@Entity  
	@Table(name="user_details")  
	public class userDetail {  
	  
	    @Id  
	    @GeneratedValue(strategy=GenerationType.AUTO)  
	  
	    @Column(name="user_id")  
	    private int adminID;  
	    

		@Column(name="email_id")  
	    public String emailId;  
	    

		@Column(name="name")  
	    public String name;  
	      
	    @Column(name="password")  
	    public String password;
	    
	    public userDetail(int adminID, String emailId, String name, String password) {
			super();
			this.adminID = adminID;
			this.emailId = emailId;
			this.name = name;
			this.password = password;
		}

		public int getAdminID() {
			return adminID;
		}

		public void setAdminID(int adminID) {
			this.adminID = adminID;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		@Override
		public String toString() {
			return "userDetail [adminID=" + adminID + ", emailId=" + emailId + ", name=" + name + ", password="
					+ password + "]";
		}  
	    

}
}

