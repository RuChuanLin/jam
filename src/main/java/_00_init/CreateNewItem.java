package _00_init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
		NewItem ni = new NewItem("guitar", "sony", 65000, "Sony Guitar", "eletronic", (byte) 0, 10, 0, "");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(ni);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		NewItemDAO nDao = new NewItemHBN();
		int itemId = nDao.getNewId();
		String picBase64 = GetImageStr(
				"C:/Users/admin/Documents/_Projects/workspace/Jam/WebContent/images/test/i03.jpg");

		NewItemPic nip = new NewItemPic(itemId, picBase64);
		nDao.saveNewPic(nip);
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
