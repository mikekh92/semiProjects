package com.kh.basket1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.basket1.model.service.basket1Service;

/**
 * Servlet implementation class ajaxConfirmBasket
 */
@WebServlet("/confirmBasket.ba")
public class ajaxConfirmBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxConfirmBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bano = (String[])request.getParameterValues("bano");
		String[] orderNoS = (String[])request.getParameterValues("orderNo");
		int[] basketY = new int[bano.length];
		int[] orderNo = new int[orderNoS.length];
		for(int i=0;i<basketY.length;i++) {
			basketY[i] = Integer.parseInt(bano[i]);
			orderNo[i] = Integer.parseInt(orderNoS[i]);
		}
		
		new basket1Service().confirmBasket(basketY, orderNo);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
