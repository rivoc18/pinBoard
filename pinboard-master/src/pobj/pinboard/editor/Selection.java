package pobj.pinboard.editor;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import pobj.pinboard.document.Board;
import pobj.pinboard.document.Clip;

public class Selection {
	List<Clip> liste;
	
	
	public Selection() {
		this.liste = new ArrayList<Clip>();
	}
	public void select(Board board,double x, double y) {
		liste.clear();
		for ( Clip c : board.getContents()) {
			if(c.isSelected(x, y)) {
				System.out.println(board.getContents().size());
				liste.add(c);
				return ;
			}
		}
		
	}
	public void toogleSelect(Board board, double x, double y) {
		for ( Clip c : board.getContents()) {
			if(c.isSelected(x, y)) {
				if(liste.contains(c))
					liste.remove(c);
				else
					liste.add(c);
			}
		}
	}
	public void clear() {
		liste.clear();
	}
	
	public List<Clip> getContents(){
		return liste;
	}
	
	public void drawFeedback(GraphicsContext gc) {
		double x=liste.get(0).getLeft();
		double y=liste.get(0).getTop();
		double w=liste.get(0).getRight();
		double h=liste.get(0).getBottom();
		
		for ( Clip c : liste) {
			if(c.getLeft()<x) {
				x=c.getLeft();
			}
			if(c.getTop()<y) {
				y=c.getTop();
			}
			if(c.getRight()>w) {
				w=c.getRight();
			}
			if(c.getBottom()>h) {
				h=c.getBottom();
			}
		}
		gc.strokeRect(x, y, w, h);
	}
} 
