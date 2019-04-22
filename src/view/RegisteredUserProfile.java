package view;

import javax.swing.JFrame;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Playlist;
import model.PlaylistList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;


public class RegisteredUserProfile extends JFrame{
	private volatile static RegisteredUserProfile instance = null;
	public String currentUser;
	public JLabel lblUser;
	private JButton btnRefresh,btnFavoritePlaylist,btnFavoriteSong;
	ArrayList<Song> userSongs,userSongsFavorites;
	ArrayList<Playlist> userPlaylist,userPlaylistFavorites;
	PlaylistList pl;
	JList songJlist,playlistJList,FavoriteplaylistJList,FavoritesongJList, mostPlayedList;

	boolean songChanged;
	
	public static RegisteredUserProfile getInstance() {
        if (instance == null) {
        	instance = new RegisteredUserProfile();
        }
		return instance;
	}
	
	public RegisteredUserProfile() {
		getContentPane().setLayout(null);
		
		lblUser = new JLabel("User:" + currentUser );
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUser.setBounds(10, 34, 1071, 53);
		getContentPane().add(lblUser);
		
		JLabel lblPlaylists = new JLabel("Playlist/s");
		lblPlaylists.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylists.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlaylists.setBounds(84, 133, 202, 53);
		getContentPane().add(lblPlaylists);
		
		JLabel lblSongs = new JLabel("Song/s");
		lblSongs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSongs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSongs.setBounds(765, 133, 202, 53);
		getContentPane().add(lblSongs);
		
		playlistJList = new JList();
		playlistJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
		});
		playlistJList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		playlistJList.setBounds(10, 173, 355, 190);
		getContentPane().add(playlistJList);
		
		songJlist = new JList();
		songJlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
		});
		songJlist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		songJlist.setBounds(726, 184, 355, 109);
		getContentPane().add(songJlist);
		
		btnFavoritePlaylist = new JButton("Favorite Playlist");
		btnFavoritePlaylist.setBounds(108, 69, 139, 53);
		getContentPane().add(btnFavoritePlaylist);
		btnFavoritePlaylist.addActionListener((ActionListener) new btn_FavoritePlaylist());
		
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(477, 170, 139, 53);
		getContentPane().add(btnRefresh);
		
		JLabel lblFavoritePlaylists = new JLabel("Favorite Playlist/s");
		lblFavoritePlaylists.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritePlaylists.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFavoritePlaylists.setBounds(84, 388, 202, 53);
		getContentPane().add(lblFavoritePlaylists);
		
		FavoriteplaylistJList = new JList();
		FavoriteplaylistJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
		});
		FavoriteplaylistJList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		FavoriteplaylistJList.setBounds(10, 430, 355, 190);
		getContentPane().add(FavoriteplaylistJList);
		
		btnFavoriteSong = new JButton("Favorite Song");
		btnFavoriteSong.setBounds(726, 69, 139, 53);
		getContentPane().add(btnFavoriteSong);
		
		FavoritesongJList = new JList();
		FavoriteplaylistJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
			}
		});
		FavoritesongJList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		FavoritesongJList.setBounds(726, 332, 355, 109);
		getContentPane().add(FavoritesongJList);
		
		JLabel lblFavoriteSongs = new JLabel("Favorite Song/s");
		lblFavoriteSongs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoriteSongs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFavoriteSongs.setBounds(765, 292, 202, 53);
		getContentPane().add(lblFavoriteSongs);
		
		JButton btnMostplayed = new JButton("MostPlayed");
		btnMostplayed.addActionListener(new btn_MostPlayed());
		btnMostplayed.setBounds(477, 251, 139, 53);
		getContentPane().add(btnMostplayed);
		
		 mostPlayedList = new JList();
		mostPlayedList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mostPlayedList.setBounds(477, 315, 139, 84);
		getContentPane().add(mostPlayedList);
		btnFavoriteSong.addActionListener((ActionListener) new btn_FavoriteSong());

		
		
		JLabel songCount = new JLabel("Most Played Song/s");
		songCount.setHorizontalAlignment(SwingConstants.CENTER);
		songCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		songCount.setBounds(765, 447, 202, 53);
		getContentPane().add(songCount);
		
		JButton btnCount = new JButton("Sort High Song Count");
		btnCount.setBounds(897, 69, 139, 53);
		getContentPane().add(btnCount);
		
		btnFavoriteSong.addActionListener((ActionListener) new btn_FavoriteSong());
		
		btnRefresh.addActionListener((ActionListener) new btn_Refresh());
		
		this.setSize(1100, 700);
	}
	
	class btn_Refresh implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			//============================================== General Songs
			userSongs = generalModel.getInstance().gettingSongs(currentUser);
			
			DefaultListModel DLM = new DefaultListModel();
			
			for(int x = 0; x < userSongs.size();x++)
				DLM.addElement(userSongs.get(x).getSongName());
			
			songJlist.setModel(DLM);
			
			//============================================== General Playlists
			userPlaylist = generalModel.getInstance().gettingPlaylists(currentUser);
			
			DefaultListModel DLM2 = new DefaultListModel();
			
			for(int y = 0; y < userPlaylist.size(); y++)
				DLM2.addElement(userPlaylist.get(y).getPlaylistName());
			
			playlistJList.setModel(DLM2);
			
			//============================================== Favorite Playlists
			userPlaylistFavorites = generalModel.getInstance().gettingFavoritePlaylist(currentUser);
			
			DefaultListModel DLM3 = new DefaultListModel();
			
			for(int w = 0; w < userPlaylistFavorites.size(); w++)
				DLM3.addElement(userPlaylistFavorites.get(w).getPlaylistName());
			
			FavoriteplaylistJList.setModel(DLM3);
			
			
			SongList sList = new SongList();
			PlaylistList pList1 = new PlaylistList();
			
			//============================================== Favorite Playlists
			userSongsFavorites = generalModel.getInstance().gettingFavoriteSong(currentUser);
			
			DefaultListModel DLM4 = new DefaultListModel();
			
			for(int a = 0; a < userSongsFavorites.size();a++)
				DLM4.addElement(userSongsFavorites.get(a).getSongName());
			
			FavoritesongJList.setModel(DLM4);
			
			//============================================== Most Played Song
			
			userSongs = generalModel.getInstance().getMostPlayed(currentUser);
			DefaultListModel DLM5 = new DefaultListModel();
			
			DLM5.addElement(userSongs.get(0).getSongName());
			
			 
			mostPlayedList.setModel(DLM5);
		}
	}
	
	class btn_FavoritePlaylist implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String playlistOfUser = userPlaylist.get(playlistJList.getSelectedIndex()).getUsername();
			String playlistName = userPlaylist.get(playlistJList.getSelectedIndex()).getPlaylistName();
			
			generalModel.getInstance().favoritingPlaylist(playlistOfUser,playlistName);
		}
	}	
	
	class btn_FavoriteSong implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String songOfUser = userSongs.get(songJlist.getSelectedIndex()).getUserName();
			String songName = userSongs.get(songJlist.getSelectedIndex()).getSongName();
			
			generalModel.getInstance().favoritingSongs(songOfUser, songName);
		}
	}
	

	class btn_MostPlayed implements ActionListener

	{
		
		public void actionPerformed(ActionEvent e)
		{

			userSongs = generalModel.getInstance().getMostPlayed(currentUser);
			DefaultListModel DLM = new DefaultListModel();
			
			DLM.addElement(userSongs.get(0).getSongName());
		
			mostPlayedList.setModel(DLM);

		}
	}
	
	public void getUserName(String currentUser) {
		this.currentUser = currentUser;
		lblUser.setText("User: " + currentUser);
	}
}
