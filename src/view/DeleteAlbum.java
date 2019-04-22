//package view;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import controller.PlaylistBuilder;
//import controller.SongBuilder;
//import model.Playlist;
//import model.PlaylistList;
//import model.Song;
//import model.SongList;
//import model.generalModel;
//
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import java.awt.Color;
//
//public class DeleteAlbum extends JFrame {
//	private volatile static DeleteAlbum instance = null;
//	private JPanel contentPane;
//	JButton btnRemoveFromQueue;
//	JComboBox comboBoxSongs;
//
//	/**
//	 * Launch the application.
//	 */
//	public static DeleteAlbum getInstance() {
//        if (instance == null) {
//        	instance = new DeleteAlbum();
//        }
//		return instance;
//	}
//
//
//	/**
//	 * Create the frame.
//	 */
//	public DeleteAlbum() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 250, 200);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(255,255,250));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		comboBoxSongs = new JComboBox();
//		comboBoxSongs.setBounds(53, 56, 127, 28);
//		contentPane.add(comboBoxSongs);
//		
//		JLabel lblSongs = new JLabel("Song:");
//		lblSongs.setBounds(92, 31, 58, 14);
//		contentPane.add(lblSongs);
//		
//		btnRemoveFromQueue = new JButton("Remove from Queue");
//		btnRemoveFromQueue.setBackground(new Color(255, 255, 255));
//		btnRemoveFromQueue.addActionListener(new btn_AddToPlaylist());
//		btnRemoveFromQueue.setBounds(40, 95, 154, 28);
//		contentPane.add(btnRemoveFromQueue);
//	}
//	
//	class btn_AddToPlaylist implements ActionListener
//	 {
//		 public void actionPerformed(ActionEvent e)
//		 {		
//			 int i, j;
//			 
//		 	 SongList sl = new SongList();
//		 	 PlaylistList pl = new PlaylistList();
//		 	 
//		 	 String currUser = RegisteredUserView.getInstance().currentUser;
//		 	 
//		 	 for(i = 0; i < generalModel.getInstance().getUserPlaylist(currUser).size(); i++)
//		 	 {	
//		 		 if(comboBoxPlaylists.getSelectedItem().equals(generalModel.getInstance().getUserPlaylist(currUser).get(i).getPlaylistName()))
//		 		 {
//		 			for(j = 0; j < generalModel.getInstance().gettingSongs(currUser).size(); j++)
//		 			{
//					 	if (comboBoxSongs.getSelectedItem().equals(generalModel.getInstance().gettingSongs(currUser).get(j).getSongName()))
//					 	{				
//					 		generalModel.getInstance().getUserPlaylist(currUser).get(i).addSongToPlaylist(generalModel.getInstance().gettingSongs(currUser).get(j));       
//					 		//System.out.print(generalModel.getInstance().getUserPlaylist(currUser).get(i).getSongInPlaylist().get(j).getSongName());
//					 		//System.out.print(pl.getPlaylistList().get(i).getSongInPlaylist().get(j).getSongName());
//					 		
//					 		
//					 	}
//		 			}
//		 		 }
//		 	 }
//		 	 
//		 	 
//		 		System.out.println(generalModel.getInstance().getUserPlaylist(currUser).get(comboBoxPlaylists.getSelectedIndex()).getSongInPlaylist().get(0).getSongName());
//		 	 
//				
//		 		dispose();
//		 	 
//		 	 
//			 
//		 }
//	 }
//}
