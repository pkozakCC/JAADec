package net.sourceforge.jaad.mp4.boxes.impl.oma;

import java.io.IOException;
import net.sourceforge.jaad.mp4.MP4InputStream;
import net.sourceforge.jaad.mp4.boxes.FullBox;

/**
 * This box is used for several sub-boxes of the user-data box in an OMA DRM 
 * file. These boxes have in common, that they only contain one String.
 * 
 * @author in-somnia
 */
public class OMAURLBox extends FullBox {

	private String content;

	public OMAURLBox(String name) {
		super(name);
	}

	@Override
	public void decode(MP4InputStream in) throws IOException {
		super.decode(in);

		content = in.readUTFString((int) left, MP4InputStream.UTF8);
		left = 0;
	}

	/**
	 * Returns the String that this box contains. Its meaning depends on the 
	 * type of this box.
	 * 
	 * @return the content of this box
	 */
	public String getContent() {
		return content;
	}
}
