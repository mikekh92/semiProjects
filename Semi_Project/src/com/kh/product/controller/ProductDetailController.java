package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Attachment;
import com.kh.product.model.vo.Category;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/detail.pd")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int proNo = Integer.parseInt(request.getParameter("proNo"));
		
		Product  p = new ProductService().selectdetail(proNo);
		ArrayList<Attachment> list = new ProductService().selectAttachment(proNo);
		ArrayList<Category> bList = new ProductService().selectCategoryList();
		Category b = new ProductService().selectBigCategory(p.getCateBno());
		Category s = new ProductService().selectSmallCategory(p.getCateSno());
		
		request.setAttribute("adCate",1);
		request.setAttribute("b", b);
		request.setAttribute("s", s);
		request.setAttribute("bList", bList);
		request.setAttribute("p", p);
		request.setAttribute("list", list);
		request.setAttribute("proNo", proNo);
		request.getRequestDispatcher("/views/admin/product/productDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
