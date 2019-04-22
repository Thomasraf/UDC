package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SongBuilder;
import controller.generalController;
import model.Database;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class SearchView extends JFrame {
	private volatile static SearchView instance = null;
	private JPanel contentPane;
	JButton btnSearch;
	String fileName;
	private JTextField textFieldSearchParameter;
	private JLabel lblSearch;
	String searchText;
	String text;
	String currentUser;

	public static SearchView getInstance() {
        if (instance == null) {
        	instance = new SearchView();
        }
		return instance;
	}
	

	/**
	 * Create the frame.
	 */
	public SearchView() {
		setTitle("Not So Spotify");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Antonello Santos\\Documents\\DesignChallenge2\\src\\images\\spotify.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 149);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSearch = new JButton("Search ");
		btnSearch.setBounds(179, 70, 89, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new btn_Search());
		
		textFieldSearchParameter = new JTextField();
		textFieldSearchParameter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSearchParameter.setColumns(10);
		textFieldSearchParameter.setBounds(82, 21, 202, 30);
		contentPane.add(textFieldSearchParameter);
		
		lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearch.setBounds(10, 11, 95, 44);
		contentPane.add(lblSearch);
		}
	
	class btn_Search implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 searchText = textFieldSearchParameter.getText();
			 SearchResultView.getInstance().setText(searchText);
			 SearchResultView.getInstance().setUsername(currentUser);
			 SearchResultView.getInstance().setVisible(true);
		 }
	 }
	
	public void setUsername(String currentUser) {
		this.currentUser = currentUser;
	}
}
