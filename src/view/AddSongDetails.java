package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
public class AddSongDetails extends JFrame{
	private JTextField SongTextField;
	private JTextField ArtistTextField;
	private JTextField GenreTextField;
	private JTextField DateTextField;
	private JTextField AlbumTextField;
	public AddSongDetails() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Song Details");
		lblNewLabel.setBounds(659, 31, 212, 76);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		getContentPane().add(lblNewLabel);
		
		JLabel lblSongTitle = new JLabel("Song Title");
		lblSongTitle.setBounds(10, 71, 116, 54);
		lblSongTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblSongTitle);
		
		SongTextField = new JTextField();
		SongTextField.setBounds(10, 113, 300, 30);
		getContentPane().add(SongTextField);
		SongTextField.setColumns(10);
		
		ArtistTextField = new JTextField();
		ArtistTextField.setBounds(10, 165, 300, 30);
		ArtistTextField.setColumns(10);
		getContentPane().add(ArtistTextField);
		
		JLabel lblArtist = new JLabel("Artist ");
		lblArtist.setBounds(10, 136, 60, 32);
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblArtist);
		
		GenreTextField = new JTextField();
		GenreTextField.setBounds(10, 220, 300, 30);
		GenreTextField.setColumns(10);
		getContentPane().add(GenreTextField);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 190, 68, 39);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblGenre);
		
		DateTextField = new JTextField();
		DateTextField.setBounds(10, 275, 300, 30);
		DateTextField.setColumns(10);
		getContentPane().add(DateTextField);
		
		JLabel lblDateMade = new JLabel("Date Made");
		lblDateMade.setBounds(10, 250, 68, 31);
		lblDateMade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblDateMade);
		
		AlbumTextField = new JTextField();
		AlbumTextField.setBounds(10, 325, 300, 30);
		AlbumTextField.setColumns(10);
		getContentPane().add(AlbumTextField);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(10, 303, 57, 27);
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblAlbum);
		
		JLabel lblSongDetails = new JLabel("Song Details");
		lblSongDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSongDetails.setBounds(194, 11, 116, 54);
		getContentPane().add(lblSongDetails);
	}
}
