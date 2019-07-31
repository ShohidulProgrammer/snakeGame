package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	
	private Color col;
	
	//int dir = 0;
	
	/*private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);*/

	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(7 - (-7)) + (-7));
		velY = (r.nextInt(7 - (-7)) + (-7));
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		/*dir = r.nextInt(2);
		if(dir ==0){
			velX = 2;
			velY = 5;
		}else if(dir == 1){
			velX = 5;
			velY = 2;
		}*/

		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		//equation for z= vely*(-1) => z= -5*(-1)=5 => z=5* (-1)= -5.
		if(y <= 0 || y >= Game.HEIGHT - 40) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
