package ebore.model;

import java.util.List;

import ebore.dao.NovelDao;

public class NovelList {
	List<Novel> novel;
	static NovelDao novelDao;

	public static List<Novel> getAllNovel() {
		novelDao = (novelDao == null) ? new NovelDao() : novelDao;
		return novelDao.selectAllNovel();
	}

	public List<Novel> getNovel() {
		return novel;
	}

	public void setNovel(List<Novel> novel) {
		this.novel = novel;
	}

}
