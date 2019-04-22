package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.generalController;
import model.account;
import model.generalModel;
import view.LoggingInView.confirmButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InfoSong extends JFrame{
	
	AddSong song;
	String songTitle,artistName,albumName,genreName,yearDate;
	
	public InfoSong() {
		
		this.setSize(650, 700);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 55, 614, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSongTitle = new JLabel("");
		lblSongTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSongTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSongTitle.setBounds(20, 69, 604, 49);
		lblSongTitle.setText(gettingSong(songTitle));
		getContentPane().add(lblSongTitle);
		
		JLabel lblArtist = new JLabel("Artist:");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArtist.setBounds(10, 168, 614, 23);
		getContentPane().add(lblArtist);
		
		JLabel lblArtistName = new JLabel("");
		lblArtistName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtistName.setBounds(20, 182, 604, 49);
		lblArtistName.setText(gettingArtist(artistName));
		getContentPane().add(lblArtistName);
		
		JLabel lblAlbum = new JLabel("Album Name");
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlbum.setBounds(10, 266, 614, 23);
		getContentPane().add(lblAlbum);
		
		JLabel lblAlbumName = new JLabel("");
		lblAlbumName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAlbumName.setBounds(20, 280, 604, 49);
		lblAlbumName.setText(gettingAlbum(albumName));
		getContentPane().add(lblAlbumName);
		
		JLabel lblGenre = new JLabel("Genre Type");
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenre.setBounds(10, 361, 614, 23);
		getContentPane().add(lblGenre);
		
		JLabel lblGenreName = new JLabel("");
		lblGenreName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenreName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGenreName.setBounds(20, 375, 604, 49);
		lblGenreName.setText(gettingGenre(genreName));
		getContentPane().add(lblGenreName);
		
		
		
		JLabel lblReleaseDate = new JLabel("Year Of Release");
		lblReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReleaseDate.setBounds(10, 476, 614, 23);
		getContentPane().add(lblReleaseDate);
		
		JLabel lblYearOfRelease = new JLabel("");
		lblYearOfRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearOfRelease.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblYearOfRelease.setBounds(20, 490, 604, 49);
		lblYearOfRelease.setText(gettingYear(yearDate));
		getContentPane().add(lblYearOfRelease);
		
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(496, 597, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new confirmButton());
	}
	
	class confirmButton implements ActionListener
	{
	public void actionPerformed (ActionEvent account)
		{
			closingWindow();
		}
	}

	private String gettingYear(String e) {
		String year = e;
		return year;
	}

	private String gettingGenre(String d) {
		String genre = d;
		return genre;
	}

	private String gettingAlbum(String c) {
		String album = c;
		return album;
	}

	private String gettingArtist(String b) {
		String artist = b;
		return artist;
	}

	private String gettingSong(String a) {
		String title = a;
		return title;
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}

}
