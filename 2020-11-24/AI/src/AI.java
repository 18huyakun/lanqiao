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
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY,bossX,bossY;
	int Flag;
	Image heroImg[][]=new Image[4][3];//0是left，1是right，2是up，3是down
	Image currentImg;
	Image bossImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;

			bossX=0;
			bossY=0;

			Flag=1;
			
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try
			{
				Thread.sleep(150);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}

			if(bossY<heroY){
				bossY++;
			}else{
				bossY--;
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,230,250);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);	
		if(action==LEFT){
			heroSpot(0);
			System.out.println("向左转");
			heroX=heroX-1;
		}
		if(action==RIGHT){
			heroSpot(1);
			System.out.println("向右转");
			heroX=heroX+1;		
		}
		if(action==UP){
			heroSpot(2);
			System.out.println("向上转");
			heroY=heroY-1;	
		}
		if(action==DOWN){
			heroSpot(3);
			System.out.println("向下转");
			heroY=heroY+1;
		}
	}
	void heroSpot(int direction){
		if(Flag==1){
				currentImg=heroImg[direction][0];
				Flag++;
			}
			else if(Flag==2){
				currentImg=heroImg[direction][2];
				Flag--;
			}
	}
}