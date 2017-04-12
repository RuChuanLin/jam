package _00_init;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class PicSize {
	static double sampleSize = 0.0;
	static int imageWidth = 0;
	static int imageHeight = 0;

	public static String minify(String pic,int picScale) {
		String data = pic.split(",")[0];
		String pb64 = pic.split(",")[1];
		System.out.println("data:" + data);

		byte[] decode = Base64.decodeBase64(pb64);

		ByteArrayInputStream bais = new ByteArrayInputStream(decode);

		try {
			BufferedImage srcBufferedImage = ImageIO.read(bais);
			int type = srcBufferedImage.getType();
			String format = "";
			if (type == BufferedImage.TYPE_4BYTE_ABGR || type == BufferedImage.TYPE_4BYTE_ABGR_PRE
					|| type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_ARGB_PRE) {
				format = "png";
			} else {
				format = "jpg";
			}
			imageWidth = srcBufferedImage.getWidth();
			imageHeight = srcBufferedImage.getHeight();

			int shorter = Math.min(imageWidth, imageHeight);
			sampleSize = (double)shorter/picScale;
			imageWidth = (int) (imageWidth / sampleSize);
			imageHeight = (int) (imageHeight / sampleSize);
			
			BufferedImage scaledBufferedImage = new BufferedImage(imageWidth, imageHeight, type);
			Graphics graphics = scaledBufferedImage.createGraphics();
			graphics.drawImage(srcBufferedImage, 0, 0, imageWidth, imageHeight, null);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(scaledBufferedImage, format, baos);
			decode = baos.toByteArray();
			pb64 = Base64.encodeBase64String(decode);
			pic = data + "," + pb64;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return pic;
	}
}
