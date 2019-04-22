package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;


import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AlbumView extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	boolean evenClick = false;
	String currentUser;
	private JPanel MainRectangle, SongDetails,  TopBar, MusicPanel, RecentlyPlayedPanel, Dashboard;
	JList Playlist_List, RecentlyPlayedList, RP_List, MP_List;
	JLabel 	SongName, Artist, Album, MusicLbl, label, MostPlayedSongs,
			AlbumArt_1, AlbumArt_2, AlbumArt_3, AlbumArt_4,
			AlbumArt_5, AlbumArt_6, lblMadeForYou;
	JButton Shufflebtn, Nextbtn, Prevbtn, Playbtn, Repeatbtn, Queuebtn, 
			StopBtn, Volumebtn, NewAlbumPic, btnLogout, SearchBtn, ProfilePic, 
			Profile, Notificationbtn, Refreshbtn, verified, btnNewButton,
			Library, Artist_Music, Genre_Music, Albums_Music, Playlist_Name3,
			Playlist_Name2, Playlist_Name1, Playlists_Music, Playlist_Name7, 
			Playlist_Name6, Playlist_Name5, Playlist_Name4, Playlist_Name9, 
			Playlist_Name8, RPSONG_1, RPSONG_2, RPSONG_3, RPSONG_4, RPSONG_5,
			RPSONG_6, RPSONG_7, MPSONG_1, MPSONG_2, MPSONG_3, MPSONG_4, MPSONG_5,
			AddSongbtn, AlbumName_1, AlbumName_2, AlbumName_3, AlbumName_4, AlbumName_5,
			AlbumName_6;
	
	ArtistView profileView = ArtistView.getInstance();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeViewA frame = new HomeViewA();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
private volatile static AlbumView modelInstance = null;
	
	public static AlbumView getInstance() {
        if (modelInstance == null) {
        	modelInstance = new AlbumView();
        }
		return modelInstance;
	
	}

	
	
	/**
	 * Create the frame.
	 */
	private AlbumView() {
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
		
		MainRectangle = new JPanel();
		MainRectangle.setBackground(new Color(30,58,42));
		MainRectangle.setBounds(110, 579, 1036, 92);
		contentPane.add(MainRectangle);
		MainRectangle.setLayout(null);
		
		SongDetails = new JPanel();
		SongDetails.setBackground(new Color(30,58,42));
		SongDetails.setBounds(0, 0, 147, 101);
		MainRectangle.add(SongDetails);
		SongDetails.setLayout(null);
		
		SongName = new JLabel("(Song Name)");
		SongName.setHorizontalAlignment(SwingConstants.CENTER);
		SongName.setForeground(new Color(255, 255, 255));
		SongName.setFont(new Font("Calibri", Font.PLAIN, 14));
		SongName.setBounds(0, 0, 147, 40);
		SongDetails.add(SongName);
		
		Artist = new JLabel("(Artist)");
		Artist.setHorizontalAlignment(SwingConstants.CENTER);
		Artist.setForeground(Color.WHITE);
		Artist.setFont(new Font("Calibri", Font.PLAIN, 12));
		Artist.setBounds(0, 39, 147, 28);
		SongDetails.add(Artist);
		
		Album = new JLabel("(Album)");
		Album.setHorizontalAlignment(SwingConstants.CENTER);
		Album.setForeground(Color.WHITE);
		Album.setFont(new Font("Calibri", Font.PLAIN, 12));
		Album.setBounds(0, 62, 147, 28);
		SongDetails.add(Album);
		
		Shufflebtn = new JButton("");
		Shufflebtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/shuffle (4).png")));
		Shufflebtn.setBackground(new Color(30,58,42));
		Shufflebtn.setBounds(290, 31, 39, 39);
		Shufflebtn.setBorder(null);
		MainRectangle.add(Shufflebtn);
		
		Nextbtn = new JButton("");
		Nextbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/next (2).png")));
		Nextbtn.setBackground(new Color(30, 58, 42));
		Nextbtn.setBounds(512, 31, 39, 39);
		Nextbtn.setBorder(null);
		MainRectangle.add(Nextbtn);
		
		Prevbtn = new JButton("");
		Prevbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/back (2).png")));
		Prevbtn.setBackground(new Color(30, 58, 42));
		Prevbtn.setBounds(355, 31, 39, 39);
		Prevbtn.setBorder(null);
		MainRectangle.add(Prevbtn);
		
		Playbtn = new JButton("");
		Playbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/play-button (2).png")));
		Playbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(evenClick) {
				Playbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/play-button (2).png")));
				evenClick = false;
			}
				else {
					Playbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/rounded-pause-button.png")));
					evenClick = true;
				}
				}
		});
		Playbtn.setBounds(413, 15, 78, 70);
		Playbtn.setBackground(new Color(30, 58, 42));
		Playbtn.setBorder(null);
		MainRectangle.add(Playbtn);
		
		Repeatbtn = new JButton("");
		Repeatbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/repeat.png")));
		Repeatbtn.setBackground(new Color(30, 58, 42));
		Repeatbtn.setBounds(577, 31, 39, 39);
		Repeatbtn.setBorder(null);
		MainRectangle.add(Repeatbtn);
		
		Queuebtn = new JButton("");
		Queuebtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/list (1).png")));
		Queuebtn.setBorder(null);
		Queuebtn.setBackground(new Color(30, 58, 42));
		Queuebtn.setBounds(769, 31, 39, 39);
		MainRectangle.add(Queuebtn);
		
		StopBtn = new JButton("");
		StopBtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/stop (3).png")));
		StopBtn.setBorder(null);
		StopBtn.setBackground(new Color(30, 58, 42));
		StopBtn.setBounds(818, 31, 39, 39);
		MainRectangle.add(StopBtn);
		
		Volumebtn = new JButton("");
		Volumebtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/speaker (2).png")));
		Volumebtn.setBorder(null);
		Volumebtn.setBackground(new Color(30, 58, 42));
		Volumebtn.setBounds(867, 31, 39, 39);
		MainRectangle.add(Volumebtn);
		
		
		NewAlbumPic = new JButton("");
		NewAlbumPic.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/photo.png")));
		NewAlbumPic.setBounds(0, 579, 119, 92);
		contentPane.add(NewAlbumPic);
		NewAlbumPic.setBackground(new Color(170, 187, 204));
		
		TopBar = new JPanel();
		TopBar.setBackground(new Color(30, 58, 42));
		TopBar.setBounds(0, 0, 1152, 61);
		contentPane.add(TopBar);
		TopBar.setLayout(null);
		
		btnLogout = new JButton("");
		btnLogout.setBounds(10, 11, 39, 39);
		btnLogout.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/logout.png")));
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(30, 58, 42));
		TopBar.add(btnLogout);
		
		txtSearch = new JTextField();
		txtSearch.setForeground(SystemColor.desktop);
		txtSearch.setText("Search");
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setBounds(95, 11, 170, 39);
		TopBar.add(txtSearch);
		txtSearch.setColumns(10);
		
		SearchBtn = new JButton("");
		SearchBtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/magnifying-glass (1).png")));
		SearchBtn.setBorder(null);
		SearchBtn.setBackground(new Color(30,58,42));
		SearchBtn.setBounds(55, 11, 39, 39);
		SearchBtn.setBorder(null);
		TopBar.add(SearchBtn);
		
		ProfilePic = new JButton("");
		ProfilePic.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/user-avatar-main-picture.png")));
		ProfilePic.setBounds(478, 10, 40, 40);
		TopBar.add(ProfilePic);
		ProfilePic.setBackground(new Color(170, 187, 204));
		
		Profile = new JButton("hello");
		Profile.setBackground(new Color(30,58,42));
		Profile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Profile.setForeground(Color.WHITE);
		Profile.setBounds(520, 19, 145, 23);
		Profile.setBorder(null);
		TopBar.add(Profile);
		
		Notificationbtn = new JButton("");
		Notificationbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/notifications-button.png")));
		Notificationbtn.setBorder(null);
		Notificationbtn.setBackground(new Color(30, 58, 42));
		Notificationbtn.setBounds(1084, 11, 39, 39);
		TopBar.add(Notificationbtn);
		
		Refreshbtn = new JButton("");
		Refreshbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/reload.png")));
		Refreshbtn.setBorder(null);
		Refreshbtn.setBackground(new Color(30, 58, 42));
		Refreshbtn.setBounds(1035, 11, 39, 39);
		TopBar.add(Refreshbtn);
		
		verified = new JButton("");
		verified.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/correct (4).png")));
		verified.setEnabled(false);
		verified.setBorder(null);
		verified.setBackground(new Color(30, 58, 42));
		verified.setBounds(448, 22, 28, 28);
		TopBar.add(verified);
		
		MusicPanel = new JPanel();
		MusicPanel.setBackground(new Color(254, 254, 250));
		MusicPanel.setBounds(0, 62, 186, 514);
		contentPane.add(MusicPanel);
		MusicPanel.setLayout(null);
		
		btnNewButton = new JButton("New Playlist");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/add-circular-outlined-button (1).png")));
		btnNewButton.setBounds(0, 429, 186, 88);
		MusicPanel.add(btnNewButton);
		
		MusicLbl = new JLabel("Music");
		MusicLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MusicLbl.setBackground(new Color(254, 254, 250));
		MusicLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MusicLbl.setBounds(0, 0, 186, 34);
		MusicPanel.add(MusicLbl);
		
		Library = new JButton("Library");
		Library.setBackground(new Color(242, 203, 155));
		Library.setHorizontalAlignment(SwingConstants.LEFT);
		Library.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Library.setBounds(0, 33, 186, 30);
		MusicPanel.add(Library);
		
		Artist_Music = new JButton("Artist");
		Artist_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Artist_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artist_Music.setBackground(new Color(254, 254, 250));
		Artist_Music.setBounds(0, 62, 186, 30);
		MusicPanel.add(Artist_Music);
		
		Genre_Music = new JButton("Genre");
		Genre_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Genre_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genre_Music.setBackground(new Color(254, 254, 250));
		Genre_Music.setBounds(0, 119, 186, 30);
		MusicPanel.add(Genre_Music);
		
		Albums_Music = new JButton("Albums");
		Albums_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Albums_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Albums_Music.setBackground(new Color(242, 203, 155));
		Albums_Music.setBounds(0, 90, 186, 30);
		MusicPanel.add(Albums_Music);
		

		Playlist_Name3 = new JButton("(PlaylistName)");

		Playlist_Name3.setEnabled(false);
		Playlist_Name3.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name3.setBackground(new Color(254, 254, 250));
		Playlist_Name3.setBounds(0, 232, 186, 30);
		MusicPanel.add(Playlist_Name3);
		

		Playlist_Name2 = new JButton("(PlaylistName)");

		Playlist_Name2.setEnabled(false);
		Playlist_Name2.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name2.setBackground(new Color(242, 203, 155));
		Playlist_Name2.setBounds(0, 203, 186, 30);
		MusicPanel.add(Playlist_Name2);
		

		Playlist_Name1 = new JButton("(PlaylistName)");

		Playlist_Name1.setEnabled(false);
		Playlist_Name1.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name1.setBackground(new Color(254, 254, 250));
		Playlist_Name1.setBounds(0, 175, 186, 30);
		MusicPanel.add(Playlist_Name1);
		
		Playlists_Music = new JButton("Playlists");
		Playlists_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Playlists_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlists_Music.setBackground(new Color(242, 203, 155));
		Playlists_Music.setBounds(0, 146, 186, 30);
		MusicPanel.add(Playlists_Music);
		

		Playlist_Name7 = new JButton("(PlaylistName)");

		Playlist_Name7.setEnabled(false);
		Playlist_Name7.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name7.setBackground(new Color(254, 254, 250));
		Playlist_Name7.setBounds(0, 344, 186, 30);
		MusicPanel.add(Playlist_Name7);
		

		Playlist_Name6 = new JButton("(PlaylistName)");

		Playlist_Name6.setEnabled(false);
		Playlist_Name6.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name6.setBackground(new Color(242, 203, 155));
		Playlist_Name6.setBounds(0, 315, 186, 30);
		MusicPanel.add(Playlist_Name6);
		

		Playlist_Name5 = new JButton("(PlaylistName)");

		Playlist_Name5.setEnabled(false);
		Playlist_Name5.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name5.setBackground(new Color(254, 254, 250));
		Playlist_Name5.setBounds(0, 287, 186, 30);
		MusicPanel.add(Playlist_Name5);
		

		Playlist_Name4 = new JButton("(PlaylistName)");

		Playlist_Name4.setEnabled(false);
		Playlist_Name4.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name4.setBackground(new Color(242, 203, 155));
		Playlist_Name4.setBounds(0, 258, 186, 30);
		MusicPanel.add(Playlist_Name4);
		

		Playlist_Name9 = new JButton("(PlaylistName)");

		Playlist_Name9.setEnabled(false);
		Playlist_Name9.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name9.setBackground(new Color(254, 254, 250));
		Playlist_Name9.setBounds(0, 401, 186, 30);
		MusicPanel.add(Playlist_Name9);
		

		Playlist_Name8 = new JButton("(PlaylistName)");

		Playlist_Name8.setEnabled(false);
		Playlist_Name8.setHorizontalAlignment(SwingConstants.LEFT);
		Playlist_Name8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlist_Name8.setBackground(new Color(242, 203, 155));
		Playlist_Name8.setBounds(0, 372, 186, 30);
		MusicPanel.add(Playlist_Name8);
		
		Playlist_List = new JList();
		Playlist_List.setBounds(0, 175, 186, 253);
		MusicPanel.add(Playlist_List);
		
		RecentlyPlayedPanel = new JPanel();
		RecentlyPlayedPanel.setLayout(null);
		RecentlyPlayedPanel.setBackground(new Color(254, 254, 250));
		RecentlyPlayedPanel.setBounds(960, 62, 186, 514);
		contentPane.add(RecentlyPlayedPanel);
		
		label = new JLabel("Recently Played");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBackground(new Color(254, 254, 250));
		label.setBounds(0, 0, 186, 34);
		RecentlyPlayedPanel.add(label);
		
		RPSONG_1 = new JButton("");
		RPSONG_1.setEnabled(false);
		RPSONG_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RPSONG_1.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_1.setBackground(new Color(242, 203, 155));
		RPSONG_1.setBounds(0, 33, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_1);
		
		RPSONG_2 = new JButton("");
		RPSONG_2.setEnabled(false);
		RPSONG_2.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_2.setBackground(new Color(254, 254, 250));
		RPSONG_2.setBounds(0, 62, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_2);
		
		RPSONG_4 = new JButton("");
		RPSONG_4.setEnabled(false);
		RPSONG_4.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_4.setBackground(new Color(254, 254, 250));
		RPSONG_4.setBounds(0, 119, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_4);
		
		RPSONG_3 = new JButton("");
		RPSONG_3.setEnabled(false);
		RPSONG_3.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_3.setBackground(new Color(242, 203, 155));
		RPSONG_3.setBounds(0, 90, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_3);
		
		RPSONG_7 = new JButton("");
		RPSONG_7.setEnabled(false);
		RPSONG_7.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_7.setBackground(new Color(242, 203, 155));
		RPSONG_7.setBounds(0, 203, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_7);
		
		RPSONG_6 = new JButton("");
		RPSONG_6.setEnabled(false);
		RPSONG_6.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_6.setBackground(new Color(254, 254, 250));
		RPSONG_6.setBounds(0, 175, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_6);
		
		RPSONG_5 = new JButton("");
		RPSONG_5.setEnabled(false);
		RPSONG_5.setHorizontalAlignment(SwingConstants.LEFT);
		RPSONG_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RPSONG_5.setBackground(new Color(242, 203, 155));
		RPSONG_5.setBounds(0, 146, 186, 30);
		RecentlyPlayedPanel.add(RPSONG_5);
		
		MPSONG_3 = new JButton("");
		MPSONG_3.setEnabled(false);
		MPSONG_3.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_3.setBackground(new Color(254, 254, 250));
		MPSONG_3.setBounds(0, 344, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_3);
		
		MPSONG_2 = new JButton("");
		MPSONG_2.setEnabled(false);
		MPSONG_2.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_2.setBackground(new Color(242, 203, 155));
		MPSONG_2.setBounds(0, 315, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_2);
		
		MPSONG_1 = new JButton("");
		MPSONG_1.setEnabled(false);
		MPSONG_1.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_1.setBackground(new Color(254, 254, 250));
		MPSONG_1.setBounds(0, 287, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_1);
		
		MPSONG_5 = new JButton("");
		MPSONG_5.setEnabled(false);
		MPSONG_5.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_5.setBackground(new Color(254, 254, 250));
		MPSONG_5.setBounds(0, 401, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_5);
		
		MPSONG_4 = new JButton("");
		MPSONG_4.setEnabled(false);
		MPSONG_4.setHorizontalAlignment(SwingConstants.LEFT);
		MPSONG_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MPSONG_4.setBackground(new Color(242, 203, 155));
		MPSONG_4.setBounds(0, 372, 186, 30);
		RecentlyPlayedPanel.add(MPSONG_4);
		
		AddSongbtn = new JButton("Add Song");
		AddSongbtn.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/add-circular-outlined-button (1).png")));
		AddSongbtn.setHorizontalAlignment(SwingConstants.LEFT);
		AddSongbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AddSongbtn.setBounds(0, 426, 186, 88);
		RecentlyPlayedPanel.add(AddSongbtn);
		
		MostPlayedSongs = new JLabel("Most Played ");
		MostPlayedSongs.setHorizontalAlignment(SwingConstants.CENTER);
		MostPlayedSongs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MostPlayedSongs.setBackground(new Color(254, 254, 250));
		MostPlayedSongs.setBounds(0, 231, 186, 61);
		RecentlyPlayedPanel.add(MostPlayedSongs);
		
		RecentlyPlayedList = new JList();
		RecentlyPlayedList.setBounds(0, 33, 186, 197);
		RecentlyPlayedPanel.add(RecentlyPlayedList);
		
		RP_List = new JList();
		RP_List.setBounds(0, 33, 186, 200);
		RecentlyPlayedPanel.add(RP_List);
		
		MP_List = new JList();
		MP_List.setBounds(0, 287, 186, 139);
		RecentlyPlayedPanel.add(MP_List);
		
		Dashboard = new JPanel();
		Dashboard.setBackground(new Color(254, 254, 250));
		Dashboard.setBorder(null);
		Dashboard.setBounds(196, 72, 754, 496);
		contentPane.add(Dashboard);
		Dashboard.setLayout(null);
		
		AlbumArt_1 = new JLabel("ALBUM ART");
		AlbumArt_1.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/KDRLK.png")));
		AlbumArt_1.setBackground(new Color(254,254,250));
		AlbumArt_1.setHorizontalAlignment(SwingConstants.CENTER);
		AlbumArt_1.setBounds(51, 27, 164, 164);
		Dashboard.add(AlbumArt_1);
		
		AlbumArt_2 = new JLabel("ALBUM ART");
		AlbumArt_2.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/khalid.png")));
		AlbumArt_2.setHorizontalAlignment(SwingConstants.CENTER);
		AlbumArt_2.setBackground(new Color(254, 254, 250));
		AlbumArt_2.setBounds(285, 27, 164, 164);
		Dashboard.add(AlbumArt_2);
		
		AlbumArt_3 = new JLabel("ALBUM ART");
		AlbumArt_3.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/Africa.png")));
		AlbumArt_3.setHorizontalAlignment(SwingConstants.CENTER);
		AlbumArt_3.setBackground(new Color(254, 254, 250));
		AlbumArt_3.setBounds(530, 27, 164, 164);
		Dashboard.add(AlbumArt_3);
		
		AlbumArt_4 = new JLabel("ALBUM ART");
		AlbumArt_4.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/images.png")));
		AlbumArt_4.setHorizontalAlignment(SwingConstants.CENTER);
		AlbumArt_4.setBackground(new Color(254, 254, 250));
		AlbumArt_4.setBounds(51, 242, 164, 164);
		Dashboard.add(AlbumArt_4);
		
		AlbumArt_5 = new JLabel("ALBUM ART");
		AlbumArt_5.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/brownbag.png")));
		AlbumArt_5.setHorizontalAlignment(SwingConstants.CENTER);
		AlbumArt_5.setBackground(new Color(254, 254, 250));
		AlbumArt_5.setBounds(285, 242, 164, 164);
		Dashboard.add(AlbumArt_5);
		
		AlbumArt_6 = new JLabel("ALBUM ART");
		AlbumArt_6.setIcon(new ImageIcon(AlbumView.class.getResource("/images2/yourname.png")));
		AlbumArt_6.setHorizontalAlignment(SwingConstants.CENTER);
		AlbumArt_6.setBackground(new Color(254, 254, 250));
		AlbumArt_6.setBounds(530, 242, 164, 164);
		Dashboard.add(AlbumArt_6);
		
		AlbumName_1 = new JButton("Album Name");
		AlbumName_1.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_1.setBackground(new Color(254, 254, 250));
		AlbumName_1.setBounds(51, 197, 164, 23);
		AlbumName_1.setBorder(null);
		Dashboard.add(AlbumName_1);
		
		AlbumName_2 = new JButton("Album Name");
		AlbumName_2.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_2.setBackground(new Color(254, 254, 250));
		AlbumName_2.setBounds(285, 197, 164, 23);
		AlbumName_2.setBorder(null);
		Dashboard.add(AlbumName_2);
		
		AlbumName_3 = new JButton("Album Name");
		AlbumName_3.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_3.setBackground(new Color(254, 254, 250));
		AlbumName_3.setBounds(530, 197, 175, 23);
		AlbumName_3.setBorder(null);
		Dashboard.add(AlbumName_3);
		
		AlbumName_4 = new JButton("Album Name");
		AlbumName_4.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_4.setBackground(new Color(254, 254, 250));
		AlbumName_4.setBounds(51, 418, 164, 23);
		AlbumName_4.setBorder(null);
		Dashboard.add(AlbumName_4);
		
		AlbumName_5 = new JButton("Album Name");
		AlbumName_5.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_5.setBackground(new Color(254, 254, 250));
		AlbumName_5.setBounds(285, 418, 164, 23);
		AlbumName_5.setBorder(null);
		Dashboard.add(AlbumName_5);
		
		AlbumName_6 = new JButton("Album Name");
		AlbumName_6.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_6.setBackground(new Color(254, 254, 250));
		AlbumName_6.setBounds(530, 418, 175, 23);
		AlbumName_6.setBorder(null);
		Dashboard.add(AlbumName_6);
		
		lblMadeForYou = new JLabel("Your Albums");
		lblMadeForYou.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMadeForYou.setBounds(0, 0, 186, 23);
		Dashboard.add(lblMadeForYou);
		
		ProfilePic.addActionListener(new btnProfile());
		Profile.addActionListener(new btnProfile());
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void setUsername(String username)
	{
		this.currentUser = username;
		Profile.setText(currentUser);
		Profile.repaint();
	}
	
	class btnProfile implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			profileView.getInstance().run();
			profileView.setUsername(currentUser);
			closeWindow();
			
		}
		
	}
	
	public void closeWindow()
	{
		this.setVisible(false);
	}
	
	public void openWindow()
	{
		this.setVisible(true);
	}
}

