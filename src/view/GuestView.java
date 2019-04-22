package view;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import jaco.mp3.player.MP3Player;
import model.PlaylistList;
import model.SongList;
import view.AddSong;
import view.SelectAccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;


import jaco.mp3.player.MP3Player;
import model.PlaylistList;
import model.SongList;
import model.account;
import java.awt.Color;

public class GuestView extends JFrame {
	private volatile static GuestView instance = null;
	MP3Player mp3 = new MP3Player(new File("currentSong.mp3"));

	private JPanel contentPane;
	public String currentUser;
	JButton btnPickPlaylist, btnPickSong, btnCreatePlaylist, btnUploadSong, btnEditSong, btnPlay, btnPause, btnNextSong, btnPreviousSong;
	JList yourSongsList, playlistListJList, playlistSongList;
	JTextPane txtpnSongNameGenre;
	private JButton btnRefresh;
	JLabel lblUser;
	PlaylistList pl;
	
	public static GuestView getInstance() {
        if (instance == null) {
        	instance = new GuestView();
        }
		return instance;
	}

	public void setSong(String path) {
		mp3.stop();
		mp3 = new MP3Player(new File(path));
	}
	
	/**
	 * Create the frame.
	 */
	public GuestView() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuestView.class.getResource("/images/spotify.png")));
		setTitle("Not So Spotify");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 1189, 813);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36,36,36));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnPlay = new JButton("");
		 btnPlay.setIcon(new ImageIcon(GuestView.class.getResource("/images/play-button.png")));
		btnPlay.addActionListener(new btn_Play());
		btnPlay.setBounds(492, 681, 89, 45);
		btnPlay.setBackground(new Color(59,186,169));
		contentPane.add(btnPlay);
		
		 btnPause = new JButton("");
		 btnPause.setIcon(new ImageIcon(GuestView.class.getResource("/images/pause-button.png")));
		btnPause.addActionListener(new btn_Pause());
		btnPause.setBounds(593, 681, 89, 45);
		btnPause.setBackground(new Color(59,186,169));
		contentPane.add(btnPause);
		
		 btnNextSong = new JButton("");
		 btnNextSong.setIcon(new ImageIcon(GuestView.class.getResource("/images/skip-to-next-track.png")));
		btnNextSong.setBounds(705, 681, 89, 45);
		btnNextSong.setBackground(new Color(59,186,169));
		contentPane.add(btnNextSong);
		btnNextSong.addActionListener(new btn_nextSong());
		
		 btnPreviousSong = new JButton("");
		 btnPreviousSong.setIcon(new ImageIcon(GuestView.class.getResource("/images/back-track.png")));
		btnPreviousSong.setBounds(380, 681, 89, 45);
		btnPreviousSong.setBackground(new Color(59,186,169));
		contentPane.add(btnPreviousSong);
		btnPreviousSong.addActionListener(new btn_prevSong());
		
		playlistListJList = new JList();
		playlistListJList.setBounds(25, 93, 322, 558);
		playlistListJList.setBackground(new Color(224,224,224));
		contentPane.add(playlistListJList);
		//for(int x = 0; x < pl.getPlaylistSize() ;x++) {
		//	playlistListJList.add(playlistListJList.getComponent(x));
		//}
		
		 playlistSongList = new JList();
		playlistSongList.setBounds(395, 93, 375, 224);
		playlistSongList.setBackground(new Color(224,224,224));
		contentPane.add(playlistSongList);
		
		 btnPickPlaylist = new JButton("Pick Playlist");
		 btnPickPlaylist.setForeground(Color.BLACK);
		btnPickPlaylist.setBounds(25, 664, 136, 45);
		btnPickPlaylist.setBackground(new Color(59,186,169));
		contentPane.add(btnPickPlaylist);
		
		JButton btnPickSong = new JButton("Add Song to Playlist");
		btnPickSong.setForeground(Color.BLACK);
		btnPickSong.setBounds(957, 664, 190, 45);
		btnPickSong.setBackground(new Color(59,186,169));
		contentPane.add(btnPickSong);
		btnPickSong.addActionListener(new btn_addSongtoP());
		 
		txtpnSongNameGenre = new JTextPane();
		txtpnSongNameGenre.setBounds(395, 427, 375, 224);
		txtpnSongNameGenre.setText("Song Name: \r\nGenre: \r\n");
		txtpnSongNameGenre.setBackground(new Color(224,224,224));
		contentPane.add(txtpnSongNameGenre);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setForeground(Color.WHITE);
		lblSongInfo.setBounds(395, 390, 95, 26);
		lblSongInfo.setBackground(new Color(224,224,224));
		contentPane.add(lblSongInfo);
		
		btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.setForeground(Color.BLACK);
		btnCreatePlaylist.addActionListener(new btn_CreatePlaylist());
		btnCreatePlaylist.setBounds(25, 11, 118, 45);
		btnCreatePlaylist.setBackground(new Color(59,186,169));
		contentPane.add(btnCreatePlaylist);
		
		 btnUploadSong = new JButton("Upload Song");
		 btnUploadSong.setForeground(Color.BLACK);
		btnUploadSong.addActionListener(new btn_UploadSong());
		btnUploadSong.setBounds(1021, 11, 126, 45);
		btnUploadSong.setBackground(new Color(59,186,169));
		contentPane.add(btnUploadSong);
		
		 yourSongsList = new JList();
		yourSongsList.setBounds(806, 94, 341, 557);
		yourSongsList.setBackground(new Color(224,224,224));
		contentPane.add(yourSongsList);
		
		JLabel lblSongsInPlaylist = new JLabel("Songs in Playlist");
		lblSongsInPlaylist.setForeground(Color.WHITE);
		lblSongsInPlaylist.setBounds(395, 63, 101, 26);
		contentPane.add(lblSongsInPlaylist);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setForeground(Color.WHITE);
		lblPlaylists.setBounds(53, 69, 95, 14);
		contentPane.add(lblPlaylists);
		
		JLabel lblYourSongs = new JLabel("Your Songs");
		lblYourSongs.setForeground(Color.WHITE);
		lblYourSongs.setBounds(825, 69, 95, 14);
		contentPane.add(lblYourSongs);
		
		 btnEditSong = new JButton("Edit Song");
		 btnEditSong.setForeground(Color.BLACK);
		btnEditSong.setBounds(905, 11, 89, 45);
		contentPane.add(btnEditSong);
		btnEditSong.setBackground(new Color(59,186,169));
		btnEditSong.addActionListener(new btn_editsong());
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(Color.BLACK);
		btnRefresh.addActionListener(new btn_Refresh());
		btnRefresh.setBounds(154, 21, 97, 25);
		btnRefresh.setBackground(new Color(59,186,169));
		contentPane.add(btnRefresh);
		
		lblUser = new JLabel("Guest" );
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(492, 23, 201, 16);
		contentPane.add(lblUser);
		
		JButton shuffleButton = new JButton("");
		shuffleButton.setIcon(new ImageIcon(GuestView.class.getResource("/images/shuffle.png")));
		shuffleButton.setBounds(279, 681, 89, 45);
		shuffleButton.setBackground(new Color(59,186,169));
		contentPane.add(shuffleButton);
		shuffleButton.addActionListener(new btn_shuffle());
		
		JButton repeatButton = new JButton("");
		repeatButton.setIcon(new ImageIcon(GuestView.class.getResource("/images/repeat.png")));
		repeatButton.setBounds(806, 681, 89, 45);
		contentPane.add(repeatButton);
		repeatButton.setBackground(new Color(59,186,169));
		repeatButton.addActionListener(new btn_repeat());
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setForeground(Color.BLACK);
		logoutButton.setBounds(1050, 728, 97, 25);
		logoutButton.setBackground(new Color(59,186,169));
		contentPane.add(logoutButton);
		logoutButton.addActionListener(new btn_Logout());
	}
	
	 class btn_Play implements ActionListener 
	 {

	     public void actionPerformed(ActionEvent e) 
	     {	 
	    	 mp3.play();

	     }
	 }
	
	 class btn_addSongtoP implements ActionListener 
	 {

	     public void actionPerformed(ActionEvent e) 
	     {
	    	 AddSongToPlaylist astp = new AddSongToPlaylist();
			 astp.setVisible(true);
			 
			 SongList sList = new SongList();
			 PlaylistList pList = new PlaylistList();
			 
			 for(int x = 0; x < sList.getSongSize(); x++)
			 {
				 astp.comboBoxSongs.addItem(sList.getSongList().get(x).getSongName());;
			 }
			 
			 for(int y = 0; y < pList.getPlaylistSize(); y++)
			 {
				 astp.comboBoxPlaylists.addItem(pList.getPlaylistList().get(y).getPlaylistName());
			 }

	     }
	 }
	 
	 class btn_Pause implements ActionListener 
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 mp3.pause();
		 }
	 }
	 
	 class btn_shuffle implements ActionListener 
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			if(mp3.isShuffle())
			{
				mp3.setShuffle(true);
			}
			else 
			{
				mp3.setShuffle(false);
			}
		 
		 }
	 }
	 
	 class btn_repeat implements ActionListener 
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 mp3.setRepeat(true);
		 }
	 }
	 class btn_UploadSong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 AddSong.getInstance().setVisible(true);
		 }
	 }
	 
	 class btn_Refresh implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 
			 SongList sList = new SongList();
			 DefaultListModel DLM = new DefaultListModel();
			 
			 for(int x = 0; x < sList.getSongSize(); x++)
			 DLM.addElement(sList.getSongList().get(x).getSongName());

			 yourSongsList.setModel(DLM);
			 
			 PlaylistList pList = new PlaylistList();
			 DefaultListModel DLM2 = new DefaultListModel();
			 
			 for(int x = 0; x < pList.getPlaylistSize(); x++)
			 DLM2.addElement(pList.getPlaylistList().get(x).getPlaylistName());

			 playlistListJList.setModel(DLM2);
			 
			 DefaultListModel DLM3 = new DefaultListModel();
			 
			 for(int i = 0; i < pList.getPlaylistSize(); i++)
				 for(int j = 0; j <  sList.getSongSize(); j++)
				//	 DLM3.addElement(pList.getPlaylistList().get(i).getSongInPlaylist().get(j).getSongName());
			 
			 playlistSongList.setModel(DLM3);
			 
			 
		 }
	 }
	 
	 class btn_CreatePlaylist implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 CreatePlaylist cp = CreatePlaylist.getInstance();
			 cp.setVisible(true);
			 
			 
		 }
	 }
	 
	 class btn_Logout implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			JOptionPane.showMessageDialog(null,"You have been Logged out!");
			SelectAccount.getInstance().setVisible(true);
			closingWindow();
		 }
	 }
	 
	 class btn_editsong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			EditSongView.getInstance().setVisible(true);
			
		 }
	 }
	 
	 class btn_nextSong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			mp3.skipForward();
			
		 }
	 }
	 
	 class btn_prevSong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			mp3.skipBackward();
			
		 }
	 }
		public void closingWindow() {
			this.setVisible(false);
		}
		
		public void setUserName(String currentUser) {
			this.currentUser = currentUser;
			lblUser.setText("Current User: " + currentUser);
		}
}
