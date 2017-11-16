package com.exercise.jframe;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.bjsxt.logistics.entity.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RegisterFrame extends JFrame {

	private static final long serialVersionUID = -4533110021807986968L;
	private static JTextField textName;
	private static JTextField textPassword;
	private static JTextField textAge;
	private static JTextField textCardnum;
	private static JLabel lbUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 558);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("注册");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbUserName = new JLabel("账户：");
		lbUserName.setForeground(Color.BLUE);
		lbUserName.setFont(new Font("楷体", Font.BOLD, 20));
		lbUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lbUserName.setBounds(97, 84, 77, 30);
		contentPane.add(lbUserName);

		JLabel lbPassWord = new JLabel("\u5BC6\u7801\uFF1A");
		lbPassWord.setForeground(Color.BLUE);
		lbPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lbPassWord.setFont(new Font("楷体", Font.BOLD, 20));
		lbPassWord.setBounds(97, 143, 77, 30);
		contentPane.add(lbPassWord);

		JLabel lbAge = new JLabel("年龄：");
		lbAge.setForeground(Color.BLUE);
		lbAge.setFont(new Font("楷体", Font.BOLD, 20));
		lbAge.setHorizontalAlignment(SwingConstants.CENTER);
		lbAge.setBounds(97, 203, 77, 30);
		contentPane.add(lbAge);

		JLabel lbIdNumble = new JLabel("证件号码：");
		lbIdNumble.setForeground(Color.BLUE);
		lbIdNumble.setFont(new Font("楷体", Font.BOLD, 20));
		lbIdNumble.setHorizontalAlignment(SwingConstants.CENTER);
		lbIdNumble.setBounds(97, 262, 117, 30);
		contentPane.add(lbIdNumble);
		// 注册
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.setFont(new Font("楷体", Font.BOLD, 20));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result;
				try {
					result = register();
					System.out.println("From  Server:" + result);
					if (result.equals("注册成功")) {
						JOptionPane.showMessageDialog(null, "注册成功");
						new StartOpenClient().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "注册失败");
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(97, 383, 98, 37);
		contentPane.add(btnRegister);
		// 登录
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setFont(new Font("楷体", Font.BOLD, 20));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 取消
				new StartOpenClient().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(280, 383, 98, 37);
		contentPane.add(btnCancel);

		textName = new JTextField();
		textName.setBounds(213, 84, 165, 30);
		contentPane.add(textName);
		textName.setColumns(10);

		textPassword = new JTextField();
		textPassword.setBounds(213, 143, 165, 30);
		contentPane.add(textPassword);
		textPassword.setColumns(10);

		textAge = new JTextField();
		textAge.setBounds(213, 203, 165, 30);
		contentPane.add(textAge);
		textAge.setColumns(10);

		textCardnum = new JTextField();
		textCardnum.setBounds(213, 262, 165, 30);
		contentPane.add(textCardnum);
		textCardnum.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/4.jpg")));
		lblNewLabel.setBounds(0, 0, 476, 529);
		contentPane.add(lblNewLabel);
	}

	public static String register() throws Exception, IOException {
		// 获取账户信息
		String name = textName.getText();
		// 获取密码信息
		String password = textPassword.getText();
		String result = null;
		// 创建用户对象
		User user = new User(name, password);
		// 创建Socket
		Socket s = new Socket("127.0.0.1", 9999);
		// 获取流
		OutputStream os = s.getOutputStream();
		OutputStream os1 = s.getOutputStream();
		// 创建对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(os);
		DataOutputStream dos = new DataOutputStream(os1);
		// 向服务端发送输入的对象信息
		dos.writeUTF("注册");// 发送客户端标识信息
		oos.writeObject(user);// 发送用户信息
		oos.flush();

		// 获取服务端反馈的信息
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		result = dis.readUTF();
		// 关闭流和Socket
		os.close();
		s.close();
		return result;
	}

}
