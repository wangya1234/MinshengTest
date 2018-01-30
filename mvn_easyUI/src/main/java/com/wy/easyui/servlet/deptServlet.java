package com.wy.easyui.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dept/delete")
public class deptServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   /* int rows = Integer.parseInt(req.getParameter("rows"));
	    int page = Integer.parseInt(req.getParameter("page"));
	    System.out.println("rows="+rows);
	    System.out.println("page="+page);*/
	    String[] deptIds = req.getParameterValues("deptIds");
	    for(int i=0;i<deptIds.length;i++){
	    	System.out.println(deptIds[i]);
	    }
	    resp.getWriter().write("{\"status\":\"200\"}");
	    resp.getWriter().flush();
	}
	
	

}
