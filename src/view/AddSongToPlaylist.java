package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PlaylistBuilder;
import controller.SongBuilder;
import model.Playlist;
import model.PlaylistList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class AddSongToPlaylist extends JFrame {
	private volatile static AddSongToPlaylist instance = null;
	private JPanel contentPane;
	JButton btnAddToPlaylist;
	JComboBox comboBoxSongs, comboBoxPlaylists;

	/**
	 * Launch the application.
	 */
	public static AddSongToPlaylist getInstance() {
        if (instance == null) {
        	instance = new AddSongToPlaylist();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	public AddSongToPlaylist() {
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
		
		btnAddToPlaylist = new JButton("Add to Playlist");
		btnAddToPlaylist.addActionListener(new btn_AddToPlaylist());
		btnAddToPlaylist.setBounds(102, 94, 192, 28);
		contentPane.add(btnAddToPlaylist);
		
		 comboBoxPlaylists = new JComboBox();
		comboBoxPlaylists.setBounds(236, 40, 127, 28);
		contentPane.add(comboBoxPlaylists);
		
		JLabel lblPlaylist = new JLabel("Playlist");
		lblPlaylist.setBounds(236, 23, 58, 14);
		contentPane.add(lblPlaylist);
	}
	
	class btn_AddToPlaylist implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {		
			 int i, j;
			 
		 	 SongList sl = new SongList();
		 	 PlaylistList pl = new PlaylistList();
		 	 
		 	 String currUser = RegisteredUserView.getInstance().currentUser;
		 	 
		 	 for(i = 0; i < generalModel.getInstance().getUserPlaylist(currUser).size(); i++)
		 	 {	
		 		 if(comboBoxPlaylists.getSelectedItem().equals(generalModel.getInstance().getUserPlaylist(currUser).get(i).getPlaylistName()))
		 		 {
		 			for(j = 0; j < generalModel.getInstance().gettingSongs(currUser).size(); j++)
		 			{
					 	if (comboBoxSongs.getSelectedItem().equals(generalModel.getInstance().gettingSongs(currUser).get(j).getSongName()))
					 	{				
					 		generalModel.getInstance().getUserPlaylist(currUser).get(i).addSongToPlaylist(generalModel.getInstance().gettingSongs(currUser).get(j));       
					 		//System.out.print(generalModel.getInstance().getUserPlaylist(currUser).get(i).getSongInPlaylist().get(j).getSongName());
					 		//System.out.print(pl.getPlaylistList().get(i).getSongInPlaylist().get(j).getSongName());
					 		
					 		
					 	}
		 			}
		 		 }
		 	 }
		 	 
		 	 
		 		System.out.println(generalModel.getInstance().getUserPlaylist(currUser).get(comboBoxPlaylists.getSelectedIndex()).getSongInPlaylist().get(0).getSongName());
		 	 
				
		 		dispose();
		 	 
		 	 
			 
		 }
	 }
}
