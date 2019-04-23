package pobj.pinboard.editor.tools;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pobj.pinboard.document.Clip;
import pobj.pinboard.document.ClipRect;
import pobj.pinboard.editor.EditorInterface;

public class ToolRect implements Tool {
	
	private Clip rect;



	@Override
	public void press(EditorInterface i, MouseEvent e) {
		rect = new ClipRect(e.getX(), e.getY(), e.getX(), e.getY(),  Color.RED);
		
		
	}

	@Override
	public void drag(EditorInterface i, MouseEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getX()<rect.getLeft()) {
			if(e.getY()<rect.getTop()) {
				rect.setGeometry(e.getX(), e.getY() ,rect.getLeft(), rect.getTop());
			}
			else {
				rect.setGeometry(rect.getLeft(),e.getY() , e.getX(), rect.getTop());
			}
		}
		else {*/
			rect.setGeometry(rect.getLeft(), rect.getTop(), e.getX(), e.getY());
		//}
	}

	@Override
	public void release(EditorInterface i, MouseEvent e) {
		// TODO Auto-generated method stub
		i.getBoard().addClip(rect);
		
	}

	@Override
	public void drawFeedback(EditorInterface i, GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.strokeRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return rect.toString();
	}

}
