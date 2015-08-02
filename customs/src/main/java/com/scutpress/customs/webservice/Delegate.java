package com.scutpress.customs.webservice;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.scutpress.customs.beans.DocBean;
import com.scutpress.customs.beans.NewsBean;
import com.scutpress.customs.beans.UsersBean;




@WebService
public interface Delegate {

	/**
	 * ChDAO<br>
	 * 获取众包用户的Id和登录名 "select id,loginname from users where userclass=3"
	 * 
	 */
	@WebMethod
	public List<UsersBean> getProId_Name() throws SQLException;

	/**
	 * ChDAO<br>
	 * 通过传来的关键字keyword或classId或nameId(众包人员)，找到含有该关键字的文档并显示出来,此时文档的状态必须为3：校审
	 * 
	 * @param keyword
	 *            basic表中的title包含了keyword
	 * @param classId
	 *            classify表中的ID
	 * @param userId
	 *            用户在user表里的ID
	 */
	@WebMethod
	public LinkedList<DocBean> cheGetDocByKCN(String keyword, int classId, int userId) throws SQLException;

	/**
	 * ChDAO<br>
	 * 查找全部待审核的文档
	 */
	@WebMethod
	public List<DocBean> getCheckerInfo() throws SQLException;

	// DAO
	@WebMethod
	public int userIsExist(String getLoginName);// 判断注册名是否被使用

	@WebMethod
	public boolean addUser(UsersBean ub);// 添加用户

	@WebMethod
	public void addUserDocUrl(int id, String newName);// 添加众包人员的校审材料名

	@WebMethod
	public int checkUserClass(String loginName) throws SQLException;// 通过loginName在数据库中找到对应用户，返回相应用户类别型号

	@WebMethod
	public int checkUserId(String loginName) throws SQLException;// 通过loginName在数据库中找到对应用户，返回相应用户id号

	@WebMethod
	public String checkUserName(int id) throws SQLException;// 通过用户id在数据库中找到对应用户，返回相应用户名

	@WebMethod
	public boolean checkUser(String loginName, String password) throws SQLException;// 检查是否能登录成功

	@WebMethod
	public List<String> getDocClass(int i) throws SQLException;// 拿到数据库里档案的种类返回String型的列表

	@WebMethod
	public List<String> getUserClass(int i) throws SQLException;// 拿到数据库里用户的种类,返回String型的列表,若i=0，则返回所有种类

	@WebMethod
	public void updateDocByDAO(int id, String title, int classId) throws SQLException;

	@WebMethod
	public void updateUserClass(int id, String className) throws SQLException;// 改变对应用户类别的名字

	@WebMethod
	public void updateUserAuth(int id) throws SQLException;// 改变对应众包人员的授权状态,默认是0，若通过审核，将状态改为1

	@WebMethod
	public void updateUserDocUrl(int id) throws SQLException;// 改变对应众包人员的上传的文档名

	@WebMethod
	public void updateDocClass(int id, String className) throws SQLException;// 改变对应档案类别的名字

	@WebMethod
	public boolean addDocOne(String title, int classId, String loginName, String newName) throws SQLException;// 针对录入人员：将文档的标题、类型

	@WebMethod
	public List<DocBean> getDocByUser(int userid) throws SQLException;// 通过用户id拿到数据库里档案信息返回DocBean型的列表

	@WebMethod
	public List<DocBean> getDoc(int i) throws SQLException;// 拿到数据库里档案信息返回DocBean型的列表,i=0时取所有信息

	@WebMethod
	public List<UsersBean> getUser(int i) throws SQLException;// 拿到数据库里用户信息返回UsersBean型的列表,i=0时取所有信息

	@WebMethod
	public String getDocName(int classId) throws SQLException;// 通过文档类型找类型名

	@WebMethod
	public LinkedList<DocBean> uploadgetDocByKey(String keyword) throws SQLException;// 通过传来的关键字keyword，找到含有该关键字的文档并显示出来

	@WebMethod
	public LinkedList<DocBean> proGetDocByKC(String keyword, int classId) throws SQLException;// 通过传来的关键字keyword或classId，找到含有该关键字的文档并显示出来,此时文档的状态必须为1：可包

	@WebMethod
	public void delFromBasicinfo(int id) throws SQLException;// 删除basicinfo表里的一行数据

	@WebMethod
	public void delFromUser(int id) throws SQLException;// 删除user表里的一行数据

	// EditDAO
	@WebMethod
	public LinkedList<DocBean> editGetDocByKCBT(String keyword, int classId, String builder, String startBt,
			String endBt) throws SQLException;

	@WebMethod
	public List<DocBean> getEditorInfo() throws SQLException;

	// ManagerDAO
	@WebMethod
	public List<UsersBean> getProcesserUsers() throws SQLException;

	@WebMethod
	public List<UsersBean> getManagerUsers() throws SQLException;

	/**
	 * ProDAO<br>
	 * 修改档案内容
	 */
	@WebMethod
	public void updateAllDoc(int id, String retitle, String keywords, String keypersons, String buildtime,
			String builder, String abstracts, String fulltext, String translatetext) throws SQLException;

	/**
	 * ProDAO<br>
	 * ??ChDAO 根据档案ID修改针对不通过的档案的建议
	 */
	@WebMethod
	public void updateDocSuggestion(int id, String suggestion)
			throws SQLException;/* 通过文档id 设置用户id和文档状态 */

	/**
	 * 
	 * ProDAO ?? ChDAO 通过文档id将文档状态改变
	 * 
	 * @param id
	 *            the id in table basicinfo
	 * @param x
	 *            原本的state
	 * @param y
	 *            修改后的state
	 */
	@WebMethod
	public boolean statexToy(int id, int x, int y) throws SQLException;

	/**
	 * ProDAO 通过文档id 设置用户id和文档状态为已接包
	 * 
	 * @param id
	 *            文档id
	 * @param uid
	 *            用户id
	 * @throws SQLException
	 */
	@WebMethod
	public void updateDocByProDAO(int id, int uid)
			throws SQLException;/* 通过文档id 设置用户id和文档状态 */

	@WebMethod
	public List<String> getDocState(int i) throws SQLException;// 拿到数据库里档案的状态id，返回String型的列表

	@WebMethod
	public LinkedList<DocBean> proGetDocByKS(String keyword, int stateId, int uid) throws SQLException;// 通过keyword和文档状态，查找指定用户的文档

	@WebMethod
	public void delFromProFile(int id)
			throws SQLException;/* 通过文档id修改文档状态：从被包改成可包 */

	@WebMethod
	public List<DocBean> getProcesserInfo() throws SQLException;

	@WebMethod
	public List<DocBean> getProFileInfo(int uid) throws SQLException;

	// PubDAO
	@WebMethod
	public List<String> getNewCol(int i) throws SQLException;// 拿到数据库里新闻的栏目返回String型的列表，i=0时返回所有栏目

	@WebMethod
	public LinkedList<NewsBean> pubGetNewsByKC(String keyword, int columnId) throws SQLException;// 通过传来的关键字keyword或columnId，找到含有该关键字的文档并显示出来

	@WebMethod
	public boolean addNews(String title, int authorId, String keywords, String inputDate, int columnId, String fullText)
			throws SQLException;// 针对新闻人员：添加一则新闻

	@WebMethod
	public void editNews(int id, String title, String keywords, int columnId, String fullText) throws SQLException;// 修改一则新闻

	@WebMethod
	public List<NewsBean> getNews(int i) throws SQLException;// 通过新闻id拿到数据库里新闻信息返回NewsBean型的列表,i=0时取所有信息

	@WebMethod
	public List<String> getNewsClass(int i) throws SQLException;// 拿到数据库里新闻的种类返回String型的列表

	@WebMethod
	public void updateNewsClass(int id, String className) throws SQLException;// 改变对应档案类别的名字

	@WebMethod
	public void delFromNews(int id) throws SQLException;// 删除news表里的一行数据

	@WebMethod
	public List<NewsBean> getPublisherInfo(int uid) throws SQLException;

	@WebMethod
	public List<DocBean> getPubNewInfo() throws SQLException;

	/**
	 * UploaderDAO <br>
	 * "select * from basicinfo order by InputDate desc" <br>
	 * 获取全部档案信息，并根据输入时间排序
	 */
	@WebMethod
	public List<DocBean> getUploaderInfo() throws SQLException;

}
