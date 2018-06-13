package ebore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ebore.model.Comment;

public class CommentDAO extends DAO {

	/**
	 * 
	 * @param storyID
	 * @param userID
	 * @param content
	 * @param postDate
	 * @param approved
	 * @return
	 */

	// push again
	/*
	 * INSERT COMMENT INTO DATA
	 */
	public boolean insert(String storyID, int userID, String content, Object postDate, int approved) {
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "insert into comment (IDSTORY, IDUSER, CCONTENT, POSTDATE, APPROVED)"
					+ "value (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, storyID);
			statement.setInt(2, userID);
			statement.setString(3, content);
			statement.setObject(4, postDate);
			statement.setInt(5, approved);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}
	}

	/*
	 * DELETE COMMENT BY ID
	 */
	public boolean delete(String id) {
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "DELETE FROM comments WHERE IDCOMMENT = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;

		}
	}

	/*
	 * SELECT A COMMENT BY ID
	 */
	public Comment selectByCommentID(String commentID) {
		Comment newComment = null;
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, commentID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				newComment = new Comment(resultSet.getInt(""), resultSet.getString(""), resultSet.getString(""),
						resultSet.getDate(""), resultSet.getInt(""));
			}
			return newComment;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}
		return newComment;
	}

	/*
	 * SELECT COMMENTS BY STORYID
	 */
	public List<Comment> select(String storyID) {
		ArrayList<Comment> commentsList = new ArrayList<>();
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, storyID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Comment newComment = new Comment(resultSet.getInt(""), resultSet.getString(""), resultSet.getString(""),
						resultSet.getDate(""), resultSet.getInt(""));
				commentsList.add(newComment);
			}
			return commentsList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}

		return commentsList;
	}

	/*
	 * SELECT ALL COMMENT
	 */
	public List<Comment> selectAllComment() {
		ArrayList<Comment> commentsList = new ArrayList<>();
		try {
			if (myConnection == null) {
				myConnection = connectionPool.borrowConnection();
				connection = myConnection.getConnection();
			}
			String sql = "SELECT * FROM COMMENTS";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Comment newComment = new Comment(resultSet.getInt("IDCOMMENT"), resultSet.getString("IDUSER"), resultSet.getString("CCONTENT"),
						resultSet.getDate("POSTDATE"), resultSet.getInt("APPROVED"));
				commentsList.add(newComment);
			}
			return commentsList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.returnConnection(myConnection);
			myConnection = null;
		}
		return commentsList;
	}
	public static void main(String[] args) {
		CommentDAO dao = new CommentDAO();
		System.out.println(dao.selectAllComment());
	}
}
