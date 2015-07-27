package zc.study.struts1.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zc.study.struts1.domain.Cadeau;
import zc.study.struts1.persistance.CadeauMapper;
import zc.study.struts1.persistance.util.TMS2_DBUtil;


/**
 * @author Pascal Jacob
 */
public class TestMyBatisAccess {
	Logger logger = LogManager.getLogger();


	public void testDBAccess() throws NamingException, SQLException {
		logger.entry();

		try (SqlSession session = TMS2_DBUtil.getSession()) {
			CadeauMapper mapper = session.getMapper(CadeauMapper.class);
			List<Cadeau> activeCadeaux = mapper.getByStatus(CadeauMapper.Status.actif);

			logger.info("nb line returned: {}", activeCadeaux.size());
			for (Cadeau cadeau : activeCadeaux) {
				logger.info(cadeau);
			}
		}

		logger.exit();
	}
}

/* EOF */
