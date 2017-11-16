package com.exercise.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TraceByID extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldlbSerialNumble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraceByID frame = new TraceByID();
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
	public TraceByID() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("追踪物品");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbSerialNumble = new JLabel("\u7F16\u7801\uFF1A");
		lbSerialNumble.setBounds(79, 94, 54, 15);
		contentPane.add(lbSerialNumble);
		
		JButton btnComfirm = new JButton("\u786E\u8BA4");
		btnComfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//追踪确认
				new TracePro().setVisible(true);
				dispose();
				
			}
		});
		btnComfirm.setBounds(58, 209, 93, 23);
		contentPane.add(btnComfirm);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//追踪取消
				new Function().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(279, 209, 93, 23);
		contentPane.add(btnCancel);
		
		textFieldlbSerialNumble = new JTextField();
		textFieldlbSerialNumble.setBounds(162, 91, 186, 21);
		contentPane.add(textFieldlbSerialNumble);
		textFieldlbSerialNumble.setColumns(10);
	}

}
