package ebore.controller.novel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ebore.dao.NovelDao;
import ebore.dao.UserDAO;
import ebore.model.LineNovel;
import ebore.model.Novel;

/**
 * Servlet implementation class DeleteNovel
 */
@WebServlet("/DeleteNovel")
public class DeleteNovel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNovel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String novelCode = request.getParameter("novelCode");
//		if(novelCode!= null) {
//			NovelDao.removeItem(novelCode);
//			
//		}
//		response.sendRedirect("novelManage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String novelCode = request.getParameter("novelCode").trim();
		if(novelCode!= null) {
			Novel.deleteNovel(novelCode);
		}
		response.sendRedirect("novelManage.jsp");
		
		
//		String novelCode = request.getParameter("novelCode");
//		System.out.println(novelCode);
//		Novel n = NovelDao.lookUp(novelCode);
//		System.out.println(n);
//		NovelDao dao = new NovelDao();
//		dao.delete(n);
//		NovelDao.mapNovel.remove(n.getNovelCode(),n);
//		getServletContext().getRequestDispatcher("/novelManage.jsp").forward(request, response);
	}

}
