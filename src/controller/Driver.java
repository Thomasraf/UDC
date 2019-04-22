package controller;
import model.Database;
import view.SelectAccount;

public class Driver {

	public static void main(String[] args) {
		//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.120.137:3306/","superuser","arielariel0","swdespa"
		
		//jdbc:mysql://192.168.0.110:3306/
		
		//test adding for Git REEEE

		String URL = "jdbc:mysql://localhost:3306/";

		String USERNAME = "ariel";
		String PASSWORD = "arielariel0";
		String DATABASE = "swdespa";



		Database.getInstance().setConnection(URL, USERNAME, PASSWORD, DATABASE);
		SelectAccount sa = new SelectAccount();
		
	}

}
