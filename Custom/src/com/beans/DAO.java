package com.beans;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.webservice.ConDele;

public class DAO {// 各种对数据库的操作函数

	public int userIsExist(String getLoginName) {// 判断注册名是否被使用
		return ConDele.getDele().userIsExist(getLoginName);
	}

	public boolean addUser(UsersBean ub) {// 添加用户
		return ConDele.getDele().addUser(ub);
	}

	public void addUserDocUrl(int id, String newName) {// 添加众包人员的校审材料名
		ConDele.getDele().addUserDocUrl(id, newName);
	}

	public int checkUserClass(String loginName) throws SQLException {// 通过loginName在数据库中找到对应用户，返回相应用户类别型号
		return ConDele.getDele().checkUserClass(loginName);
	}

	public int checkUserId(String loginName) throws SQLException {// 通过loginName在数据库中找到对应用户，返回相应用户id号
		return ConDele.getDele().checkUserId(loginName);
	}

	public String checkUserName(int id) throws SQLException {// 通过用户id在数据库中找到对应用户，返回相应用户名
		return ConDele.getDele().checkUserName(id);
	}

	public boolean checkUser(String loginName, String password) throws SQLException {// 检查是否能登录成功
		return ConDele.getDele().checkUser(loginName, password);
	}

	public List<String> getDocClass(int i) throws SQLException {// 拿到数据库里档案的种类返回String型的列表
		return ConDele.getDele().getDocClass(i);
	}

	public List<String> getUserClass(int i) throws SQLException {// 拿到数据库里用户的种类,返回String型的列表,若i=0，则返回所有种类
		return ConDele.getDele().getUserClass(i);
	}

	public void updateDoc(int id, String title, int classId) throws SQLException {
		ConDele.getDele().updateDocByDAO(id, title, classId);
	}

	public void updateUserClass(int id, String className) throws SQLException {// 改变对应用户类别的名字
		ConDele.getDele().updateUserClass(id, className);
	}

	public void updateUserAuth(int id) throws SQLException {// 改变对应众包人员的授权状态,默认是0，若通过审核，将状态改为1
		ConDele.getDele().updateUserAuth(id);
	}

	public void updateUserDocUrl(int id) throws SQLException {// 改变对应众包人员的上传的文档名
		ConDele.getDele().updateUserDocUrl(id);
	}

	public void updateDocClass(int id, String className) throws SQLException {// 改变对应档案类别的名字
		ConDele.getDele().updateDocClass(id, className);
	}

	public boolean addDocOne(String title, int classId, String loginName, String newName) throws SQLException {// 针对录入人员：将文档的标题、类型
		return ConDele.getDele().addDocOne(title, classId, loginName, newName);
		// 、userID写入数据库中，同时将文档的State属性设为0
	}

	public List<DocBean> getDocByUser(int userid) throws SQLException {// 通过用户id拿到数据库里档案信息返回DocBean型的列表
		return ConDele.getDele().getDocByUser(userid);
	}

	public List<DocBean> getDoc(int i) throws SQLException {// 拿到数据库里档案信息返回DocBean型的列表,i=0时取所有信息
		return ConDele.getDele().getDoc(i);
	}

	public List<UsersBean> getUser(int i) throws SQLException {// 拿到数据库里用户信息返回UsersBean型的列表,i=0时取所有信息
		return ConDele.getDele().getUser(i);
	}

	public String getDocName(int classId) throws SQLException {// 通过文档类型找类型名
		return ConDele.getDele().getDocName(classId);
	}

	public LinkedList<DocBean> uploadgetDocByKey(String keyword) throws SQLException {// 通过传来的关键字keyword，找到含有该关键字的文档并显示出来
		return ConDele.getDele().uploadgetDocByKey(keyword);
	}

	public LinkedList<DocBean> proGetDocByKC(String keyword, int classId) throws SQLException {// 通过传来的关键字keyword或classId，找到含有该关键字的文档并显示出来,此时文档的状态必须为1：可包
		return ConDele.getDele().proGetDocByKC(keyword, classId);
	}

	public void delFromBasicinfo(int id) throws SQLException {// 删除basicinfo表里的一行数据
		ConDele.getDele().delFromBasicinfo(id);
	}

	public void delFromUser(int id) throws SQLException {// 删除user表里的一行数据
		ConDele.getDele().delFromUser(id);

	}

}
