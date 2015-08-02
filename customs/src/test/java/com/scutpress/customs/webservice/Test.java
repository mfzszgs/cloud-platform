package com.scutpress.customs.webservice;

import java.util.List;

import com.scutpress.customs.beans.ChDAO;
import com.scutpress.customs.beans.DocBean;
import com.scutpress.customs.beans.UsersBean;



public class Test {

	public static void main(String args[]) throws Exception {
		ListPrint lp = new ListPrint();
		ChDAO chdao = new ChDAO();

		List<UsersBean> getProId_Name_output = chdao.getProId_Name();
		System.out.println("ChDAO, getProId_Name's output");
		lp.printiUsersBeanList(getProId_Name_output);
		System.out.println("---------------------------");

		List<DocBean> cheGetDocByKCN_output = chdao.cheGetDocByKCN(null, 6, 0);
		System.out.println("ChDAO, cheGetDocByKCN_output");
		lp.printiDocBeanList(cheGetDocByKCN_output);
		System.out.println("---------------------------");

		List<DocBean> getCheckerInfo_output = chdao.getCheckerInfo();
		System.out.println("ChDAO, getCheckerInfo_output");
		lp.printiDocBeanList(getCheckerInfo_output);
		System.out.println("---------------------------");
	}

}
