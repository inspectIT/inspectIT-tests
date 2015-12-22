package test.info.novatec.inspectit.http.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Providing a fake request. Only methods instrumented through inspectIT are
 * implemented
 * 
 * @author Alfred Kraus
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SampleHttpRequest implements HttpServletRequest {

	private String uri;
	private String method;
	private Map<String, String[]> parameters = new HashMap<>();
	private Map<String, String> attributes = new HashMap<>();
	private Enumeration attributesNamesEnumeration;
	private Vector attributesNamesVector = new Vector();
	private Map<String, String> headers = new HashMap<>();
	private Enumeration headerNamesEnumeration;
	private Vector headerNamesVector = new Vector();
	private MockSession test;

	public SampleHttpRequest(String uri, String method) {
		this.uri = uri;
		this.method = method;
	}

	// methods invoked by the agents
	@Override
	public String getRequestURI() {
		return uri;
	}

	@Override
	public String getMethod() {
		return method;
	}

	@Override
	public HttpSession getSession(boolean create) {
		return test;
	}

	@Override
	public HttpSession getSession() {
		test = new MockSession();
		return test;
	}

	// methods NOT invoked by the agents
	@Override
	public Object getAttribute(String name) {
		if (attributes.containsKey(name)) {
			return attributes.get(name);
		} else {
			return null;
		}
	}

	@Override
	public Enumeration getAttributeNames() {
		attributesNamesVector.clear();
		Iterator iterator = attributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry couples = (Map.Entry) iterator.next();
			attributesNamesVector.add(couples.getKey());
		}
		attributesNamesEnumeration = attributesNamesVector.elements();
		return attributesNamesEnumeration;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
	}

	@Override
	public int getContentLength() {
		return 0;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public String getParameter(String name) {
		return parameters.get(name)[0];
	}

	public void setParameter(String name, Object value) {
		if (value.getClass().equals(String[].class)) {
			parameters.put(name, (String[]) value);
		} else {
			parameters.put(name, new String[] { value.toString() });
		}
	}

	@Override
	public Enumeration getParameterNames() {
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		return null;
	}

	@Override
	public Map getParameterMap() {
		return parameters;
	}

	@Override
	public String getProtocol() {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public int getServerPort() {
		return 0;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return null;
	}

	@Override
	public String getRemoteAddr() {
		return null;
	}

	@Override
	public String getRemoteHost() {
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value.toString());
	}

	@Override
	public void removeAttribute(String name) {
	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public Enumeration getLocales() {
		return null;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return null;
	}

	@Override
	public String getRealPath(String path) {
		return null;
	}

	@Override
	public int getRemotePort() {
		return 0;
	}

	@Override
	public String getLocalName() {
		return null;
	}

	@Override
	public String getLocalAddr() {
		return null;
	}

	@Override
	public int getLocalPort() {
		return 0;
	}

	@Override
	public String getAuthType() {
		return null;
	}

	@Override
	public Cookie[] getCookies() {
		return null;
	}

	@Override
	public long getDateHeader(String name) {
		return 0;
	}

	@Override
	public String getHeader(String name) {
		return headers.get(name);
	}

	public void setHeader(String name, Object value) {
		headers.put(name, value.toString());
	}

	@Override
	public Enumeration getHeaders(String name) {
		return null;
	}

	@Override
	public Enumeration getHeaderNames() {
		headerNamesVector.clear();
		Iterator iterator = headers.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry couples = (Map.Entry) iterator.next();
			headerNamesVector.add(couples.getKey());
		}
		headerNamesEnumeration = headerNamesVector.elements();
		return headerNamesEnumeration;
	}

	@Override
	public int getIntHeader(String name) {
		return 0;
	}

	@Override
	public String getPathInfo() {
		return null;
	}

	@Override
	public String getPathTranslated() {
		return null;
	}

	@Override
	public String getContextPath() {
		return null;
	}

	@Override
	public String getQueryString() {
		return null;
	}

	@Override
	public String getRemoteUser() {
		return null;
	}

	@Override
	public boolean isUserInRole(String role) {
		return false;
	}

	@Override
	public Principal getUserPrincipal() {
		return null;
	}

	@Override
	public String getRequestedSessionId() {
		return null;
	}

	@Override
	public StringBuffer getRequestURL() {
		return null;
	}

	@Override
	public String getServletPath() {
		return null;
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromUrl() {
		return false;
	}

}
