package dao;
/*
 * 这个类可以实现最基础的查询
 * 之后的查询均建立在这个基础上
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
	//执行的是查询，先是返回一个结果集
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
	
	//执行的是查询，但是返回的是多个结果集
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
	
	//执行的是查询，但是返回的是一个值
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
