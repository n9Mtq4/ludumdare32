package com.n9mtq4.ludum.uw;

import com.n9mtq4.ludum.uw.engine.entitiy.mob.Player;
import com.n9mtq4.ludum.uw.game.entity.projectiles.PillowProjectile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by will on 4/20/15 at 4:15 PM.
 */
public class Cheater {
	
	private JFrame frame;
	private JPanel contentPanel;
	private JTextField fireRate;
	private JTextField range;
	private JCheckBox invincible;
	private JButton save;
	
	public Cheater() {
		gui();
	}
	
	public void gui() {
		
		frame = new JFrame("Cheat!");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		fireRate = new JTextField(String.valueOf(PillowProjectile.rateOfFire));
		range = new JTextField(String.valueOf(PillowProjectile.sRange));
		invincible = new JCheckBox("Player Invincibility");
		invincible.setSelected(false);
		contentPanel = new JPanel(new GridLayout(3, 2));
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PillowProjectile.rateOfFire = Integer.parseInt(fireRate.getText());
					PillowProjectile.sRange = Integer.parseInt(range.getText());
					Player.invincible = invincible.isSelected();
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Oops something went wrong: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		contentPanel.add(l("Rate of fire in 60th of seconds"));
		contentPanel.add(fireRate);
		contentPanel.add(l("Range in pixels"));
		contentPanel.add(range);
		contentPanel.add(invincible);
		
		frame.add(contentPanel, BorderLayout.CENTER);
		frame.add(save, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		frame.getRootPane().setDefaultButton(save);
		
	}
	
	private JLabel l(String s) {
		return new JLabel(s);
	}
	
}
