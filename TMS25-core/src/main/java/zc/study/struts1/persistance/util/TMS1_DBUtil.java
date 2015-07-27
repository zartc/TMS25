package zc.study.struts1.persistance.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Wadis_DBUtil {
	static Logger logger = LogManager.getLogger();

	private static SqlSessionFactory sqlSessionFactory;

	static {
		logger.entry();
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("zc/study/struts1/persistance/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "wadis");
		} catch (IOException e) {
			logger.catching(e);
		} finally {
			IOUtils.closeQuietly(reader);
		}
		logger.exit();
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}


/* EOF */