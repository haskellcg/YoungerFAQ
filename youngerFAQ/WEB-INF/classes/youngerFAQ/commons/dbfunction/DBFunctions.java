package youngerFAQ.commons.dbfunction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import youngerFAQ.commons.sub.*;

public class DBFunctions {

	private DBConnection dbc = new DBConnection();

	// 注册功能：向数据库中添加用户的信息
	// 返回值：用户的ID
	public String insertUserMes(UserMes userMes){

		String insertSql="insert younger_user_info(user_name,user_dearname,user_password,user_email,user_cellnumber,user_qqnumber,user_workname,user_address,user_birthday,user_headpic,user_isadmin,user_sex) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String userId=null;
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(insertSql);
			preparedSm.setString(1, userMes.getUserName());
			preparedSm.setString(2, userMes.getDearName());
			preparedSm.setString(3, userMes.getPassword());
			preparedSm.setString(4, userMes.getEmail());
			preparedSm.setString(5, userMes.getCellNumber());
			preparedSm.setString(6, userMes.getQqnumber());
			preparedSm.setString(7, userMes.getWorkName());
			preparedSm.setString(8, userMes.getAddress());
			preparedSm.setString(9, userMes.getBirthday());
			preparedSm.setString(10, userMes.getHeadPic());
			preparedSm.setInt(11, userMes.isAdministrator()==true?1:0);
			preparedSm.setInt(12, userMes.isSex()==true?1:0);
			preparedSm.execute();
			preparedSm.close();
			
			String selectSql="select user_id from younger_user_info where user_name="+"'"+userMes.getUserName()+"'";
			PreparedStatement preparedSm2=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm2.executeQuery();
			while(resultSet.next()){
				userId=Integer.toString(resultSet.getInt("user_id"));
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return userId;

	}

	// 修改个人信息的功能:根据输入的用户信息修改相应的用户信息
	// 返回值：0表示成功
	// 1表示失败
	public int alterUserMes(UserMes userMes) {

		String updateSql="update younger_user_info set user_name=?,user_dearname=?,user_password=?," +
													  "user_email=?,user_cellnumber=?,user_qqnumber=?," +
													  "user_workname=?,user_address=?,user_birthday=?," +
													  "user_headpic=?,"+
													  "user_isadmin=?,user_sex=? where user_id=?";
											     
		try{									      
			PreparedStatement preparedSm=dbc.getPreparedStatement(updateSql);
			preparedSm.setString(1,userMes.getUserName());
			preparedSm.setString(2,userMes.getDearName());
			preparedSm.setString(3,userMes.getPassword());
			preparedSm.setString(4,userMes.getEmail());
			preparedSm.setString(5,userMes.getCellNumber());
			preparedSm.setString(6,userMes.getQqnumber());
			preparedSm.setString(7,userMes.getWorkName());
			preparedSm.setString(8,userMes.getAddress());
			preparedSm.setString(9,userMes.getBirthday());
			preparedSm.setString(10,userMes.getHeadPic());
			preparedSm.setInt(11,userMes.isAdministrator()==true?1:0);
			preparedSm.setInt(12,userMes.isSex()==true?1:0);
			preparedSm.setInt(13,Integer.parseInt(userMes.getUserId()));
			preparedSm.execute();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;

	}

	// 删除用户：从数据库中删除指定ID的用户数据
	// 返回值：0表示成功
	// 1表示失败
	public int deleteUserMes(String userId) {

		
		String deleteSql="delete from younger_user_info where user_id="+userId;
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(deleteSql);
			preparedSm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
			return 0;

	}

	// 查看个人信息功能：根据用户ID获得该用户的详细信息
	public UserMes getUserMes(String userId) {

		String selectSql="select * from younger_user_info where user_id="+userId;
		UserMes userMes=new UserMes();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				userMes.setUserId(Integer.toString(resultSet.getInt("user_id")));
				userMes.setUserName(resultSet.getString("user_name"));
				userMes.setDearName(resultSet.getString("user_dearname"));
				userMes.setPassword(resultSet.getString("user_password"));
				userMes.setEmail(resultSet.getString("user_email"));
				userMes.setCellNumber(resultSet.getString("user_cellnumber"));
				userMes.setQqnumber(resultSet.getString("user_qqnumber"));
				userMes.setWorkName(resultSet.getString("user_workname"));
				userMes.setAddress(resultSet.getString("user_address"));
				userMes.setBirthday(resultSet.getString("user_birthday"));
				userMes.setHeadPic(resultSet.getString("user_headpic"));
				userMes.setAdministrator(resultSet.getInt("user_isadmin")==1?true:false);
				userMes.setSex(resultSet.getInt("user_sex")==1?true:false);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return userMes;

	}
	
	//根据用户名的Unicode编码序列列出所有的用户信息
	public UserMesList getUserMesListByOrder(){
		UserMesList userList=new UserMesList();
		String orderSelectSql="select * from younger_user_info order by user_name"; 
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				UserMes userMes=new UserMes();
				userMes.setUserId(Integer.toString(resultSet.getInt("user_id")));
				userMes.setUserName(resultSet.getString("user_name"));
				userMes.setDearName(resultSet.getString("user_dearname"));
				userMes.setPassword(resultSet.getString("user_password"));
				userMes.setEmail(resultSet.getString("user_email"));
				userMes.setCellNumber(resultSet.getString("user_cellnumber"));
				userMes.setQqnumber(resultSet.getString("user_qqnumber"));
				userMes.setWorkName(resultSet.getString("user_workname"));
				userMes.setAddress(resultSet.getString("user_address"));
				userMes.setBirthday(resultSet.getString("user_birthday"));
				userMes.setHeadPic(resultSet.getString("user_headpic"));
				userMes.setAdministrator(resultSet.getInt("user_isadmin")==1?true:false);
				userMes.setSex(resultSet.getInt("user_sex")==1?true:false);
				userList.append(userMes);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
		
	}
	
	
	//根据用户名获得ID
	public String getUserId(String userName){
		
		String selectSql="select user_id from younger_user_info where user_name="+"'"+userName+"'";
		String userId="";
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				userId=resultSet.getString("user_id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userId;
		
	}

	// 登录功能/注册时验证：验证用户名是否存在
	// 返回值：0表示不存在
	// 1表示存在
	public int userNameIsExist(String userName) {

		String selectSql="select * from younger_user_info where user_name="+"'"+userName+"'";
		int exist=0;
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				exist=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return exist;

	}

	/*********************************************************************/

	// 提出问题功能：把问题信息存入数据库
	// 返回值：问题的ID
	public String insertProblemMes(ProblemMes proMes) {

		
		String insertSql="insert younger_pro_info(pro_title,pro_content,pro_kindof,pro_publisher,pro_publishdate,pro_bestans,pro_isend,pro_visitnumber) values(?,?,?,?,?,?,?,?)";
		String proId="";
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(insertSql);
			preparedSm.setString(1,proMes.getProTitle());
			preparedSm.setString(2,proMes.getProContent());
			preparedSm.setString(3,proMes.getProKindOf());
			preparedSm.setString(4,proMes.getProPublisher());
			preparedSm.setString(5,proMes.getProPublishDate());
			preparedSm.setInt(6,Integer.parseInt(proMes.getProBestAnsId()));
			preparedSm.setInt(7,(proMes.isEnd()==true)?1:0);
			preparedSm.setInt(8, proMes.getProVisitNumber());
			
			preparedSm.execute();
			preparedSm.close();
			
			String selectSql="select pro_id from younger_pro_info where pro_publishdate="+"'"+proMes.getProPublishDate()+"'";
			PreparedStatement preparedSm2=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm2.executeQuery();
			while(resultSet.next()){
				proId=Integer.toString(resultSet.getInt("pro_id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return proId;

	}

	// 查看问题功能：根据问题的ID返回问题的详细信息
	public ProblemMes getProblemMes(String proId) {

		String selectSql="select * from younger_pro_info where pro_id="+proId;
		ProblemMes proMes=new ProblemMes();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				proMes.setProId(proId);
				proMes.setProTitle(resultSet.getString("pro_title"));
				proMes.setProContent(resultSet.getString("pro_content"));
				proMes.setProKindOf(resultSet.getString("pro_kindof"));
				proMes.setProPublisher(resultSet.getString("pro_publisher"));
				proMes.setProPublishDate(resultSet.getString("pro_publishdate"));
				proMes.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				proMes.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				proMes.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proMes;

	}

	// 删除问题：验证用户为提出者或者是管理员，如果是可以删除
	// 返回值：0表示成功
	// 1表示失败
	public int deleteProblemMes(String proId) {

		String deleteSql="delete from youger_pro_info where pro_id="+proId;
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(deleteSql);
			preparedSm.execute();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;

	}

	//根据问题ID增加问题的访问量
	//返回值：0增加成功
	//		1表示失败
	public int addProblemVisitNumber(String proId){
		
		String updateSql="update younger_pro_info set pro_visitnumber=pro_visitnumber+1 where pro_id="+proId;
		PreparedStatement preparedSm=dbc.getPreparedStatement(updateSql);
		try{
			preparedSm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	// 设为最佳答案：根据答案的ID，找到答案对应问题的最佳答案属性
	// 返回值:0表示成功
	// 		1表示失败
	public int setBestAnswer(String answerId) {

		ProblemMes proMes=getProblemMes(getAnswerMes(answerId).getAnsToProId());
		String updateSql="update younger_pro_info set pro_bestans="+answerId+",pro_isend=?"+" where pro_id="+proMes.getProId();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(updateSql);
			preparedSm.setInt(1, 1);
			preparedSm.execute();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;

	}

	// 列出所有问题按访问量大小顺序
	public ProblemMesList getAllProblemMes() {

		String orderSelectSql="select * from younger_pro_info order by pro_visitnumber desc";
		ProblemMesList proList=new ProblemMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ProblemMes temp=new ProblemMes();
				temp.setProId(Integer.toString(resultSet.getInt("pro_id")));
				temp.setProTitle(resultSet.getString("pro_title"));
				temp.setProContent(resultSet.getString("pro_content"));
				temp.setProKindOf(resultSet.getString("pro_kindof"));
				temp.setProPublisher(resultSet.getString("pro_publisher"));
				temp.setProPublishDate(resultSet.getString("pro_publishdate"));
				temp.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				temp.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				temp.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
				proList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proList;
	}

	//列出未解决问题根据提问者ID
	public ProblemMesList getSolveProblemMesByID(String userId) {

		String publisher=getUserMes(userId).getUserName();
		String orderSelectSql="select * from younger_pro_info where pro_isend=0 and pro_publisher="+"'"+publisher+"'"+" order by pro_visitnumber desc";
		ProblemMesList proList=new ProblemMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ProblemMes temp=new ProblemMes();
				temp.setProId(Integer.toString(resultSet.getInt("pro_id")));
				temp.setProTitle(resultSet.getString("pro_title"));
				temp.setProContent(resultSet.getString("pro_content"));
				temp.setProKindOf(resultSet.getString("pro_kindof"));
				temp.setProPublisher(resultSet.getString("pro_publisher"));
				temp.setProPublishDate(resultSet.getString("pro_publishdate"));
				temp.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				temp.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				temp.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
				proList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proList;
	}
	
	//列出未解决问题
	public ProblemMesList getSolveProblemMes() {
		
		String orderSelectSql="select * from younger_pro_info where pro_isend=0 order by pro_visitnumber desc";
		ProblemMesList proList=new ProblemMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ProblemMes temp=new ProblemMes();
				temp.setProId(Integer.toString(resultSet.getInt("pro_id")));
				temp.setProTitle(resultSet.getString("pro_title"));
				temp.setProContent(resultSet.getString("pro_content"));
				temp.setProKindOf(resultSet.getString("pro_kindof"));
				temp.setProPublisher(resultSet.getString("pro_publisher"));
				temp.setProPublishDate(resultSet.getString("pro_publishdate"));
				temp.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				temp.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				temp.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
				proList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proList;
	}
	
	//列出已解决问题根据提问者ID
	public ProblemMesList getSolvedProblemMesByID(String userId) {

		String publisher=getUserMes(userId).getUserName();
		String orderSelectSql="select * from younger_pro_info where pro_isend=1 and pro_publisher="+"'"+publisher+"'"+" order by pro_visitnumber desc";
		ProblemMesList proList=new ProblemMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ProblemMes temp=new ProblemMes();
				temp.setProId(Integer.toString(resultSet.getInt("pro_id")));
				temp.setProTitle(resultSet.getString("pro_title"));
				temp.setProContent(resultSet.getString("pro_content"));
				temp.setProKindOf(resultSet.getString("pro_kindof"));
				temp.setProPublisher(resultSet.getString("pro_publisher"));
				temp.setProPublishDate(resultSet.getString("pro_publishdate"));
				temp.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				temp.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				temp.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
				proList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proList;
	} 
	
	//列出已解决问题
	public ProblemMesList getSolvedProblemMes(){
		
		String orderSelectSql="select * from younger_pro_info where pro_isend=1 order by pro_visitnumber desc";
		ProblemMesList proList=new ProblemMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ProblemMes temp=new ProblemMes();
				temp.setProId(Integer.toString(resultSet.getInt("pro_id")));
				temp.setProTitle(resultSet.getString("pro_title"));
				temp.setProContent(resultSet.getString("pro_content"));
				temp.setProKindOf(resultSet.getString("pro_kindof"));
				temp.setProPublisher(resultSet.getString("pro_publisher"));
				temp.setProPublishDate(resultSet.getString("pro_publishdate"));
				temp.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				temp.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				temp.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
				proList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proList;
	}

	//列出制定类型的问题按访问量大小
	public ProblemMesList getKindOfProblemMes(String kind){
		
		ProblemMesList proList=new ProblemMesList();
		String orderSelectSql="select * from younger_pro_info where pro_kindof="+"'"+kind+"'"+" order by pro_visitnumber";
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(orderSelectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ProblemMes temp=new ProblemMes();
				temp.setProId(Integer.toString(resultSet.getInt("pro_id")));
				temp.setProTitle(resultSet.getString("pro_title"));
				temp.setProContent(resultSet.getString("pro_content"));
				temp.setProKindOf(resultSet.getString("pro_kindof"));
				temp.setProPublisher(resultSet.getString("pro_publisher"));
				temp.setProPublishDate(resultSet.getString("pro_publishdate"));
				temp.setProBestAnsId(Integer.toString(resultSet.getInt("pro_bestans")));
				temp.setEnd(resultSet.getInt("pro_isend")==1?true:false);
				temp.setProVisitNumber(resultSet.getInt("pro_visitnumber"));
				proList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return proList;
	}
	
	/*********************************************************************/

	// 回答问题功能：把答案存入数据库
	// 返回值:答案的ID
	public String insertAnswerMes(AnswerMes ansMes) {

		String insertSql="insert younger_ans_info(ans_toproid,ans_pername,ans_content) values(?,?,?)";
		String ansId="";
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(insertSql);
			preparedSm.setInt(1,Integer.parseInt(ansMes.getAnsToProId()));
			preparedSm.setString(2,ansMes.getAnsPersonname());
			preparedSm.setString(3,ansMes.getAnsContent());
			preparedSm.execute();
			
			
			String selectSql="select ans_id from younger_ans_info where ans_content="+"'"+ansMes.getAnsContent()+"'"+" and ans_toproid="+ansMes.getAnsToProId();
			PreparedStatement preparedSm2=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm2.executeQuery();
			while(resultSet.next()){
				ansId=Integer.toString(resultSet.getInt("ans_id"));
			}
			preparedSm.close();
			resultSet.close();
			preparedSm2.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ansId;

	}
	
	//根据答案ID获得答案的具体信息
	public AnswerMes getAnswerMes(String ansId){
		
		String selectSql="select * from younger_ans_info where ans_id="+ansId;
		AnswerMes ansMes=new AnswerMes();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				ansMes.setAnsId(Integer.toString(resultSet.getInt("ans_id")));
				ansMes.setAnsToProId(Integer.toString(resultSet.getInt("ans_toproid")));
				ansMes.setAnsContent(resultSet.getString("ans_content"));
				ansMes.setAnsPersonname(resultSet.getString("ans_pername"));
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ansMes;
		
	}
	//获得指定用户Id的所有答案
	public AnswerMesList getAnswerMesListToUserId(String userId){
		String userName=getUserMes(userId).getUserName();
		String selectSql="select * from younger_ans_info where ans_pername="+"'"+userName+"'";
		AnswerMesList ansList=new AnswerMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				AnswerMes temp=new AnswerMes();
				temp.setAnsId(Integer.toString(resultSet.getInt("ans_id")));
				temp.setAnsToProId(Integer.toString(resultSet.getInt("ans_toproid")));
				temp.setAnsContent(resultSet.getString("ans_content"));
				temp.setAnsPersonname(resultSet.getString("ans_pername"));
				ansList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ansList;
		
	}
	
	//获得指定问题ID的所有答案
	public AnswerMesList getAnswerListToProId(String proId){
		
		String selectSql="select * from younger_ans_info where ans_toproid="+proId;
		AnswerMesList ansList=new AnswerMesList();
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				AnswerMes temp=new AnswerMes();
				temp.setAnsId(Integer.toString(resultSet.getInt("ans_id")));
				temp.setAnsToProId(Integer.toString(resultSet.getInt("ans_toproid")));
				temp.setAnsContent(resultSet.getString("ans_content"));
				temp.setAnsPersonname(resultSet.getString("ans_pername"));
				ansList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ansList;
	}
	
	/*********************************************************************/
	
	//发表评论：将评论数据存入数据库
	//返回值：评论ID
	public String insertAnswerCommentMes(AnswerCommentMes ansCommentMes){
		
		String insertSql="insert younger_ans_comment(comment_content,comment_ans_id,comment_publisher_id) values(?,?,?)";
		String commentId="";
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(insertSql);
			preparedSm.setString(1, ansCommentMes.getCommentContent());
			preparedSm.setInt(2, Integer.parseInt(ansCommentMes.getCommentAnsId()));
			preparedSm.setInt(3,Integer.parseInt(ansCommentMes.getCommentPublishId()));
			preparedSm.execute();
			
			
			String selectSql="select comment_id from younger_ans_comment where comment_content="+"'"+ansCommentMes.getCommentContent()+"'"+
																		 " and comment_ans_id="+ansCommentMes.getCommentAnsId()+
																		 " and comment_publisher_id="+ansCommentMes.getCommentPublishId();
			PreparedStatement preparedSm2=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm2.executeQuery();
			while(resultSet.next()){
				commentId=Integer.toString(resultSet.getInt("comment_id"));
			}
			preparedSm.close();
			resultSet.close();
			preparedSm2.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return commentId;
		
	}
	
	//根据用户ID获得该用户发布的所有评论
	public AnswerCommentMesList getCommentToOtherListByID(String userId){
		
		AnswerCommentMesList commentList=new AnswerCommentMesList();
		String selectSql="select * from younger_ans_comment where comment_publisher_id="+userId;
		try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				AnswerCommentMes temp=new AnswerCommentMes();
				temp.setCommentId(Integer.toString(resultSet.getInt("comment_id")));
				temp.setCommentContent(resultSet.getString("comment_content"));
				temp.setCommentAnsId(Integer.toString(resultSet.getInt("comment_ans_id")));
				temp.setCommentPublishId(Integer.toString(resultSet.getInt("comment_publisher_id")));
				
				commentList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return commentList;
		
	}
	
	//根据用户ID获得用户的答案的所有评论
    public AnswerCommentMesList getCommentToSelfListByID(String userId){
		
    	AnswerCommentMesList commentList=new AnswerCommentMesList();
    	String userName=getUserMes(userId).getUserName();
    	String selectSql="select * from younger_ans_comment";
    	try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				if(getAnswerMes(Integer.toString(resultSet.getInt("comment_ans_id"))).getAnsPersonname().equals(userName)){
					AnswerCommentMes temp=new AnswerCommentMes();
					temp.setCommentId(Integer.toString(resultSet.getInt("comment_id")));
					temp.setCommentContent(resultSet.getString("comment_content"));
					temp.setCommentAnsId(Integer.toString(resultSet.getInt("comment_ans_id")));
					temp.setCommentPublishId(Integer.toString(resultSet.getInt("comment_publisher_id")));
					
					commentList.append(temp);
				}
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return commentList;
		
	}
    //根据答案ID获得答案后的一系列评论
    public AnswerCommentMesList getCommentByAnsId(String ansId){
 
    	AnswerCommentMesList commentList=new AnswerCommentMesList();
    	String selectSql="select * from younger_ans_comment where comment_ans_id="+ansId;
    	try{
			PreparedStatement preparedSm=dbc.getPreparedStatement(selectSql);
			ResultSet resultSet=preparedSm.executeQuery();
			while(resultSet.next()){
				AnswerCommentMes temp=new AnswerCommentMes();
				temp.setCommentId(Integer.toString(resultSet.getInt("comment_id")));
				temp.setCommentContent(resultSet.getString("comment_content"));
				temp.setCommentAnsId(Integer.toString(resultSet.getInt("comment_ans_id")));
				temp.setCommentPublishId(Integer.toString(resultSet.getInt("comment_publisher_id")));
				
				commentList.append(temp);
			}
			resultSet.close();
			preparedSm.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return commentList;
    	
    }
	
	/*********************************************************************/
    //删除问题后要求删除问题的所有答案以及所有评论
    //返回值：0表示删除成功
    //		1表示失败
    public int deleteAnsCmtToProId(String proId){
    	
    	String deleteAnsSql="delete from younger_ans_info where ans_toproid="+proId;
    	String selectAnsSql="select ans_id from younger_ans_info where ans_toproid="+proId;
    	String deleteCommentSql="delete from younger_ans_comment where comment_ans_id=?";
    	try{
    		PreparedStatement preparedSm=dbc.getPreparedStatement(selectAnsSql);
    		ResultSet resultSet=preparedSm.executeQuery();
    		while(resultSet.next()){
    			String ansTempId=Integer.toString(resultSet.getInt("ans_id"));
    			PreparedStatement preparedSm2=dbc.getPreparedStatement(deleteCommentSql);
    			preparedSm2.setString(1, ansTempId);
    			preparedSm2.execute();
    			preparedSm2.close();
    		}
    		resultSet.close();
    		preparedSm.close();
    		
    		PreparedStatement preparedSm3=dbc.getPreparedStatement(deleteAnsSql);
			preparedSm3.execute();
			preparedSm3.close();
    		
    		
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    	
    }
    
	// 搜索答案：根据关键字列出所有在数据库中问题标题含有关键字的问题
	public ProblemMesList getProblemMesByKey(String index) {

		ProblemMesList proList = new ProblemMesList();
		TypeList typeList = new TypeList();
		ArrayList<String> type = typeList.getList();
		try{
			
			ResultSet rs = selectTitle(index);
			ResultSetMetaData md = rs.getMetaData();
			int count = md.getColumnCount();
			if (count != 0) {
				setProblemMes(rs, proList);
			}
		
			
			for (int i = 0; i < type.size(); i++) {
				if (index.contains(type.get(i))) {
					rs = selectClass(type.get(i));
					md = rs.getMetaData();
					count = md.getColumnCount();
					if (count != 0) {
						setProblemMes(rs, proList);
					}
				}
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return proList;


	}
	
	// 搜索辅助函数:将问题从资源里面分解
	protected void setProblemMes(ResultSet rs, ProblemMesList proList)
				throws SQLException {
		while (rs.next()) {
				ProblemMes temp = new ProblemMes();
				temp.setProId(Integer.toString(rs.getInt(1)));
				if(problemIsExist(Integer.toString(rs.getInt(1)), proList)==0){
					temp.setProTitle(rs.getString(2));
					temp.setProContent(rs.getString(3));
					temp.setProKindOf(rs.getString(4));
					temp.setProPublisher(rs.getString(5));
					temp.setProPublishDate(rs.getString(6));
					temp.setProVisitNumber(rs.getInt(7));
					temp.setProBestAnsId(Integer.toString(rs.getInt(8)));
					temp.setEnd(rs.getInt(9) == 1);
					proList.append(temp);
				}
		}
	}
	
	
	//辅助函数：根据问题列表，判断该问题是否存在
	//返回值：1表示存在
	//		0表示不存在
	protected int problemIsExist(String proId,ProblemMesList proList){
		
		int isExist=0;
		for(proList.setFirst();proList.isInList();proList.next()){
			if(proList.currValue().getProId().equals(proId)){
				isExist=1;
			}
		}
		return isExist;
	}
	
	//辅助函数: 根据标题完全匹配搜索
	protected ResultSet selectTitle(String index) throws SQLException {
		PreparedStatement ps = null;
		ps = dbc.getPreparedStatement("select * from younger_pro_info where pro_title like ?");
		ps.setString(1, "%" + index + "%");
		ResultSet rs = null;
		rs = ps.executeQuery();
		return rs;
	}

	//辅助函数: 根据预定义的关键字库来搜索
	protected ResultSet selectClass(String index) throws SQLException {
		PreparedStatement ps = null;
		ps = dbc.getPreparedStatement("select * from younger_pro_info where pro_kindof like ?");
		ps.setString(1, "%" + index + "%");
		ResultSet rs = null;
		rs = ps.executeQuery();
		return rs;
	}

	
	//搜索用户：根据关键字列出所有在数据库中用户名中含有关键字的用户
	public UserMesList getUserMesListByKey(String user){
		
		UserMes userMes = null;
		UserMesList userMesList = new UserMesList();
		PreparedStatement ps = null;
		ps = dbc.getPreparedStatement("select * from younger_user_info where user_name like ?");
		try{
			ps.setString(1, "%" + user + "%");
			ResultSet resultSet = null;
			resultSet = ps.executeQuery();
			ResultSetMetaData md = resultSet.getMetaData();
			if (md.getColumnCount() == 0)
				return null;
			else {
				while (resultSet.next()) {
					userMes = new UserMes();
					userMes.setUserId(Integer.toString(resultSet.getInt("user_id")));
					userMes.setUserName(resultSet.getString("user_name"));
					userMes.setDearName(resultSet.getString("user_dearname"));
					userMes.setPassword(resultSet.getString("user_password"));
					userMes.setEmail(resultSet.getString("user_email"));
					userMes.setCellNumber(resultSet.getString("user_cellnumber"));
					userMes.setQqnumber(resultSet.getString("user_qqnumber"));
					userMes.setWorkName(resultSet.getString("user_workname"));
					userMes.setAddress(resultSet.getString("user_address"));
					userMes.setBirthday(resultSet.getString("user_birthday"));
					userMes.setHeadPic(resultSet.getString("user_headpic"));
					userMes.setAdministrator(resultSet.getInt("user_isadmin") == 1 ? true
							: false);
					userMes.setSex(resultSet.getInt("user_sex") == 1 ? true : false);
					userMesList.append(userMes);
				}
			}
			resultSet.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		return userMesList;
		
	}
	
	//根据输入的用户名返回指定的用户信息
	public UserMes getUserMesByKey(String user){
		UserMes userMes = new UserMes();
		PreparedStatement ps = null;
		ps = dbc.getPreparedStatement("select * from younger_user_info where user_name like ?");
		try{
			ps.setString(1, user);
			ResultSet resultSet = null;
			resultSet = ps.executeQuery();
			ResultSetMetaData md = resultSet.getMetaData();
			if (md.getColumnCount() == 0)
				return null;
			else {
				while(resultSet.next()){
					userMes.setUserId(Integer.toString(resultSet.getInt("user_id")));
					userMes.setUserName(resultSet.getString("user_name"));
					userMes.setDearName(resultSet.getString("user_dearname"));
					userMes.setPassword(resultSet.getString("user_password"));
					userMes.setEmail(resultSet.getString("user_email"));
					userMes.setCellNumber(resultSet.getString("user_cellnumber"));
					userMes.setQqnumber(resultSet.getString("user_qqnumber"));
					userMes.setWorkName(resultSet.getString("user_workname"));
					userMes.setAddress(resultSet.getString("user_address"));
					userMes.setBirthday(resultSet.getString("user_birthday"));
					userMes.setHeadPic(resultSet.getString("user_headpic"));
					userMes.setAdministrator(resultSet.getInt("user_isadmin") == 1 ? true
						: false);
					userMes.setSex(resultSet.getInt("user_sex") == 1 ? true : false);
				}
			}
			resultSet.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userMes;
	}
}
