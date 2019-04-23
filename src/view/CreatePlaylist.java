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

import controller.PlaylistBuilder;
import controller.SongBuilder;
import controller.generalController;
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

public class CreatePlaylist extends JFrame {
	private volatile static CreatePlaylist instance = null;
	private JPanel contentPane;
	private JTextField textFieldEnterPlaylistName;
	JButton btnCreatePlaylist;
	JTextField textField;
	String fileName;
	String currentUser;
	private JTextField descriptionTextField;
	private ArrayList<Playlist> userPlaylist;

	/**
	 * Launch the application.
	 */
	public static CreatePlaylist getInstance() {
        if (instance == null) {
        	instance = new CreatePlaylist();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	private CreatePlaylist() {
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





		JLabel label = new JLabel("Description:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(65, 84, 80, 14);
		contentPane.add(label);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(30, 109, 160, 122);
		contentPane.add(descriptionTextField);
		descriptionTextField.setColumns(10);

	}
	
	class btn_CreatePlaylist implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 String playlistName = textFieldEnterPlaylistName.getText();
			 String username = currentUser;
			 String favorite = "0";
			 String description = descriptionTextField.getText();
			 String privacy = "0";
			 
			 boolean isTrue = true;
			 

			 


			 Playlist addedPlaylist = new PlaylistBuilder()
					 .setPlaylistName(playlistName)
					 .setUsername(username)
					 .setFavorite(favorite)
					 .setPrivacy(privacy)
					 .setDescription(description)

					 .getPlaylist();

			 PlaylistList pList = new PlaylistList();
			 
			 for(int i = 0; i < generalModel.getInstance().getUserPlaylist(username).size();i++)
			 {
				 if(playlistName.equals(generalModel.getInstance().getUserPlaylist(username).get(i).getPlaylistName()))
				 {
					 JOptionPane.showMessageDialog(null,"Playlist already exists");
					 dispose();
					 isTrue = false;
				 }
			 }
			 
			 if(isTrue != false)
			 {
				 pList.addEvent(addedPlaylist);
				 int index = pList.getIndex(addedPlaylist);
			 
				 generalModel.getInstance().getPlaylistData(addedPlaylist);

				 generalController.getInstance().gettingUserPlaylist(username, playlistName, favorite,privacy,description);

				 JOptionPane.showMessageDialog(null, "Added " + playlistName + " playlist!");
				 
				 dispose();
			 
			 }

			 //===================

			 HomeView.getInstance().userPlaylists = generalModel.getInstance().gettingPlaylists(HomeView.getInstance().currentUser);
			 DefaultListModel DLM2 = new DefaultListModel();
			
			 for(int y = 0; y < HomeView.getInstance().userPlaylists.size(); y++)
				 DLM2.addElement(HomeView.getInstance().userPlaylists.get(y).getPlaylistName());

			 HomeView.getInstance().Playlist_List.setModel(DLM2);
			 //=====================



		 }
		 }
	 
	
	public void closingWindow() {
		this.setVisible(false);
	}
	
	public void setUsername(String username) {
		this.currentUser = username;
	}
 }
 //songID, username, songName,artistName,albumName,genre,year,path,count,favorite
