package _01_member.model;

import java.util.Collection;


public interface MemberDAO {
	// 得到所有account的List物件
	public void getAccountList();

	// 儲存註冊帳號資料
	public void saveMember(Member mem);

	// 用id/帳號搜尋該會員的所有資料
	public Member getMember(int id);

	public Member getMemberByAccount(String account);
	
	// 用帳號搜尋該會員的Id 暱稱
	public Member getMemberIdAlias(String account);

	// 檢查用戶是否已存在
	public boolean idExists(String account);

	// 儲存修改的會員資料
	public int updateMember(Member mem);

	// 刪除會員資料
	public int deleteMember(String pk);

	// 檢查密碼是否正確
	public boolean checkPassword(String account, String password);

	// 搜尋所有用戶名
	public Collection<Member> getAllMembers();


}
