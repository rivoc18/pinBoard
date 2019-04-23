package pobj.pinboard.document;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ClipRect extends AbstractClip implements Clip {
	
	public ClipRect(double left, double top, double right, double bottom, Color color) {
		super(left, top, right, bottom, color);
	}

	@Override
	public void draw(GraphicsContext ctx) {
		// TODO Auto-generated method stub
		ctx.setFill(getColor());
		ctx.fillRect(getLeft(),getTop(),getRight(),getBottom());
	}
	
	@Override
	public Clip copy() {
		return new ClipRect(this.getLeft(),this.getTop(),this.getRight(),this.getBottom(),this.getColor());
	}

}
