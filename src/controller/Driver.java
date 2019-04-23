	package controller;
import model.Database;
import view.SelectAccount;

public class Driver {

	public static void main(String[] args) {
		//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.120.137:3306/","superuser","arielariel0","swdespa"
		
		//jdbc:mysql://192.168.0.110:3306/
		
		//test adding for Git REEEE

		String URL = "jdbc:mysql://localhost:3306/";


		String USERNAME = "root";


//		String PASSWORD = "1234";
		String PASSWORD = "rootadmin";
//		String DATABASE = "swdespa";
		String DATABASE = "udc";


		Database.getInstance().setConnection(URL, USERNAME, PASSWORD, DATABASE);
		//Database.getInstance().testerTemplate();
		//Database.getInstance().readBLOB(1);	
		SelectAccount sa = new SelectAccount();
		
	}

}
