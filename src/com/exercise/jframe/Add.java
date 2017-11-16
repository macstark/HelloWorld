package com.exercise.jframe;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.bjsxt.logistics.entity.Product;
import com.bjsxt.logistics.impldao.ProductImpDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Add extends JFrame {

	private static final long serialVersionUID = 853973405013196679L;
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
					Add frame = new Add();
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
	public Add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 451);
		getContentPane().setLayout(null);

		JLabel lblName = new JLabel("\u54C1\u540D\uFF1A");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("楷体", Font.BOLD, 18));
		lblName.setBounds(76, 45, 103, 42);
		getContentPane().add(lblName);

		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setBounds(177, 45, 199, 42);
		setTitle("添加");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add(textName);
		textName.setColumns(10);

		JLabel lblId = new JLabel("\u7F16\u53F7\uFF1A");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("楷体", Font.BOLD, 18));
		lblId.setBounds(74, 106, 103, 42);
		getContentPane().add(lblId);

		JLabel lblFromPlace = new JLabel("\u4EA7\u5730\uFF1A");
		lblFromPlace.setHorizontalAlignment(SwingConstants.LEFT);
		lblFromPlace.setFont(new Font("楷体", Font.BOLD, 18));
		lblFromPlace.setBounds(74, 169, 103, 42);
		getContentPane().add(lblFromPlace);

		textId = new JTextField();
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setBounds(177, 106, 199, 42);
		getContentPane().add(textId);
		textId.setColumns(10);

		textFromPlace = new JTextField();
		textFromPlace.setHorizontalAlignment(SwingConstants.CENTER);
		textFromPlace.setBounds(177, 169, 199, 42);
		getContentPane().add(textFromPlace);
		textFromPlace.setColumns(10);

		JLabel lblCount = new JLabel("\u6570\u91CF\uFF1A");
		lblCount.setHorizontalAlignment(SwingConstants.LEFT);
		lblCount.setFont(new Font("楷体", Font.BOLD, 18));
		lblCount.setBounds(74, 226, 103, 42);
		getContentPane().add(lblCount);

		textCount = new JTextField();
		textCount.setHorizontalAlignment(SwingConstants.CENTER);
		textCount.setBounds(177, 226, 199, 42);
		getContentPane().add(textCount);
		textCount.setColumns(10);

		JLabel lbltoPlace = new JLabel("\u53D1\u5F80\u5730\uFF1A");
		lbltoPlace.setHorizontalAlignment(SwingConstants.LEFT);
		lbltoPlace.setFont(new Font("楷体", Font.BOLD, 18));
		lbltoPlace.setBounds(74, 278, 103, 42);
		getContentPane().add(lbltoPlace);

		textToPlace = new JTextField();
		textToPlace.setHorizontalAlignment(SwingConstants.CENTER);
		textToPlace.setBounds(177, 278, 199, 42);
		getContentPane().add(textToPlace);
		textToPlace.setColumns(10);

		JButton btnSave = new JButton("\u5F55\u5165");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 录入：
				// 获取文本框信息
				String name = textName.getText();
				String id1 = textId.getText();
				int id = Integer.parseInt(id1);
				String fromPlace = textFromPlace.getText();
				int count = Integer.parseInt(textCount.getText());
				String toPlace = textToPlace.getText();

				// 创建产品对象
				Product pt = new Product(name, id, fromPlace, count, toPlace);
				// 添加对象
				ProductImpDao pi = new ProductImpDao();
				pi.addPro(pt);
				JOptionPane.showMessageDialog(null, "添加成功");
				// 跳转界面
				new Function().setVisible(true);
				dispose();
			}
		});
		btnSave.setBounds(64, 343, 103, 42);
		getContentPane().add(btnSave);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 取消
				new Function().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(273, 343, 103, 42);
		getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Add.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 437, 422);
		getContentPane().add(lblNewLabel);
	}
}
