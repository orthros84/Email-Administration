package emailApp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "xyzcompany.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
	    department = setDepartment();
		//System.out.println("Department : " + department);
		
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is : " + this.password);
		
		email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your email is : " + email);
	}
	
	private String setDepartment() {
		System.out.println("New worker : " + firstName+"\n" +" DEPARTMENT CODES\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "sales";}
		else if (depChoice == 2 ) {return "development";}
		else if (depChoice == 3 ) {return "accounting";}
		else {return "";}	
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0 ; i<length ; i++) {
			int rand = (int)( Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailBoxCapacity() {return mailBoxCapacity;}
	public String getAltEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		
		return "DISPLAY NAME : " + firstName + " " + lastName +"\n" +
			   "Company Email : " + email + "\n" +
			   "Mailbox Capacity : " + mailBoxCapacity + "mb";
		
	}

}
