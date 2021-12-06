package mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sqlsessionfactory를 만들어서 dao에게 반환하는 클래스
public class DBService{
	public SqlSessionFactory factory;
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
	/*single ton*/
	private static DBService instance;
	private DBService() {
		/*SqlSessionFactory 빌드*/
		try {
			String resource ="mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DBService getInstance() {
		if(instance == null) {
			instance = new DBService();
		}
		return instance;
	}
	
	
}