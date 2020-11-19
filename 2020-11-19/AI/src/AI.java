import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	int x,y;
	int leftFlag;
	Image img,img1,img2,img3,img4,img5,currentImg;
	public MainCanvas(){
		try
		{
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");

			currentImg=img;
			x=120;
			y=100;
			leftFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		
		if(action==LEFT){
			if(leftFlag=1){
				currentImg=img4;
				leftFlag++;
			}
			else if(leftFlag=2){
				currentImg=img5;
				leftFlag--;
			}
			System.out.println("向左转");
			x=x-1;
			repaint();
		}
		if(action==RIGHT){
			currentImg=img3;
			System.out.println("向右转");
			x=x+1;
			repaint();
		}
		if(action==UP){
			currentImg=img2;
			System.out.println("向上转");
			y=y-1;
			repaint();
		}
		if(action==DOWN){
			currentImg=img;
			System.out.println("向下转");
			y=y+1;
			repaint();
		}
	}
}