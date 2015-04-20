package com.n9mtq4.ludum.uw;

import com.n9mtq4.ludum.uw.game.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by will on 4/18/15 at 10:31 AM.
 */
public class Launcher {
	
	private String[] args;
	private JFrame frame;
	private JButton start;
	private JButton source;
	private JButton exit;
	private JButton cheater;
	private JPanel buttonPanel;
	private JPanel logoPanel;
	
	public Launcher(String[] args) {
		
		this.args = args;
		frame = new JFrame("Launcher | n9Mtq4 | LD32");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start = new JButton("Start");
		start.addActionListener(new AL());
		source = new JButton("See Source");
		source.addActionListener(new AL());
		cheater = new JButton("Cheat");
		cheater.addActionListener(new AL());
		exit = new JButton("Close");
		exit.addActionListener(new AL());
		
		try {
			final BufferedImage i = ImageIO.read(Launcher.class.getResource("/logo/banner.png"));
			logoPanel = new JPanel() {
				protected void paintComponent(Graphics graphics) {
					super.paintComponent(graphics);
					graphics.drawImage(i, 0, 0, null);
				}
			};
			logoPanel.setPreferredSize(new Dimension(i.getWidth(), i.getHeight()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		buttonPanel = new JPanel(new GridLayout(2, 2));
		buttonPanel.add(source);
		buttonPanel.add(start);
		buttonPanel.add(cheater);
		buttonPanel.add(exit);
		
		frame.add(logoPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getRootPane().setDefaultButton(start);
		
	}
	
	private class AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonText = ((JButton) e.getSource()).getText();
			if (buttonText.equalsIgnoreCase("start")) {
				GameWindow.main(args);
				frame.dispose();
			}else if (buttonText.equalsIgnoreCase("see source")) {
				try {
					Desktop.getDesktop().browse(new URL("https://github.com/n9Mtq4/ludumdare32").toURI());
				}catch (IOException e1) {
					e1.printStackTrace();
				}catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}else if (buttonText.equalsIgnoreCase("close")) {
				System.exit(0);
			}else if (buttonText.equalsIgnoreCase("cheat")) {
				new Cheater();
			}
		}
	}
	
	public static void main(String[] args) {
		
		new Launcher(args);
		
	}
	
}
