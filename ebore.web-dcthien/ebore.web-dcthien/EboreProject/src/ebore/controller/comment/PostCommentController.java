package ebore.controller.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ebore.model.Comment;
import ebore.model.User;

/**
 * Servlet implementation class PostCommentController
 */
@WebServlet("/PostCommentController")
public class PostCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		// Get the story
		String url = (String) request.getSession().getAttribute("url");
		String storyID = request.getParameter("storyID");
		String content = request.getParameter("comment");
		
		User user = (User) request.getSession().getAttribute("user");
		int userID = 0;
//		if (user != null) userID = user.getID();
		
		// update comment list for current story
		boolean isSuccessfullyUpdate = Comment.postNewComment(storyID, userID, content);
		
		if (!isSuccessfullyUpdate) {
			response.sendRedirect("");
		} else {
			response.sendRedirect(url);
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
