package dao;


public class AdminDao extends BasicDao<Object>{
	
	@Override
	public Object Scalar(String sql, Object... params) {
		return super.Scalar(sql, params);
	}
	
	
}
