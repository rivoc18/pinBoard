package pobj.pinboard.editor;


import pobj.pinboard.document.Board;
import pobj.pinboard.document.Clip;
import pobj.pinboard.editor.tools.Tool;
import pobj.pinboard.editor.tools.ToolEllipse;
import pobj.pinboard.editor.tools.ToolRect;
import pobj.pinboard.editor.tools.ToolSelection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class EditorWindow implements EditorInterface,ClipboardListener {
	
	private Tool tool = new ToolRect();
	private Board board;
	private Canvas canvas;
	private Selection selection;
	private Clipboard clipboard;
	
	public EditorWindow(final Stage stage) {
		
		board = new Board();
		stage.setTitle("lop");
		selection = new Selection();
		Clipboard.getInstance();
		Menu File = new Menu("File");
		Menu Edit= new Menu("Edit");
		Menu Tools = new Menu("Tools");	
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(File, Edit, Tools);
		MenuItem select = new MenuItem("Selection");
		Tools.getItems().addAll(select);
		MenuItem copy = new MenuItem("copy");
		MenuItem paste = new MenuItem("paste");
		MenuItem delete = new MenuItem("delete");
		Tools.getItems().addAll(select);
		Edit.getItems().addAll(copy,paste,delete);
		
		Button box = new Button("Box");
		Button ellipse = new Button("Ellipse");
		Button img = new Button("Img...");
		
		ToolBar toolBar = new ToolBar(box, ellipse, img);
		
		
		canvas = new Canvas(600, 600);
		
		Separator s = new Separator();
		
		

		EventHandler<ActionEvent> actionBox = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tool = new ToolRect();		
			}
		};
		
		EventHandler<ActionEvent> actionEllipse = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tool = new ToolEllipse();
			}
		};
		EventHandler<ActionEvent> actionSelection = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tool = new ToolSelection();
			}
		};
		
		EventHandler<ActionEvent> actionCopy = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Clipboard.getInstance().copyToClipboard(selection.getContents());
			}
			
		};
		EventHandler<ActionEvent> actionPaste = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (Clip c:Clipboard.getInstance().copyFromClipboard()) {
					c.draw(canvas.getGraphicsContext2D());
				}
			}
		};
		EventHandler<ActionEvent> actionDelete = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Clipboard.getInstance().clear();
			}
		};
		
		copy.setOnAction(actionCopy);
		paste.setOnAction(actionPaste);
		delete.setOnAction(actionDelete);
		select.setOnAction(actionSelection);
		box.setOnAction(actionBox);
		ellipse.setOnAction(actionEllipse);
		
		press(this);		
		drag(this);
		release(this);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(menuBar, toolBar, canvas, s);
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		
		board.draw(canvas.getGraphicsContext2D());
		stage.show();
		
		
	}
	
	public void press( EditorInterface i) {
		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				tool.press(i, e);
				
			}
			
		});
	}
	
	public void drag( EditorInterface i) {
		canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				tool.drag(i, e);
				draw();
			}
			
		});
	}

	public void release( EditorInterface i) {
		canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				tool.release(i, e);
				board.draw(canvas.getGraphicsContext2D());
				
			}
			
		});
	}
 	
	
	
	public void draw() {
		board.draw(canvas.getGraphicsContext2D());
		tool.drawFeedback(this, canvas.getGraphicsContext2D());
	}
	
	@Override
	public Board getBoard() {
		return board;
	}

	


	@Override
	public void clipboardChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Selection getSelection() {
		// TODO Auto-generated method stub
		return selection;
	}

	@Override
	public CommandStack getUndoStack() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	