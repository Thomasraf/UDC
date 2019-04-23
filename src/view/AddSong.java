package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SongBuilder;
import controller.generalController;
import model.Database;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class AddSong extends JFrame {
	private volatile static AddSong instance = null;
	private JPanel contentPane;
	private JTextField textFieldArtistName;
	private JTextField textFieldAlbum;
	private JTextField textFieldGenre;
	JButton btnChooseFile, btnNewButton;
	String fileName, currentUser;
	private JTextField textFieldChosenFile;
	private JTextField textFieldSongName;
	private JLabel lblSongName, lblArtist;
	private JComboBox yearComboBox;
	ArrayList<Song> userSongsMostPlayed, userSongs;
	private int songctr = 1;
	/**
	 * Launch the application.
	 */

	
	public static AddSong getInstance() {
        if (instance == null) {
        	instance = new AddSong();
        }
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private AddSong() {
		setTitle("Not So Spotify");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Antonello Santos\\Documents\\DesignChallenge2\\src\\images\\spotify.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setBounds(0, 140, 86, 14);
		contentPane.add(lblArtistName);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(29, 194, 46, 14);
		contentPane.add(lblGenre);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(29, 167, 46, 14);
		contentPane.add(lblAlbum);
		
//		textFieldArtistName = new JTextField();
//		textFieldArtistName.setBounds(87, 137, 162, 20);
//		contentPane.add(textFieldArtistName);
//		textFieldArtistName.setColumns(10);
		lblArtist = new JLabel(currentUser);
		lblArtist.setBounds(87, 137, 162, 20);
		contentPane.add(lblArtist);
		
		textFieldAlbum = new JTextField();
		textFieldAlbum.setColumns(10);
		textFieldAlbum.setBounds(87, 164, 162, 20);
		contentPane.add(textFieldAlbum);
		
		textFieldGenre = new JTextField();
		textFieldGenre.setColumns(10);
		textFieldGenre.setBounds(87, 191, 162, 20);
		contentPane.add(textFieldGenre);
		
		btnNewButton = new JButton("Add Song");
		btnNewButton.addActionListener(new btn_Add());
		btnNewButton.setBounds(306, 203, 89, 23);
		contentPane.add(btnNewButton);
		

		btnChooseFile = new JButton("Choose File");
		btnChooseFile.setBackground(Color.WHITE);
		btnChooseFile.addActionListener(new btn_ChooseFile());

		btnChooseFile.setBounds(33, 73, 140, 25);
		contentPane.add(btnChooseFile);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(29, 221, 46, 14);
		contentPane.add(lblYear);
		
		textFieldChosenFile = new JTextField();
		textFieldChosenFile.setColumns(10);
		textFieldChosenFile.setBounds(29, 40, 220, 20);
		contentPane.add(textFieldChosenFile);
		
		textFieldSongName = new JTextField();
		textFieldSongName.setColumns(10);
		textFieldSongName.setBounds(87, 111, 162, 20);
		contentPane.add(textFieldSongName);
		
		lblSongName = new JLabel("Song Name");
		lblSongName.setBounds(0, 111, 86, 14);
		contentPane.add(lblSongName);
		
		yearComboBox = new JComboBox();
		yearComboBox.setBounds(87, 224, 70, 22);
		for(int i = 1900; i < 2020; i++) {
			String strI = Integer.toString(i);
			yearComboBox.addItem(strI);	
		}
		
		contentPane.add(yearComboBox);
	}
	
	class btn_ChooseFile implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 JFileChooser chooser = new JFileChooser();
			 chooser.showOpenDialog(null);
			 File f = chooser.getSelectedFile();
			 fileName = f.getAbsolutePath();
			 textFieldChosenFile.setText(fileName);
		 }
		 
	 }
	
	class btn_Add implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {

			 
			 int songid = songctr;
			 String name = textFieldSongName.getText();


			 int songID = 0;
			 String username = currentUser;
			 String songName = textFieldSongName.getText();
			 String artistName = currentUser;
			 String albumName = textFieldAlbum.getText();
			 String genre = textFieldGenre.getText();
			 String year = (String) yearComboBox.getSelectedItem();
			 String path = textFieldChosenFile.getText();
			 String favorite = "0";
			 int count = 0;
			 
			 
			 Song addedSong = new SongBuilder()
					 .setSongID(songID)
					 .setUserName(username)
					 .setSongName(songName)
					 .setArtistName(artistName)
					 .setAlbum(albumName)
					 .setGenre(genre)
					 .setYear(year)
					 .setPath(path)
					 .setCount(count)
					 .setFavorite(favorite)
					 .getSong();
			 	     
			 
			 
			 
			 SongList sList = new SongList();
			 sList.addSong(addedSong);
			 int index = sList.getIndex(addedSong);
			 
//			 generalModel.getInstance().getSongData(addedSong, addedSong.getSongName());
			 generalController.getInstance().addSong(addedSong);
			 JOptionPane.showMessageDialog(null,"Added " + songName + ".mp3");
			 closingWindow();
			 //==========================================================   FOR LIBRARY STUFF
			 userSongs = generalModel.getInstance().gettingSongs(HomeView.getInstance().currentUser);
			 
			 DefaultListModel DLMTitle = new DefaultListModel();
			 DefaultListModel DLMArtist = new DefaultListModel();
			 DefaultListModel DLMGenre = new DefaultListModel();
			 DefaultListModel DLMAlbum = new DefaultListModel();
			 DefaultListModel DLMYear = new DefaultListModel();
			 DefaultListModel DLMFavorite = new DefaultListModel();
			 
			 for(int x = 0; x < userSongs.size(); x++) {
				 DLMTitle.addElement(userSongs.get(x).getSongName());
				 DLMArtist.addElement(userSongs.get(x).getArtistName());
				 DLMGenre.addElement(userSongs.get(x).getGenre());
				 DLMAlbum.addElement(userSongs.get(x).getAlbum());
				 DLMYear.addElement(userSongs.get(x).getYear());
				 DLMFavorite.addElement(userSongs.get(x).getFavorite());
			 }
//			 LibraryView.getInstance().Title_list.setModel(DLMTitle);
//			 LibraryView.getInstance().Artist_list.setModel(DLMArtist);
//			 LibraryView.getInstance().Genre_List.setModel(DLMGenre);
//			 LibraryView.getInstance().Album_List.setModel(DLMAlbum);
//			 LibraryView.getInstance().Year_List.setModel(DLMYear);
//			 LibraryView.getInstance().Fave_List.setModel(DLMFavorite);
			 
			 //==========================================================  FOR MOST PLAYED STUFF

		 userSongsMostPlayed = generalModel.getInstance().getMostPlayed(HomeView.getInstance().currentUser);

			 
			 DefaultListModel DLMMostPlayed = new DefaultListModel();
			 
			 for(int x = 0; x < userSongsMostPlayed.size(); x++)
				 DLMMostPlayed.addElement(userSongsMostPlayed.get(x).getSongName());
			 
			 HomeView.getInstance().MP_List.setModel(DLMMostPlayed);
//			 LibraryView.getInstance().MP_List.setModel(DLMMostPlayed);
			 //==========================================================
			 

		 }
		
	 }
	
	public String gettingSong() {
		String title = textFieldSongName.getText();
		return title;
	}
	
	public String gettingArtist() {
		String artist = textFieldArtistName.getText();
		return artist;
	}
	
	public String gettingAlbum() {
		String album = textFieldAlbum.getText();
		return album;
	}
	
	public String gettingGenre() {
		String genre = textFieldGenre.getText();
		return genre;
	}
	
	public String gettingYear() {
		String year = (String) yearComboBox.getSelectedItem();
		return year;
	}
	
	public void setCurrentUser(String name)
	{
		currentUser = name;
		lblArtist.setText(currentUser);
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}
