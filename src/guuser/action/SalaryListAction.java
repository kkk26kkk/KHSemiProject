package guuser.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import dao.SalaryDAO;
import vo.SalaryInfo;



public class SalaryListAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
	  try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  ActionForward forward = new ActionForward();
    SalaryDAO dao=new SalaryDAO();
    List<SalaryInfo> vo=new ArrayList<SalaryInfo>();
	
	int page=1;
	int limit=10;
	
	if(request.getParameter("page")!=null) {
		page=Integer.parseInt(request.getParameter("page"));
	}
	System.out.println("�Ѿ��������="+page);
	
	
	HttpSession session=request.getSession();
	if(session.getAttribute("limit")!=null) {
		limit=Integer.parseInt(session.getAttribute("limit").toString());
	}
	if(request.getParameter("limit")!=null) {
		limit=Integer.parseInt(request.getParameter("limit"));
		session.setAttribute("limit", limit);
		System.out.println("limit = "+limit);
	}
	
	 String gid=(String) session.getAttribute("gid");//�߰��׸�
	vo=dao.getSalarylists2(page,limit,gid);
	

	int listcount=dao.getListCount2(gid);
	
	int maxpage=(listcount+limit-1)/limit;
	System.out.println("����������="+maxpage);

	
	int startpage= ((page-1)/10)*10+1;
	System.out.println("���� �������� ������ ���� �������� ��="+startpage);
	
	
	int endpage=startpage+10-1;
	System.out.println("���� �������� ������ ������ ������ ��="+endpage);
	
	
	
	if(endpage>maxpage) endpage=maxpage;
	
	request.setAttribute("page", page);//���� ������ ��
	request.setAttribute("maxpage", maxpage);//�ִ� ������ ��
	
	
	request.setAttribute("startpage",startpage);
	
	
	request.setAttribute("endpage",endpage);
	
	request.setAttribute("listcount",listcount);//�� ���� ��
	
	request.setAttribute("vo",vo);
	request.setAttribute("limit", limit);
	
	
	forward.setRedirect(false);
	
	//���� ��� �������� �̵��ϱ� ���� ��θ� �����մϴ�.
	
	
	
	
	/*forward.setRedirect(false);*/
	forward.setPath("gu/user/salarylist.jsp");
	
	return forward;

}
  
    
    
    

  }


