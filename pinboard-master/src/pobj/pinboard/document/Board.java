package pobj.pinboard.document;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board{
	
	List<Clip> l;
	
	public Board(){
		l=new ArrayList<Clip>();
	}
	
	public List<Clip> getContents() {
		return l;
	}

	public void addClip(Clip c1) {
		l.add(c1);
	}

	public void addClip(List<Clip> asList) {
		for(Clip c:asList) {
			l.add(c);
		}
	}	
	
	public void removeClip(Clip c1) {
		l.remove(c1);
		
	}

	public void removeClip(List<Clip> asList) {
		for(Clip c:asList) {
			l.remove(c);
		}
		
	}
	
	public void draw(GraphicsContext gc) {
		ClipRect c = new ClipRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight(), Color.WHITE);
		c.draw(gc);
		
		for(Clip clip : this.l) {
			clip.draw(gc);
		}
	}


	

}
