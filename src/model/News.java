package model;

public class News {
	private String newsTitle;
	private String newsContent;
	private String newsImage;

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsImage() {
		return newsImage;
	}

	public void setNewsImage(String newsImage) {
		this.newsImage = newsImage;
	}

	public News(String newsTitle, String newsContent, String newsImage) {
		super();
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsImage = newsImage;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

}
