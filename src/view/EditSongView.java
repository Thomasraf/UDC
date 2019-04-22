package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SongBuilder;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.Color;

public class EditSongView extends JFrame {
	private volatile static EditSongView instance = null;
	private JPanel contentPane;
	private JTextField textFieldArtistName;
	private JTextField textFieldAlbum;
	private JTextField textFieldGenre;
	JButton btn_editsong;
	private JTextField textFieldYear;
	String fileName;
	private JTextField textFieldSongName;
	private JLabel lblSongName;
	String currentUser;
	String songName;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	/**
	 * Launch the application.
	 */

	
	public static EditSongView getInstance() {
        if (instance == null) {
        	instance = new EditSongView();
        }
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public EditSongView() {
		setTitle("Not So Spotify");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Nello Santos\\Documents\\GitHub\\DesignChallenge2\\src\\images\\spotify.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 429, 195);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setBounds(10, 40, 86, 14);
		contentPane.add(lblArtistName);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(39, 94, 46, 14);
		contentPane.add(lblGenre);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(39, 67, 46, 14);
		contentPane.add(lblAlbum);
		
		textFieldArtistName = new JTextField();
		textFieldArtistName.setBounds(97, 37, 205, 20);
		contentPane.add(textFieldArtistName);
		textFieldArtistName.setColumns(10);
		
		textFieldAlbum = new JTextField();
		textFieldAlbum.setBounds(97, 64, 205, 20);
		textFieldAlbum.setColumns(10);
		contentPane.add(textFieldAlbum);
		
		textFieldGenre = new JTextField();
		textFieldGenre.setBounds(97, 91, 205, 20);
		textFieldGenre.setColumns(10);
		contentPane.add(textFieldGenre);
		
		 btn_editsong = new JButton("Edit Song");
		 btn_editsong.addActionListener(new btn_Edit());
		 btn_editsong.setBounds(289, 119, 116, 23);
		contentPane.add(btn_editsong);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(39, 121, 46, 14);
		contentPane.add(lblYear);
		
		textFieldSongName = new JTextField();
		textFieldSongName.setBounds(97, 11, 205, 20);
		textFieldSongName.setColumns(10);
		contentPane.add(textFieldSongName);
		
		lblSongName = new JLabel("Song Name");
		lblSongName.setBounds(10, 11, 86, 14);
		contentPane.add(lblSongName);
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(97, 122, 86, 20);
		for(int i = 1900; i < 2020; i++) {
			String strI = Integer.toString(i);
			comboBox.addItem(strI);
		}
		contentPane.add(comboBox);
	}
	
	class btn_Edit implements ActionListener{
		 
		 public void actionPerformed(ActionEvent e)
		 {
			 	int songID = 0;
			 	String username = RegisteredUserView.getInstance().currentUser;
			 	String songName = RegisteredUserView.getInstance().getSongName();
			 	String artistName = RegisteredUserView.getInstance().getArtistName();
			 	String albumName = RegisteredUserView.getInstance().getAlbumName();
			 	String genreName = RegisteredUserView.getInstance().getGenreName();
			 	String yearDate = RegisteredUserView.getInstance().getYearDate();
			 	
			 	String songNameNew = textFieldSongName.getText(); //New Song Name
			 	String artistNameNew = textFieldArtistName.getText(); //New Artist Name
			 	String albumNameNew = textFieldAlbum.getText();// New Album Name
			 	String genreNameNew = textFieldGenre.getText();//New Genre Name
			 	String yearNew = (String) comboBox.getSelectedItem(); //New Year Date
			 	
			 	if(songName == songNameNew)
			 		songNameNew = songName;
			 	if(artistName == artistNameNew)
			 		artistNameNew = artistName;
			 	if(albumName == albumNameNew)
			 		albumNameNew = albumName;
			 	if(genreName == genreNameNew)
			 		genreNameNew = genreName;
			 	if(yearDate == yearNew)
			 		yearNew = yearDate;
			 	
			 	generalModel.getInstance().editSongData(username, songName, songNameNew, artistNameNew, albumNameNew,genreNameNew, yearNew);
			 			
			 	
			 	JOptionPane.showMessageDialog(null, "Your song (" + songName + ") has been changed to (" + songNameNew + ")");
			 	closingWindow();
		 }
	 }
	
	public void getUsername(String currentUser) {
		this.currentUser = currentUser;
	}
	public void getOldSongName(String songName) {
		this.songName = songName;
	}
	public void closingWindow() {
		this.setVisible(false);
	}
}
