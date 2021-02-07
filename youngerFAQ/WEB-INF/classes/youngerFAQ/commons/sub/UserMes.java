package youngerFAQ.commons.sub;

public class UserMes {

	private String userId;			//用户的ID
	private String userName;		//用户的名称
	private String dearName;		//用户的昵称
	private String password;		//用户的密码
	private String email;			//用户的电子邮箱
	private String cellNumber;		//用户的移动电话
	private String qqnumber;		//用户的QQ号码
	private String workName;		//用户的工作
	private String address;			//用户的所在地
	private String birthday;		//用户的出生日期
	private String headPic;			//用户的头像的文件地址
	private boolean isAdministrator;//用户是否为管理员
	private boolean sex;			//用户的性别
	
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQqnumber() {
		return qqnumber;
	}
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}
	public String getDearName() {
		return dearName;
	}
	public void setDearName(String dearName) {
		this.dearName = dearName;
	}
	public String getUserName() {
		return userName;
	}
	public boolean isAdministrator() {
		return isAdministrator;
	}
	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	
	
	
	

}
