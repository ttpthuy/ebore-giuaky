package ebore.model;

import ebore.dao.NovelDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Novel {

	private String novelCode;
	private String novelName;
	private String novelType;
	private String novelDescription;
	private String novelScontent;
	private double novelPrice;
	private String novelAuthor;
	private String novelLanguage;
	
	private static NovelDao novelDAO = new NovelDao();
	public Novel(String novelCode, String novelName, double novelPrice,String novelType,String novelAuthor, String novelLanguage,String novelDescription, String novelScontent) {
		super();
		this.novelCode = novelCode;
		this.novelName = novelName;
		this.novelPrice = novelPrice;
		this.novelType = novelType;
		this.novelAuthor = novelAuthor;
		this.novelLanguage = novelLanguage;
		this.novelDescription = novelDescription;
		this.novelScontent = novelScontent;
		
	}

	public Novel() {

	}

	

	public String getNovelCode() {
		return novelCode;
	}

	public void setNovelCode(String novelCode) {
		this.novelCode = novelCode;
	}

	public String getNovelName() {
		return novelName;
	}

	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}

	public String getNovelType() {
		return novelType;
	}

	public void setNovelType(String novelType) {
		this.novelType = novelType;
	}

	public String getNovelDescription() {
		return novelDescription;
	}

	public void setNovelDescription(String novelDescription) {
		this.novelDescription = novelDescription;
	}

	public String getNovelScontent() {
		return novelScontent;
	}

	public void setNovelScontent(String novelScontent) {
		this.novelScontent = novelScontent;
	}

	public double getNovelPrice() {
		return novelPrice;
	}

	public void setNovelPrice(double novelPrice) {
		this.novelPrice = novelPrice;
	}

	public String getNovelAuthor() {
		return novelAuthor;
	}

	public void setNovelAuthor(String novelAuthor) {
		this.novelAuthor = novelAuthor;
	}

	public String getNovelLanguage() {
		return novelLanguage;
	}

	public void setNovelLanguage(String novelLanguage) {
		this.novelLanguage = novelLanguage;
	}

	public boolean getMe(String procode) {
		if (!this.novelCode.equals(procode)) {
			return false;
		}
		return true;
	}
	public boolean equalNovelCode(String novel) {
		return novelCode.equalsIgnoreCase(novel);
	}

	@Override
	public String toString() {
		return "Product [productCode=" + novelCode + ", productName=" + novelName + ",novelType = " + novelType
				+ ", productPrice=" + novelPrice + "]";
	}

	public static void deleteNovel(String novelCode) {
		novelDAO = (novelDAO == null) ? new NovelDao() : novelDAO;
		novelDAO.delete(novelCode);
		
	}

}
