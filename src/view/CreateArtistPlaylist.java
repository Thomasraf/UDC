package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.io.File;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import controller.ArtistPlaylistBuilder;
import controller.PlaylistBuilder;
import controller.SongBuilder;
import controller.generalController;
import model.ArtistPlaylist;
import model.Database;
import model.Playlist;
import model.PlaylistList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;


import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CreateArtistPlaylist extends JFrame {
	private volatile static CreateArtistPlaylist instance = null;
	private JPanel contentPane;
	private JTextField textFieldEnterPlaylistName;
	JButton btnCreatePlaylist,btnChoosePicture;
	String textField,fileName;
	private JTextField textFieldChosenFile;
	private JTextField descriptionTextField;
	private int playlistctr = 1;

	/**
	 * Launch the application.
	 */
	public static CreateArtistPlaylist getInstance() {
        if (instance == null) {
        	instance = new CreateArtistPlaylist();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	private CreateArtistPlaylist() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEnterPlaylistName = new JTextField();
		textFieldEnterPlaylistName.setBounds(30, 39, 407, 20);
		contentPane.add(textFieldEnterPlaylistName);
		textFieldEnterPlaylistName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Playlist Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 14, 112, 14);
		contentPane.add(lblNewLabel);
		
		btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new btn_CreatePlaylist());
		btnCreatePlaylist.setBounds(336, 228, 101, 23);
		contentPane.add(btnCreatePlaylist);


//		textField = new JTextField();
//		textField.setColumns(10);
//		textField.setBounds(250, 95, 187, 122);
//		contentPane.add(textField);


		JLabel label = new JLabel("Description:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(312, 70, 80, 14);
		contentPane.add(label);

		btnChoosePicture = new JButton("Choose Image");
		btnChoosePicture.setBounds(30, 228, 101, 23);
		contentPane.add(btnChoosePicture);
		btnChoosePicture.addActionListener(new btn_ChoosePicture());

		JLabel PlaylistImagelbl = new JLabel("Image:");
		PlaylistImagelbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PlaylistImagelbl.setBounds(60, 66, 56, 23);
		contentPane.add(PlaylistImagelbl);
		
		JLabel lblNewLabel_1 = new JLabel("Playlist Image here");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_1.setBounds(30, 93, 160, 94);
		contentPane.add(lblNewLabel_1);
		
		textFieldChosenFile = new JTextField();
		textFieldChosenFile.setBounds(30, 198, 160, 20);
		contentPane.add(textFieldChosenFile);
		textFieldChosenFile.setColumns(10);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(277, 95, 160, 122);
		contentPane.add(descriptionTextField);
		descriptionTextField.setColumns(10);

	}
	
	class btn_ChoosePicture implements ActionListener
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
	
	class btn_CreatePlaylist implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 String playlistName = textFieldEnterPlaylistName.getText();
			 String username = HomeViewA.getInstance().currentUser;
			 String path = textFieldChosenFile.getText();
			 String description = descriptionTextField.getText();
			 			 
			 ArtistPlaylistBuilder build = new ArtistPlaylistBuilder();
			 build.setName(playlistName);
			 build.setUsername(username);
			 build.setDescription(description);
			 build.setPath(path);
			 
			 
			 ArtistPlaylist newPlaylist = build.getPlaylist();
			 
			 generalController.getInstance().addArtistPlaylist(newPlaylist);
			 setVisible(false);
			 playlistctr++;

		 }
		}
	 
	
	public void closingWindow() {
		this.setVisible(false);
	}
 }
 //songID, username, songName,artistName,albumName,genre,year,path,count,favorite
