package test.info.novatec.inspectit.http.tools;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Providing a mock for fake-requests
 * 
 * @author Alfred Kraus
 */
public class MockServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
	}

}
