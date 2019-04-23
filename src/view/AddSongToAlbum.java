package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlbumBuilder;
import controller.SongBuilder;
import model.Album;
import model.AlbumList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class AddSongToAlbum extends JFrame {
	private volatile static AddSongToAlbum instance = null;
	private JPanel contentPane;
	JButton btnAddToAlbum;
	JComboBox comboBoxSongs, comboBoxAlbums;

	/**
	 * Launch the application.
	 */
	public static AddSongToAlbum getInstance() {
        if (instance == null) {
        	instance = new AddSongToAlbum();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	public AddSongToAlbum() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 189);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxSongs = new JComboBox();
		comboBoxSongs.setBounds(46, 40, 127, 28);
		contentPane.add(comboBoxSongs);
		
		JLabel lblSongs = new JLabel("Song:");
		lblSongs.setBounds(46, 15, 58, 14);
		contentPane.add(lblSongs);
		
		btnAddToAlbum = new JButton("Add to Album");
		btnAddToAlbum.addActionListener(new btn_AddToAlbum());
		btnAddToAlbum.setBounds(102, 94, 192, 28);
		contentPane.add(btnAddToAlbum);
		
		 comboBoxAlbums = new JComboBox();
		comboBoxAlbums.setBounds(236, 40, 127, 28);
		contentPane.add(comboBoxAlbums);
		
		JLabel lblPlaylist = new JLabel("Album");
		lblPlaylist.setBounds(236, 23, 58, 14);
		contentPane.add(lblPlaylist);
	}
	
	class btn_AddToAlbum implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {		
			 int i, j;
			 
		 	 SongList sl = new SongList();
		 	 AlbumList pl = new AlbumList();
		 	 
		 	 String currUser = RegisteredUserView.getInstance().currentUser;
		 	 
//		 	 for(i = 0; i < generalModel.getInstance().getUserAlbum(currUser).size(); i++)
//		 	 {	
//		 		 if(comboBoxAlbums.getSelectedItem().equals(generalModel.getInstance().getUserAlbum(currUser).get(i).getPlaylistName()))
//		 		 {
//		 			for(j = 0; j < generalModel.getInstance().gettingSongs(currUser).size(); j++)
//		 			{
//					 	if (comboBoxSongs.getSelectedItem().equals(generalModel.getInstance().gettingSongs(currUser).get(j).getSongName()))
//					 	{				
//					 		generalModel.getInstance().getUserAlbum(currUser).get(i).addSongToPlaylist(generalModel.getInstance().gettingSongs(currUser).get(j));       
//					 		//System.out.print(generalModel.getInstance().getUserPlaylist(currUser).get(i).getSongInPlaylist().get(j).getSongName());
//					 		//System.out.print(pl.getPlaylistList().get(i).getSongInPlaylist().get(j).getSongName());
//					 		
//					 		
//					 	}
//		 			}
//		 		 }
//		 	 }
		 	 
		 	 
//		 		System.out.println(generalModel.getInstance().getUserAlbum(currUser).get(comboBoxAlbums.getSelectedIndex()).getSongInAlbum().get(0).getSongName());
		 	 
				
		 		dispose();
		 	 
		 	 
			 
		 }
	 }
}
