package youngerFAQ.commons.sub;

public class ProblemMes {
	
	private String proId;			//问题ID
	private String proTitle;		//问题标题
	private String proContent;		//问题内容
	private String proKindOf;		//问题类型
	private String proPublishDate;	//问题提出的日期
	private String proBestAnsId;	//问题的最佳答案
	private String proPublisher;	//问题的提出者
	private int    proVisitNumber;	//问题的访问次数
	private boolean isEnd;			//问题是否结束
	
	
	public int getProVisitNumber() {
		return proVisitNumber;
	}
	public void setProVisitNumber(int proVisitNumber) {
		this.proVisitNumber = proVisitNumber;
	}
	public String getProPublishDate() {
		return proPublishDate;
	}
	public void setProPublishDate(String proPublishDate) {
		this.proPublishDate = proPublishDate;
	}
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProTitle() {
		return proTitle;
	}
	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public String getProKindOf() {
		return proKindOf;
	}
	public void setProKindOf(String proKindOf) {
		this.proKindOf = proKindOf;
	}
	public String getProBestAnsId() {
		return proBestAnsId;
	}
	public void setProBestAnsId(String proBestAnsId) {
		this.proBestAnsId = proBestAnsId;
	}
	public String getProPublisher() {
		return proPublisher;
	}
	public void setProPublisher(String proPublisher) {
		this.proPublisher = proPublisher;
	}
	
	
	
	
	

}
