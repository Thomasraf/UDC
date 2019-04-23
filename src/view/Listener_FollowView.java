package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Playlist;
import model.Song;
import model.generalModel;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;


import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Listener_FollowView extends JFrame {

	private JPanel contentPane;
	boolean evenClick = false;
	boolean evenClick2 = false;

	JList playlistJList,songJList;
	ArrayList<Song> userSongs;
	ArrayList<Playlist> userPlaylists;
	JButton btnFollow,Refreshbtn;
	String searchingText,currentUser;

	
	private volatile static Listener_FollowView instance = null;
	public static Listener_FollowView getInstance() {
        if (instance == null) {
        	instance = new Listener_FollowView();
        }
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public Listener_FollowView() {
		setBackground(new Color(254,254,250));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 700);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254,254,250));
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MainRectangle = new JPanel();
		MainRectangle.setBackground(new Color(30,58,42));
		MainRectangle.setBounds(110, 579, 1036, 92);
		contentPane.add(MainRectangle);
		MainRectangle.setLayout(null);
		
		JPanel SongDetails = new JPanel();
		SongDetails.setBackground(new Color(30,58,42));
		SongDetails.setBounds(0, 0, 147, 101);
		MainRectangle.add(SongDetails);
		SongDetails.setLayout(null);
		
		JLabel SongName = new JLabel("(Song Name)");
		SongName.setHorizontalAlignment(SwingConstants.CENTER);
		SongName.setForeground(new Color(255, 255, 255));
		SongName.setFont(new Font("Calibri", Font.PLAIN, 14));
		SongName.setBounds(0, 0, 147, 40);
		SongDetails.add(SongName);
		
		JLabel Artist = new JLabel("(Artist)");
		Artist.setHorizontalAlignment(SwingConstants.CENTER);
		Artist.setForeground(Color.WHITE);
		Artist.setFont(new Font("Calibri", Font.PLAIN, 12));
		Artist.setBounds(0, 39, 147, 28);
		SongDetails.add(Artist);
		
		JLabel Album = new JLabel("(Album)");
		Album.setHorizontalAlignment(SwingConstants.CENTER);
		Album.setForeground(Color.WHITE);
		Album.setFont(new Font("Calibri", Font.PLAIN, 12));
		Album.setBounds(0, 62, 147, 28);
		SongDetails.add(Album);
		
		JButton Shufflebtn = new JButton("");
		Shufflebtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/shuffle (4).png")));
		Shufflebtn.setBackground(new Color(30,58,42));
		Shufflebtn.setBounds(290, 31, 39, 39);
		Shufflebtn.setBorder(null);
		MainRectangle.add(Shufflebtn);
		
		JButton Nextbtn = new JButton("");
		Nextbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/next (2).png")));
		Nextbtn.setBackground(new Color(30, 58, 42));
		Nextbtn.setBounds(512, 31, 39, 39);
		Nextbtn.setBorder(null);
		MainRectangle.add(Nextbtn);
		
		JButton Prevbtn = new JButton("");
		Prevbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/back (2).png")));
		Prevbtn.setBackground(new Color(30, 58, 42));
		Prevbtn.setBounds(355, 31, 39, 39);
		Prevbtn.setBorder(null);
		MainRectangle.add(Prevbtn);
		
		JButton Playbtn = new JButton("");
		Playbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/play-button (2).png")));
		Playbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(evenClick) {
				Playbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/play-button (2).png")));
				evenClick = false;
			}
				else {
					Playbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/rounded-pause-button.png")));
					evenClick = true;
				}
				}
		});
		Playbtn.setBounds(413, 15, 78, 70);
		Playbtn.setBackground(new Color(30, 58, 42));
		Playbtn.setBorder(null);
		MainRectangle.add(Playbtn);
		
		JButton Repeatbtn = new JButton("");
		Repeatbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/repeat.png")));
		Repeatbtn.setBackground(new Color(30, 58, 42));
		Repeatbtn.setBounds(577, 31, 39, 39);
		Repeatbtn.setBorder(null);
		MainRectangle.add(Repeatbtn);
		
		JButton Queuebtn = new JButton("");
		Queuebtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/list (1).png")));
		Queuebtn.setBorder(null);
		Queuebtn.setBackground(new Color(30, 58, 42));
		Queuebtn.setBounds(769, 31, 39, 39);
		MainRectangle.add(Queuebtn);
		
		JButton StopBtn = new JButton("");
		StopBtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/stop (3).png")));
		StopBtn.setBorder(null);
		StopBtn.setBackground(new Color(30, 58, 42));
		StopBtn.setBounds(818, 31, 39, 39);
		MainRectangle.add(StopBtn);
		
		JButton Volumebtn = new JButton("");
		Volumebtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/speaker (2).png")));
		Volumebtn.setBorder(null);
		Volumebtn.setBackground(new Color(30, 58, 42));
		Volumebtn.setBounds(867, 31, 39, 39);
		MainRectangle.add(Volumebtn);
		
		
		JButton NewAlbumPic = new JButton("");
		NewAlbumPic.setIcon(new ImageIcon(HomeView.class.getResource("/images2/photo.png")));
		NewAlbumPic.setBounds(0, 579, 119, 92);
		contentPane.add(NewAlbumPic);
		NewAlbumPic.setBackground(new Color(170, 187, 204));
		
		JPanel TopBar = new JPanel();
		TopBar.setBackground(new Color(30, 58, 42));
		TopBar.setBounds(0, 0, 1152, 61);
		contentPane.add(TopBar);
		TopBar.setLayout(null);
		
		JButton button = new JButton("");
		button.setBounds(10, 11, 39, 39);
		button.setIcon(new ImageIcon(HomeView.class.getResource("/images2/expand-button.png")));
		button.setBorder(null);
		button.setBackground(new Color(30, 58, 42));
		TopBar.add(button);
		
		JButton SearchBtn = new JButton("");
		SearchBtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/magnifying-glass (1).png")));
		SearchBtn.setBorder(null);
		SearchBtn.setBackground(new Color(30,58,42));
		SearchBtn.setBounds(55, 11, 39, 39);
		SearchBtn.setBorder(null);
		TopBar.add(SearchBtn);
		
		JButton ProfilePic = new JButton("");
		ProfilePic.setIcon(new ImageIcon(HomeView.class.getResource("/images2/user-avatar-main-picture.png")));
		ProfilePic.setBounds(478, 10, 40, 40);
		TopBar.add(ProfilePic);
		ProfilePic.setBackground(new Color(170, 187, 204));
		
		JButton Profile = new JButton("Profile Name");
		Profile.setBackground(new Color(30,58,42));
		Profile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Profile.setForeground(Color.WHITE);
		Profile.setBounds(520, 19, 145, 23);
		Profile.setBorder(null);
		TopBar.add(Profile);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(HomeView.class.getResource("/images2/notifications-button.png")));
		button_2.setBorder(null);
		button_2.setBackground(new Color(30, 58, 42));
		button_2.setBounds(1084, 11, 39, 39);
		TopBar.add(button_2);
		

		Refreshbtn = new JButton("");

		Refreshbtn.setIcon(new ImageIcon(Listener_FollowView.class.getResource("/images2/reload.png")));
		Refreshbtn.setBorder(null);
		Refreshbtn.setBackground(new Color(30, 58, 42));
		Refreshbtn.setBounds(1035, 11, 39, 39);
		TopBar.add(Refreshbtn);

		Refreshbtn.addActionListener(new btn_Refresh());

		
		JPanel MusicPanel = new JPanel();
		MusicPanel.setBackground(new Color(254, 254, 250));
		MusicPanel.setBounds(0, 62, 186, 514);
		contentPane.add(MusicPanel);
		MusicPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("New Playlist");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(HomeView.class.getResource("/images2/add-circular-outlined-button (1).png")));
		btnNewButton.setBounds(0, 429, 186, 88);
		MusicPanel.add(btnNewButton);
		
		JLabel MusicLbl = new JLabel("Music");
		MusicLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MusicLbl.setBackground(new Color(254, 254, 250));
		MusicLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MusicLbl.setBounds(0, 0, 186, 34);
		MusicPanel.add(MusicLbl);
		
		JButton Library = new JButton("Library");
		Library.setBackground(new Color(242, 203, 155));
		Library.setHorizontalAlignment(SwingConstants.LEFT);
		Library.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Library.setBounds(0, 33, 186, 30);
		MusicPanel.add(Library);
		
		JButton Artist_Music = new JButton("Artist");
		Artist_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Artist_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artist_Music.setBackground(new Color(254, 254, 250));
		Artist_Music.setBounds(0, 62, 186, 30);
		MusicPanel.add(Artist_Music);
		
		JButton Genre_Music = new JButton("Genre");
		Genre_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Genre_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genre_Music.setBackground(new Color(254, 254, 250));
		Genre_Music.setBounds(0, 119, 186, 30);
		MusicPanel.add(Genre_Music);
		
		JButton Albums_Music = new JButton("Albums");
		Albums_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Albums_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Albums_Music.setBackground(new Color(242, 203, 155));
		Albums_Music.setBounds(0, 90, 186, 30);
		MusicPanel.add(Albums_Music);
		
		JButton Playlist_Name3 = new JButton("");
		Playlist_Name3.setEnabled(false);
		Playlist_Name3.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name3.setBackground(new Color(254, 254, 250));
		Playlist_Name3.setBounds(0, 232, 186, 30);
		MusicPanel.add(Playlist_Name3);
		
		JButton Playlist_Name2 = new JButton("");
		Playlist_Name2.setEnabled(false);
		Playlist_Name2.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name2.setBackground(new Color(242, 203, 155));
		Playlist_Name2.setBounds(0, 203, 186, 30);
		MusicPanel.add(Playlist_Name2);
		
		JButton Playlist_Name1 = new JButton("");
		Playlist_Name1.setEnabled(false);
		Playlist_Name1.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name1.setBackground(new Color(254, 254, 250));
		Playlist_Name1.setBounds(0, 175, 186, 30);
		MusicPanel.add(Playlist_Name1);
		
		JButton Playlists_Music = new JButton("Playlists");
		Playlists_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Playlists_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlists_Music.setBackground(new Color(242, 203, 155));
		Playlists_Music.setBounds(0, 146, 186, 30);
		MusicPanel.add(Playlists_Music);
		
		JButton Playlist_Name7 = new JButton("");
		Playlist_Name7.setEnabled(false);
		Playlist_Name7.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name7.setBackground(new Color(254, 254, 250));
		Playlist_Name7.setBounds(0, 344, 186, 30);
		MusicPanel.add(Playlist_Name7);
		
		JButton Playlist_Name6 = new JButton("");
		Playlist_Name6.setEnabled(false);
		Playlist_Name6.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name6.setBackground(new Color(242, 203, 155));
		Playlist_Name6.setBounds(0, 315, 186, 30);
		MusicPanel.add(Playlist_Name6);
		
		JButton Playlist_Name5 = new JButton("");
		Playlist_Name5.setEnabled(false);
		Playlist_Name5.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name5.setBackground(new Color(254, 254, 250));
		Playlist_Name5.setBounds(0, 287, 186, 30);
		MusicPanel.add(Playlist_Name5);
		
		JButton Playlist_Name4 = new JButton("");
		Playlist_Name4.setEnabled(false);
		Playlist_Name4.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name4.setBackground(new Color(242, 203, 155));
		Playlist_Name4.setBounds(0, 258, 186, 30);
		MusicPanel.add(Playlist_Name4);
		
		JButton Playlist_Name9 = new JButton("");
		Playlist_Name9.setEnabled(false);
		Playlist_Name9.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name9.setBackground(new Color(254, 254, 250));
		Playlist_Name9.setBounds(0, 401, 186, 30);
		MusicPanel.add(Playlist_Name9);
		
		JButton Playlist_Name8 = new JButton("");
		Playlist_Name8.setEnabled(false);
		Playlist_Name8.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name8.setBackground(new Color(242, 203, 155));
		Playlist_Name8.setBounds(0, 372, 186, 30);
		MusicPanel.add(Playlist_Name8);
		
		JList Playlist_list = new JList();
		Playlist_list.setBounds(0, 175, 186, 256);
		MusicPanel.add(Playlist_list);
		
		JPanel RecentlyPlayedPanel = new JPanel();
		RecentlyPlayedPanel.setLayout(null);
		RecentlyPlayedPanel.setBackground(new Color(254, 254, 250));
		RecentlyPlayedPanel.setBounds(960, 62, 186, 514);
		contentPane.add(RecentlyPlayedPanel);
		
		JLabel label = new JLabel("Favorite Songs");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBackground(new Color(254, 254, 250));
		label.setBounds(0, 0, 186, 34);
		RecentlyPlayedPanel.add(label);
		
		JButton RPSONG_1 = new JButton("");
		RPSONG_1.setEnabled(false);
		RPSONG_1.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_1.setBackground(new Color(242, 203, 155));
		RPSONG_1.setBounds(0, 33, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_1);
		
		JButton RPSONG_2 = new JButton("");
		RPSONG_2.setEnabled(false);
		RPSONG_2.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_2.setBackground(new Color(254, 254, 250));
		RPSONG_2.setBounds(0, 62, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_2);
		
		JButton RPSONG_4 = new JButton("");
		RPSONG_4.setEnabled(false);
		RPSONG_4.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_4.setBackground(new Color(254, 254, 250));
		RPSONG_4.setBounds(0, 119, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_4);
		
		JButton RPSONG_3 = new JButton("");
		RPSONG_3.setEnabled(false);
		RPSONG_3.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_3.setBackground(new Color(242, 203, 155));
		RPSONG_3.setBounds(0, 90, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_3);
		
		JButton RPSONG_7 = new JButton("");
		RPSONG_7.setEnabled(false);
		RPSONG_7.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_7.setBackground(new Color(242, 203, 155));
		RPSONG_7.setBounds(0, 203, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_7);
		
		JButton RPSONG_6 = new JButton("");
		RPSONG_6.setEnabled(false);
		RPSONG_6.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_6.setBackground(new Color(254, 254, 250));
		RPSONG_6.setBounds(0, 175, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_6);
		
		JButton RPSONG_5 = new JButton("");
		RPSONG_5.setEnabled(false);
		RPSONG_5.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_5.setBackground(new Color(242, 203, 155));
		RPSONG_5.setBounds(0, 146, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_5);
		
		JButton MPSONG_3 = new JButton("");
		MPSONG_3.setEnabled(false);
		MPSONG_3.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_3.setBackground(new Color(254, 254, 250));
		MPSONG_3.setBounds(0, 344, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_3);
		
		JButton MPSONG_2 = new JButton("");
		MPSONG_2.setEnabled(false);
		MPSONG_2.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_2.setBackground(new Color(242, 203, 155));
		MPSONG_2.setBounds(0, 315, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_2);
		
		JButton MPSONG_1 = new JButton("");
		MPSONG_1.setEnabled(false);
		MPSONG_1.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_1.setBackground(new Color(254, 254, 250));
		MPSONG_1.setBounds(0, 287, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_1);
		
		JButton MPSONG_5 = new JButton("");
		MPSONG_5.setEnabled(false);
		MPSONG_5.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_5.setBackground(new Color(254, 254, 250));
		MPSONG_5.setBounds(0, 401, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_5);
		
		JButton MPSONG_4 = new JButton("");
		MPSONG_4.setEnabled(false);
		MPSONG_4.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_4.setBackground(new Color(242, 203, 155));
		MPSONG_4.setBounds(0, 372, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_4);
		
		JButton AddSongbtn = new JButton("Add Song");
		AddSongbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/add-circular-outlined-button (1).png")));
		AddSongbtn.setHorizontalAlignment(SwingConstants.LEFT);
		AddSongbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AddSongbtn.setBounds(0, 426, 186, 88);
		RecentlyPlayedPanel.add(AddSongbtn);
		
		JLabel MostPlayedSongs = new JLabel("Most Played ");
		MostPlayedSongs.setHorizontalAlignment(SwingConstants.CENTER);
		MostPlayedSongs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MostPlayedSongs.setBackground(new Color(254, 254, 250));
		MostPlayedSongs.setBounds(0, 231, 186, 61);
		RecentlyPlayedPanel.add(MostPlayedSongs);
		
		JList FaveSongslist = new JList();
		FaveSongslist.setBounds(0, 33, 186, 200);
		RecentlyPlayedPanel.add(FaveSongslist);
		
		JList MostPlayed_list = new JList();
		MostPlayed_list.setBounds(0, 291, 186, 140);
		RecentlyPlayedPanel.add(MostPlayed_list);
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(254, 254, 250));
		Dashboard.setBorder(null);
		Dashboard.setBounds(196, 72, 754, 496);
		contentPane.add(Dashboard);
		Dashboard.setLayout(null);
		
		JLabel DP_Listener = new JLabel("DP");
		//DP_Listener.setIcon(new ImageIcon(HomeView.class.getResource("/images2/KDRLK.png")));
		DP_Listener.setBackground(new Color(254,254,250));
		DP_Listener.setHorizontalAlignment(SwingConstants.CENTER);
		DP_Listener.setBounds(10, 0, 164, 164);
		Dashboard.add(DP_Listener);
		
		JLabel lblProfileDetails = new JLabel("(Playlist details)");
		lblProfileDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfileDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfileDetails.setBackground(new Color(254, 254, 250));
		lblProfileDetails.setBounds(184, 82, 377, 55);
		Dashboard.add(lblProfileDetails);
		
		JButton ProfileName_Dashboard = new JButton("Profile Name");
		ProfileName_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		ProfileName_Dashboard.setForeground(Color.BLACK);
		ProfileName_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ProfileName_Dashboard.setBorder(null);
		ProfileName_Dashboard.setBackground(new Color(254,254,250));
		ProfileName_Dashboard.setBounds(184, 11, 305, 60);
		Dashboard.add(ProfileName_Dashboard);
		
		JButton FavePlaylists_Dashboard = new JButton("Public Playlists");
		FavePlaylists_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		FavePlaylists_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		FavePlaylists_Dashboard.setBackground(new Color(254, 254, 250));

		FavePlaylists_Dashboard.setBounds(0, 170, 377, 30);
		Dashboard.add(FavePlaylists_Dashboard);
		
		JButton LFollow_Dashboard = new JButton("My Songs");

		LFollow_Dashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LFollow_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		LFollow_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LFollow_Dashboard.setBackground(new Color(254, 254, 250));

		LFollow_Dashboard.setBounds(377, 170, 377, 30);
		Dashboard.add(LFollow_Dashboard);
		

		JList LFollow1 = new JList();
		LFollow1.setBackground(new Color(254,254,250));
		LFollow1.setBounds(418, 199, 164, 30);
		Dashboard.add(LFollow1);
		
		JList AFollow1 = new JList();
		AFollow1.setBackground(new Color(254, 254, 250));
		AFollow1.setBounds(580, 199, 164, 30);
		Dashboard.add(AFollow1);
		
		JList LFollow2 = new JList();
		LFollow2.setBackground(new Color(254, 254, 250));
		LFollow2.setBounds(418, 229, 164, 30);
		Dashboard.add(LFollow2);
		
		JList AFollow2 = new JList();
		AFollow2.setBackground(new Color(254, 254, 250));
		AFollow2.setBounds(580, 229, 164, 30);
		Dashboard.add(AFollow2);
		
		JList LFollow3 = new JList();
		LFollow3.setBackground(new Color(254, 254, 250));
		LFollow3.setBounds(418, 262, 164, 30);
		Dashboard.add(LFollow3);
		
		JList AFollow3 = new JList();
		AFollow3.setBackground(new Color(254, 254, 250));
		AFollow3.setBounds(580, 262, 164, 30);
		Dashboard.add(AFollow3);
		
		JList LFollow4 = new JList();
		LFollow4.setBackground(new Color(254, 254, 250));
		LFollow4.setBounds(418, 292, 164, 30);
		Dashboard.add(LFollow4);
		
		JList AFollow4 = new JList();
		AFollow4.setBackground(new Color(254, 254, 250));
		AFollow4.setBounds(580, 292, 164, 30);
		Dashboard.add(AFollow4);
		
		JList LFollow5 = new JList();
		LFollow5.setBackground(new Color(254, 254, 250));
		LFollow5.setBounds(418, 323, 164, 30);
		Dashboard.add(LFollow5);
		
		JList AFollow5 = new JList();
		AFollow5.setBackground(new Color(254, 254, 250));
		AFollow5.setBounds(580, 323, 164, 30);
		Dashboard.add(AFollow5);
		
		JList LFollow6 = new JList();
		LFollow6.setBackground(new Color(254, 254, 250));
		LFollow6.setBounds(418, 353, 164, 30);
		Dashboard.add(LFollow6);
		
		JList AFollow6 = new JList();
		AFollow6.setBackground(new Color(254, 254, 250));
		AFollow6.setBounds(580, 353, 164, 30);
		Dashboard.add(AFollow6);
		
		JList LFollow7 = new JList();
		LFollow7.setBackground(new Color(254, 254, 250));
		LFollow7.setBounds(418, 386, 164, 30);
		Dashboard.add(LFollow7);
		
		JList AFollow7 = new JList();
		AFollow7.setBackground(new Color(254, 254, 250));
		AFollow7.setBounds(580, 386, 164, 30);
		Dashboard.add(AFollow7);
		
		JList LFollow8 = new JList();
		LFollow8.setBackground(new Color(254, 254, 250));
		LFollow8.setBounds(418, 416, 164, 30);
		Dashboard.add(LFollow8);
		
		JList AFollow8 = new JList();
		AFollow8.setBackground(new Color(254, 254, 250));
		AFollow8.setBounds(580, 416, 164, 30);
		Dashboard.add(AFollow8);
		
		JList LFollow9 = new JList();
		LFollow9.setBackground(new Color(254, 254, 250));
		LFollow9.setBounds(418, 444, 164, 30);
		Dashboard.add(LFollow9);
		
		JList AFollow9 = new JList();
		AFollow9.setBackground(new Color(254, 254, 250));
		AFollow9.setBounds(580, 444, 164, 30);
		Dashboard.add(AFollow9);
		

		btnFollow = new JButton("Follow");

		btnFollow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(evenClick2) {
				btnFollow.setText("FOLLOW");
				evenClick = false;
			}
				else {
					btnFollow.setText("UNFOLLOW");
					evenClick2 = true;
				}
				}
		});
		btnFollow.setForeground(Color.WHITE);
		btnFollow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFollow.setBackground(Color.BLACK);
		btnFollow.setBounds(603, 126, 136, 35);
		Dashboard.add(btnFollow);
		

		playlistJList = new JList();
		playlistJList.setBounds(0, 203, 369, 293);
		Dashboard.add(playlistJList);
		
		songJList = new JList();
		songJList.setBounds(387, 204, 367, 288);
		Dashboard.add(songJList);
	}
	
	class btn_Refresh implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userPlaylists = generalModel.getInstance().gettingPrivatePlaylists(searchingText);
			
			DefaultListModel DLM1 = new DefaultListModel();
			
			for(int a = 0; a < userPlaylists.size(); a++)
				DLM1.addElement(userPlaylists.get(a).getPlaylistName());
			
			playlistJList.setModel(DLM1);
			
			//=========================================================================================
			
			userSongs = generalModel.getInstance().gettingSongs(currentUser);
			
			DefaultListModel DLM2 = new DefaultListModel();
			
			for(int b = 0; b < userSongs.size();b++)
				DLM2.addElement(userSongs.get(b).getSongName());
			
			songJList.setModel(DLM2);
		}
	}
	
	public void setText(String searchText) {
		this.searchingText = searchText;
	}
	
	public void setUsername(String username) {
		this.currentUser = username;

	}
}
