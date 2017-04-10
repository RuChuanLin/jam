package _02_transaction.model;

import java.util.List;

import _01_member.model.Member;

public interface UsedItemDAO {
	// 新增二手資料
	public int saveItem(UsedItem uim);

	// 新增二手資料-圖片
	public int savePic(UsedItemPic uip);

	// 獲得剛剛新增的itemId
	public int getNewId(int seller);

	// 獲得搜尋後的總頁數和資料數
	public long[] getAllpage(String key);

	// 獲得搜尋後的該頁全部資料(不搜尋則key值給"")
	public List<UsedItem> getAllItem(String key, int page);

	// 獲得每個的第一張圖片(封面)
	public String getFirstPic(int itemId);

	// 獲得該筆的所有資料
	public UsedItem getItem(int itemId);

	// 獲得該筆的所有圖片資料
	public List<UsedItemPic> getAllPic(int itemId);

	// 由賣家ID取得帳號&暱稱
	public String[] getName(int seller);

	// 修改物品資料
	public int updateItem(UsedItem uim);

	// 修改物品資料-圖片
	public int updatePic(int itemId, String[] pic);

	// 物品交易成功or下架
	public int offItem(int itemId, byte onSale);

	// 新增出價紀錄
	public int newBid(BidRecord br);

	// 取消出價
	public int cancelBid(int itemId, int bidder);

	// 獲得出價紀錄
	public List<BidRecord> getBid(int itemId);

	// 確認買家
	public void confirmBid(int itemId, int bidder);

	// 設定出價狀態
	public void setBidStatus(int itemId, int status);

}
