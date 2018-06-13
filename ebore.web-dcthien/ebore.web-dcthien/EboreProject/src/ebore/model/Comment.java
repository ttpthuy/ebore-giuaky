package ebore.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import ebore.dao.CommentDAO;

public class Comment {
	private int commentID;
	private String username; /* not userID */
	private String content;
	private Date postDate;
	private int approved;
	
	private static CommentDAO commentDAO;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int commentID, String username, String content, Date postDate, int approved) {
		super();
		this.commentID = commentID;
		this.username = username;
		this.content = content;
		this.postDate = postDate;
		this.approved = approved;
	}
	
	/*
	 * insert new comment
	 */
	public static boolean postNewComment(String storyID, int userID, String content) {
		commentDAO = (commentDAO == null) ? new CommentDAO() : commentDAO;
		
		Calendar calendar = Calendar.getInstance();
		long currentDateTimeInMillis = calendar.getTimeInMillis();
		Timestamp timestamp = new Timestamp(currentDateTimeInMillis);
		return commentDAO.insert(storyID, userID, content, timestamp, 1);
	}
	
	/*
	 * delete comment
	 */
	public static void deleteComment(String id) {
		commentDAO = (commentDAO == null) ? new CommentDAO() : commentDAO;
		commentDAO.delete(id);
	}
	
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public String getUsername() {
		return username;
	}
	public String getContent() {
		return content;
	}
	public Date getPostDate() {
		return postDate;
	}
	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", username=" + username + ", content=" + content + ", postDate="
				+ postDate + ", approved=" + approved + "]" + " \n";
	}
	
	
	
}
