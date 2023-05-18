package com.film.dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/4/27 14:44
 */
public class BaseDao {
	static String driver;
	static String url;
	static String username;
	static String password;

	/**
	 * @description:读取配置文件=创建配置文件对象+配置文件形成输入流+配置文件加载到配置对象+读取配置文件数据
	 * @param: null
	 * @return:
	 * @author lzl
	 * @date: 2023/4/22 15:31
	 */
	static void init() {
		//创建配置文件对象
		Properties properties = new Properties();
		//文件路径
		String path = "jdbc.properties";
		//配置文件形成输入流
		InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(path);
		//配置文件加载到配置对象
		try {
			properties.load(inputStream);
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//加载驱动
	static {
		//读取jdbc.properties数据
		init();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//创建连接对象
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	//关闭所有资源对象
	public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null) resultSet.close();
			if (statement != null) statement.close();
			if (connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//增删改
	public static boolean operation(String sql, Object... objects) {
		objects.toString();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		int result= 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				preparedStatement.setObject(i + 1, objects[i]);
			}
			result = preparedStatement.executeUpdate();
			//测试一波
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭所有资源对象
			closeAll(null, preparedStatement, connection);
		}
		return false;
	}
}
