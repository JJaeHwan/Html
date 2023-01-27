package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoimpl;
import kr.or.ddit.lprod.vo.LprodVO;
/*
 
 	dao메소드 호출 하여 결과를 리턴받는다 -dao 객체필요 - 생성자에서 수행
 	자신의 객체를 생성하여 리턴하는 메소드 
 	
 */
public class LProdServiceimpl implements ILprodService {
	private ILprodDao dao;
	private static ILprodService service;
	private LProdServiceimpl() {
		dao = LprodDaoimpl.getDao();
	}
	
	public static ILprodService getService() {
		if(service == null) service = new LProdServiceimpl();
		return service;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		
		List<LprodVO> list = null;
		
		list = dao.selectLprod();
		
		return list;
	}


}
