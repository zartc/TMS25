package zc.study.struts1.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zc.study.struts1.domain.Cadeau;
import zc.study.struts1.persistance.CadeauMapper;
import zc.study.struts1.persistance.util.WadisCMS_DBUtil;

public class TestMyBatisAccess {
	Logger logger = LogManager.getLogger();

	public void testDBAccess() throws NamingException, SQLException {
		logger.entry();
		
		SqlSession session = WadisCMS_DBUtil.getSession();
		
		try {
			CadeauMapper mapper = session.getMapper(CadeauMapper.class);
			List<Cadeau> allCadeaux = mapper.getAll(CadeauMapper.Status.actif);
			
			logger.info("nb line returned: {}", allCadeaux.size());
			for (Cadeau cadeau : allCadeaux) {
				logger.info(cadeau);
			}
		} finally {
			session.close();
		}
		
		logger.exit();
	}
}

/* EOF */
