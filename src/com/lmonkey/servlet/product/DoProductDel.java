package com.lmonkey.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.service.LMONKEY_PRODUCTDao;

@WebServlet("/manage/admin_productdel")
public class DoProductDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		
		int count = LMONKEY_PRODUCTDao.del(id);
		
		if(count < 0) {
			PrintWriter out  = response.getWriter();
			
			out.write("<script>");
			out.write("alert('删除失败')");
			out.write("localtion.href='/manage/admin_doproductselect'");
			out.write("</script>");
		}
		else{
			response.sendRedirect("admin_doproductselect?cp="+request.getParameter("age"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
				String ids[]= request.getParameterValues("id[]");
				
				for(int i = 0; i < ids.length; i++){
					LMONKEY_PRODUCTDao.del(ids[i]);
				}
				response.sendRedirect("/MonkeyShop/manage/admin_doproductselect");
	}
}
