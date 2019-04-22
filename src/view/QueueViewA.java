package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class QueueViewA extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	boolean evenClick = false;
	private JList NIQ_Year3;
	private JList NU_Year1;

	/**
	 * Launch the application.
	 */
	private volatile static QueueViewA instance = null;
	public static QueueViewA getInstance() {
        if (instance == null) {
        	instance = new QueueViewA();
        }
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public QueueViewA() {
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
		
		JLabel SongName = new JLabel("()");
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
		Shufflebtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/shuffle (4).png")));
		Shufflebtn.setBackground(new Color(30,58,42));
		Shufflebtn.setBounds(290, 31, 39, 39);
		Shufflebtn.setBorder(null);
		MainRectangle.add(Shufflebtn);
		
		JButton Nextbtn = new JButton("");
		Nextbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/next (2).png")));
		Nextbtn.setBackground(new Color(30, 58, 42));
		Nextbtn.setBounds(512, 31, 39, 39);
		Nextbtn.setBorder(null);
		MainRectangle.add(Nextbtn);
		
		JButton Prevbtn = new JButton("");
		Prevbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/back (2).png")));
		Prevbtn.setBackground(new Color(30, 58, 42));
		Prevbtn.setBounds(355, 31, 39, 39);
		Prevbtn.setBorder(null);
		MainRectangle.add(Prevbtn);
		
		JButton Playbtn = new JButton("");
		Playbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/play-button (2).png")));
		Playbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(evenClick) {
				Playbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/play-button (2).png")));
				evenClick = false;
			}
				else {
					Playbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/rounded-pause-button.png")));
					evenClick = true;
				}
				}
		});
		Playbtn.setBounds(413, 15, 78, 70);
		Playbtn.setBackground(new Color(30, 58, 42));
		Playbtn.setBorder(null);
		MainRectangle.add(Playbtn);
		
		JButton Repeatbtn = new JButton("");
		Repeatbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/repeat.png")));
		Repeatbtn.setBackground(new Color(30, 58, 42));
		Repeatbtn.setBounds(577, 31, 39, 39);
		Repeatbtn.setBorder(null);
		MainRectangle.add(Repeatbtn);
		
		JButton Queuebtn = new JButton("");
		Queuebtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/list (1).png")));
		Queuebtn.setBorder(null);
		Queuebtn.setBackground(new Color(30, 58, 42));
		Queuebtn.setBounds(769, 31, 39, 39);
		MainRectangle.add(Queuebtn);
		
		JButton StopBtn = new JButton("");
		StopBtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/stop (3).png")));
		StopBtn.setBorder(null);
		StopBtn.setBackground(new Color(30, 58, 42));
		StopBtn.setBounds(818, 31, 39, 39);
		MainRectangle.add(StopBtn);
		
		JButton Volumebtn = new JButton("");
		Volumebtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/speaker (2).png")));
		Volumebtn.setBorder(null);
		Volumebtn.setBackground(new Color(30, 58, 42));
		Volumebtn.setBounds(867, 31, 39, 39);
		MainRectangle.add(Volumebtn);
		
		
		JButton NewAlbumPic = new JButton("");
		NewAlbumPic.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/photo.png")));
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
		btnLogout.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/logout.png")));
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
		SearchBtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/magnifying-glass (1).png")));
		SearchBtn.setBorder(null);
		SearchBtn.setBackground(new Color(30,58,42));
		SearchBtn.setBounds(55, 11, 39, 39);
		SearchBtn.setBorder(null);
		TopBar.add(SearchBtn);
		
		JButton ProfilePic = new JButton("");
		ProfilePic.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/user-avatar-main-picture.png")));
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
		button_2.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/notifications-button.png")));
		button_2.setBorder(null);
		button_2.setBackground(new Color(30, 58, 42));
		button_2.setBounds(1084, 11, 39, 39);
		TopBar.add(button_2);
		
		JButton Refreshbtn = new JButton("");
		Refreshbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/reload.png")));
		Refreshbtn.setBorder(null);
		Refreshbtn.setBackground(new Color(30, 58, 42));
		Refreshbtn.setBounds(1035, 11, 39, 39);
		TopBar.add(Refreshbtn);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/correct (4).png")));
		button_1.setEnabled(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(30, 58, 42));
		button_1.setBounds(448, 22, 28, 28);
		TopBar.add(button_1);
		
		JPanel MusicPanel = new JPanel();
		MusicPanel.setBackground(new Color(254, 254, 250));
		MusicPanel.setBounds(0, 62, 186, 514);
		contentPane.add(MusicPanel);
		MusicPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("New Playlist");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/add-circular-outlined-button (1).png")));
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
		
		JButton Playlists_Music = new JButton("Playlists");
		Playlists_Music.setHorizontalAlignment(SwingConstants.LEFT);
		Playlists_Music.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Playlists_Music.setBackground(new Color(242, 203, 155));
		Playlists_Music.setBounds(0, 146, 186, 30);
		MusicPanel.add(Playlists_Music);
		
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
		AddSongbtn.setIcon(new ImageIcon(QueueViewA.class.getResource("/images2/add-circular-outlined-button (1).png")));
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
		RP_List.setBounds(0, 33, 186, 200);
		RecentlyPlayedPanel.add(RP_List);
		
		JList MP_list = new JList();
		MP_list.setBounds(0, 287, 186, 142);
		RecentlyPlayedPanel.add(MP_list);
		
		JPanel Dashboard = new JPanel();
		Dashboard.setBackground(new Color(254, 254, 250));
		Dashboard.setBorder(null);
		Dashboard.setBounds(196, 72, 754, 496);
		contentPane.add(Dashboard);
		Dashboard.setLayout(null);
		
		JLabel lblQueue = new JLabel("Queue");
		lblQueue.setBackground(new Color(254,254,250));
		lblQueue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQueue.setBounds(10, 11, 186, 23);
		Dashboard.add(lblQueue);
		
		JButton Title_Dashboard = new JButton("Title");
		Title_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Title_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Title_Dashboard.setBackground(new Color(254, 254, 250));
		Title_Dashboard.setBounds(2, 77, 200, 30);
		Dashboard.add(Title_Dashboard);
		
		JButton Album_Dashboard = new JButton("Album");
		Album_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Album_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Album_Dashboard.setBackground(new Color(254, 254, 250));
		Album_Dashboard.setBounds(396, 77, 172, 30);
		Dashboard.add(Album_Dashboard);
		
		JButton Year_Dashboard = new JButton("Year");
		Year_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Year_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Year_Dashboard.setBackground(new Color(254, 254, 250));
		Year_Dashboard.setBounds(658, 77, 78, 30);
		Dashboard.add(Year_Dashboard);
		
		JButton Genre_Dashboard = new JButton("Genre");
		Genre_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Genre_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genre_Dashboard.setBackground(new Color(254, 254, 250));
		Genre_Dashboard.setBounds(567, 77, 95, 30);
		Dashboard.add(Genre_Dashboard);
		
		JButton AddQueuebtn = new JButton("");
		AddQueuebtn.setIcon(new ImageIcon(PlaylistView.class.getResource("/images2/add-to-queue-button (1).png")));
		AddQueuebtn.setBorder(null);
		AddQueuebtn.setBackground(new Color(254,254,250));
		AddQueuebtn.setBounds(607, 11, 39, 39);
		AddQueuebtn.setBorder(null);
		AddQueuebtn.setToolTipText("Add Song to Queue");
		Dashboard.add(AddQueuebtn);
		
		JButton RemoveSongfromPlaylistbtn = new JButton("");
		RemoveSongfromPlaylistbtn.setIcon(new ImageIcon(PlaylistView.class.getResource("/images2/prohibition (1).png")));
		RemoveSongfromPlaylistbtn.setBorder(null);
		RemoveSongfromPlaylistbtn.setBackground(new Color(254, 254, 250));
		RemoveSongfromPlaylistbtn.setBounds(656, 11, 39, 39);
		RemoveSongfromPlaylistbtn.setBorder(null);
		RemoveSongfromPlaylistbtn.setToolTipText("Remove Song from Queue");
		Dashboard.add(RemoveSongfromPlaylistbtn);
		
		JButton Artist_Dashboard = new JButton("Artist");
		Artist_Dashboard.setHorizontalAlignment(SwingConstants.LEFT);
		Artist_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artist_Dashboard.setBackground(new Color(254, 254, 250));
		Artist_Dashboard.setBounds(199, 77, 200, 30);
		Dashboard.add(Artist_Dashboard);
		
		JLabel NowPlayinglbl = new JLabel("Now Playing");
		NowPlayinglbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		NowPlayinglbl.setBackground(new Color(254, 254, 250));
		NowPlayinglbl.setBounds(10, 45, 188, 30);
		Dashboard.add(NowPlayinglbl);
		
		JLabel NextInQueuelbl = new JLabel("Next In Queue");
		NextInQueuelbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		NextInQueuelbl.setBackground(new Color(254, 254, 250));
		NextInQueuelbl.setBounds(10, 144, 188, 30);
		Dashboard.add(NextInQueuelbl);
		
		JLabel NextUplbl = new JLabel("Next Up");
		NextUplbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		NextUplbl.setBackground(new Color(254, 254, 250));
		NextUplbl.setBounds(10, 284, 188, 30);
		Dashboard.add(NextUplbl);
		
		JButton Title_NIQ = new JButton("Title");
		Title_NIQ.setHorizontalAlignment(SwingConstants.LEFT);
		Title_NIQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Title_NIQ.setBackground(new Color(254, 254, 250));
		Title_NIQ.setBounds(0, 176, 200, 30);
		Dashboard.add(Title_NIQ);
		
		JButton Arist_NIQ = new JButton("Artist");
		Arist_NIQ.setHorizontalAlignment(SwingConstants.LEFT);
		Arist_NIQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Arist_NIQ.setBackground(new Color(254, 254, 250));
		Arist_NIQ.setBounds(197, 176, 200, 30);
		Dashboard.add(Arist_NIQ);
		
		JButton Album_NIQ = new JButton("Album");
		Album_NIQ.setHorizontalAlignment(SwingConstants.LEFT);
		Album_NIQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Album_NIQ.setBackground(new Color(254, 254, 250));
		Album_NIQ.setBounds(394, 176, 172, 30);
		Dashboard.add(Album_NIQ);
		
		JButton Genre_NIQ = new JButton("Genre");
		Genre_NIQ.setHorizontalAlignment(SwingConstants.LEFT);
		Genre_NIQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genre_NIQ.setBackground(new Color(254, 254, 250));
		Genre_NIQ.setBounds(565, 176, 95, 30);
		Dashboard.add(Genre_NIQ);
		
		JButton Year_NIQ = new JButton("Year");
		Year_NIQ.setHorizontalAlignment(SwingConstants.LEFT);
		Year_NIQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Year_NIQ.setBackground(new Color(254, 254, 250));
		Year_NIQ.setBounds(656, 176, 78, 30);
		Dashboard.add(Year_NIQ);
		
		JButton Title_NU = new JButton("Title");
		Title_NU.setHorizontalAlignment(SwingConstants.LEFT);
		Title_NU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Title_NU.setBackground(new Color(254, 254, 250));
		Title_NU.setBounds(2, 320, 200, 30);
		Dashboard.add(Title_NU);
		
		JButton Artist_NIQ = new JButton("Artist");
		Artist_NIQ.setHorizontalAlignment(SwingConstants.LEFT);
		Artist_NIQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artist_NIQ.setBackground(new Color(254, 254, 250));
		Artist_NIQ.setBounds(199, 320, 200, 30);
		Dashboard.add(Artist_NIQ);
		
		JButton Album_NU = new JButton("Album");
		Album_NU.setHorizontalAlignment(SwingConstants.LEFT);
		Album_NU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Album_NU.setBackground(new Color(254, 254, 250));
		Album_NU.setBounds(396, 320, 172, 30);
		Dashboard.add(Album_NU);
		
		JButton Genre_NU = new JButton("Genre");
		Genre_NU.setHorizontalAlignment(SwingConstants.LEFT);
		Genre_NU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genre_NU.setBackground(new Color(254, 254, 250));
		Genre_NU.setBounds(567, 320, 95, 30);
		Dashboard.add(Genre_NU);
		
		JButton Year_NU = new JButton("Year");
		Year_NU.setHorizontalAlignment(SwingConstants.LEFT);
		Year_NU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Year_NU.setBackground(new Color(254, 254, 250));
		Year_NU.setBounds(658, 320, 78, 30);
		Dashboard.add(Year_NU);
		
		JList NP_Title = new JList();
		NP_Title.setBackground(new Color(254,254,250));
		NP_Title.setBounds(2, 106, 200, 30);
		Dashboard.add(NP_Title);
		
		JList NP_Artist = new JList();
		NP_Artist.setBackground(new Color(254, 254, 250));
		NP_Artist.setBounds(199, 106, 200, 30);
		Dashboard.add(NP_Artist);
		
		JList NP_Album = new JList();
		NP_Album.setBackground(new Color(254, 254, 250));
		NP_Album.setBounds(396, 106, 172, 30);
		Dashboard.add(NP_Album);
		
		JList NP_Genre = new JList();
		NP_Genre.setBackground(new Color(254, 254, 250));
		NP_Genre.setBounds(567, 106, 95, 30);
		Dashboard.add(NP_Genre);
		
		JList NP_Year = new JList();
		NP_Year.setBackground(new Color(254, 254, 250));
		NP_Year.setBounds(658, 106, 78, 30);
		Dashboard.add(NP_Year);
		
		JList NIQ_Title1 = new JList();
		NIQ_Title1.setBackground(new Color(254, 254, 250));
		NIQ_Title1.setBounds(0, 204, 196, 30);
		Dashboard.add(NIQ_Title1);
		
		JList NIQ_Artist1 = new JList();
		NIQ_Artist1.setBackground(new Color(254, 254, 250));
		NIQ_Artist1.setBounds(197, 204, 202, 30);
		Dashboard.add(NIQ_Artist1);
		
		JList NIQ_Album1 = new JList();
		NIQ_Album1.setBackground(new Color(254, 254, 250));
		NIQ_Album1.setBounds(394, 204, 172, 30);
		Dashboard.add(NIQ_Album1);
		
		JList NIQ_Genre1 = new JList();
		NIQ_Genre1.setBackground(new Color(254, 254, 250));
		NIQ_Genre1.setBounds(565, 204, 95, 30);
		Dashboard.add(NIQ_Genre1);
		
		JList NIQ_Year1 = new JList();
		NIQ_Year1.setBackground(new Color(254, 254, 250));
		NIQ_Year1.setBounds(656, 204, 78, 30);
		Dashboard.add(NIQ_Year1);
		
		JList NIQ_Title2 = new JList();
		NIQ_Title2.setBackground(new Color(254, 254, 250));
		NIQ_Title2.setBounds(2, 232, 194, 30);
		Dashboard.add(NIQ_Title2);
		
		JList NIQ_Artist2 = new JList();
		NIQ_Artist2.setBackground(new Color(254, 254, 250));
		NIQ_Artist2.setBounds(199, 232, 200, 30);
		Dashboard.add(NIQ_Artist2);
		
		JList NIQ_Album2 = new JList();
		NIQ_Album2.setBackground(new Color(254, 254, 250));
		NIQ_Album2.setBounds(396, 232, 172, 30);
		Dashboard.add(NIQ_Album2);
		
		JList NIQ_Genre2 = new JList();
		NIQ_Genre2.setBackground(new Color(254, 254, 250));
		NIQ_Genre2.setBounds(567, 232, 95, 30);
		Dashboard.add(NIQ_Genre2);
		
		JList NIQ_Year2 = new JList();
		NIQ_Year2.setBackground(new Color(254, 254, 250));
		NIQ_Year2.setBounds(658, 232, 78, 30);
		Dashboard.add(NIQ_Year2);
		
		JList NIQ_Title3 = new JList();
		NIQ_Title3.setBackground(new Color(254, 254, 250));
		NIQ_Title3.setBounds(2, 263, 194, 30);
		Dashboard.add(NIQ_Title3);
		
		JList NIQ_Artist3 = new JList();
		NIQ_Artist3.setBackground(new Color(254, 254, 250));
		NIQ_Artist3.setBounds(199, 263, 200, 30);
		Dashboard.add(NIQ_Artist3);
		
		JList NIQ_Album3 = new JList();
		NIQ_Album3.setBackground(new Color(254, 254, 250));
		NIQ_Album3.setBounds(396, 263, 172, 30);
		Dashboard.add(NIQ_Album3);
		
		JList NIQ_Genre3 = new JList();
		NIQ_Genre3.setBackground(new Color(254, 254, 250));
		NIQ_Genre3.setBounds(567, 263, 95, 30);
		Dashboard.add(NIQ_Genre3);
		
		NIQ_Year3 = new JList();
		NIQ_Year3.setBackground(new Color(254, 254, 250));
		NIQ_Year3.setBounds(658, 263, 78, 30);
		Dashboard.add(NIQ_Year3);
		
		JList NU_Title1 = new JList();
		NU_Title1.setBackground(new Color(254, 254, 250));
		NU_Title1.setBounds(2, 349, 196, 30);
		Dashboard.add(NU_Title1);
		
		JList NU_Artist1 = new JList();
		NU_Artist1.setBackground(new Color(254, 254, 250));
		NU_Artist1.setBounds(199, 349, 202, 30);
		Dashboard.add(NU_Artist1);
		
		JList NU_Album1 = new JList();
		NU_Album1.setBackground(new Color(254, 254, 250));
		NU_Album1.setBounds(396, 349, 172, 30);
		Dashboard.add(NU_Album1);
		
		JList NU_Genre1 = new JList();
		NU_Genre1.setBackground(new Color(254, 254, 250));
		NU_Genre1.setBounds(567, 349, 95, 30);
		Dashboard.add(NU_Genre1);
		
		NU_Year1 = new JList();
		NU_Year1.setBackground(new Color(254, 254, 250));
		NU_Year1.setBounds(658, 349, 78, 30);
		Dashboard.add(NU_Year1);
		
		JList NU_Title2 = new JList();
		NU_Title2.setBackground(new Color(254, 254, 250));
		NU_Title2.setBounds(2, 377, 196, 30);
		Dashboard.add(NU_Title2);
		
		JList NU_Artist2 = new JList();
		NU_Artist2.setBackground(new Color(254, 254, 250));
		NU_Artist2.setBounds(199, 377, 202, 30);
		Dashboard.add(NU_Artist2);
		
		JList NU_Album2 = new JList();
		NU_Album2.setBackground(new Color(254, 254, 250));
		NU_Album2.setBounds(398, 377, 172, 30);
		Dashboard.add(NU_Album2);
		
		JList NU_Genre2 = new JList();
		NU_Genre2.setBackground(new Color(254, 254, 250));
		NU_Genre2.setBounds(567, 377, 95, 30);
		Dashboard.add(NU_Genre2);
		
		JList NU_Year2 = new JList();
		NU_Year2.setBackground(new Color(254, 254, 250));
		NU_Year2.setBounds(658, 377, 78, 30);
		Dashboard.add(NU_Year2);
		
		JList NU_Title3 = new JList();
		NU_Title3.setBackground(new Color(254, 254, 250));
		NU_Title3.setBounds(2, 408, 196, 30);
		Dashboard.add(NU_Title3);
		
		JList NU_Artist3 = new JList();
		NU_Artist3.setBackground(new Color(254, 254, 250));
		NU_Artist3.setBounds(199, 408, 202, 30);
		Dashboard.add(NU_Artist3);
		
		JList NU_Album3 = new JList();
		NU_Album3.setBackground(new Color(254, 254, 250));
		NU_Album3.setBounds(398, 408, 172, 30);
		Dashboard.add(NU_Album3);
		
		JList NU_Genre3 = new JList();
		NU_Genre3.setBackground(new Color(254, 254, 250));
		NU_Genre3.setBounds(567, 408, 95, 30);
		Dashboard.add(NU_Genre3);
		
		JList NU_Year3 = new JList();
		NU_Year3.setBackground(new Color(254, 254, 250));
		NU_Year3.setBounds(658, 408, 78, 30);
		Dashboard.add(NU_Year3);
		
		JList NU_Title4 = new JList();
		NU_Title4.setBackground(new Color(254, 254, 250));
		NU_Title4.setBounds(2, 438, 196, 30);
		Dashboard.add(NU_Title4);
		
		JList NU_Artist4 = new JList();
		NU_Artist4.setBackground(new Color(254, 254, 250));
		NU_Artist4.setBounds(199, 438, 202, 30);
		Dashboard.add(NU_Artist4);
		
		JList NU_Album4 = new JList();
		NU_Album4.setBackground(new Color(254, 254, 250));
		NU_Album4.setBounds(396, 438, 172, 30);
		Dashboard.add(NU_Album4);
		
		JList NU_Genre4 = new JList();
		NU_Genre4.setBackground(new Color(254, 254, 250));
		NU_Genre4.setBounds(567, 438, 95, 30);
		Dashboard.add(NU_Genre4);
		
		JList NU_Year4 = new JList();
		NU_Year4.setBackground(new Color(254, 254, 250));
		NU_Year4.setBounds(658, 438, 78, 30);
		Dashboard.add(NU_Year4);
		
		JList NU_Title5 = new JList();
		NU_Title5.setBackground(new Color(254, 254, 250));
		NU_Title5.setBounds(2, 466, 196, 30);
		Dashboard.add(NU_Title5);
		
		JList NU_Artist5 = new JList();
		NU_Artist5.setBackground(new Color(254, 254, 250));
		NU_Artist5.setBounds(199, 466, 202, 30);
		Dashboard.add(NU_Artist5);
		
		JList NU_Album5 = new JList();
		NU_Album5.setBackground(new Color(254, 254, 250));
		NU_Album5.setBounds(398, 466, 172, 30);
		Dashboard.add(NU_Album5);
		
		JList NU_Genre5 = new JList();
		NU_Genre5.setBackground(new Color(254, 254, 250));
		NU_Genre5.setBounds(567, 466, 95, 30);
		Dashboard.add(NU_Genre5);
		
		JList NU_Year5 = new JList();
		NU_Year5.setBackground(new Color(254, 254, 250));
		NU_Year5.setBounds(658, 466, 78, 30);
		Dashboard.add(NU_Year5);
		

		
	}

}
