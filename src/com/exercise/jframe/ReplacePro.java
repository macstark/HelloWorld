package com.exercise.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bjsxt.logistics.entity.Product;
import com.bjsxt.logistics.impldao.ProductImpDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ReplacePro extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textId;
	private JTextField textFromPlace;
	private JTextField textCount;
	private JTextField textToPlace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReplacePro frame = new ReplacePro();
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
	public ReplacePro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("修改");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTradeName = new JLabel("\u54C1\u540D\uFF1A");
		lbTradeName.setFont(new Font("楷体", Font.BOLD, 16));
		lbTradeName.setHorizontalAlignment(SwingConstants.CENTER);
		lbTradeName.setBounds(45, 49, 93, 38);
		contentPane.add(lbTradeName);
		
		textName = new JTextField();
		textName.setBounds(148, 49, 228, 38);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lbSerialNumble = new JLabel("\u7F16\u7801\uFF1A");
		lbSerialNumble.setFont(new Font("楷体", Font.BOLD, 16));
		lbSerialNumble.setHorizontalAlignment(SwingConstants.CENTER);
		lbSerialNumble.setBounds(45, 111, 93, 38);
		contentPane.add(lbSerialNumble);
		
		textId = new JTextField();
		textId.setBounds(148, 111, 228, 38);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lbProductionPlace = new JLabel("\u4EA7\u5730\uFF1A");
		lbProductionPlace.setFont(new Font("楷体", Font.BOLD, 16));
		lbProductionPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lbProductionPlace.setBounds(45, 174, 93, 38);
		contentPane.add(lbProductionPlace);
		
		textFromPlace = new JTextField();
		textFromPlace.setBounds(148, 174, 228, 38);
		contentPane.add(textFromPlace);
		textFromPlace.setColumns(10);
		
		JLabel lbQuantity = new JLabel("\u6570\u91CF\uFF1A");
		lbQuantity.setFont(new Font("楷体", Font.BOLD, 16));
		lbQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lbQuantity.setBounds(45, 233, 93, 38);
		contentPane.add(lbQuantity);
		
		textCount = new JTextField();
		textCount.setBounds(148, 233, 228, 38);
		contentPane.add(textCount);
		textCount.setColumns(10);
		
		JLabel lbSentTo = new JLabel("\u53D1\u5F80\u5730\uFF1A");
		lbSentTo.setFont(new Font("楷体", Font.BOLD, 16));
		lbSentTo.setHorizontalAlignment(SwingConstants.CENTER);
		lbSentTo.setBounds(45, 296, 93, 38);
		contentPane.add(lbSentTo);
		
		textToPlace = new JTextField();
		textToPlace.setBounds(148, 296, 228, 38);
		contentPane.add(textToPlace);
		textToPlace.setColumns(10);
		
		JButton btnNewAmend = new JButton("\u4FEE\u6539");
		btnNewAmend.setFont(new Font("楷体", Font.BOLD, 18));
		btnNewAmend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				String name = textName.getText();
				int id = Integer.parseInt(textId.getText());
				String fromPlace = textFromPlace.getText();
				int count = Integer.parseInt(textCount.getText());
				String toPlace = textToPlace.getText();
				//
				Product pt = new Product(name, id, fromPlace, count, toPlace);
				new ProductImpDao().addPro(pt);
				JOptionPane.showMessageDialog(null, "修改成功");
				new Function().setVisible(true);
				dispose();
			}
		});
		btnNewAmend.setBounds(58, 365, 110, 38);
		contentPane.add(btnNewAmend);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setFont(new Font("楷体", Font.BOLD, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取消
				new ReplaceByID().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(246, 365, 110, 38);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReplacePro.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 414, 437);
		contentPane.add(lblNewLabel);
	}

}
