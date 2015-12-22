package test.info.novatec.inspectit.http.tools;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * Providing a fake session. Only methods instrumented through inspectIT are
 * implemented
 * 
 * @author Alfred Kraus
 * 
 */
public class MockSession implements HttpSession {

	private Map<String, String> attributes = new HashMap<>();
	@SuppressWarnings("rawtypes")
	private Enumeration attributesNamesEnumeration;
	@SuppressWarnings("rawtypes")
	private Vector attributeNamesVector = new Vector();

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value.toString());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Enumeration getAttributeNames() {
		attributeNamesVector.clear();
		Iterator iterator = attributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry couples = (Map.Entry) iterator.next();
			attributeNamesVector.add(couples.getKey());
		}
		attributesNamesEnumeration = attributeNamesVector.elements();
		return attributesNamesEnumeration;
	}

	@Override
	public Object getAttribute(String name) {
		Object o = attributes.get(name);
		return o;
	}
	
	// --- non touched ---

	@Override
	public long getCreationTime() {
		return 0;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public long getLastAccessedTime() {
		return 0;
	}

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
	}

	@Override
	public int getMaxInactiveInterval() {
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public HttpSessionContext getSessionContext() {
		return null;
	}

	@Override
	public Object getValue(String name) {
		return null;
	}

	@Override
	public String[] getValueNames() {
		return null;
	}

	@Override
	public void putValue(String name, Object value) {
	}

	@Override
	public void removeAttribute(String name) {
	}

	@Override
	public void removeValue(String name) {
	}

	@Override
	public void invalidate() {
	}

	@Override
	public boolean isNew() {
		return false;
	}

}
