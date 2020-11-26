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
	/*Image LEFTImg[]=new Image[3];
	Image RIGHTImg[]=new Image[3];
	Image UPImg[]=new Image[3];
	Image DOWNImg[]=new Image[3];*/
	Image heroImg[][]=new Image[4][3];//0 LEFT,1RIGHT,2 UP ,3 DOWN
	Image currentImg;
	int Flag,x,y,j;
	public MainCanvas(){
		try{
			/*for (int i=0;i<LEFTImg.length ;i++ )
			{
				 LEFTImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for (int i=0;i<RIGHTImg.length ;i++ )
			{
				 RIGHTImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			for (int i=0;i<UPImg.length ;i++ )
			{
				 UPImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			for (int i=0;i<DOWNImg.length ;i++ )
			{
				 DOWNImg[i]=Image.createImage("/sayo"+i+"0.png");
			}*/
			for (int i=0;i<heroImg.length ;i++ )
			{ 
				for (int j=0;j<heroImg[i].length ;j++ )
				{
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}





			//下
			/*img8=Image.createImage("/sayo00.png");
			img=Image.createImage("/sayo10.png");
			img9=Image.createImage("/sayo20.png");
			//上
			img10=Image.createImage("/sayo04.png");
			img3=Image.createImage("/sayo14.png");
			img11=Image.createImage("/sayo24.png");
			//左
			img4=Image.createImage("/sayo02.png");
			img1=Image.createImage("/sayo12.png");
			img5=Image.createImage("/sayo22.png");
			//右
			img6=Image.createImage("/sayo06.png");
			img2=Image.createImage("/sayo16.png");
			img7=Image.createImage("/sayo26.png");*/

			currentImg=heroImg[3][1];
		    x=120;
			y=100;
			Flag=1;

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);

	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if (action==LEFT)
		{
			heroqiehuan(0);
			System.out.println("向左转");
			x=x-1;
			repaint();
		}
		if (action==RIGHT)
		{
			heroqiehuan(1);
			System.out.println("向右转");
			x=x+1;
			repaint();
		}
		
		if (action==DOWN)
		{
			heroqiehuan(3);
			System.out.println("向下");
			y=y+1;
			repaint();
		}
		
		if (action==UP)
		{
			heroqiehuan(2);
			System.out.println("向上");
			y=y-1;
			repaint();
		}
	}
		void heroqiehuan(int derrection)
		{
			if (Flag==1)
			{
				currentImg=heroImg[derrection][0];
				Flag++;
			}
			else if (Flag==2)
			{
				currentImg=heroImg[derrection][2];
				Flag--;
			}
		}
}