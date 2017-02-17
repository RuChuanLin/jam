package _01_member.controller;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import _01_member.model.Member;

public interface RegisterServiceInterface {


	// 搜尋所有用戶名
	List<String> memberIDList = new ArrayList<String>();

	void allIDList();

	//檢查用戶是否已存在
	public boolean idExists(String account) throws IOException;
	
	// 檢查密碼是否正確
	public boolean checkPassword(String account, String password);

//	搜尋該會員的所有資料
	public Member findUserData(String account);
	
	char[] clobToCharArray(Clob clob);
	
//	//儲存註冊帳號資料
//	public void saveRegisterMember(RegisterMemberBean mem) throws SQLException;

	//儲存修改的會員資料
	public void updateMember(Member mem);


}
