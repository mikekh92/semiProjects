package com.kh.product.controller.Boling;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageInfo;
import com.kh.product.model.service.Boling.BolingService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class Soccer
 */
@WebServlet("/boling.pg")
public class Boling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// --------------------페이징 처리------------------------
		int listCount; //현재 총 게시글 개수
		int currentPage; //현재 페이지(사용자가 요청한 페이지)
		int pageLimit; //페이지 하단에 보이는 페이지 페이징 최대 개수
		int boardLimit; //한 페이지에서 보여질 게시글 개수
		
		int maxPage; //가장 마지막 페이지가 몇번페이지인지 (총 페이지수)
		int startPage; //페이지 하단에 보여질 페이징 시작 수 
		int endPage; //페이지 하단에 보여질 페이징 끝 수 
		int cateNo =0;
		//listCount 현재 총 게시글 개수
		listCount = new BolingService().BolingCount(); 
		//currentPage 현재 페이지(사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		if((request.getParameter("tp")!=null)) {
			cateNo = Integer.parseInt(request.getParameter("tp"));
			}else {
				cateNo=0;
			}
		
		int listCounttp = new BolingService().BolingtpCount(cateNo);
		//pageLimit 페이지 하단에 보이는 페이지 페이징 최대 개수
		pageLimit = 10;
		//boardLimit 한 페이지에서 보여질 게시글 개수
		boardLimit = 10;
		
		//maxPage 가장 마지막 페이지가 몇번 페이지인지 (총 페이지 수)
		//listCount와 boardLimit의 영향을 받는다 (총개수와 표현할개수)
//		107 10 = 11       =  10 - 7  <-정수형계산  실수형계산-> 	10.7   11.0
//		89 10 = 9         =   8 - 9 <-  					8.9	   9.0
//		111 10 = 12  	  =  11 - 1	<- 						11.1   12.0
//		110 10 = 11 	  =  11 - 0 <- 						11.0   11.0
		
		
		//만약 (listCount / boardLimit)+1 을 하면 딱 나누어 떨어질때도 +1이 되기 때문에
		//나누고 난 뒤 올림처리를 이용해서 계산(나머지가 있을때만 +1 됨) 
		//1)listCount를 double형으로 변환  (double)listCount
		//2)listCount/boardLimit      (double)listCount/boardLimit)
		//3)결과를 올림처리 Math.ceil() 메소드 호출 Math.ceil((double)listCount/boardLimit
		//4)결과값을 다시 int 자료형으로 형변환 시켜준다  (int)(Math.ceil((double)listCount/boardLimit))
		
		maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		int maxPagetp = (int)(Math.ceil((double)listCounttp/boardLimit));
		
		//startPage 페이지 하단에 보여질 페이징 시작 수 
		//pageLimit와 currentPage 에 영향을 받는다 
		
		//startPage = 1,11,21,31,41,51,61,71.....  10의 배수 + 1
		//만약 pageLimit을 5로 설정했을때 = 1,6,11,16,...... 5의 배수 + 1
		// n * pageLimit + 1 
		// startPage = 1   n=0*10+1   1      1~10  = 0이여야하지만 마지막 10에서 1이 되어버림
		// startPage = 11  n=1*10+1   11     11~20 = 1이여야하지만 마지막 20에서 2이 되어버림
		// startPage = 21  n=2*10+1   21	 21~30 = 2이여야하지만 마지막 30에서 3이 되어버림
		// 0~9 /   10 0 이렇게 해당 범위에 -1을 해주면 원하는 값을 얻을 수 있음 
		// 10~19 / 10 1
		// 20~29 / 10 2
		// n = (currentPage-1)/pageLimit
		
		//startPage = n * pageLimit + 1
		startPage = (currentPage-1)/pageLimit * pageLimit + 1;
		
		//endPage = 페이지 하단에 보여질 페이징 끝 수 
		//startPage,pageLimit에 영향을 받는다 
		//pageLimit을 10이라고 가정했을때 
		// startPage=1 endPage=10  pageLimit=10
		// startPage=11 endPage=20 pageLimit=10
		// startPage=21 endPage=30 pageLimit=10
		
		endPage = startPage+pageLimit - 1;
		
	
		// maxPage 11일 경우 기존대로 작성하면 endPage가 20이 나오기때문에 11으로 변경해주는 처리가 필요함 
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		if(endPage>maxPagetp) {
			endPage=maxPagetp;
		}
		
		//페이지 정보들을 요청 처리 보내면 된다 .
		//1.페이징바를 만들때 필요한 객체
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit
												,maxPage,startPage,endPage);
		PageInfo pitp = new PageInfo(listCounttp,currentPage,pageLimit,boardLimit
				,maxPagetp,startPage,endPage);

		if((cateNo==0)) {
		ArrayList<Product> list = new BolingService().BolingProduct(pi);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("category", "boling");
		}
		else {
		ArrayList<Product> listtp = new BolingService().BolingtpProduct(pitp,cateNo);
		request.setAttribute("pi", pitp);
		request.setAttribute("list", listtp);
		request.setAttribute("category", "boling");
		}
		request.getRequestDispatcher("/views/semi/categoryPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
