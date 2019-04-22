package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class NotificationView extends JFrame {

	private JPanel contentPane;
	boolean evenClick = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotificationView frame = new NotificationView();
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
	public NotificationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254,254,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MainRectangle = new JPanel();
		MainRectangle.setBackground(new Color(30,58,42));
		MainRectangle.setBounds(0, 570, 398, 91);
		contentPane.add(MainRectangle);
		MainRectangle.setLayout(null);
		
		JLabel SongName = new JLabel("(Song Name)");
		SongName.setHorizontalAlignment(SwingConstants.CENTER);
		SongName.setForeground(new Color(255, 255, 255));
		SongName.setFont(new Font("Calibri", Font.PLAIN, 14));
		SongName.setBounds(10, 21, 72, 17);
		MainRectangle.add(SongName);
		
		JLabel Artist = new JLabel("(Artist)");
		Artist.setHorizontalAlignment(SwingConstants.CENTER);
		Artist.setForeground(Color.WHITE);
		Artist.setFont(new Font("Calibri", Font.PLAIN, 12));
		Artist.setBounds(10, 38, 37, 16);
		MainRectangle.add(Artist);
		
		JLabel Album = new JLabel("(Album)");
		Album.setHorizontalAlignment(SwingConstants.CENTER);
		Album.setForeground(Color.WHITE);
		Album.setFont(new Font("Calibri", Font.PLAIN, 12));
		Album.setBounds(10, 54, 43, 16);
		MainRectangle.add(Album);
		
		JButton Prevbtn = new JButton("");
		Prevbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/back (2).png")));
		Prevbtn.setBackground(new Color(30, 58, 42));
		Prevbtn.setBounds(183, 21, 45, 45);
		Prevbtn.setBorder(null);
		MainRectangle.add(Prevbtn);
		
		JButton Playbtn = new JButton("");
		Playbtn.setBounds(238, 13, 65, 65);
		MainRectangle.add(Playbtn);
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
		Playbtn.setBackground(new Color(30, 58, 42));
		Playbtn.setBorder(null);
		
		JButton Nextbtn = new JButton("");
		Nextbtn.setBounds(313, 21, 45, 45);
		MainRectangle.add(Nextbtn);
		Nextbtn.setIcon(new ImageIcon(HomeView.class.getResource("/images2/next (2).png")));
		Nextbtn.setBackground(new Color(30, 58, 42));
		Nextbtn.setBorder(null);
		
		JPanel TopBar = new JPanel();
		TopBar.setLayout(null);
		TopBar.setBackground(new Color(30, 58, 42));
		TopBar.setBounds(0, 0, 398, 68);
		contentPane.add(TopBar);
		
		JButton Notificationbtn = new JButton("");
		Notificationbtn.setIcon(new ImageIcon(NotificationView.class.getResource("/images2/notifications-button.png")));
		Notificationbtn.setBorder(null);
		Notificationbtn.setBackground(new Color(30, 58, 42));
		Notificationbtn.setBounds(343, 11, 45, 45);
		TopBar.add(Notificationbtn);
		
		JButton ProfilePic = new JButton("");
		ProfilePic.setIcon(new ImageIcon(NotificationView.class.getResource("/images2/user-avatar-main-picture.png")));
		ProfilePic.setBorder(null);
		ProfilePic.setBackground(new Color(254,254,250));
		ProfilePic.setBounds(10, 11, 45, 45);
		TopBar.add(ProfilePic);
		
		JButton ProfileName = new JButton("Profile Name");
		ProfileName.setHorizontalAlignment(SwingConstants.LEFT);
		ProfileName.setBorder(null);
		ProfileName.setBounds(65, 20, 145, 23);
		ProfileName.setBackground(new Color(30,58,42));
		ProfileName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ProfileName.setForeground(Color.WHITE);
		TopBar.add(ProfileName);
		
		JPanel Notification1 = new JPanel();
		Notification1.setBackground(new Color(242, 203, 155));
		Notification1.setBounds(0, 98, 398, 79);
		contentPane.add(Notification1);
		Notification1.setLayout(null);
		
		JLabel lblRafaelAddedMy = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		lblRafaelAddedMy.setHorizontalAlignment(SwingConstants.CENTER);
		lblRafaelAddedMy.setBounds(0, 0, 398, 79);
		Notification1.add(lblRafaelAddedMy);
		lblRafaelAddedMy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(254,254,250));
		panel.setBounds(0, 177, 398, 79);
		contentPane.add(panel);
		
		JLabel label_1 = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(0, 0, 398, 79);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(242, 203, 155));
		panel_1.setBounds(0, 256, 398, 79);
		contentPane.add(panel_1);
		
		JLabel label_2 = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(0, 0, 398, 79);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(254, 254, 250));
		panel_2.setBounds(0, 336, 398, 79);
		contentPane.add(panel_2);
		
		JLabel label_3 = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(0, 0, 398, 79);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(242, 203, 155));
		panel_3.setBounds(0, 415, 398, 79);
		contentPane.add(panel_3);
		
		JLabel label_4 = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(0, 0, 398, 79);
		panel_3.add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(254, 254, 250));
		panel_4.setBounds(0, 494, 398, 79);
		contentPane.add(panel_4);
		
		JLabel label_5 = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(0, 0, 398, 79);
		panel_4.add(label_5);
		
		JLabel lblNewsFeed = new JLabel("News Feed");
		lblNewsFeed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewsFeed.setBounds(0, 68, 398, 32);
		contentPane.add(lblNewsFeed);
		
		JLabel label = new JLabel("Rafael added My Bad  by Khalid to Khalid Beats");
		label.setBackground(new Color(254,254,250));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(0, 0, 398, 79);


	}
}
