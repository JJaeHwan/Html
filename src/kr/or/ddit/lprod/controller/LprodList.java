package kr.or.ddit.lprod.controller;
/*
 	sendRedirect
 	 - 나갔다 다시들어온다?
 	
 	forward
 	- Request와 Response를 공유 
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LProdServiceimpl;
import kr.or.ddit.lprod.vo.LprodVO;

@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 0. 클라이언트 전송시 데이터를 받는다
		
		// 1. service객체를 얻어온다.
		ILprodService service = LProdServiceimpl.getService();	
		
		// 2. service메소드 호출한다 - 결과를 리턴 받는다
		List<LprodVO> list = service.selectLprod();
		
		// 3. 결과를 request에 저장한다
		request.setAttribute("list", list);
		
		// 4. view페이지로 이동(forward) = html을 이용하여 출력 하거나 또는 json데이터를 생성 
		RequestDispatcher disp =  request.getRequestDispatcher("view/lprodList.jsp");
		disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
