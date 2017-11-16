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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class DeletePro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePro frame = new DeletePro();
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
	public DeletePro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("删除物品信息");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTradeName = new JLabel("\u54C1\u540D\uFF1A");
		lbTradeName.setFont(new Font("楷体", Font.BOLD, 18));
		lbTradeName.setHorizontalAlignment(SwingConstants.CENTER);
		lbTradeName.setBounds(60, 112, 86, 40);
		contentPane.add(lbTradeName);
		
		JLabel lbSerialNumble = new JLabel("\u7F16\u53F7\uFF1A");
		lbSerialNumble.setFont(new Font("楷体", Font.BOLD, 18));
		lbSerialNumble.setHorizontalAlignment(SwingConstants.CENTER);
		lbSerialNumble.setBounds(60, 52, 86, 40);
		contentPane.add(lbSerialNumble);
		
		JLabel lbProductionPlace = new JLabel("\u4EA7\u5730\uFF1A");
		lbProductionPlace.setFont(new Font("楷体", Font.BOLD, 18));
		lbProductionPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lbProductionPlace.setBounds(60, 172, 86, 40);
		contentPane.add(lbProductionPlace);
		
		JLabel lbQuantity = new JLabel("\u6570\u91CF\uFF1A");
		lbQuantity.setFont(new Font("楷体", Font.BOLD, 18));
		lbQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lbQuantity.setBounds(60, 229, 86, 40);
		contentPane.add(lbQuantity);
		
		JLabel lbSentTo = new JLabel("\u53D1\u5F80\u5730\uFF1A");
		lbSentTo.setFont(new Font("楷体", Font.BOLD, 18));
		lbSentTo.setHorizontalAlignment(SwingConstants.CENTER);
		lbSentTo.setBounds(60, 279, 86, 40);
		contentPane.add(lbSentTo);
		
		JLabel lbId = new JLabel("");
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		lbId.setBounds(155, 52, 213, 40);
		contentPane.add(lbId);
		
		JLabel lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(155, 112, 213, 40);
		contentPane.add(lblName);
		
		JLabel lblFromPlace = new JLabel("");
		lblFromPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblFromPlace.setBounds(155, 172, 213, 40);
		contentPane.add(lblFromPlace);
		
		JLabel lblCount = new JLabel("");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setBounds(155, 229, 213, 40);
		contentPane.add(lblCount);
		
		JLabel lblToPlace = new JLabel("");
		lblToPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblToPlace.setBounds(155, 281, 213, 40);
		contentPane.add(lblToPlace);
		
		int id1 = Integer.parseInt(DeleteByID.textField.getText());
		Product pt = new ProductImpDao().getPro(id1);
		String name = pt.getName();
		int id = pt.getId();
		String fromPlace = pt.getFromPlace();
	    int count = pt.getCount();
	    String toPlace = pt.getToPlace();
	    lblName.setText(name);
	    lbId.setText(Integer.toString(id));
		lblFromPlace.setText(fromPlace);
		lblCount.setText(Integer.toString(count));
		lblToPlace.setText(toPlace);
		
		JButton btnNewDelete = new JButton("删除");
		btnNewDelete.setFont(new Font("楷体", Font.BOLD, 18));
		btnNewDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认删除
				int result = JOptionPane.showConfirmDialog(null, "确认删除");
				if (result == JOptionPane.YES_OPTION) {
					//删除
					int id = Integer.parseInt(DeleteByID.textField.getText());
					new ProductImpDao().deletePro(id);
					new DeleteByID().setVisible(true);
					System.out.println("删除成功");
					dispose();
				}
			}
		});
		btnNewDelete.setBounds(71, 358, 93, 40);
		contentPane.add(btnNewDelete);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setFont(new Font("楷体", Font.BOLD, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认取消
				new DeleteByID().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(265, 358, 93, 40);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DeletePro.class.getResource("/images/11.jpg")));
		lblNewLabel.setBounds(0, 0, 441, 432);
		contentPane.add(lblNewLabel);
		

	}
}
