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

public class RemoveSongFromAlbumView extends JFrame {
	private volatile static RemoveSongFromAlbumView instance = null;
	private JPanel contentPane;
	JButton btnRemoveSongFromAlbum;
	JComboBox comboBoxSongs, comboBoxAlbums;

	/**
	 * Launch the application.
	 */
	public static RemoveSongFromAlbumView getInstance() {
        if (instance == null) {
        	instance = new RemoveSongFromAlbumView();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	private RemoveSongFromAlbumView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 189);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxSongs = new JComboBox();
		comboBoxSongs.setBounds(236, 40, 127, 28);
		contentPane.add(comboBoxSongs);
		
		JLabel lblSongs = new JLabel("Song:");
		lblSongs.setBounds(236, 15, 58, 14);
		contentPane.add(lblSongs);
		
		btnRemoveSongFromAlbum = new JButton("Remove from Album");
		btnRemoveSongFromAlbum.setBackground(new Color(255, 255, 255));
		btnRemoveSongFromAlbum.addActionListener(new btn_RemoveSongFromAlbum());
		btnRemoveSongFromAlbum.setBounds(102, 94, 192, 28);
		contentPane.add(btnRemoveSongFromAlbum);
		
		comboBoxAlbums = new JComboBox();
		comboBoxAlbums.setBounds(46, 40, 127, 28);
		contentPane.add(comboBoxAlbums);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(46, 15, 58, 14);
		contentPane.add(lblAlbum);
	}
	
	class btn_RemoveSongFromAlbum implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {		
			 int i, j;
			 
		 	 String currUser = HomeViewA.getInstance().currentUser;
		 	 
//		 	 for(i = 0; i < generalModel.getInstance().getUserAlbum(currUser).size(); i++)
//		 	 {	
//		 		 if(comboBoxAlbums.getSelectedItem().equals(generalModel.getInstance().getUserAlbum(currUser).get(i).getPlaylistName()))
//		 		 {
//		 			for(j = 0; j < generalModel.getInstance().gettingSongs(currUser).size(); j++)
//		 			{
//					 	if (comboBoxSongs.getSelectedItem().equals(generalModel.getInstance().gettingSongs(currUser).get(j).getSongName()))
//					 	{				
//					 		generalModel.getInstance().getUserAlbum(currUser).get(i).addSongToPlaylist(generalModel.getInstance().gettingSongs(currUser).remove(j));       
//					 		//System.out.print(generalModel.getInstance().getUserPlaylist(currUser).get(i).getSongInPlaylist().get(j).getSongName());
//					 		//System.out.print(pl.getPlaylistList().get(i).getSongInPlaylist().get(j).getSongName());
//					 		
//					 		
//					 	}
//		 			}
//		 		 }
//		 	 }
		 	 
		 	 
//		 		System.out.println("removed: ", generalModel.getInstance().getUserAlbum(currUser).get(comboBoxAlbums.getSelectedIndex()).getSongInPlaylist().get(0).getSongName());
		 	 
				
		 		dispose();
		 	 
		 	 
			 
		 }
	 }
}
