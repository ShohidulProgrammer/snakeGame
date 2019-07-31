package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import org.w3c.dom.events.EventException;

import game.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.hud =hud;
		this.handler = handler;
	}
	
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu){
			//play button
			if(mouseOver(mx, my, 210, 150, 200, 64)){
				Game.gameState = STATE.Select;				
				//AudioPlayer.getSound("menu_sound").play();
				return;
			}
			//help button
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				Game.gameState = STATE.Help;
				return;
				//AudioPlayer.getSound("menu_sound").play();
			}
			//quit button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(1);
			}
		}		 
		 
		if(Game.gameState == STATE.Select){
			//normal button
			if(mouseOver(mx, my, 210, 150, 200, 64)){
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));

				game.diff = 0;
				
				//game.gameState = STATE.Select;
				
				//AudioPlayer.getSound("menu_sound").play();
			}
			
			//Hard button
			if(mouseOver(mx, my, 210, 250, 200, 64)){
					Game.gameState = STATE.Game;
					handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
					handler.clearEnemys();
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
					
					game.diff = 1;
					
				
				//AudioPlayer.getSound("menu_sound").play();
			}
			
			
		
			//back button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
					Game.gameState = STATE.Menu;
					//AudioPlayer.getSound("menu_sound").play();					
					return;				
			}
		}	
		
		//back button for help
		if(game.gameState == STATE.Help){
				if(mouseOver(mx, my, 210, 350, 200, 64)){
					game.gameState = STATE.Menu;
					
					//AudioPlayer.getSound("menu_sound").play();
					return;
				}
			}
		//back button for help
		if(game.gameState == STATE.End){
			
		
			if(mouseOver(mx, my, 210, 350, 200, 64)){
					game.gameState = STATE.Menu;
					hud.setLevel(1);
					hud.setScore(0);
					//AudioPlayer.getSound("menu_sound").play();
    		}
			}
				
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x+width){
			if(my > y && my < y+width){
				return true;
			}else return false;			
		}else return false;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		if(Game.gameState == STATE.Menu){
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.green);			
			g.drawString("IT HOME", 200, 50);

			g.setColor(Color.cyan);
			g.drawString("Color Snake", 150, 115);
			
			//g.setColor(Color.red);
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 196);
			
			

			g.drawRect(210, 250, 200, 64);
			g.drawString("IT MODE", 250, 296);
			
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Help", 270, 396);
		}else if(Game.gameState == STATE.Help){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 257, 100 );
			
			g.setFont(fnt3);
			g.drawString("Use W S A D keys to move player and dodge enemis" , 55, 180);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}
		
		else if(Game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.red);
			g.drawString("Game Over", 180, 100);
			
			g.setColor(Color.cyan);
			g.setFont(fnt3);
			g.drawString("You Lost with a Score of: " + hud.getScore(), 175, 200);
			g.setColor(Color.green);
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 245, 390);
		}
		
if(Game.gameState == STATE.Select){
			
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.green);			
			g.drawString("IT HOME", 200, 50);

			g.setColor(Color.cyan);
			g.drawString("SELECT DIFFICULTY", 60, 115);
			
			g.setColor(Color.white);
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("NORMAL", 250, 196);
			
			

			g.drawRect(210, 250, 200, 64);
			g.drawString("HARD", 270, 296);
			
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("BACK", 270, 396);
		}
		
		
	}

}
