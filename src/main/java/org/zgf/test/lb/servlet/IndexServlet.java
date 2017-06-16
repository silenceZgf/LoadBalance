package org.zgf.test.lb.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1821967554289665508L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<br/>\n********************  request ********************<br/>\n");

		sb.append("request.getServerName: " + request.getServerName() + "<br/>\n" );
		sb.append("request.getServerPort: " + request.getServerPort() + "<br/>\n" );
		sb.append("request.getServletPath: " + request.getServletPath() + "<br/>\n" );
		
		sb.append("request.getLocalAddr: " + request.getLocalAddr() + "<br/>\n" );
		sb.append("request.getLocalName: " + request.getLocalName() + "<br/>\n" );
		sb.append("request.getLocalPort: " + request.getLocalPort() + "<br/>\n" );
		
		sb.append("request.getAuthType: " + request.getAuthType() + "<br/>\n" );
		sb.append("request.getCharacterEncoding: " + request.getCharacterEncoding() + "<br/>\n" );
		sb.append("request.getContentType: " + request.getContentType() + "<br/>\n" );
		sb.append("request.getContextPath: " + request.getContextPath() + "<br/>\n" );
		sb.append("request.getContentLength: " + request.getContentLength() + "<br/>\n" );
		
		sb.append("request.getMetho: " + request.getMethod() + "<br/>\n" );
		sb.append("request.getPathInfo: " + request.getPathInfo() + "<br/>\n" );
		sb.append("request.getPathTranslated: " + request.getPathTranslated() + "<br/>\n" );
		sb.append("request.getProtocol: " + request.getProtocol() + "<br/>\n" );
		
		sb.append("request.getRemoteAddr: " + request.getRemoteAddr() + "<br/>\n" );
		sb.append("request.getRemoteHost: " + request.getRemoteHost() + "<br/>\n" );
		sb.append("request.getRemotePort: " + request.getRemotePort() + "<br/>\n" );
		sb.append("request.getRemoteUser: " + request.getRemoteUser() + "<br/>\n" );
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			sb.append("request.getHeader(\"" + headerName + "\"):  " + request.getHeader(headerName) + "<br/>\n" );
		}
		
		
		sb.append("<br/>\n********************  session ********************<br/>\n");
		HttpSession session = request.getSession();
		sb.append("seession.getId:  " +  session.getId() + "<br/>\n" );
		sb.append("seession.getCreationTime:  " +  session.getCreationTime() + ", " + dateToString(session.getCreationTime()) + "<br/>\n" );
		sb.append("seession.getLastAccessedTime:  " +  session.getLastAccessedTime() + ", " + dateToString(session.getLastAccessedTime()) + "<br/>\n" );
		sb.append("seession.getMaxInactiveInterval:  " +  session.getMaxInactiveInterval() + "<br/>\n" );
		
		System.out.println(sb.toString().replace("<br/>", ""));
		response.getWriter().print(sb.toString());
	}
	
	private String dateToString(Long milsecs){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return sdf.format(new Date(milsecs));
	}

}
