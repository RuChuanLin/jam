package _04_band.model;

import java.util.List;

public interface BandDAO {
	//新增樂團徵人資料
	public int saveBand(Band band);
	//獲得搜尋後的總頁數和資料數(不搜尋則key值給"")
	public long[] getAllpage(String key);
	//獲得搜尋後的該頁全部資料(不搜尋則key值給"")
	public List<Band> getAllItem(String key,int page);
	//獲得該筆的所有資料
	public Band getItem(int bandId);
	//修改徵人資料
	public int updateBand(Band band);
	//關閉徵人資訊
	public int offBand(int courseId);
	
	
	
	
}
