package ebore.model;

import java.util.List;

import ebore.dao.CommentDAO;

public class CommentList {
	private List<Comment> comments;
	private static CommentDAO commentDAO;

	public CommentList(String storyID) {
		commentDAO = (commentDAO == null) ? new CommentDAO() : commentDAO;
		comments = commentDAO.select(storyID);
	}

	public static List<Comment> getAllComment() {
		commentDAO = (commentDAO == null) ? new CommentDAO() : commentDAO;
		return commentDAO.selectAllComment();
	}
	
	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommentList [comments=" + comments + ", commentDAO=" + commentDAO + "]";
	}

}
