package pobj.pinboard.editor;

import java.util.ArrayList;
import java.util.List;

import pobj.pinboard.document.Clip;

public class Clipboard {
	private static Clipboard clipboard = new Clipboard();
	private List<Clip> listeClip;
	
	private Clipboard() {
		listeClip=new ArrayList<Clip>();
		
	}
	
	public static Clipboard getInstance() {
		return clipboard;
		
	}
	public void copyToClipboard(List<Clip> clips) {
		for (Clip c:clips) {
			listeClip.add(c.copy());
		}
		System.out.println("listeClip"+listeClip.size());
	}
	public List<Clip> copyFromClipboard(){
		List<Clip> copie=new ArrayList<Clip>();
		for (Clip c:listeClip) {
			copie.add(c.copy());
		}
		return copie;
	}
	public void clear() {
		listeClip.clear();
	}
	public boolean isEmpty(){
		return listeClip.isEmpty();
	}
	
}
