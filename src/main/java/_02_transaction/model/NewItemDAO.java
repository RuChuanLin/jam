package _02_transaction.model;

import java.util.List;

public interface NewItemDAO {

	// 獲得搜尋後的總頁數和資料數
	public long[] getAllpage(String key);

	// 獲得搜尋後的該頁全部資料(不搜尋則key值給"")
	public List<NewItem> getAllItem(String key, int page);

	// 獲得每個的第一張圖片(封面)
	public String getFirstPic(int itemId);

	// 獲得該筆的所有資料
	public NewItem getItem(int itemId);

	// 獲得該筆的所有圖片資料
	public List<NewItemPic> getAllPic(int itemId);

	// 獲得新增一筆的id
	public int getNewId();

	// 儲存圖片
	public void saveNewPic(NewItemPic nip);

}
