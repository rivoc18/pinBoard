package pobj.pinboard.editor.tools;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import pobj.pinboard.document.Clip;
import pobj.pinboard.editor.EditorInterface;

public class ToolSelection implements Tool{
	private double xPress;
	private double yPress;
	@Override
	public void press(EditorInterface i, MouseEvent e) {
		xPress=e.getX();
		yPress=e.getY();
			if(e.isShiftDown()) {
				i.getSelection().toogleSelect(i.getBoard(), e.getX(), e.getY());
			}
			else {
				i.getSelection().select(i.getBoard(), e.getX(), e.getY());
				
			}
		
		
	}

	@Override
	public void drag(EditorInterface i, MouseEvent e) {



			for ( Clip c : i.getSelection().getContents()) {
				c.move(e.getX()-xPress, e.getY()-yPress);
			}
			xPress=e.getX();
			yPress=e.getY();

	}

	@Override
	public void release(EditorInterface i, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFeedback(EditorInterface i, GraphicsContext gc) {
		// TODO Auto-generated method stub
		i.getSelection().drawFeedback(gc);
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
