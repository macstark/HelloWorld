package com.exercise.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bjsxt.logistics.impldao.ProductImpDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Function extends JFrame {

	private static final long serialVersionUID = 1122277095365061874L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Function frame = new Function();
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
	public Function() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("功能");
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 添加
				new Add().setVisible(true);
				dispose();

			}
		});
		btnAdd.setBounds(166, 21, 93, 23);
		contentPane.add(btnAdd);

		JButton btnModification = new JButton("\u4FEE\u6539");
		btnModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 修改
				new ReplaceByID().setVisible(true);
				dispose();
			}
		});
		btnModification.setBounds(166, 66, 93, 23);
		contentPane.add(btnModification);

		JButton btnSeek = new JButton("\u67E5\u8BE2");
		btnSeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 查询
				new GetByID().setVisible(true);
				dispose();
			}
		});
		btnSeek.setBounds(166, 112, 93, 23);
		contentPane.add(btnSeek);

		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 删除
				new DeleteByID().setVisible(true);
				dispose();
			}
		});
		btnDelete.setBounds(166, 157, 93, 23);
		contentPane.add(btnDelete);

		JButton btnTrace = new JButton("\u8FFD\u8E2A");
		btnTrace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 追踪
				new TraceByID().setVisible(true);
				dispose();
			}
		});
		btnTrace.setBounds(166, 203, 93, 23);
		contentPane.add(btnTrace);

		JButton btnReturn = new JButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartOpenClient().setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(166, 250, 93, 23);
		contentPane.add(btnReturn);

		JButton btnExit = new JButton("退出");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//保存产品信息
				ProductImpDao pi = new ProductImpDao();
				pi.savePro();
				//退出
				int choice = JOptionPane.showConfirmDialog(null, "是否退出");
				if (choice == JOptionPane.YES_OPTION) {
					exit();
				}
			}
		});
		btnExit.setBounds(166, 298, 93, 23);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Function.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 436, 356);
		contentPane.add(lblNewLabel);
	}

	public static void exit() {
		System.exit(0);
	}
}
