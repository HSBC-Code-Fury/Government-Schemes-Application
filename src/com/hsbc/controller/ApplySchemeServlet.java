/*
 * package com.hsbc.controller; import java.io.IOException; import
 * java.io.PrintWriter; import java.sql.SQLException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * public class ApplySchemeServlet extends HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * resp.setContentType("text/html"); PrintWriter out=resp.getWriter();
 * 
 * String sid=req.getParameter("schemeId"); String
 * cid=req.getParameter("citizenIdId");
 * 
 * ApplySchemeDao dao=new ApplySchemeDao(); System.out.println(sid);
 * 
 * try { if(dao.validateScheme("CITI5","SCHE001")) { RequestDispatcher
 * rd=req.getRequestDispatcher("eligible.html"); rd.forward(req, resp); } else {
 * RequestDispatcher rd=req.getRequestDispatcher("noteligible.html");
 * rd.forward(req, resp); } } catch (SQLException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); }
 * 
 * }
 * 
 * }
 */