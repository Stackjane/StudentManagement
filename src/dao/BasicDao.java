package dao;
/*
 * ��������ʵ��������Ĳ�ѯ
 * ֮��Ĳ�ѯ�����������������
 */
import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import druid.JDBCUtilbyDruid;

public class BasicDao<T> {
	
	private QueryRunner qr = new QueryRunner();
	
	public int update(String sql,Object...params){
		Connection connection = null;
		try {
			connection = JDBCUtilbyDruid.getConnection();
			int update = qr.update(connection, sql, params);
			return update;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtilbyDruid.Close(null, connection, null);
		}
	}
	//ִ�е��ǲ�ѯ�����Ƿ���һ�������
	public T QuerySingle(String sql,Class<T> clazz,Object...params) {
		Connection connection = null;
		try {
			connection = JDBCUtilbyDruid.getConnection();
			T query = qr.query(connection, sql, new BeanHandler<T>(clazz), params);
			return query;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtilbyDruid.Close(null, connection, null);
		}		
	}
	
	//ִ�е��ǲ�ѯ�����Ƿ��ص��Ƕ�������
	public List<T> QueryMulti(String sql,Class<T> clazz,Object...params){
		Connection connection = null;
		try {
			connection = JDBCUtilbyDruid.getConnection();
			List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
			return query;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtilbyDruid.Close(null, connection, null);
		}		
	}
	
	//ִ�е��ǲ�ѯ�����Ƿ��ص���һ��ֵ
	public Object Scalar(String sql,Object...params) {
		Connection connection = null;
		try {
			connection = JDBCUtilbyDruid.getConnection();
			Object query = qr.query(connection, sql, new ScalarHandler<Object>(), params);
			return query;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			JDBCUtilbyDruid.Close(null, connection, null);
		}
		
	}
	
}
