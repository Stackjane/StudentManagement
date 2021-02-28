package druid;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
/*
 * 注意现在配置文件中连接的数据库是girls
 */
public class JDBCUtilbyDruid {
	static DataSource ds;
	//加载配置文件
	static {		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\Druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//用来获得连接
	public static Connection getConnection() throws Exception {
		return ds.getConnection();
	}
	//用来关闭连接
	public static void Close(ResultSet set,Connection connection,Statement statement){
		try {
			if(set!=null)
				set.close();
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}catch(Exception e) {
			throw new RuntimeException(e);  //这个异常是在运行会出现，编译时是不会出现的
		}
	}
}
