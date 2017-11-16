package com.exercise.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bjsxt.logistics.entity.Product;
import com.bjsxt.logistics.impldao.ProductImpDao;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GetPro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetPro frame = new GetPro();
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
	public GetPro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("查询页");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTradeName = new JLabel("名称：");
		lbTradeName.setFont(new Font("楷体", Font.BOLD, 16));
		lbTradeName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTradeName.setBounds(23, 97, 98, 32);
		contentPane.add(lbTradeName);
		
		JLabel lbSerialNumble = new JLabel("编号：");
		lbSerialNumble.setFont(new Font("楷体", Font.BOLD, 16));
		lbSerialNumble.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSerialNumble.setBounds(23, 139, 98, 32);
		contentPane.add(lbSerialNumble);
		
		JLabel lbProductionPlace = new JLabel("产地：");
		lbProductionPlace.setFont(new Font("楷体", Font.BOLD, 16));
		lbProductionPlace.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProductionPlace.setBounds(23, 175, 98, 32);
		contentPane.add(lbProductionPlace);
		
		JLabel lbQuantity = new JLabel("数量：");
		lbQuantity.setFont(new Font("楷体", Font.BOLD, 16));
		lbQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lbQuantity.setBounds(23, 217, 98, 32);
		contentPane.add(lbQuantity);
		
		JLabel lbSentTo = new JLabel("发往地：");
		lbSentTo.setFont(new Font("楷体", Font.BOLD, 16));
		lbSentTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSentTo.setBounds(23, 262, 98, 32);
		contentPane.add(lbSentTo);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(121, 97, 255, 32);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(121, 139, 255, 32);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setBounds(121, 175, 255, 32);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setBounds(121, 217, 255, 32);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setBounds(121, 262, 255, 32);
		contentPane.add(lbl5);
		
		int id1 = Integer.parseInt(GetByID.textField.getText());
		Product pt = new ProductImpDao().getPro(id1);
		String name = pt.getName();
		int id = pt.getId();
		String fromPlace = pt.getFromPlace();
	    int count = pt.getCount();
	    String toPlace = pt.getToPlace();
	    lbl1.setText(name);
		lbl2.setText(Integer.toString(id));
		lbl3.setText(fromPlace);
		lbl4.setText(Integer.toString(count));
		lbl5.setText(toPlace);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Function().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(293, 359, 83, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("产品详情");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 25, 138, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GetPro.class.getResource("/images/11.jpg")));
		lblNewLabel_1.setBounds(0, 0, 386, 392);
		contentPane.add(lblNewLabel_1);
	}
}
