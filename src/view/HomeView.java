package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.RecentlyPlayedBuilder;
import controller.SongBuilder;
import jaco.mp3.player.MP3Player;
import model.Playlist;
import model.RecentlyPlayed;
import model.RecentlyPlayedList;
import model.Song;
import model.SongList;
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
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class HomeView extends JFrame {

	private volatile static HomeView instance = null;
	MP3Player mp3 = new MP3Player(new File("currentSong.mp3"));
	public String currentUser;
	private JPanel contentPane;
	private JTextField txtSearch;
	boolean evenClick = false;
	JButton btnCreatePlaylist, AddSongbtn, Profile, Library, Refreshbtn, Playbtn, StopBtn, Nextbtn, Prevbtn;
	JList Playlist_List, MP_List, RecentlyPlayedList;
	SongList sl = new SongList();
	ArrayList<Song> userSongsMostPlayed, userSongs;
	ArrayList<RecentlyPlayed> userRecentlyPlayed;
	ArrayList<Playlist> userPlaylists;
	boolean songChangedInLibrary, playSongInPlaylist, songChangedInMP;
	boolean songPaused;


	JButton btnSearch;
	JButton ProfilePic;
	String profilePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static HomeView getInstance() {
        if (instance == null) {
        	instance = new HomeView();
        }
		return instance;
	}

	public void setSong(String path) {
		mp3.stop();
		mp3 = new MP3Player(new File(path));
	}
	
	public void refreshSongs(SongList sl) {
		this.sl = sl;
	}
	
	/**
	 * Create the frame.
	 */
	public HomeView() {
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
		
		 Nextbtn = new JButton("");
		Nextbtn.addActionListener(new btn_nextSong());
		Nextbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/next (2).png")));
		Nextbtn.setBackground(new Color(30, 58, 42));
		Nextbtn.setBounds(512, 31, 39, 39);
		Nextbtn.setBorder(null);
		MainRectangle.add(Nextbtn);
		

		 Prevbtn = new JButton("");

		Prevbtn.addActionListener(new btn_prevSong());
		Prevbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/back (2).png")));
		Prevbtn.setBackground(new Color(30, 58, 42));
		Prevbtn.setBounds(355, 31, 39, 39);
		Prevbtn.setBorder(null);
		MainRectangle.add(Prevbtn);
		

		 Playbtn = new JButton("");

		Playbtn.addActionListener(new btn_Play());
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
		
		 StopBtn = new JButton("");
		StopBtn.addActionListener(new btn_Stop());
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
		btnLogout.setIcon(new ImageIcon(HomeView.class.getResource("/images2/logout.png")));
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
		
		 Profile = new JButton("Profile Name");
		Profile.setBackground(new Color(30,58,42));
		Profile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Profile.setForeground(Color.WHITE);
		Profile.setBounds(520, 19, 145, 23);
		Profile.setBorder(null);
		TopBar.add(Profile);
		
		JButton Notificationbtn = new JButton("");
		Notificationbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/notifications-button.png")));
		Notificationbtn.setBorder(null);
		Notificationbtn.setBackground(new Color(30, 58, 42));
		Notificationbtn.setBounds(1084, 11, 39, 39);
		TopBar.add(Notificationbtn);
		
		 Refreshbtn = new JButton("");
		Refreshbtn.addActionListener(new Refresh_btn());
		Refreshbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/reload.png")));
		Refreshbtn.setBorder(null);
		Refreshbtn.setBackground(new Color(30, 58, 42));
		Refreshbtn.setBounds(1035, 11, 39, 39);
		TopBar.add(Refreshbtn);
		
		JPanel MusicPanel = new JPanel();
		MusicPanel.setBackground(new Color(254, 254, 250));
		MusicPanel.setBounds(0, 62, 186, 514);
		contentPane.add(MusicPanel);
		MusicPanel.setLayout(null);
		
		 btnCreatePlaylist = new JButton("New Playlist");
		btnCreatePlaylist.addActionListener(new btn_CreatePlaylist());
		btnCreatePlaylist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreatePlaylist.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreatePlaylist.setIcon(new ImageIcon(HomeView.class.getResource("/images2/add-circular-outlined-button (1).png")));
		btnCreatePlaylist.setBounds(0, 429, 186, 88);
		MusicPanel.add(btnCreatePlaylist);
		
		JLabel MusicLbl = new JLabel("Music");
		MusicLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MusicLbl.setBackground(new Color(254, 254, 250));
		MusicLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MusicLbl.setBounds(0, 0, 186, 34);
		MusicPanel.add(MusicLbl);
		
		 Library = new JButton("Library");
		Library.addActionListener(new btn_Library());
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
		
		 Playlist_List = new JList();
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
		


		 AddSongbtn = new JButton("Add To Playlist");

		AddSongbtn.addActionListener(new btn_AddSong());
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
		
		 RecentlyPlayedList = new JList();
		RecentlyPlayedList.setBounds(0, 33, 186, 197);
		RecentlyPlayedPanel.add(RecentlyPlayedList);
		
		JList RP_List = new JList();
		RP_List.setBounds(0, 33, 186, 200);
		RecentlyPlayedPanel.add(RP_List);
		
		 MP_List = new JList();
		 MP_List.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					try {	
					}catch(ArrayIndexOutOfBoundsException e) {}
					songChangedInMP = true;	
				}
			});
		MP_List.setBounds(0, 287, 186, 139);
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
		PlaylistArt_1.setBounds(51, 27, 164, 164);
		Dashboard.add(PlaylistArt_1);
		
		JLabel PlaylistArt_2 = new JLabel("ALBUM ART");
		PlaylistArt_2.setIcon(new ImageIcon(HomeView.class.getResource("/images2/khalid.png")));
		PlaylistArt_2.setHorizontalAlignment(SwingConstants.CENTER);
		PlaylistArt_2.setBackground(new Color(254, 254, 250));
		PlaylistArt_2.setBounds(285, 27, 164, 164);
		Dashboard.add(PlaylistArt_2);
		
		JLabel PlaylistArt_3 = new JLabel("ALBUM ART");
		PlaylistArt_3.setIcon(new ImageIcon(HomeView.class.getResource("/images2/Africa.png")));
		PlaylistArt_3.setHorizontalAlignment(SwingConstants.CENTER);
		PlaylistArt_3.setBackground(new Color(254, 254, 250));
		PlaylistArt_3.setBounds(530, 27, 164, 164);
		Dashboard.add(PlaylistArt_3);
		
		JLabel PlaylistArt_4 = new JLabel("ALBUM ART");
		PlaylistArt_4.setIcon(new ImageIcon(HomeView.class.getResource("/images2/images.png")));
		PlaylistArt_4.setHorizontalAlignment(SwingConstants.CENTER);
		PlaylistArt_4.setBackground(new Color(254, 254, 250));
		PlaylistArt_4.setBounds(51, 242, 164, 164);
		Dashboard.add(PlaylistArt_4);
		
		JLabel PlaylistArt_5 = new JLabel("ALBUM ART");
		PlaylistArt_5.setIcon(new ImageIcon(HomeView.class.getResource("/images2/brownbag.png")));
		PlaylistArt_5.setHorizontalAlignment(SwingConstants.CENTER);
		PlaylistArt_5.setBackground(new Color(254, 254, 250));
		PlaylistArt_5.setBounds(285, 242, 164, 164);
		Dashboard.add(PlaylistArt_5);
		
		JLabel PlaylistArt_6 = new JLabel("ALBUM ART");
		PlaylistArt_6.setIcon(new ImageIcon(HomeView.class.getResource("/images2/yourname.png")));
		PlaylistArt_6.setHorizontalAlignment(SwingConstants.CENTER);
		PlaylistArt_6.setBackground(new Color(254, 254, 250));
		PlaylistArt_6.setBounds(530, 242, 164, 164);
		Dashboard.add(PlaylistArt_6);
		
		JButton AlbumName_1 = new JButton("Dec my Ave");
		AlbumName_1.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_1.setBackground(new Color(254, 254, 250));
		AlbumName_1.setBounds(51, 197, 164, 23);
		AlbumName_1.setBorder(null);
		Dashboard.add(AlbumName_1);
		
		JButton AlbumName_2 = new JButton("Khalid Beats ");
		AlbumName_2.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_2.setBackground(new Color(254, 254, 250));
		AlbumName_2.setBounds(285, 197, 164, 23);
		AlbumName_2.setBorder(null);
		Dashboard.add(AlbumName_2);
		
		JButton AlbumName_3 = new JButton("Toto by Africa");
		AlbumName_3.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_3.setBackground(new Color(254, 254, 250));
		AlbumName_3.setBounds(530, 197, 175, 23);
		AlbumName_3.setBorder(null);
		Dashboard.add(AlbumName_3);
		
		JButton AlbumName_4 = new JButton("Old People Music - 80's");
		AlbumName_4.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_4.setBackground(new Color(254, 254, 250));
		AlbumName_4.setBounds(51, 418, 164, 23);
		AlbumName_4.setBorder(null);
		Dashboard.add(AlbumName_4);
		
		JButton AlbumName_5 = new JButton("Brownbag Music");
		AlbumName_5.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_5.setBackground(new Color(254, 254, 250));
		AlbumName_5.setBounds(285, 418, 164, 23);
		AlbumName_5.setBorder(null);
		Dashboard.add(AlbumName_5);
		
		JButton AlbumName_6 = new JButton("Your Name. (Original Motion Picture Soundtrack)");
		AlbumName_6.setHorizontalAlignment(SwingConstants.LEFT);
		AlbumName_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		AlbumName_6.setBackground(new Color(254, 254, 250));
		AlbumName_6.setBounds(530, 418, 175, 23);
		AlbumName_6.setBorder(null);
		Dashboard.add(AlbumName_6);
		
		JLabel lblMadeForYou = new JLabel("Playlists you might like");
		lblMadeForYou.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMadeForYou.setBounds(0, 0, 186, 23);
		Dashboard.add(lblMadeForYou);
		

		

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
	
	class Refresh_btn implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 //==========================================================   FOR LIBRARY STUFF
			 userSongs = generalModel.getInstance().gettingSongs(HomeView.getInstance().currentUser);
			 
			 DefaultListModel DLMTitle = new DefaultListModel();
			 DefaultListModel DLMArtist = new DefaultListModel();
			 DefaultListModel DLMGenre = new DefaultListModel();
			 DefaultListModel DLMAlbum = new DefaultListModel();
			 DefaultListModel DLMYear = new DefaultListModel();
			 DefaultListModel DLMFavorite = new DefaultListModel();

			 
			 for(int x = 0; x < userSongs.size(); x++) {
				 DLMTitle.addElement(userSongs.get(x).getSongName());
				 DLMArtist.addElement(userSongs.get(x).getArtistName());
				 DLMGenre.addElement(userSongs.get(x).getGenre());
				 DLMAlbum.addElement(userSongs.get(x).getAlbum());
				 DLMYear.addElement(userSongs.get(x).getYear());
				 DLMFavorite.addElement(userSongs.get(x).getFavorite());
			 }
//			 LibraryView.getInstance().Title_list.setModel(DLMTitle);
//			 LibraryView.getInstance().Artist_list.setModel(DLMArtist);
//			 LibraryView.getInstance().Genre_List.setModel(DLMGenre);
//			 LibraryView.getInstance().Album_List.setModel(DLMAlbum);
//			 LibraryView.getInstance().Year_List.setModel(DLMYear);
//			 LibraryView.getInstance().Fave_List.setModel(DLMFavorite);
			 
			 //==========================================================  FOR MOST PLAYED STUFF
			 userSongsMostPlayed = generalModel.getInstance().getMostPlayed(currentUser);
			 

//			 DefaultListModel DLMMostPlayed = new DefaultListModel();

			 
//			 for(int x = 0; x < userSongsMostPlayed.size(); x++)
//				 DLMMostPlayed.addElement(userSongsMostPlayed.get(x).getSongName() + " (" + userSongsMostPlayed.get(x).getCount() + ") ");
//			 
//			 HomeView.getInstance().MP_List.setModel(DLMMostPlayed);
//			 LibraryView.getInstance().MP_List.setModel(DLMMostPlayed);
			 //========================================================== FOR PLAYLISTS
			 userPlaylists = generalModel.getInstance().gettingPlaylists(HomeView.getInstance().currentUser);
			 DefaultListModel DLM2 = new DefaultListModel();

			
			 for(int y = 0; y < userPlaylists.size(); y++)
				 DLM2.addElement(userPlaylists.get(y).getPlaylistName());


			 HomeView.getInstance().Playlist_List.setModel(DLM2);
//			 LibraryView.getInstance().Playlist_List.setModel(DLM2);
			//==========================================================


			 Playlist_List.setModel(DLM2);

			 
			 
		 }
	 }
	
	class btn_CreatePlaylist implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {

			 CreatePlaylist.getInstance().setVisible(true);
			 CreatePlaylist.getInstance().setUsername(currentUser); 

			 
			 CreatePlaylist.getInstance().setVisible(true);
			 
			 

		 }
	 }
	
	class btn_AddSong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 AddSong.getInstance().setVisible(true);
		 }
	 }
	
	class btn_Library implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
//			 LibraryView.getInstance().setVisible(true);
//			 LibraryView.getInstance().setUserName(currentUser);
			 dispose();
		 }
	 }
	
	 class btn_Play implements ActionListener 
	 {

	     public void actionPerformed(ActionEvent e) 
	     {	 
	    	 userSongs = generalModel.getInstance().gettingSongs(HomeView.getInstance().currentUser);
	    	 System.out.println("songChangedInMP: "+songChangedInMP);
		    	if (songChangedInMP == true)
		    	 {
		    		 mp3.pause();
			    	 int SongID = userSongs.get(MP_List.getSelectedIndex()).getSongID();
		    		 generalModel.getInstance().readSongData(SongID);
		    		 generalModel.getInstance().updateCount(SongID);
		    		 mp3 = new MP3Player(new File("currentSong.mp3"));
			    	 mp3.play();
			    	 songChangedInMP = false;
			    	 
			    	 RecentlyPlayed addedSong = new RecentlyPlayedBuilder()
							 .setSongID(userSongs.get(MP_List.getSelectedIndex()).getSongID())
							 .setUserName(userSongs.get(MP_List.getSelectedIndex()).getUserName())
							 .setSongName(userSongs.get(MP_List.getSelectedIndex()).getSongName())
							 .setArtistName(userSongs.get(MP_List.getSelectedIndex()).getArtistName())
							 .setAlbum(userSongs.get(MP_List.getSelectedIndex()).getAlbum())
							 .setGenre(userSongs.get(MP_List.getSelectedIndex()).getGenre())
							 .setYear(userSongs.get(MP_List.getSelectedIndex()).getYear())
							 .setPath(userSongs.get(MP_List.getSelectedIndex()).getPath())
							 .setCount(userSongs.get(MP_List.getSelectedIndex()).getCount())
							 .setFavorite(userSongs.get(MP_List.getSelectedIndex()).getFavorite())
							 .getSong();
			    	 
			    	 RecentlyPlayedList sList = new RecentlyPlayedList();
			    	 sList.addSong(addedSong);
			    	 DefaultListModel DLM2 = new DefaultListModel();
					 for(int i = 0; i < sList.getSongListSize(); i++)
					 {
						 DLM2.addElement(sList.getSongList().get(i).getSongName());
					 }
					 RecentlyPlayedList.setModel(DLM2);
		    	 }
		    	/* else if(playSongInPlaylist == true)
			     {
		    		 mp3.pause();
			    	 int SongID2 = userPlaylists.get(Playlist_List.getSelectedIndex()).getSongInPlaylist().get(yourSongsListJList.getSelectedIndex()).getSongID();
			    	 generalModel.getInstance().readSongData(SongID2);
			    	 generalModel.getInstance().updateCount(SongID2);
			    	 mp3 = new MP3Player(new File("currentSong.mp3"));
				     mp3.play();
				   	 playSongInPlaylist = false;
			     } */else 
		    	 {
			    	 if(songPaused == true)
			    	 {
		    		 mp3.pause();
		    		 songPaused = false;
			    	 }
			    	 else
			    	 {
			    	 mp3.play();
			    	 songPaused = true;
			    	 }
		    	 }
		    	
		    	
		    	
	     }
	 }
	 
	 class btn_Stop implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 mp3.stop();
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
	 
	 public void setUserName(String currentUser) {
			this.currentUser = currentUser;
			Profile.setText("Current User: " + currentUser);
		}
		
}