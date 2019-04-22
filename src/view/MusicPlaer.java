package view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;
import model.PlaylistList;
import model.SongList;
import model.account;
import model.generalModel;
import view.LoggingInView.confirmButton;

public class MusicPlaer extends JFrame {

	MP3Player mp3 = new MP3Player(new File("C:\\Users\\Nello Santos\\Desktop\\Music\\DecAve.mp3"));
	private JPanel contentPane;
	//private signingUp currentUser;
	JButton btnPickPlaylist, btnAddSongToPlaylist, btnCreatePlaylist, btnUploadSong, btnEditSong, btnPlay, btnPause, btnNextSong, btnPreviousSong, btnSongInfo;
	JList yourSongsList, playlistList;
	JTextPane txtpnSongNameGenre;
	private JButton btnRefresh;
	account registeredAccount;
	private volatile static MusicPlaer instance = null;
	String registeredUsername;
	InfoSong songInformation;

	public static MusicPlaer getInstance() {
        if (instance == null) {
        	instance = new MusicPlaer();
        }
		return instance;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicPlaer frame = new MusicPlaer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public MusicPlaer() {

		MP3Player mp3 = new MP3Player(new File("C:\\Users\\Nello Santos\\Desktop\\Music\\DecAve.mp3"));
		songInformation = new InfoSong();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 1189, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnPlay = new JButton("");
		 btnPlay.setIcon(new ImageIcon("C:\\Users\\Antonello Santos\\Documents\\GitHub\\DesignChallenge2\\src\\images\\play-button.png"));
		btnPlay.addActionListener(new btn_Play());
		btnPlay.setBounds(492, 681, 89, 45);
		contentPane.add(btnPlay);
		
		 btnPause = new JButton("");
		 btnPause.setIcon(new ImageIcon(RegisteredUserView.class.getResource("/images/pause-button.png")));
		btnPause.addActionListener(new btn_Pause());
		btnPause.setBounds(593, 681, 89, 45);
		contentPane.add(btnPause);
		
		 btnNextSong = new JButton("");
		 btnNextSong.setIcon(new ImageIcon(RegisteredUserView.class.getResource("/images/skip-to-next-track.png")));
		btnNextSong.setBounds(705, 681, 89, 45);
		contentPane.add(btnNextSong);
		
		 btnPreviousSong = new JButton("");
		 btnPreviousSong.setIcon(new ImageIcon(RegisteredUserView.class.getResource("/images/back-track.png")));
		btnPreviousSong.setBounds(380, 681, 89, 45);
		contentPane.add(btnPreviousSong);
		
		 playlistList = new JList();
		playlistList.setBounds(25, 93, 322, 558);
		contentPane.add(playlistList);
		
		JList playlistSongList = new JList();
		playlistSongList.setBounds(403, 139, 375, 224);
		contentPane.add(playlistSongList);
		
		btnPickPlaylist = new JButton("Bird ni Josh");
		btnPickPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPickPlaylist.setBounds(25, 664, 136, 45);
		contentPane.add(btnPickPlaylist);
		
		 btnAddSongToPlaylist = new JButton("Add Song to Playlist");
		btnAddSongToPlaylist.addActionListener(new btn_AddSongToPlaylist());
		btnAddSongToPlaylist.setBounds(957, 664, 190, 45);
		contentPane.add(btnAddSongToPlaylist);
		
		 txtpnSongNameGenre = new JTextPane();
		txtpnSongNameGenre.setBounds(403, 405, 375, 209);
		txtpnSongNameGenre.setText("Song Name: \r\nGenre: \r\n");
		contentPane.add(txtpnSongNameGenre);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setBounds(403, 373, 95, 26);
		contentPane.add(lblSongInfo);
		
		 btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new btn_CreatePlaylist());
		btnCreatePlaylist.setBounds(53, 11, 118, 45);
		contentPane.add(btnCreatePlaylist);
		
		 btnUploadSong = new JButton("Upload Song");
		btnUploadSong.addActionListener(new btn_UploadSong());
		btnUploadSong.setBounds(1052, 11, 95, 45);
		contentPane.add(btnUploadSong);
		
		 yourSongsList = new JList();
		yourSongsList.setBounds(806, 94, 341, 557);
		contentPane.add(yourSongsList);
		
		JLabel lblSongsInPlaylist = new JLabel("Songs in Playlist");
		lblSongsInPlaylist.setBounds(403, 112, 101, 26);
		contentPane.add(lblSongsInPlaylist);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(53, 69, 95, 14);
		contentPane.add(lblPlaylists);
		
		JLabel lblYourSongs = new JLabel("Your Songs");
		lblYourSongs.setBounds(825, 69, 95, 14);
		contentPane.add(lblYourSongs);
		
		 btnEditSong = new JButton("Edit Song");
		btnEditSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditSong.setBounds(953, 11, 89, 45);
		contentPane.add(btnEditSong);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new btn_Refresh());
		btnRefresh.setBounds(738, 21, 97, 25);
		contentPane.add(btnRefresh);
		
		JLabel lblUser = new JLabel("Current User:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setBounds(418, 20, 118, 16);
		contentPane.add(lblUser);
		
		JButton shuffleButton = new JButton("");
		shuffleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		shuffleButton.setIcon(new ImageIcon(RegisteredUserView.class.getResource("/images/shuffle.png")));
		shuffleButton.setBounds(279, 681, 89, 45);
		contentPane.add(shuffleButton);
		
		JButton repeatButton = new JButton("");
		repeatButton.setIcon(new ImageIcon(RegisteredUserView.class.getResource("/images/repeat.png")));
		repeatButton.setBounds(806, 681, 89, 45);
		contentPane.add(repeatButton);
		
		JLabel usernameField = new JLabel("");
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		usernameField.setBounds(529, -1, 153, 57);
		usernameField.setText(gettingUsername(registeredUsername)); //making the username
		contentPane.add(usernameField);
		
		btnSongInfo = new JButton("Song Info");
		btnSongInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSongInfo.setBounds(854, 11, 89, 45);
		contentPane.add(btnSongInfo);
		btnSongInfo.addActionListener(new songInfo());
	}
	
	 class btn_Play implements ActionListener 
	 {

	     public void actionPerformed(ActionEvent e) 
	     {
	        mp3.play();

	     }
	 }
	 
	 class btn_Pause implements ActionListener 
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 mp3.pause();
		 }
	 }
	 
	 class btn_UploadSong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 AddSong as = AddSong.getInstance();
			 as.setVisible(true);
			 
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

			 playlistList.setModel(DLM2);
			 
			 
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
	 
	 class btn_AddSongToPlaylist implements ActionListener
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
	 
	 public String gettingUsername(String w) {
		 String username = w;
		 return username;
	 }
	 
	 class songInfo implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 songInformation.setVisible(true);
		 }
	 }
	 
	 public void seeingSongInformation(InfoSong songInformation) {
			this.songInformation = songInformation;
		}
}
