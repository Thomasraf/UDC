package view;
import model.Playlist;
import model.Song;
import model.generalModel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class SearchResultView extends JFrame {

	private JPanel contentPane;
	boolean evenClick = false;
	private JButton Artist_Dashboard;
	JButton Refreshbtn,btnAddSong,btnAddPlaylist,btnGoToListener;
	JList SongsList,listPlaylist;
	ArrayList<Song> searchSongs, userSongs;
	String currentUser;
	ArrayList<Playlist> searchPlaylist;
	private volatile static SearchResultView instance = null;
	public static SearchResultView getInstance() {
        if (instance == null) {
        	instance = new SearchResultView();
        }
		return instance;
	}
	String searchingText;
	
	
	/**
	 * Create the frame.
	 */
	public SearchResultView() {
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
		Refreshbtn.setIcon(new ImageIcon(SearchResultView.class.getResource("/images2/reload.png")));
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
		
		JLabel Librarylbl = new JLabel("Search Results");
		Librarylbl.setBackground(new Color(254,254,250));
		Librarylbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Librarylbl.setBounds(12, 11, 186, 23);
		Dashboard.add(Librarylbl);
		
		JButton Title_Dashboard = new JButton("Title");
		Title_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Title_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Title_Dashboard.setBackground(new Color(254, 254, 250));
		Title_Dashboard.setBounds(10, 50, 186, 30);
		Dashboard.add(Title_Dashboard);
		
		Artist_Dashboard = new JButton("Artist");
		Artist_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Artist_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artist_Dashboard.setBackground(new Color(254, 254, 250));
		Artist_Dashboard.setBounds(192, 50, 196, 30);
		Dashboard.add(Artist_Dashboard);
		
		JButton Follower_Dashboard = new JButton("Followers");
		Follower_Dashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Follower_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Follower_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Follower_Dashboard.setBackground(new Color(254, 254, 250));
		Follower_Dashboard.setBounds(384, 50, 196, 30);
		Dashboard.add(Follower_Dashboard);
		
		SongsList = new JList();
		SongsList.setBounds(12, 79, 177, 417);
		Dashboard.add(SongsList);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBackground(new Color(254,254,250));
		btnNewButton_1.setBounds(10, 79, 186, 417);
		Dashboard.add(btnNewButton_1);
		
		JList Artist_list = new JList();
		Artist_list.setBounds(206, 79, 176, 417);
		Dashboard.add(Artist_list);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBackground(new Color(254,254,250));
		button_1.setBounds(224, 79, 164, 417);
		Dashboard.add(button_1);
		
		JList Followers_List = new JList();
		Followers_List.setBounds(384, 79, 186, 417);
		Dashboard.add(Followers_List);
		
		JButton button_3 = new JButton("");
		button_3.setEnabled(false);
		button_3.setBackground(new Color(254,254,250));
		button_3.setBounds(384, 79, 196, 417);
		Dashboard.add(button_3);
		
		JButton ListPlaylist = new JButton("Playlist");
		ListPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		ListPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ListPlaylist.setBackground(new Color(254, 254, 250));
		ListPlaylist.setBounds(580, 50, 174, 30);
		Dashboard.add(ListPlaylist);
		
		listPlaylist = new JList();
		listPlaylist.setBounds(582, 79, 170, 417);
		Dashboard.add(listPlaylist);
		
		JButton button_5 = new JButton("");
		button_5.setEnabled(false);
		button_5.setBackground(new Color(254, 254, 250));
		button_5.setBounds(582, 79, 172, 417);
		Dashboard.add(button_5);
		
		btnAddSong = new JButton("Add Song");
		btnAddSong.setBounds(224, 11, 89, 23);
		Dashboard.add(btnAddSong);
		btnAddSong.addActionListener(new btn_AddSong());
		
		btnAddPlaylist = new JButton("Add Playlist");
		btnAddPlaylist.setBounds(328, 11, 89, 23);
		Dashboard.add(btnAddPlaylist);
		
		btnGoToListener = new JButton("Go To Listener");
		btnGoToListener.setBounds(452, 11, 121, 23);
		Dashboard.add(btnGoToListener);
		btnGoToListener.addActionListener(new btn_GoToListener());
		
		JButton btnGoToArtist = new JButton("Go To Artist");
		btnGoToArtist.setBounds(595, 11, 121, 23);
		Dashboard.add(btnGoToArtist);
		
		
	}
	
	class btn_Refresh implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			searchSongs = generalModel.getInstance().getSearchSongs(searchingText);
			searchPlaylist = generalModel.getInstance().getSearchPlaylist(searchingText);
			
			DefaultListModel DLM1 = new DefaultListModel();
			DefaultListModel DLM2 = new DefaultListModel();
			
			for(int a = 0; a < searchSongs.size(); a++)
				DLM1.addElement(searchSongs.get(a).getSongName());
			
			for(int b = 0; b < searchPlaylist.size();b++)
				DLM2.addElement(searchPlaylist.get(b).getPlaylistName());
			
			SongsList.setModel(DLM1);
			listPlaylist.setModel(DLM2);
		}
	}
	
	class btn_GoToListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Listener_FollowView.getInstance().setText(searchingText);
			Listener_FollowView.getInstance().setUsername(currentUser);
			Listener_FollowView.getInstance().setVisible(true);
		}
	}
	
	class btn_AddSong implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			generalModel.getInstance().addSearchSongs(searchingText,currentUser);		
		}
	}
	
	class btn_AddPlaylist implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			generalModel.getInstance().addSearchPlaylists(searchingText,currentUser);
		}
	}
	public void setText(String text) {
		this.searchingText = text;
	}
	
	public void setUsername(String currentUser) {
		this.currentUser = currentUser;
	}
}
