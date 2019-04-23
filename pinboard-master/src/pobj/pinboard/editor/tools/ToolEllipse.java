package pobj.pinboard.editor.tools;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pobj.pinboard.document.Clip;
import pobj.pinboard.document.ClipEllipse;
import pobj.pinboard.editor.EditorInterface;

public class ToolEllipse implements Tool{
	
	private Clip ellipse;
	

	@Override
	public void press(EditorInterface i, MouseEvent e) {
		// TODO Auto-generated method stub
		ellipse = new ClipEllipse(e.getX(), e.getY(), e.getX(), e.getY(), Color.RED);
	}

	@Override
	public void drag(EditorInterface i, MouseEvent e) {
		// TODO Auto-generated method stub
		ellipse.setGeometry(ellipse.getLeft(), ellipse.getTop(), e.getX(), e.getY());
	}

	@Override
	public void release(EditorInterface i, MouseEvent e) {
		// TODO Auto-generated method stub
		i.getBoard().addClip(ellipse);
	}

	@Override
	public void drawFeedback(EditorInterface i, GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.strokeOval(ellipse.getLeft(), ellipse.getTop(), ellipse.getRight(), ellipse.getBottom());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ellipse.toString();
	}

}
