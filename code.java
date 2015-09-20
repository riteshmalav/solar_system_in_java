import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class code extends Applet implements Runnable {
	Image background,sun,mercury,venus,earth,
		mars,jupiter,saturn,uranus,neptune,moon;
	double mercury_x = 0,mercury_y = 0;
	double mercury_a = 200,mercury_b = 100;
	double mercury_size = 1,mercury_theta = 180;
	
	double venus_x = 0,venus_y = 0;
	double venus_a = 250,venus_b = 130;
	double venus_size = 1,venus_theta = 30;
	
	double earth_x = 0,earth_y = 0;
	double earth_a = 320,earth_b = 160;
	double earth_size = 1,earth_theta = 0;
	
	double mars_x = 0,mars_y = 0;
	double mars_a = 380,mars_b = 180;
	double mars_size = 1,mars_theta = 50;
	
	double jupiter_x = 0,jupiter_y = 0;
	double jupiter_a = 470,jupiter_b = 240;
	double jupiter_size = 1,jupiter_theta = 90;
	
	double saturn_x = 0,saturn_y = 0;
	double saturn_a = 560,saturn_b = 270;
	double saturn_size = 1,saturn_theta = 240;
	
	double uranus_x = 0,uranus_y = 0;
	double uranus_a = 650,uranus_b = 310;
	double uranus_size = 1,uranus_theta = 300;
	
	double neptune_x = 0,neptune_y = 0;
	double neptune_a = 750,neptune_b = 350;
	double neptune_size = 1,neptune_theta = 140;
	
	double moon_x = 0,moon_y = 0;
	double moon_a = 60,moon_b = 30;
	double moon_size = 1,moon_theta = 140;
	
	private Image i;
	private Graphics doubleG;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(1300, 800);
		background = getImage(getCodeBase(), "galaxy.jpg");
		sun = getImage(getCodeBase(), "sun.png");
		mercury = getImage(getCodeBase(), "mercury.png");
		venus = getImage(getCodeBase(), "venus.png");
		earth = getImage(getCodeBase() , "earth.png");
		mars = getImage(getCodeBase() , "mars.png");
		jupiter = getImage(getCodeBase(), "jupiter.png");
		saturn = getImage(getCodeBase() , "saturn.png");
		uranus = getImage(getCodeBase() , "uranus.png");
		neptune = getImage(getCodeBase() , "neptune.png");
		moon = getImage(getCodeBase() , "moon.png");
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(i == null){
			i = createImage(this.getSize().width , this.getSize().height);
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		System.out.println();
		g.drawImage(moon, (int)moon_x-7, (int)moon_y-7, 15, 15, this);
		if(mercury_y > getHeight()/2){
			g.drawImage(sun, getWidth()/2-300/2, getHeight()/2-280/2, 300, 280, this);
			g.drawImage(mercury, (int)mercury_x-10, (int)mercury_y-10, 20, 20, this);
			g.drawImage(venus, (int)venus_x-20, (int)venus_y-20, 40, 40, this);
			g.drawImage(earth, (int)earth_x-30, (int)earth_y-30, 60, 60, this);
			g.drawImage(mars, (int)mars_x-20, (int)mars_y-20, 40, 40, this);
			g.drawImage(jupiter, (int)jupiter_x-40, (int)jupiter_y-40, 80, 80, this);
			g.drawImage(saturn, (int)saturn_x-35, (int)saturn_y-35, 120, 70, this);
			g.drawImage(uranus, (int)uranus_x-35, (int)uranus_y-35, 60, 110, this);
			g.drawImage(neptune, (int)neptune_x-35, (int)neptune_y-35, 70, 70, this);
			g.drawImage(neptune, (int)neptune_x-35, (int)neptune_y-35, 70, 70, this);
		}
		else{
			g.drawImage(neptune, (int)neptune_x-35, (int)neptune_y-35, 70, 70, this);
			g.drawImage(uranus, (int)uranus_x-35, (int)uranus_y-35, 60, 110, this);
			g.drawImage(saturn, (int)saturn_x-35, (int)saturn_y-35, 120, 70, this);
			g.drawImage(jupiter, (int)jupiter_x-40, (int)jupiter_y-40, 80, 80, this);
			g.drawImage(mars, (int)mars_x-20, (int)mars_y-20, 40, 40, this);
			g.drawImage(earth, (int)earth_x-30, (int) earth_y-30, 60, 60, this);
			g.drawImage(venus, (int)venus_x-20, (int) venus_y-20, 40, 40, this);
			g.drawImage(mercury, (int)mercury_x-10, (int)mercury_y-10, 20, 20, this);
			g.drawImage(sun, getWidth()/2-300/2, getHeight()/2-280/2, 300, 280, this);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			mercury_theta = mercury_theta - (double)1;
			mercury_x = getWidth()/2+mercury_a*Math.cos(mercury_theta*3.14/180);
			mercury_y = getHeight()/2+mercury_b*Math.sin(mercury_theta*3.14/180);
			
			venus_theta = venus_theta - (double)1/(double)2;
			venus_x = getWidth()/2+venus_a*Math.cos(venus_theta*3.14/180);
			venus_y = getHeight()/2+venus_b*Math.sin(venus_theta*3.14/180);
			
			earth_theta = earth_theta - (double)1/(double)4;
			earth_x = getWidth()/2+earth_a*Math.cos(earth_theta*3.14/180);
			earth_y = getHeight()/2+earth_b*Math.sin(earth_theta*3.14/180);
			
			mars_theta = mars_theta - (double)1/(double)8;
			mars_x = getWidth()/2+mars_a*Math.cos(mars_theta*3.14/180);
			mars_y = getHeight()/2+mars_b*Math.sin(mars_theta*3.14/180);
			
			jupiter_theta = jupiter_theta - (double)1/(double)16;
			jupiter_x = getWidth()/2+jupiter_a*Math.cos(jupiter_theta*3.14/180);
			jupiter_y = getHeight()/2+jupiter_b*Math.sin(jupiter_theta*3.14/180);
			
			saturn_theta = saturn_theta - (double)1/(double)32;
			saturn_x = getWidth()/2+saturn_a*Math.cos(saturn_theta*3.14/180);
			saturn_y = getHeight()/2+saturn_b*Math.sin(saturn_theta*3.14/180);
			
			uranus_theta = uranus_theta - (double)1/(double)64;
			uranus_x = getWidth()/2+uranus_a*Math.cos(uranus_theta*3.14/180);
			uranus_y = getHeight()/2+uranus_b*Math.sin(uranus_theta*3.14/180);
			
			neptune_theta = neptune_theta - (double)1/(double)128;
			neptune_x = getWidth()/2+neptune_a*Math.cos(neptune_theta*3.14/180);
			neptune_y = getHeight()/2+neptune_b*Math.sin(neptune_theta*3.14/180);
			
			moon_theta = moon_theta - (double)2/(double)1;
			moon_x = earth_x+moon_a*Math.cos(moon_theta*3.14/180);
			moon_y = earth_y+moon_b*Math.sin(moon_theta*3.14/180);
			System.out.println(moon_x + " " + moon_y + "\n");
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
