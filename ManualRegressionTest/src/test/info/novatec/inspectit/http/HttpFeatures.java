package test.info.novatec.inspectit.http;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.info.novatec.inspectit.http.tools.MockServlet;
import test.info.novatec.inspectit.http.tools.SampleHttpRequest;
import test.info.novatec.inspectit.http.tools.SampleHttpResponse;

/**
 * Testing all functions of inspectIT affecting the http sensor
 * 
 * @author Alfred Kraus
 */
public class HttpFeatures {

	private Servlet servlet;

	/**
	 * Initialising the servlet which is used for all requests
	 */
	@BeforeTest
	public void init() {
		servlet = new MockServlet();
	}

	/**
	 * Providing different GET-requests
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpGetDifferentURLs() throws ServletException, IOException {
		servlet.service(new SampleHttpRequest(
				"http://my.test.url:8080/getservice1", "GET"),
				SampleHttpResponse.INST);
		servlet.service(new SampleHttpRequest(
				"http://my.test.url:8080/getservice2", "GET"),
				SampleHttpResponse.INST);
		servlet.service(new SampleHttpRequest(
				"http://my.test.url:8080/getservice3", "GET"),
				SampleHttpResponse.INST);
	}

	/**
	 * Providing different POST-requests
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpPostDifferentURLs() throws ServletException, IOException {
		servlet.service(new SampleHttpRequest(
				"http://my.test.url:8080/postservice1", "POST"),
				SampleHttpResponse.INST);
		servlet.service(new SampleHttpRequest(
				"http://my.test.url:8080/postservice2", "POST"),
				SampleHttpResponse.INST);
		servlet.service(new SampleHttpRequest(
				"http://my.test.url:8080/postservice3", "POST"),
				SampleHttpResponse.INST);
	}

	/**
	 * Aggregating different usecases
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpUsecaseHeaderAggregation() throws ServletException,
			IOException {
		// Get
		SampleHttpRequest getRequest1 = new SampleHttpRequest(
				"http://usecaseheaderaggregation", "GET");
		getRequest1.setHeader("inspectit", "First");
		servlet.service(getRequest1, SampleHttpResponse.INST);

		SampleHttpRequest getRequest2 = new SampleHttpRequest(
				"http://usecaseheaderaggregation", "GET");
		getRequest2.setHeader("inspectit", "Second");
		servlet.service(getRequest2, SampleHttpResponse.INST);

		SampleHttpRequest getRequest3 = new SampleHttpRequest(
				"http://usecaseheaderaggregation-otherurl", "GET");
		getRequest3.setHeader("inspectit", "Third");
		servlet.service(getRequest3, SampleHttpResponse.INST);

		// Post
		SampleHttpRequest postRequest1 = new SampleHttpRequest(
				"http://usecaseheaderaggregation", "POST");
		postRequest1.setHeader("inspectit", "First");
		servlet.service(postRequest1, SampleHttpResponse.INST);

		SampleHttpRequest postRequest2 = new SampleHttpRequest(
				"http://usecaseheaderaggregation", "POST");
		postRequest2.setHeader("inspectit", "Second");
		servlet.service(postRequest2, SampleHttpResponse.INST);

		SampleHttpRequest postRequest3 = new SampleHttpRequest(
				"http://usecaseheaderaggregation-otherurl", "POST");
		postRequest3.setHeader("inspectit", "Third");
		servlet.service(postRequest3, SampleHttpResponse.INST);
	}

	/**
	 * Providing different URLs which can be distinguished through regular
	 * expressions
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpRegEx() throws ServletException, IOException {
		SampleHttpRequest request1 = new SampleHttpRequest(
				"http://a/b/c/d/diff1", "GET");
		servlet.service(request1, SampleHttpResponse.INST);

		SampleHttpRequest request2 = new SampleHttpRequest(
				"http://a/b/c/d/diff2", "GET");
		servlet.service(request2, SampleHttpResponse.INST);

		SampleHttpRequest request3 = new SampleHttpRequest(
				"http://a/b/c/d/diff3", "GET");
		servlet.service(request3, SampleHttpResponse.INST);

		SampleHttpRequest request4 = new SampleHttpRequest(
				"http://a/b/c/d/e/diff1", "GET");
		servlet.service(request4, SampleHttpResponse.INST);

		SampleHttpRequest request5 = new SampleHttpRequest(
				"http://a/b/c/d/e/diff2", "GET");
		servlet.service(request5, SampleHttpResponse.INST);

		SampleHttpRequest request6 = new SampleHttpRequest(
				"http://a/b/c/d/diff1", "POST");
		servlet.service(request6, SampleHttpResponse.INST);

		SampleHttpRequest request7 = new SampleHttpRequest(
				"http://a/b/c/d/diff2", "POST");
		servlet.service(request7, SampleHttpResponse.INST);

		SampleHttpRequest request8 = new SampleHttpRequest(
				"http://a/b/c/d/diff3", "POST");
		servlet.service(request8, SampleHttpResponse.INST);

		SampleHttpRequest request9 = new SampleHttpRequest(
				"http://a/b/c/d/e/diff1", "POST");
		servlet.service(request9, SampleHttpResponse.INST);

		SampleHttpRequest request10 = new SampleHttpRequest(
				"http://a/b/c/d/e/diff2", "POST");
		servlet.service(request10, SampleHttpResponse.INST);

		SampleHttpRequest request11 = new SampleHttpRequest("test!", "GET");
		servlet.service(request11, SampleHttpResponse.INST);

		SampleHttpRequest request12 = new SampleHttpRequest("test!", "GET");
		servlet.service(request12, SampleHttpResponse.INST);

		SampleHttpRequest request13 = new SampleHttpRequest("!test", "POST");
		servlet.service(request13, SampleHttpResponse.INST);

		SampleHttpRequest request14 = new SampleHttpRequest("!test", "POST");
		servlet.service(request14, SampleHttpResponse.INST);

	}

	/**
	 * Providing headers in a GET-request
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpHeadersGet() throws ServletException, IOException {
		SampleHttpRequest request1 = new SampleHttpRequest(
				"http://my.test.url:8080/getheaderservice1", "GET");
		request1.setHeader("FirstHeader", "1st Header");
		servlet.service(request1, SampleHttpResponse.INST);

		SampleHttpRequest request2 = new SampleHttpRequest(
				"http://my.test.url:8080/getheaderservice2", "GET");
		request2.setHeader("SecondHeader", "2nd Header");
		servlet.service(request2, SampleHttpResponse.INST);

		SampleHttpRequest request3 = new SampleHttpRequest(
				"http://my.test.url:8080/getheaderservice3", "GET");
		request3.setHeader("ThirdHeader", "3rd Header");
		servlet.service(request3, SampleHttpResponse.INST);
	}

	/**
	 * Providing headers in a POST-request
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpHeadersPost() throws ServletException, IOException {
		SampleHttpRequest request1 = new SampleHttpRequest(
				"http://my.test.url:8080/postheaderservice1", "POST");
		request1.setHeader("FirstHeader", "1st Header");
		servlet.service(request1, SampleHttpResponse.INST);

		SampleHttpRequest request2 = new SampleHttpRequest(
				"http://my.test.url:8080/postheaderservice2", "POST");
		request2.setHeader("SecondHeader", "2nd Header");
		servlet.service(request2, SampleHttpResponse.INST);

		SampleHttpRequest request3 = new SampleHttpRequest(
				"http://my.test.url:8080/postheaderservice3", "POST");
		request3.setHeader("ThirdHeader", "3rd Header");
		servlet.service(request3, SampleHttpResponse.INST);
	}

	/**
	 * Providing GET-requests with parameters
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@Test
	public void httpGetParameters() throws IOException, ServletException {
		sendGetHttp("http://my.test.url:8080/getparameterservice1", "number1",
				"number2");
		sendGetHttp("http://my.test.url:8080/getparameterservice2", "number3",
				"number4");
		sendGetHttp("http://my.test.url:8080/getparameterservice3", "number5",
				"number6");
	}

	/**
	 * Providing GET-requests with parameters (https)
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@Test
	public void httpsGetParameters() throws IOException, ServletException {
		sendGetHttp("https://my.test.url:8080/getparameterservice1", "number1",
				"number2");
		sendGetHttp("https://my.test.url:8080/getparameterservice2", "number3",
				"number4");
		sendGetHttp("https://my.test.url:8080/getparameterservice3", "number5",
				"number6");
	}

	/**
	 * Providing POST-requests with parameters
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@Test
	public void httpPostParameters() throws IOException, ServletException {
		sendPostHttp("http://my.test.url:8080/postparameterservice1",
				"number1", "number2");
		sendPostHttp("http://my.test.url:8080/postparameterservice2",
				"number3", "number4");
		sendPostHttp("http://my.test.url:8080/postparameterservice3",
				"number5", "number6");
	}

	/**
	 * Providing POST-requests with parameters (https)
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@Test
	public void httpsPostParameters() throws IOException, ServletException {
		sendPostHttp("https://my.test.url:8080/postparameterservice1",
				"number1", "number2");
		sendPostHttp("https://my.test.url:8080/postparameterservice2",
				"number3", "number4");
		sendPostHttp("https://my.test.url:8080/postparameterservice3",
				"number5", "number6");
	}

	/**
	 * Providing various GET-requests with sessionparameters
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpSessionParametersGet() throws ServletException, IOException {
		SampleHttpRequest request1 = new SampleHttpRequest(
				"http://my.test.url:8080/getsessionservice1", "GET");
		request1.getSession().setAttribute("FirstAttribute", "1st Attribute");
		servlet.service(request1, SampleHttpResponse.INST);

		SampleHttpRequest request2 = new SampleHttpRequest(
				"http://my.test.url:8080/getsessionservice2", "GET");
		request2.getSession().setAttribute("SecondAttribute", "2nd Attribute");
		servlet.service(request2, SampleHttpResponse.INST);

		SampleHttpRequest request3 = new SampleHttpRequest(
				"http://my.test.url:8080/getsessionservice3", "GET");
		request3.getSession().setAttribute("ThirdAttribute", "3rd Attribute");
		servlet.service(request3, SampleHttpResponse.INST);
	}

	/**
	 * Providing different POST-requests with sessionparameters
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void httpSessionParametersPost() throws ServletException,
			IOException {
		SampleHttpRequest request1 = new SampleHttpRequest(
				"http://my.test.url:8080/postsessionservice1", "POST");
		request1.getSession().setAttribute("FirstAttribute", "1st Attribute");
		servlet.service(request1, SampleHttpResponse.INST);

		SampleHttpRequest request2 = new SampleHttpRequest(
				"http://my.test.url:8080/postsessionservice2", "POST");
		request2.getSession().setAttribute("SecondAttribute", "2nd Attribute");
		servlet.service(request2, SampleHttpResponse.INST);

		SampleHttpRequest request3 = new SampleHttpRequest(
				"http://my.test.url:8080/postsessionservice3", "POST");
		request3.getSession().setAttribute("ThirdAttribute", "3rd Attribute");
		servlet.service(request3, SampleHttpResponse.INST);
	}

	/**
	 * Building and sending a GET-request with 2 parameters
	 * 
	 * @param url
	 * @param parameter1
	 * @param parameter2
	 * @throws IOException
	 * @throws ServletException
	 */
	private void sendGetHttp(String url, String parameter1, String parameter2)
			throws IOException, ServletException {

		SampleHttpRequest request = new SampleHttpRequest(url + "?parameter1="
				+ parameter1 + "&parameter2=" + parameter2, "GET");
		request.setParameter("parameter1", parameter1);
		request.setParameter("parameter2", parameter2);
		servlet.service(request, SampleHttpResponse.INST);
	}

	/**
	 * Building and sending a POST-Request with 2 parameters
	 * 
	 * @param url
	 * @param parameter1
	 * @param parameter2
	 * @throws IOException
	 * @throws ServletException
	 */
	private void sendPostHttp(String url, String parameter1, String parameter2)
			throws IOException, ServletException {

		SampleHttpRequest request = new SampleHttpRequest(url, "POST");
		request.setParameter("parameter1", "1st Parameter");
		request.setParameter("parameter2", "2nd Parameter");
		servlet.service(request, SampleHttpResponse.INST);
	}
}

// Http is automatically defined to start an invocation sequence, so we do
// already have them within an invocation sequence.
