package zc.study.struts1.action;

import java.util.Enumeration;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.EnumerationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import zc.study.struts1.service.TestMyBatisAccess;


public class WelcomeAction extends Action {
	Logger logger = LogManager.getLogger();


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.entry();

		logger.debug("servlet name: '{}'", getServlet().getServletName());
		logger.debug("servlet info: '{}'", getServlet().getServletInfo());

		dumpServletConfig();
		dumpServletContext();
		dumpEnvParams();

//		new TestJNDICnx().testDBAccess();
		new TestMyBatisAccess().testDBAccess();

		return logger.exit(mapping.findForward("success"));
	}

	@SuppressWarnings("unchecked")
	void dumpServletConfig() {
		logger.entry();

		ServletConfig servletConfig = getServlet().getServletConfig();

		logger.debug("servlet name: '{}'", servletConfig.getServletName());
		logger.debug("servlet context ID: '{}'", System.identityHashCode(servletConfig.getServletContext()));

		logger.info("printing all servlet config init params");
		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
		for (String s : EnumerationUtils.toList(initParameterNames)) {
			Object v = servletConfig.getInitParameter(s);
			logger.info("  '{}' = '{}'", s, v);
		}

		logger.exit();
	}

	@SuppressWarnings("unchecked")
	void dumpServletContext() {
		logger.entry();

		ServletContext servletContext = getServlet().getServletContext();

		logger.debug("context ID: '{}'", System.identityHashCode(servletContext));
		logger.debug("context Name: '{}'", servletContext.getServletContextName());
		logger.debug("context Path: '{}'", servletContext.getContextPath());
		logger.debug("context Major version: '{}'", servletContext.getMajorVersion());
		logger.debug("context Minor version: '{}'", servletContext.getMinorVersion());
		logger.debug("Server Info: '{}'", servletContext.getServerInfo());

		logger.info("printing all servlet context attributes");
		Enumeration<String> attributeNames = (Enumeration<String>)servletContext.getAttributeNames();
		for (String s : EnumerationUtils.toList(attributeNames)) {
			if ("org.apache.tomcat.util.scan.MergedWebXml".equals(s)) {
				continue;
			}
			Object v = servletContext.getAttribute(s);
			logger.info("  '{}' = '{}'", s, v);
		}

		logger.info("printing all servlet context init params");
		Enumeration<String> initParameterNames = (Enumeration<String>)servletContext.getInitParameterNames();
		for (String s : EnumerationUtils.toList(initParameterNames)) {
			Object v = servletContext.getInitParameter(s);
			logger.info("  '{}' = '{}'", s, v);
		}

		logger.exit();
	}

	private void dumpEnvParams() throws NamingException {
		logger.entry();

		InitialContext initCtx = new InitialContext();

		new JNDITree(initCtx).on(System.out).printJNDITree("java:");

		logger.exit();
	}
}

/* EOF */
