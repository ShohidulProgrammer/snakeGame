package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;
	

	public Player(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
		
		//velX = r.nextInt(5) + 1;
		//velY = r.nextInt(5);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y= Game.clamp(y, 0, Game.HEIGHT -60);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 32, 32, 0.05f, handler));
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){ //tempObject is now basic enemy  
				
				if(getBounds().intersects(tempObject.getBounds())){
					// collision code 
					HUD.HEALTH -= 2;
				}
					
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
		//g2d.draw(getBounds());
		//if(id == ID.Player)
		//g.setColor(Color.white);
		//else if(id == ID.Player2)
		//g.setColor(Color.blue);
		
	}

}
