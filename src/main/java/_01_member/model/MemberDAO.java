package _01_member.model;

import java.util.List;

public interface MemberDAO {
	// 得到所有account的List物件
	public void getAccountList();

	// 儲存註冊帳號資料
	public int saveMember(Member mem);

	// 用id搜尋該會員的所有資料
	public Member getMember(int id);

	// 用帳號檢查id
	public Member getMemberByAccount(String account);

	// 檢查用戶是否已存在
	public boolean idExists(String account);

	// 儲存修改的會員資料
	public int updateMember(Member mem);

	// 刪除會員資料
	public int deleteMember(String pk);

	// 檢查密碼是否正確
	public boolean checkPassword(String account, String password);

	//查詢有幾封新信
	public long newMsg(int userId);
	
	//查詢站內信
	public List<InnerMsg> getMsg(int userId,int start);
	
	

}
