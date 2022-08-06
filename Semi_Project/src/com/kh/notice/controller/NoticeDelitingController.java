package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDelitingController
 */
@WebServlet("/deleting.no")
public class NoticeDelitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDelitingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] temp = request.getParameterValues("values"); // [117,28,53]
		
		int [] NoticeNoForDelete= new int[temp.length];
		
		
		for (int i = 0;i < temp.length; i++) {
				NoticeNoForDelete[i]= Integer.parseInt(temp[i]);
		}
		int result =new NoticeService().selectDelete(NoticeNoForDelete);
//		int noticeNo =Integer.parseInt(request.getParameter("nno"));
		

//		String [] notice_No=request.getParameterValues("delete1");
		
//		for(int i = 0; i < notice_No.length; i++) {
//			System.out.println(notice_No[i]);	
//		} // 데이터가 첫 번째 한 개만 넘어옴 (checkbox 체크 하지 않아도)
		
		}	
//		int noticeNoArr=0;
//		
//		for(int i=0; i<notice_No.length; i++) {
//			int noticeNo = Integer.parseInt(notice_No[i]);
//			noticeNoArr+=noticeNo;
//		}
//		System.out.println(noticeNoArr);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
