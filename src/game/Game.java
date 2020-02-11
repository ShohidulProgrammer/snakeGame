package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1550691097823471818L;
	
	
	public static final int WIDTH = 640, HEIGHT = WIDTH /12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	public int diff = 0;
	
	// 0 = normal
	// 1 = Hard
	
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	
	public enum  STATE{
		Menu,
		Select,
		Help,
		Game,
		End
	};
	
	public static STATE gameState = STATE.Menu;
	//public STATE gameState = STATE.Game;
	
		public Game(){
			
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		
		//AudioPlayer.load();
		//AudioPlayer.getMusic("Music").loop();
		
		
		
		new Window(WIDTH, HEIGHT, "This Game made by Md. Shoikat @ IT HOME! 824/1 middle monipur mirpur-2 dhaka-1216", this);
		
		spawner = new Spawn(handler, hud, this);
		
		r = new Random();
		
		if(gameState == STATE.Game)
		{
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
		}else{
			for(int i = 0; i < 20; i++){
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
			}
		}
		
		
		
		
	    /*for(int i = 0; i< 50; i++){
			handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player));
		}*/
		
		
		
		
		//handler.addObject(new EnemyBoss((Game.WIDTH / 2)-48, -120, ID.EnemyBooss, handler));
		
		
		//handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, ID.EnemyBooss, handler));
		//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		//handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
		
		//for(int i = 0; i < 20; i++)
			
		//handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2));
	}
	
	public synchronized void start(){
				thread = new Thread(this);
				try{
				thread.start();
				running = true;
			}catch(Exception e){
				System.out.println("Please call me! mobile: 01536218968");
			}
				
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
	
	public void run(){
		try{
		this.requestFocus();
		}catch(Exception e){
			System.out.println("requestFocus problem.\nIf any problem Please! Call Me. Mobile: 01536218968");
			
		}
		long lastTime = System.nanoTime();
		
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		try{
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS:" + frames);
				frames = 0;
			}
		}}catch(Exception e){
			System.out.println("game Engin Function problem.\nIf any problem Please! Call Me. Mobile: 01536218968");
			
		}
		
		
		try{
		stop();
		}catch(Exception e){
			System.out.println("stop problem.\nIf any problem Please! Call Me. Mobile: 01536218968");
			
		}
	}
	
	private void tick(){
		
		if(gameState == STATE.Game)
		{
			
			if(!paused)
			{
				try{
				hud.tick();
				spawner.tick();
				handler.tick();
				}catch(Exception e){
					System.out.println("hud.tick Or spawner.tick or handler.tick.\nIf any problem Please! Call Me. Mobile: 01536218968");	
				}
				if(HUD.HEALTH <= 0){
					HUD.HEALTH = 100;
					
					gameState = STATE.End;
					handler.clearEnemys();
					for(int i = 0; i < 20; i++){
						handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
					}
					
			}
			
		}
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select){
			try{
			menu.tick();
			handler.tick();}
			catch(Exception e){
				System.out.println("menu.tick or handler.tick problem. If any problem Please! Call Me. Mobile: 01536218968");
				
			}
		}
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
	
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		try{
		handler.render(g);
		}catch(Exception e){
			System.out.println("handler.render some thing wrong");
		}
		if(paused)
		{
			g.setColor(Color.cyan);
			g.drawString("PAUSED", 120, 80);
		}
		try{
		if(gameState == STATE.Game)
		{
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
			menu.render(g);
		}
		}catch(Exception e){
			System.out.println("hud.render or menu.render problem. If any problem Please! Call Me. Mobile: 01536218968");
			
		}
		
		/*else {
			g.setColor(Color.white);
			g.drawString("Menu", 100, 100);
		}*/
		try{
		g.dispose();
		bs.show();
		}catch(Exception e){
			System.out.println("dispose or show problem If any problem Please! Call Me. Mobile: 01536218968");
			
		}
	}
	
	public static float clamp(float ver, float min, float max){
	if(ver >= max)
		return ver = max;
	else if(ver <= min)
		return ver = min;
	else 
		return ver;
	}
	
	/*public static float clamp(float y, float min, float max){
		if(y >= max)
			return y = max;
		else if(y <= min)
			return y = min;
		else 
			return y;
	}*/
	

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		try{
		new Game();
		}catch(Exception e){
			System.out.println("If any problem Please! Call Me. Mobile: 01536218968");
		}
	}

}
