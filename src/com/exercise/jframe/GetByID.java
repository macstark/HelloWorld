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

public class GetByID extends JFrame {

	private JPanel contentPane;
	static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetByID frame = new GetByID();
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
	public GetByID() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("查询");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblbSerialNumble = new JLabel("\u7F16\u7801\uFF1A");
		lblbSerialNumble.setFont(new Font("楷体", Font.BOLD, 18));
		lblbSerialNumble.setHorizontalAlignment(SwingConstants.CENTER);
		lblbSerialNumble.setBounds(39, 79, 112, 38);
		contentPane.add(lblbSerialNumble);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(150, 79, 238, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSeek = new JButton("\u67E5\u8BE2");
		btnSeek.setFont(new Font("楷体", Font.BOLD, 18));
		btnSeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询
				//获取文本框中的编号
				int id = Integer.parseInt(textField.getText());
				Product pt = new ProductImpDao().getPro(id);
				if (pt != null) {
					new GetPro().setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "编号不存在");
				}

			}
		});
		btnSeek.setBounds(74, 189, 93, 38);
		contentPane.add(btnSeek);
		
		JButton btnCannel = new JButton("\u53D6\u6D88");
		btnCannel.setFont(new Font("楷体", Font.BOLD, 18));
		btnCannel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Function().setVisible(true);
				dispose();
			}
		});
		btnCannel.setBounds(271, 189, 93, 38);
		contentPane.add(btnCannel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GetByID.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
	}

}
