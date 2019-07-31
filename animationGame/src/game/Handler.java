package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i< object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();			
		}
		
	}
	
	public void render(Graphics g){
		for(int i = 0; i< object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);			
		}		
	}
	
	public void clearEnemys(){
		for(int i = 0; i< object.size(); i++){
			GameObject tempObject = object.get(i);
			
			//if(tempObject.getId() != ID.Player) removeObject(tempObject);
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();
				if(Game.gameState != Game.STATE.End)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}
	
	//Handle adding moving object from list
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}

}
