package com.scutpress.customs.webservice;

import java.util.Iterator;
import java.util.List;

import com.scutpress.customs.beans.DocBean;
import com.scutpress.customs.beans.NewsBean;
import com.scutpress.customs.beans.UsersBean;



public class ListPrint {
	public void printiUsersBeanList(List<UsersBean> list) {
		Iterator<UsersBean> it = list.iterator();
		while (it.hasNext()) {
			UsersBean t = it.next();
			int tmp;
			String stmp;
			if ((tmp = t.getAuthority()) != 0)
				System.out.print("Authority=" + tmp + ";");
			if ((tmp = t.getId()) != 0)
				System.out.print("Id=" + tmp + ";");
			if ((tmp = t.getSexId()) != 0)
				System.out.print("SexId=" + tmp + ";");
			if ((tmp = t.getUserClass()) != 0)
				System.out.print("UserClass=" + tmp + ";");
			if ((stmp = t.getName()) != null)
				System.out.print("Name=" + stmp + ";");
			if ((stmp = t.getLoginName()) != null)
				System.out.print("LoginName=" + stmp + ";");
			if ((stmp = t.getPassword()) != null)
				System.out.print("Password=" + stmp + ";");
			if ((stmp = t.getAddress()) != null)
				System.out.print("Address=" + stmp + ";");
			if ((stmp = t.getOfficeNumber()) != null)
				System.out.print("OfficeNumber=" + stmp + ";");
			if ((stmp = t.getPhoneNumber()) != null)
				System.out.print("PhoneNumber=" + stmp + ";");
			if ((stmp = t.getPostCode()) != null)
				System.out.print("PostCode=" + stmp + ";");
			if ((stmp = t.getEmail()) != null)
				System.out.print("Email=" + stmp + ";");
			if ((stmp = t.getOrganization()) != null)
				System.out.print("Organization=" + stmp + ";");
			if ((stmp = t.getdocUrl()) != null)
				System.out.print("docUrl=" + stmp + ";");
			System.out.println();
		}
	}

	public void printiNewsBeanList(List<NewsBean> list) {
		Iterator<NewsBean> it = list.iterator();
		while (it.hasNext()) {
			NewsBean t = it.next();
			int tmp;
			String stmp;
			if ((tmp = t.getID()) != 0)
				System.out.print("ID=" + tmp + ";");
			if ((tmp = t.getAuthorId()) != 0)
				System.out.print("AuthorId=" + tmp + ";");
			if ((tmp = t.getPublishId()) != 0)
				System.out.print("PublishId=" + tmp + ";");
			if ((tmp = t.getColumnId()) != 0)
				System.out.print("ColumnId=" + tmp + ";");
			if ((tmp = t.getPictrueId()) != 0)
				System.out.print("PictrueId=" + tmp + ";");
			if ((stmp = t.getTitle()) != null)
				System.out.print("Title=" + stmp + ";");
			if ((stmp = t.getKeyWords()) != null)
				System.out.print("KeyWords=" + stmp + ";");
			if ((stmp = t.getInputDate()) != null)
				System.out.print("InputDate=" + stmp + ";");
			if ((stmp = t.getFullText()) != null)
				System.out.print("FullText=" + stmp + ";");
			System.out.println();
		}
	}

	public void printiDocBeanList(List<DocBean> list) {
		Iterator<DocBean> it = list.iterator();
		while (it.hasNext()) {
			DocBean t = it.next();
			int tmp;
			String stmp;
			if ((tmp = t.getID()) != 0)
				System.out.print("ID=" + tmp + ";");
			if ((tmp = t.getPublishId()) != 0)
				System.out.print("PublishId=" + tmp + ";");
			if ((tmp = t.getCustomsId()) != 0)
				System.out.print("CustomsId=" + tmp + ";");
			if ((tmp = t.getClassId()) != 0)
				System.out.print("ClassId=" + tmp + ";");
			if ((tmp = t.getRawId()) != 0)
				System.out.print("RawId=" + tmp + ";");
			if ((tmp = t.getSize()) != 0)
				System.out.print("Size=" + tmp + ";");
			if ((tmp = t.getDownCount()) != 0)
				System.out.print("DownCount=" + tmp + ";");
			if ((tmp = t.getUserId()) != 0)
				System.out.print("UserId=" + tmp + ";");
			if ((tmp = t.getState()) != 0)
				System.out.print("State=" + tmp + ";");
			if ((stmp = t.getTitle()) != null)
				System.out.print("Title=" + stmp + ";");
			if ((stmp = t.getDocAbstract()) != null)
				System.out.print("DocAbstract=" + stmp + ";");
			if ((stmp = t.getKeyWords()) != null)
				System.out.print("KeyWords=" + stmp + ";");
			if ((stmp = t.getKeyPersons()) != null)
				System.out.print("KeyPersons=" + stmp + ";");
			if ((stmp = t.getBuildTime()) != null)
				System.out.print("BuildTime=" + stmp + ";");
			if ((stmp = t.getFullText()) != null)
				System.out.print("FullText=" + stmp + ";");
			if ((stmp = t.getTranslateText()) != null)
				System.out.print("TranslateText=" + stmp + ";");
			if ((stmp = t.getSuggestion()) != null)
				System.out.print("Suggestion=" + stmp + ";");
			if ((stmp = t.getBuilder()) != null)
				System.out.print("Builder=" + stmp + ";");
			if ((stmp = t.getInputDate()) != null)
				System.out.print("InputDate=" + stmp + ";");
			if ((stmp = t.getRawFormat()) != null)
				System.out.print("RawFormat=" + stmp + ";");
			if ((stmp = t.getRawUrl()) != null)
				System.out.print("RawUrl=" + stmp + ";");
			if ((stmp = t.getReduceUrl()) != null)
				System.out.print("ReduceUrl=" + stmp + ";");
			System.out.println();
		}
	}
}
