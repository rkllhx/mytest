package com.lmonkey.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

@WebServlet("/manage/admin_doproductselect")
public class DoProductSelect extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int age = 1;
        int count = 5;
        
        //获取用户指定的页面
        String cp = request.getParameter("cp");
        
        //接收用户搜索的关键字
        String lookword = request.getParameter("lookwords");
        
        if(cp != null){
        	age = Integer.parseInt(cp);
        }
        
        int art[] = LMONKEY_PRODUCTDao.page(count, lookword);
        
        ArrayList<LMONKEY_PRODUCT> arrayList = LMONKEY_PRODUCTDao.selectAllP(age, count, lookword);
    	request.setAttribute("plist", arrayList);
		request.setAttribute("tsum", art[0]);
		request.setAttribute("tpage", art[1]);
		request.setAttribute("age", age);
		
		if(lookword != null) {
			request.setAttribute("searchParams", "&lookwords="+lookword);
		}
		
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}
}