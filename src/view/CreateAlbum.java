
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlbumBuilder;
import controller.SongBuilder;
import controller.generalController;
import model.Album;
import model.AlbumList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CreateAlbum extends JFrame {
	private volatile static CreateAlbum instance = null;
	private JPanel contentPane;
	private JTextField textFieldEnterAlbumName;
	JButton btnCreateAlbum;
	String fileName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static CreateAlbum getInstance() {
        if (instance == null) {
        	instance = new CreateAlbum();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	public CreateAlbum() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEnterAlbumName = new JTextField();
		textFieldEnterAlbumName.setBounds(30, 39, 407, 20);
		contentPane.add(textFieldEnterAlbumName);
		textFieldEnterAlbumName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Album Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 14, 112, 14);
		contentPane.add(lblNewLabel);
		
		btnCreateAlbum = new JButton("Create Album");
		btnCreateAlbum.addActionListener(new btn_CreatePlaylist());
		btnCreateAlbum.setBounds(336, 228, 101, 23);
		contentPane.add(btnCreateAlbum);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(250, 95, 187, 122);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Description:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(312, 70, 80, 14);
		contentPane.add(label);
		
		JButton btnChooseImg = new JButton("Choose Image");
		btnChooseImg.setBounds(30, 228, 101, 23);
		contentPane.add(btnChooseImg);
		
		JLabel AlbumImagelbl = new JLabel("Image:");
		AlbumImagelbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AlbumImagelbl.setBounds(60, 66, 56, 23);
		contentPane.add(AlbumImagelbl);
		
		JLabel lblNewLabel_1 = new JLabel("Album Image here");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 91, 160, 126);
		contentPane.add(lblNewLabel_1);
		btnChooseImg.addActionListener(new btn_ChooseImg());
	}
	
	class btn_ChooseImg implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JFileChooser chooser = new JFileChooser();
			 chooser.showOpenDialog(null);
			 File f = chooser.getSelectedFile();
			 System.out.println(f.getAbsolutePath());
			 fileName = f.getAbsolutePath();
//			 textFieldChosenFile.setText(fileName);
		}
		
	}
	
	class btn_CreatePlaylist implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 String albumName = textFieldEnterAlbumName.getText();
			 String username = ArtistView.getInstance().currentUser;

			 
			 boolean isTrue = true;
			 

			 String favorite = "0";


			 Album addedAlbum = new AlbumBuilder()
					 .setAlbumName(albumName)
					 .setUsername(username)
					 .setPath(fileName)
					 .getAlbum();

			 AlbumList aList = new AlbumList();
			 
			 generalController.getInstance().addAlbum(addedAlbum);
			 
//			 for(int i = 0; i < generalModel.getInstance().getUserAlbum(username).size();i++)
//			 {
//				 if(albumName.equals(generalModel.getInstance().getUserAlbum(username).get(i).getPlaylistName()))
//				 {
//					 JOptionPane.showMessageDialog(null,"Album already exists");
//					 dispose();
//					 isTrue = false;
//				 }
//			 }
			 
//			 if(isTrue != false)
//			 {
//				 aList.addEvent(addedAlbum);
//				 int index = aList.getIndex(addedAlbum);
//			 
////				 generalModel.getInstance().getAlbumData(addedAlbum);
////				 generalController.getInstance().gettingUserAlbum(username, albumName, favorite);
//				 JOptionPane.showMessageDialog(null, "Added " + albumName + " album!");
//			 
//				 
//				 dispose();
//			 
//			 }
			 


		 }
		 }
	 
	
	public void closingWindow() {
		this.setVisible(false);
	}
 }