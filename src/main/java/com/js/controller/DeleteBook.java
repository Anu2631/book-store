package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BookCrud;
@WebServlet(value ="/delete")
public class DeleteBook extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		BookCrud bc=new BookCrud(); 
		int result=bc.deleteBookById(id);
	if(result>0) {
		RequestDispatcher rd=req.getRequestDispatcher("view");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
		req.setAttribute("msg", "NO BOOK WITH GIVEN ID TO DELETE");
		rd.forward(req, resp);
	}
	}

}
