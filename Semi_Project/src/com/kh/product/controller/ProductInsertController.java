package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Attachment;
import com.kh.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductInsertController
 */
@WebServlet("/productInsert.pd")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/product_image/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
			
			String name = multiRequest.getParameter("name");
			int price = Integer.parseInt(multiRequest.getParameter("price"));
			String code = multiRequest.getParameter("code");
			int bigCg = Integer.parseInt(multiRequest.getParameter("bigCg"));
			int smallCg = Integer.parseInt(multiRequest.getParameter("smallCg"));
			String maker = multiRequest.getParameter("maker");
			String des = multiRequest.getParameter("des");
			String size = multiRequest.getParameter("size");
			int amount = Integer.parseInt(multiRequest.getParameter("amount"));
			String level = multiRequest.getParameter("level");
			int count = Integer.parseInt(multiRequest.getParameter("imglength"));
			
			Product p = new Product();
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
			
			ArrayList<Attachment> list = new ArrayList<>();
			
			for(int i=1;i<=count;i++) {
				String key = "img"+i;
				if(multiRequest.getOriginalFileName(key)!=null) {
					Attachment at = new Attachment();
					String path = "resources/product_image/";
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath(path);
					
					list.add(at);
				}
			}
			int result = new ProductService().insertProduct(p,list);
			
			if(result>0) {
//				request.getRequestDispatcher("/views/admin/product/productHome.jsp").forward(request, response);
				request.getSession().setAttribute("alertMsg", "상품 등록 완료");
				response.sendRedirect(request.getContextPath()+"/list.pd?cpage=1");
			}else {
				System.out.println("안됨");
			}
			
			
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
