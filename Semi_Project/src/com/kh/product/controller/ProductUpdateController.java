package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Attachment;
import com.kh.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductUpdateController
 */
@WebServlet("/productUpdate.pd")
public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

			int proNo = Integer.parseInt(request.getParameter("proNo"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String code = request.getParameter("code");
			int bigCg = Integer.parseInt(request.getParameter("bigCg"));
			int smallCg = Integer.parseInt(request.getParameter("smallCg"));
			String maker = request.getParameter("maker");
			String des = request.getParameter("des");
			String size = request.getParameter("size");
			int amount = Integer.parseInt(request.getParameter("amount"));
			String level = request.getParameter("levelnum");
//			int count = Integer.parseInt(request.getParameter("imglength"));
			
			Product p = new Product();
			p.setProNo(proNo);
			p.setProName(name);
			p.setProPrice(price);
			p.setProCode(code);
			p.setCateBno(bigCg);
			p.setCateSno(smallCg);
			p.setProMaker(maker);
			p.setProDes(des);
			p.setProAmount(amount);
			p.setProSize(size);
			p.setProLevel(level);
			int result = new ProductService().updateProduct(p);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "상품 수정 완료");
				response.sendRedirect(request.getContextPath()+"/detail.pd?proNo="+proNo);
			}else {
				System.out.println("안됨");
			}
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
