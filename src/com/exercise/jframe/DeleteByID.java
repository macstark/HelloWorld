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

public class DeleteByID extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteByID frame = new DeleteByID();
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
	public DeleteByID() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("删除");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbSerialNumble = new JLabel("\u7F16\u53F7\uFF1A");
		lbSerialNumble.setFont(new Font("楷体", Font.BOLD, 16));
		lbSerialNumble.setHorizontalAlignment(SwingConstants.CENTER);
		lbSerialNumble.setBounds(42, 91, 104, 35);
		contentPane.add(lbSerialNumble);

		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(146, 91, 223, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSeek = new JButton("\u67E5\u627E");
		btnSeek.setFont(new Font("楷体", Font.BOLD, 16));
		btnSeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除查询
				// 获取文本框中的编号
				int id = Integer.parseInt(textField.getText());
				Product pt = new ProductImpDao().getPro(id);
				if (pt != null) {
					new DeletePro().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "编号不存在");
				}
			}
		});
		btnSeek.setBounds(72, 194, 93, 35);
		contentPane.add(btnSeek);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setFont(new Font("楷体", Font.BOLD, 16));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 删除取消
				new Function().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(284, 194, 93, 35);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeleteByID.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
	}

}
