package model;

import java.util.ArrayList;

public class accountList {
	
	
private static ArrayList<account> accList = new ArrayList<account>();
	
	public void accountList(account acc)
	{
		accList.add(acc);
	}

	public static ArrayList<account> getSongList() {
		return accList;
	}

	public static void setSongList(ArrayList<account> accList) {
		accountList.accList = accList;
	}
	
	public int getSongSize() {
		return accList.size();
	}
	
	public int getSongListSize() {
		return accList.size();
	}

	public int getIndex(Song s) {
		return accList.indexOf(s);
	}

	public void printSongs() {
		for (int i = 0; i<accList.size(); i++)
		{
				System.out.print(accList.get(i).getUsername());
				System.out.println("");
		}
	}
}
