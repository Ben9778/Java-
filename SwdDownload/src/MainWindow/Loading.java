package MainWindow;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
public class Loading extends JWindow implements Runnable{
	JProgressBar progress;//进度条组件
	JLabel background;//背景组件
	JLabel man;//人物图片组件
	//构造函数
	public Loading() {
		this.setFrame();
		this.setman();
		this.setprogress();
		this.setMain();		
	}
	public void setMain() {
		Icon bg=new ImageIcon("Image/xyj.jpg");
		background=new JLabel(bg);
		background.setBounds(0, 0, 700, 394);
		this.add(background);
	}
	public void setFrame() {
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(700, 394);
		this.setLocation(340, 170);
	}
	public void setprogress() {
		progress=new JProgressBar();
		progress.setBounds(50, 300, 600, 40);
		progress.setStringPainted(true);
		progress.setString("加载游戏...");
		progress.setBackground(Color.WHITE);
		progress.setIndeterminate(false);
		progress.setBorderPainted(false);
		progress.setForeground(Color.BLACK);
		this.add(progress);
	}
	public void setman() {
		Icon i=new ImageIcon("Image/111.gif");
		man=new JLabel(i);
		this.add(man);
	}
	//线程启动
	public void run() {
		int[] i= {20,40,60,80,100};
		for(int j=0;j<i.length;j++) {		
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progress.setValue(i[j]);
				man.setBounds(6*i[j],260,80,80);
			}		
		Jiemian jm=new Jiemian();
	}
	public static void main(String[] args) {
		Loading a=new Loading();
		Thread t=new Thread(a);
		t.start();
	}
}
