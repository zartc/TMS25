package zc.study.struts1.persistance.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Pascal Jacob
 */
public class TMS2_DBUtil {
	static Logger logger = LogManager.getLogger();

	private static SqlSessionFactory sqlSessionFactory;

	static {
		logger.entry();

		try (Reader reader = Resources.getResourceAsReader("zc/study/struts1/persistance/mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "TMS2");
		}
		catch (IOException e) {
			logger.catching(e);
		}

		logger.exit();
	}


	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}

/* EOF */
