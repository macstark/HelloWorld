package com.exercise.jframe;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.bjsxt.logistics.entity.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

@SuppressWarnings("unchecked")
public class StartOpenServer extends JFrame {

	private static final long serialVersionUID = -6448175871980375872L;
	private JButton btnOpenServer;
	private JPanel contentPane;
	private static JTextField textField;
	private JLabel lblNewLabel_2;
	// 创建Map集合存储用户信息
	static LinkedHashMap<String, User> users = new LinkedHashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartOpenServer frame = new StartOpenServer();
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
	public StartOpenServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// 设置面板绝对布局
		contentPane.setLayout(null);
		// 禁止面板放大
		setResizable(false);
		// 设置面板居中
		setLocationRelativeTo(null);

		btnOpenServer = new JButton("开启服务");
		btnOpenServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 开启服务后禁止操作
				btnOpenServer.setEnabled(false);
				// 开启服务的方法
				try {
					openServer();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOpenServer.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnOpenServer.setBounds(299, 187, 187, 45);
		contentPane.add(btnOpenServer);

		JLabel lblNewLabel = new JLabel("端口号：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 187, 74, 45);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(113, 188, 187, 45);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("服务端");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(186, 64, 141, 45);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(StartOpenServer.class.getResource("/images/11.jpg")));
		lblNewLabel_2.setBounds(0, 0, 529, 321);
		contentPane.add(lblNewLabel_2);
	}

	@SuppressWarnings("resource")
	public static void openServer() throws Exception {
		// 获取端口号
		String strPort = textField.getText();
		int port = Integer.parseInt(strPort);
		// 创建ServerSocket
		ServerSocket ss = new ServerSocket(port);
		while (true) {
			// 开启监听
			Socket s = ss.accept();
			// 获取客户端发送的数据流
			InputStream is = s.getInputStream();
			InputStream is1 = s.getInputStream();
			// 向客户端输出
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			// 创建对象流
			ObjectInputStream ois = new ObjectInputStream(is);
			DataInputStream dis = new DataInputStream(is1);
			// 获取客户端发送的标识信息
			String res = dis.readUTF();
			// 获取用户信息
			User user = (User) ois.readObject();
			String log = "Client:" + s.getInetAddress().getHostName() + "发送的信息" + user;

			System.out.println(log);
			// 根据客户端标识进行操作
			if (res.equals("注册")) {
				if (user.getName().equals("")) {
					System.out.println("null执行了");
					dos.writeUTF("注册失败");
				} else if (!users.containsKey(user.getName())) {
					users.put(user.getName(), user);
					// 输出流
					dos.writeUTF("注册成功");
				} else {
					dos.writeUTF("注册失败");
				}
			} else {
				// 判断账号是否存在
				if (!users.containsKey(user.getName())) {
					dos.writeUTF("登录失败");
				} else if ((user.getPassword().equals(users.get(user.getName()).getPassword()))) {
					dos.writeUTF("登录成功");
				} else {
					dos.writeUTF("密码错误");
				}
			}
		}
	}
}
