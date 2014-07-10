package ISIS.Code.Matriz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * 
 * @author ISIS
 */

public class ImageCache {

	private static ImageCache instance;

	private Map<String, BufferedImage> imageMap = new HashMap<String, BufferedImage>();

	public ImageCache() {
	}

	public static synchronized ImageCache getInstance() {
		if (instance == null) {
			instance = new ImageCache();
		}

		return instance;
	}

	public BufferedImage getImage(String filename) {
		BufferedImage ret = imageMap.get(filename);

		if (ret == null) {
			try {
				ret = ImageIO.read(new File(filename));
				imageMap.put(filename, ret);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

}
