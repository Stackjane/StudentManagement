package druid;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
/*
 * ע�����������ļ������ӵ����ݿ���girls
 */
public class JDBCUtilbyDruid {
	static DataSource ds;
	//���������ļ�
	static {		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\Druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//�����������
	public static Connection getConnection() throws Exception {
		return ds.getConnection();
	}
	//�����ر�����
	public static void Close(ResultSet set,Connection connection,Statement statement){
		try {
			if(set!=null)
				set.close();
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}catch(Exception e) {
			throw new RuntimeException(e);  //����쳣�������л���֣�����ʱ�ǲ�����ֵ�
		}
	}
}
