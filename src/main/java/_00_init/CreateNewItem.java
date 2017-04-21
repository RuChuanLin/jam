package _00_init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _02_transaction.model.NewItem;
import _02_transaction.model.NewItemDAO;
import _02_transaction.model.NewItemHBN;
import _02_transaction.model.NewItemPic;
import _02_transaction.model.UsedItemDAO;
import _02_transaction.model.UsedItemHBN;

public class CreateNewItem {

	public static void main(String[] args) throws IOException {
		List<String> pics_temp = new ArrayList<>();
		NewItemDAO nDao = new NewItemHBN();

		nDao.saveNewItem(new NewItem("guitar", "fender", 16780, "FENDER CD-60CE 全桃花木 可插電民謠吉他", "CD-60CE", (byte) 0, 10, 0, ""));
		int itemId = nDao.getNewId();
		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/" + "01.jpg"));
		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/" + "02.jpg"));
		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/" + "03.jpg"));
		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/" + "04.jpg"));
		//pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/吉他類 帳號aaaa@1111/" + "5.jpg"));

//		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/吉他類 帳號aaaa@1111/" + "Palir3.webp"));

		for (String s : pics_temp) {
			nDao.saveNewPic(new NewItemPic(itemId, s));
		}
		pics_temp.clear();

//		nDao.saveNewItem(new NewItem("guitar", "fender", 29000, "yy Guitar", "eletronic", (byte) 0, 10, 0, ""));
//		itemId = nDao.getNewId();
//		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/吉他類 帳號aaaa@1111/" + "Palir5.webp"));
//
//		pics_temp.add(GetImageStr("C:/Users/admin/Desktop/假資料圖檔/吉他類 帳號aaaa@1111/" + "Palir3.webp"));
//
//		for (String s : pics_temp) {
//			nDao.saveNewPic(new NewItemPic(itemId, s));
//		}
//		pics_temp.clear();

	}

	public static String GetImageStr(String imgFilePath) throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		File file = new File(imgFilePath);
		InputStream is = new FileInputStream(file);
		// 沒問題
		// File file = new File(request.getRequestURL()+"/_996_image/pic.png");
		// InputStream is = new FileInputStream(file);
		long length = is.available();
		;
		byte[] bytes = new byte[(int) length];
		int out = 0;
		int num = 0;
		while (out < bytes.length && (num = is.read(bytes, out, bytes.length - out)) >= 0) {
			out += num;
		}
		is.close();
		byte[] picb64 = Base64.encodeBase64(bytes);

		String pic = new String(picb64);
		pic = "data:image/png;base64," + pic;
		// }
		return pic;// 返回Base64编码过的字节数组字符串
	}

}
