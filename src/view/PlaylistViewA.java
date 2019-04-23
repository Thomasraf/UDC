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
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class PlaylistViewA extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	boolean evenClick = false;
	private JButton Artist_Dashboard;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaylistViewA frame = new PlaylistViewA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlaylistViewA() {
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
		
		JButton btnLogout = new JButton("");
		btnLogout.setBounds(10, 11, 39, 39);
		btnLogout.setIcon(new ImageIcon(HomeViewA.class.getResource("/images2/logout.png")));
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
		
		JButton Refreshbtn = new JButton("");
		Refreshbtn.setIcon(new ImageIcon(PlaylistViewA.class.getResource("/images2/reload.png")));
		Refreshbtn.setBorder(null);
		Refreshbtn.setBackground(new Color(30, 58, 42));
		Refreshbtn.setBounds(1035, 11, 39, 39);
		TopBar.add(Refreshbtn);
		
		JButton verified = new JButton("");
		verified.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/correct (4).png")));
		verified.setEnabled(false);
		verified.setBorder(null);
		verified.setBackground(new Color(30, 58, 42));
		verified.setBounds(448, 22, 28, 28);
		TopBar.add(verified);
		
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
		
		JList Playlist_List = new JList();
		Playlist_List.setBounds(0, 175, 186, 253);
		MusicPanel.add(Playlist_List);
		
		JPanel RecentlyPlayedPanel = new JPanel();
		RecentlyPlayedPanel.setLayout(null);
		RecentlyPlayedPanel.setBackground(new Color(254, 254, 250));
		RecentlyPlayedPanel.setBounds(960, 62, 186, 514);
		contentPane.add(RecentlyPlayedPanel);
		
		JLabel label = new JLabel("Recently Played");
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
		
		JButton AddSongbtn = new JButton("Add Song to Playlist");
		AddSongbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/add-circular-outlined-button (1).png")));
		AddSongbtn.setHorizontalAlignment(SwingConstants.LEFT);
		AddSongbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		AddSongbtn.setBounds(0, 426, 186, 88);
		RecentlyPlayedPanel.add(AddSongbtn);
		
		JLabel MostPlayedSongs = new JLabel("Most Played ");
		MostPlayedSongs.setHorizontalAlignment(SwingConstants.CENTER);
		MostPlayedSongs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MostPlayedSongs.setBackground(new Color(254, 254, 250));
		MostPlayedSongs.setBounds(0, 231, 186, 61);
		RecentlyPlayedPanel.add(MostPlayedSongs);
		
		JList RP_List = new JList();
		RP_List.setBounds(0, 33, 186, 201);
		RecentlyPlayedPanel.add(RP_List);
		
		JList MP_List = new JList();
		MP_List.setBounds(0, 287, 186, 138);
		RecentlyPlayedPanel.add(MP_List);
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(254, 254, 250));
		Dashboard.setBorder(null);
		Dashboard.setBounds(196, 72, 754, 496);
		contentPane.add(Dashboard);
		Dashboard.setLayout(null);
		
		JLabel PlaylistArt_1 = new JLabel("ALBUM ART");
		PlaylistArt_1.setIcon(new ImageIcon(HomeView.class.getResource("/images2/KDRLK.png")));
		PlaylistArt_1.setBackground(new Color(254,254,250));
		PlaylistArt_1.setHorizontalAlignment(SwingConstants.CENTER);
		PlaylistArt_1.setBounds(10, 0, 164, 164);
		Dashboard.add(PlaylistArt_1);
		
		JLabel lblPlaylistName = new JLabel("(Playlist Name)");
		lblPlaylistName.setBackground(new Color(254,254,250));
		lblPlaylistName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlaylistName.setBounds(184, 55, 186, 23);
		Dashboard.add(lblPlaylistName);
		
		JLabel lblPlaylistDetails = new JLabel("(Playlist details)");
		lblPlaylistDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylistDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlaylistDetails.setBackground(new Color(254, 254, 250));
		lblPlaylistDetails.setBounds(184, 82, 377, 55);
		Dashboard.add(lblPlaylistDetails);
		
		JLabel Created_bylbl = new JLabel("Created by");
		Created_bylbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Created_bylbl.setBackground(new Color(254, 254, 250));
		Created_bylbl.setBounds(184, 136, 74, 23);
		Dashboard.add(Created_bylbl);
		
		JButton ProfileName_Dashboard = new JButton("Profile Name");
		ProfileName_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		ProfileName_Dashboard.setForeground(Color.BLACK);
		ProfileName_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProfileName_Dashboard.setBorder(null);
		ProfileName_Dashboard.setBackground(new Color(254,254,250));
		ProfileName_Dashboard.setBounds(256, 136, 305, 23);
		Dashboard.add(ProfileName_Dashboard);
		
		JButton Title_Dashboard = new JButton("Title");
		Title_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Title_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Title_Dashboard.setBackground(new Color(254, 254, 250));
		Title_Dashboard.setBounds(10, 170, 164, 30);
		Dashboard.add(Title_Dashboard);
		
		Artist_Dashboard = new JButton("Artist");
		Artist_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Artist_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artist_Dashboard.setBackground(new Color(254, 254, 250));
		Artist_Dashboard.setBounds(173, 170, 164, 30);
		Dashboard.add(Artist_Dashboard);
		
		JButton Album_Dashboard = new JButton("Album");
		Album_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Album_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Album_Dashboard.setBackground(new Color(254, 254, 250));
		Album_Dashboard.setBounds(335, 170, 172, 30);
		Dashboard.add(Album_Dashboard);
		
		JButton Genre_Dashboard = new JButton("Genre");
		Genre_Dashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Genre_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Genre_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genre_Dashboard.setBackground(new Color(254, 254, 250));
		Genre_Dashboard.setBounds(503, 170, 100, 30);
		Dashboard.add(Genre_Dashboard);
		
		JButton AddQueuebtn = new JButton("");
		AddQueuebtn.setIcon(new ImageIcon(PlaylistViewA.class.getResource("/images2/add-to-queue-button (1).png")));
		AddQueuebtn.setBorder(null);
		AddQueuebtn.setBackground(new Color(254,254,250));
		AddQueuebtn.setBounds(607, 11, 39, 39);
		AddQueuebtn.setBorder(null);
		AddQueuebtn.setToolTipText("Add Song to Playlist");
		Dashboard.add(AddQueuebtn);
		
		JButton RemoveSongfromPlaylistbtn = new JButton("");
		RemoveSongfromPlaylistbtn.setIcon(new ImageIcon(PlaylistViewA.class.getResource("/images2/prohibition (1).png")));
		RemoveSongfromPlaylistbtn.setBorder(null);
		RemoveSongfromPlaylistbtn.setBackground(new Color(254, 254, 250));
		RemoveSongfromPlaylistbtn.setBounds(656, 11, 39, 39);
		RemoveSongfromPlaylistbtn.setBorder(null);
		RemoveSongfromPlaylistbtn.setToolTipText("Remove Song from Playlist");
		Dashboard.add(RemoveSongfromPlaylistbtn);
		
		JButton Public_Privatebtn = new JButton("");
		Public_Privatebtn.setIcon(new ImageIcon(PlaylistViewA.class.getResource("/images2/private_(1).png")));
		Public_Privatebtn.setBorder(null);
		Public_Privatebtn.setBackground(new Color(254, 254, 250));
		Public_Privatebtn.setBounds(705, 11, 39, 39);
		Public_Privatebtn.setBorder(null);
		Public_Privatebtn.setToolTipText("Set Playlist to Public/Private");
		Dashboard.add(Public_Privatebtn);
		
		JButton Year_Dashboard = new JButton("Year");
		Year_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Year_Dashboard.setBackground(new Color(254, 254, 250));
		Year_Dashboard.setBounds(600, 170, 80, 30);
		Dashboard.add(Year_Dashboard);
		
		JButton Favorite_Dashboard = new JButton("");
		Favorite_Dashboard.setIcon(new ImageIcon(PlaylistViewA.class.getResource("/images2/star.png")));
		Favorite_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Favorite_Dashboard.setBackground(new Color(254, 254, 250));
		Favorite_Dashboard.setBounds(680, 170, 74, 30);
		Dashboard.add(Favorite_Dashboard);
		
		JList list = new JList();
		list.setBounds(12, 197, 158, 299);
		Dashboard.add(list);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBackground(new Color(254,254,250));
		btnNewButton_1.setBounds(10, 197, 164, 299);
		Dashboard.add(btnNewButton_1);
		
		JList list_1 = new JList();
		list_1.setBounds(173, 197, 158, 299);
		Dashboard.add(list_1);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBackground(new Color(254,254,250));
		button_1.setBounds(173, 197, 164, 299);
		Dashboard.add(button_1);
		
		JList list_2 = new JList();
		list_2.setBounds(335, 197, 170, 299);
		Dashboard.add(list_2);
		
		JButton button_3 = new JButton("");
		button_3.setEnabled(false);
		button_3.setBackground(new Color(254,254,250));
		button_3.setBounds(335, 197, 172, 299);
		Dashboard.add(button_3);
		
		JList list_3 = new JList();
		list_3.setBounds(503, 197, 98, 299);
		Dashboard.add(list_3);
		
		JButton button_4 = new JButton("");
		button_4.setEnabled(false);
		button_4.setBackground(new Color(254,254,250));
		button_4.setBounds(503, 197, 100, 299);
		Dashboard.add(button_4);
		
		JList list_4 = new JList();
		list_4.setBounds(600, 197, 76, 299);
		Dashboard.add(list_4);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setBackground(new Color(254,254,250));
		button_5.setBounds(600, 197, 80, 299);
		Dashboard.add(button_5);
		
		JList list_5 = new JList();
		list_5.setBounds(680, 197, 68, 299);
		Dashboard.add(list_5);
		
		JButton button_6 = new JButton("");
		button_6.setEnabled(false);
		button_6.setBackground(new Color(254,254,250));
		button_6.setBounds(680, 197, 74, 299);
		Dashboard.add(button_6);
		

		

	}
}
