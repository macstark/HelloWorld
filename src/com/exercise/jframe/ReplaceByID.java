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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ReplaceByID extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReplaceByID frame = new ReplaceByID();
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
	public ReplaceByID() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("修改");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbSerialNumble = new JLabel("\u7F16\u7801\uFF1A");
		lbSerialNumble.setFont(new Font("楷体", Font.BOLD, 18));
		lbSerialNumble.setHorizontalAlignment(SwingConstants.CENTER);
		lbSerialNumble.setBounds(37, 79, 93, 35);
		contentPane.add(lbSerialNumble);

		textField = new JTextField();
		textField.setBounds(130, 81, 252, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSeek = new JButton("\u641C\u7D22");
		btnSeek.setFont(new Font("楷体", Font.BOLD, 18));
		btnSeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 搜索
				// 获取文本框中的编号
				int id = Integer.parseInt(textField.getText());
				Product pt = new ProductImpDao().getPro(id);
				if (pt != null) {
					new ReplacePro().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "编号不存在");
				}

			}
		});
		btnSeek.setBounds(64, 194, 93, 35);
		contentPane.add(btnSeek);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setFont(new Font("楷体", Font.BOLD, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 取消
				new Function().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(267, 194, 93, 35);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ReplaceByID.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
	}

}
