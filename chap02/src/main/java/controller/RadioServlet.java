package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadioServlet
 */
@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String gender = request.getParameter("gender");
		String chk_mail = request.getParameter("chk_mail");
		String content = request.getParameter("content");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.println("����� �Է��� �����Դϴ�.<hr>");
		out.println("���� : <br>");
		out.println(gender);
		out.println("<br><br> ���� ���� ���� ���� : <b>");
		out.println(chk_mail);
		out.println("</b><br> ���� �λ� : <b><pre>");
		out.println(content);
		
		out.println("</b></pre><a href='javascript:history.go(-1)'> �ٽ� </a>");
		out.print("</body></html>");
		out.close();
	}
}
