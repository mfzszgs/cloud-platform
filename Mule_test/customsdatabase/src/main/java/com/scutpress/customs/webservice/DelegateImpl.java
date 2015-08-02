package com.scutpress.customs.webservice;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import com.scutpress.customs.beans.DocBean;
import com.scutpress.customs.beans.NewsBean;
import com.scutpress.customs.beans.UsersBean;



@WebService(endpointInterface = "com.webservice.Delegate")
public class DelegateImpl implements Delegate {
	// ChDAO
	@Override
	public List<UsersBean> getProId_Name() throws SQLException {// 拿到众包用户的名称列表
		return new ChDAO().getProId_Name();
	}

	@Override
	public LinkedList<DocBean> cheGetDocByKCN(String keyword, int classId,
			int userId) throws SQLException {// 通过传来的关键字keyword或classId或nameId(众包人员)，找到含有该关键字的文档并显示出来,此时文档的状态必须为3：校审
		return new ChDAO().cheGetDocByKCN(keyword, classId, userId);
	}

	@Override
	public List<DocBean> getCheckerInfo() throws SQLException {
		return new ChDAO().getCheckerInfo();
	}

	// DAO
	@Override
	public int userIsExist(String getLoginName) {// 判断注册名是否被使用
		return new DAO().userIsExist(getLoginName);
	}

	@Override
	public boolean addUser(UsersBean ub) {// 添加用户
		return new DAO().addUser(ub);
	}

	@Override
	public void addUserDocUrl(int id, String newName) {// 添加众包人员的校审材料名
		new DAO().addUserDocUrl(id, newName);
	}

	@Override
	public int checkUserClass(String loginName) throws SQLException {// 通过loginName在数据库中找到对应用户，返回相应用户类别型号
		return new DAO().checkUserClass(loginName);
	}

	@Override
	public int checkUserId(String loginName) throws SQLException {// 通过loginName在数据库中找到对应用户，返回相应用户id号
		return new DAO().checkUserId(loginName);
	}

	@Override
	public String checkUserName(int id) throws SQLException {// 通过用户id在数据库中找到对应用户，返回相应用户名
		return new DAO().checkUserName(id);
	}

	@Override
	public boolean checkUser(String loginName, String password)
			throws SQLException {// 检查是否能登录成功
		return new DAO().checkUser(loginName, password);
	}

	@Override
	public List<String> getDocClass(int i) throws SQLException {// 拿到数据库里档案的种类返回String型的列表
		return new DAO().getDocClass(i);
	}

	@Override
	public List<String> getUserClass(int i) throws SQLException {// 拿到数据库里用户的种类,返回String型的列表,若i=0，则返回所有种类
		return new DAO().getUserClass(i);
	}

	@Override
	public void updateDocByDAO(int id, String title, int classId)
			throws SQLException {
		new DAO().updateDoc(id, title, classId);
	}

	@Override
	public void updateUserClass(int id, String className) throws SQLException {// 改变对应用户类别的名字
		new DAO().updateUserClass(id, className);
	}

	@Override
	public void updateUserAuth(int id) throws SQLException {// 改变对应众包人员的授权状态,默认是0，若通过审核，将状态改为1
		new DAO().updateUserAuth(id);
	}

	@Override
	public void updateUserDocUrl(int id) throws SQLException {// 改变对应众包人员的上传的文档名
		new DAO().updateUserDocUrl(id);
	}

	@Override
	public void updateDocClass(int id, String className) throws SQLException {// 改变对应档案类别的名字
		new DAO().updateDocClass(id, className);
	}

	@Override
	public boolean addDocOne(String title, int classId, String loginName,
			String newName) throws SQLException {// 针对录入人员：将文档的标题、类型
		return new DAO().addDocOne(title, classId, loginName, newName);
	}

	@Override
	public List<DocBean> getDocByUser(int userid) throws SQLException {// 通过用户id拿到数据库里档案信息返回DocBean型的列表
		return new DAO().getDocByUser(userid);
	}

	@Override
	public List<DocBean> getDoc(int i) throws SQLException {// 拿到数据库里档案信息返回DocBean型的列表,i=0时取所有信息
		return new DAO().getDoc(i);
	}

	@Override
	public List<UsersBean> getUser(int i) throws SQLException {// 拿到数据库里用户信息返回UsersBean型的列表,i=0时取所有信息
		return new DAO().getUser(i);
	}

	@Override
	public String getDocName(int classId) throws SQLException {// 通过文档类型找类型名
		return new DAO().getDocName(classId);
	}

	@Override
	public LinkedList<DocBean> uploadgetDocByKey(String keyword)
			throws SQLException {// 通过传来的关键字keyword，找到含有该关键字的文档并显示出来
		return new DAO().uploadgetDocByKey(keyword);
	}

	@Override
	public LinkedList<DocBean> proGetDocByKC(String keyword, int classId)
			throws SQLException {// 通过传来的关键字keyword或classId，找到含有该关键字的文档并显示出来,此时文档的状态必须为1：可包
		return new DAO().proGetDocByKC(keyword, classId);
	}

	@Override
	public void delFromBasicinfo(int id) throws SQLException {// 删除basicinfo表里的一行数据
		new DAO().delFromBasicinfo(id);
	}

	@Override
	public void delFromUser(int id) throws SQLException {// 删除user表里的一行数据
		new DAO().delFromUser(id);
	}

	// EditDAO
	@Override
	public LinkedList<DocBean> editGetDocByKCBT(String keyword, int classId,
			String builder, String startBt, String endBt) throws SQLException {
		return new EditDAO().editGetDocByKCBT(keyword, classId, builder,
				startBt, endBt);
	}

	@Override
	public List<DocBean> getEditorInfo() throws SQLException {
		return new EditDAO().getEditorInfo();
	}

	// ManagerDAO
	@Override
	public List<UsersBean> getProcesserUsers() throws SQLException {
		return new ManageDAO().getProcesserUsers();
	}

	@Override
	public List<UsersBean> getManagerUsers() throws SQLException {
		return new ManageDAO().getManagerUsers();
	}

	// ProDAO
	@Override
	public void updateAllDoc(int id, String retitle, String keywords,
			String keypersons, String buildtime, String builder,
			String abstracts, String fulltext, String translatetext)
			throws SQLException {// 众包人员补全文档信息
		new ProDAO().updateAllDoc(id, retitle, keywords, keypersons, buildtime,
				builder, abstracts, fulltext, translatetext);
	}

	@Override
	public void updateDocSuggestion(int id, String suggestion)
			throws SQLException {/* 通过文档id 设置用户id和文档状态 */
		new ProDAO().updateDocSuggestion(id, suggestion);
	}

	@Override
	public boolean statexToy(int id, int x, int y) throws SQLException {/* 通过文档id将文档状态改为校审 */
		return new ProDAO().statexToy(id, x, y);
	}

	@Override
	public void updateDocByProDAO(int id, int uid) throws SQLException {/*
																		 * 通过文档id
																		 * 设置用户id和文档状态
																		 */
		new ProDAO().updateDoc(id, uid);
	}

	@Override
	public List<String> getDocState(int i) throws SQLException {// 拿到数据库里档案的状态id，返回String型的列表
		return new ProDAO().getDocState(i);
	}

	@Override
	public LinkedList<DocBean> proGetDocByKS(String keyword, int stateId,
			int uid) throws SQLException {// 通过keyword和文档状态，查找指定用户的文档
		return new ProDAO().proGetDocByKS(keyword, stateId, uid);
	}

	@Override
	public void delFromProFile(int id) throws SQLException {/*
															 * 通过文档id修改文档状态：从被包改成可包
															 */
		new ProDAO().delFromProFile(id);
	}

	@Override
	public List<DocBean> getProcesserInfo() throws SQLException {
		return new ProDAO().getProcesserInfo();
	}

	@Override
	public List<DocBean> getProFileInfo(int uid) throws SQLException {
		return new ProDAO().getProFileInfo(uid);
	}

	// PubDAO
	@Override
	public List<String> getNewCol(int i) throws SQLException {// 拿到数据库里新闻的栏目返回String型的列表，i=0时返回所有栏目
		return new PubDAO().getNewCol(i);
	}

	@Override
	public LinkedList<NewsBean> pubGetNewsByKC(String keyword, int columnId)
			throws SQLException {// 通过传来的关键字keyword或columnId，找到含有该关键字的文档并显示出来
		return new PubDAO().pubGetNewsByKC(keyword, columnId);
	}

	@Override
	public boolean addNews(String title, int authorId, String keywords,
			String inputDate, int columnId, String fullText)
			throws SQLException {// 针对新闻人员：添加一则新闻
		return new PubDAO().addNews(title, authorId, keywords, inputDate,
				columnId, fullText);
	}

	@Override
	public void editNews(int id, String title, String keywords, int columnId,
			String fullText) throws SQLException {// 修改一则新闻
		new PubDAO().editNews(id, title, keywords, columnId, fullText);
	}

	@Override
	public List<NewsBean> getNews(int i) throws SQLException {// 通过新闻id拿到数据库里新闻信息返回NewsBean型的列表,i=0时取所有信息
		return new PubDAO().getNews(i);
	}

	@Override
	public List<String> getNewsClass(int i) throws SQLException {// 拿到数据库里新闻的种类返回String型的列表
		return new PubDAO().getNewsClass(i);
	}

	@Override
	public void updateNewsClass(int id, String className) throws SQLException {// 改变对应档案类别的名字
		new PubDAO().updateNewsClass(id, className);
	}

	@Override
	public void delFromNews(int id) throws SQLException {// 删除news表里的一行数据
		new PubDAO().delFromNews(id);
	}

	@Override
	public List<NewsBean> getPublisherInfo(int uid) throws SQLException {
		return new PubDAO().getPublisherInfo(uid);
	}

	@Override
	public List<DocBean> getPubNewInfo() throws SQLException {
		return new PubDAO().getPubNewInfo();
	}

	// UploaderDAO
	@Override
	public List<DocBean> getUploaderInfo() throws SQLException {
		return new UploaderDAO().getUploaderInfo();
	}
}
