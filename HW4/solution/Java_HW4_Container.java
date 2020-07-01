import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Java_HW4_Container {
	// fields
	public static final Color DEFAULT_BG_COLOR = Color.WHITE;
	public static final Color DEFAULT_BD_COLOR = Color.BLACK;

	private int min_x; // the position of upper-left corner (min_x, min_y)
	private int min_y;
	private int max_x; // the position of lower-right corner (max_x, max_y)
	private int max_y;
	private Color background_color;
	private Color border_color;

	// constructors
	public Java_HW4_Container(int px, int py, int sx, int sy) {
		// given position x, y and size in x, y
		min_x = px;
		min_y = py;
		max_x = px + sx;
		max_y = py + sy;
		background_color = DEFAULT_BG_COLOR;
		border_color = DEFAULT_BD_COLOR;
	}

	public int getMinX() {
		return this.min_x;
	}
	public int getMinY() {
		return this.min_y;
	}
	public int getMaxX() {
		return this.max_x;
	}
	public int getMaxY() {
		return this.max_y;
	}
	
}

