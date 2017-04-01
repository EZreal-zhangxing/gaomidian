package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zx.Service.EncoderHandler;

public class Test {
	private SqlSessionFactory sqlsessionFactory;
	public void initMethod(){
		System.out.println(this.getClass()+" is init");
		System.out.println("The sqlSessionFactory is "+sqlsessionFactory);
		SqlSession sqlsession=sqlsessionFactory.openSession();
		System.out.println("The sqlsession is "+sqlsession);
	}
	public SqlSessionFactory getSqlsessionFactory() {
		return sqlsessionFactory;
	}
	public void setSqlsessionFactory(SqlSessionFactory sqlsessionFactory) {
		this.sqlsessionFactory = sqlsessionFactory;
	}
}

