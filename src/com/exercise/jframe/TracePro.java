package com.exercise.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TracePro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TracePro frame = new TracePro();
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
	public TracePro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("物流追踪");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTradeName = new JLabel("\u54C1\u540D\uFF1A");
		lbTradeName.setBounds(69, 57, 54, 15);
		contentPane.add(lbTradeName);
		
		JLabel lbTradeNameNew = new JLabel("New label");
		lbTradeNameNew.setBounds(133, 57, 232, 15);
		contentPane.add(lbTradeNameNew);
		
		JLabel lbSerialNumble = new JLabel("\u6570\u91CF\uFF1A");
		lbSerialNumble.setBounds(69, 106, 54, 15);
		contentPane.add(lbSerialNumble);
		
		JLabel lbSerialNumbleNew = new JLabel("New label");
		lbSerialNumbleNew.setBounds(133, 106, 232, 15);
		contentPane.add(lbSerialNumbleNew);
		
		JLabel lbTrace = new JLabel("\u72B6\u6001\uFF1A");
		lbTrace.setBounds(69, 163, 54, 15);
		contentPane.add(lbTrace);
		
		JLabel lbTraceNew = new JLabel("New label");
		lbTraceNew.setBounds(133, 163, 232, 15);
		contentPane.add(lbTraceNew);
		
		JButton btnTraceOK = new JButton("\u786E\u8BA4\u8FFD\u8E2A");
		btnTraceOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认追踪
				new TraceByID().setVisible(true);
				dispose();
			}
		});
		btnTraceOK.setBounds(57, 224, 93, 23);
		contentPane.add(btnTraceOK);
		
		JButton btnCancel = new JButton("\u786E\u8BA4\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认取消
				new TraceByID().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(272, 224, 93, 23);
		contentPane.add(btnCancel);
	}

}
