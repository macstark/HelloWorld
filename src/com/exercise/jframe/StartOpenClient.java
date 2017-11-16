package com.exercise.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.bjsxt.logistics.entity.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StartOpenClient extends JFrame {

	private static final long serialVersionUID = -3929356388545584095L;
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartOpenClient frame = new StartOpenClient();
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
	public StartOpenClient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1028, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// 窗口名字
		setTitle("物流仓库管理系统");

		// 关闭窗口放大
		setResizable(false);
		// 窗口居中
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbAccount = new JLabel("\u8D26\u6237\uFF1A");
		lbAccount.setFont(new Font("楷体", Font.BOLD, 18));
		lbAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lbAccount.setBounds(267, 208, 104, 47);
		contentPane.add(lbAccount);

		JLabel lbPassWord = new JLabel("\u5BC6\u7801\uFF1A");
		lbPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lbPassWord.setFont(new Font("楷体", Font.BOLD, 18));
		lbPassWord.setBounds(267, 321, 104, 47);
		contentPane.add(lbPassWord);

		textField = new JTextField();
		textField.setBounds(370, 210, 349, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(370, 321, 349, 47);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 18));
		// 点击注册按钮事件
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 跳转页面
				new RegisterFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(252, 483, 135, 47);
		contentPane.add(btnNewButton);
		// 点击登录按钮事件
		JButton btnNewButton_1 = new JButton("\u767B\u9646");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result;
				try {
					result = login();
					if (result.equals("登录成功")) {
						JOptionPane.showMessageDialog(null, "登录成功");
						new Function().setVisible(true);
						dispose();
					} else if (result.equals("密码错误")) {
						JOptionPane.showMessageDialog(null, "密码错误");
					} else {
						JOptionPane.showMessageDialog(null, "登录失败");
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(609, 483, 135, 47);
		contentPane.add(btnNewButton_1);

		JLabel lblTitle = new JLabel("神舟速达物流管理系统");
		lblTitle.setFont(new Font("楷体", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(330, 81, 349, 47);
		contentPane.add(lblTitle);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StartOpenClient.class.getResource("/images/1.gif")));
		lblNewLabel.setBounds(0, 0, 1022, 672);
		contentPane.add(lblNewLabel);
	}
	//登录
	public String login() throws Exception, IOException {
		// 获取账户信息
		String account = textField.getText();
		// 获取密码信息
		String password = textField_1.getText();
		// 创建用户对象
		User user = new User(account, password);
		// 创建Socket
		Socket s = new Socket("127.0.0.1", 9999);
		// 获取流
		OutputStream os = s.getOutputStream();
		OutputStream os1 = s.getOutputStream();
		// 创建对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(os);
		DataOutputStream dos = new DataOutputStream(os1);
		dos.writeUTF("登录");// 发送客户端标识信息
		oos.writeObject(user);// 向服务端发送输入的对象信息
		// 获取服务端反馈的信息
		InputStream is = s.getInputStream();
		DataInputStream ois = new DataInputStream(is);
		String result = ois.readUTF();

		oos.flush();
		os.close();
		s.close();
		return result;
	}
}
