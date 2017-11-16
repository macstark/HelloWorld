package com.bjsxt.logistics.impldao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.Collection;
import java.util.LinkedHashMap;
import com.bjsxt.logistics.dao.ProductDao;
import com.bjsxt.logistics.entity.Product;

/**
 * 操作产品实现类
 * 
 * @author Lif
 *
 */
@SuppressWarnings("unchecked")
public class ProductImpDao implements ProductDao {
	// 创建Map容器存放产品信息
	static LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();
    
	static {
		// 创建文件
		File srcFile = new File("D:/products.txt");
		// 判断文件是否存在
		if (srcFile.exists()) {
			ObjectInputStream ois = null;
			try {
				// 创建对象流
				ois = new ObjectInputStream(new FileInputStream(srcFile));
				// 读取文件信息
				products = (LinkedHashMap<Integer, Product>) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			//
			System.out.println("文件不存在");
		}

	}

	/**
	 * 添加产品
	 */
	@Override
	public void addPro(Product pt) {
		int id = pt.getId();
		// 判断产品是否存在
		if (products.containsKey(id)) {
			// 如果产品ID已存在，获取它的库存
			int count = products.get(id).getCount();
			// 添加库存
			pt.setCount(count + pt.getCount());
			// 将添加后的产品保存入数据库
			products.put(id, pt);
		} else {
			products.put(id, pt);
		}
	}

	/**
	 * 通过ID获取产品
	 */
	@Override
	public Product getPro(int id) {
		return products.get(id);
	}

	/**
	 * 通过产品名称获取产品
	 */
	@Override
	public Product getPro(String name) {
		Product pt = null;
		Collection<Product> values = products.values();
		for (Product product : values) {
			if (product.getName().equals(name)) {
				pt = product;
				break;
			}
		}
		return pt;
	}

	/**
	 * 删除产品
	 */
	@Override
	public void deletePro(int id) {
		products.remove(id);
	}

	/**
	 * 暂未实现
	 */
	@Override
	public void tracePro(int id) {

	}

	/**
	 * 保存产品信息到本地文件
	 */
	public void savePro() {
		// 创建文件
		File tofile = new File("D:/products.txt");
		// 创建对象输出流
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(tofile));
			// 输出对象
			oos.writeObject(products);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
