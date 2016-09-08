import java.awt.Color;
import java.awt.Dimension;
import java.util.Stack;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HanoiPole extends JPanel
{
	private boolean isGoalPole = false;
	private Stack<HanoiPanel> HanoiPanels = new Stack<HanoiPanel>();
	public HanoiPole(){
		this.setPreferredSize(new Dimension(25,300));
		this.setSize(new Dimension(25,300));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(Color.red);
	}
	public void setAsGoalPole(){ isGoalPole = true;}
	public boolean addPanel(HanoiPanel panel){
		/* Eðer eklenmeye çalýþýlan halka null ise */
		if(panel == null)
			return false;
		/* Eðer eklenmeye çalýþýlan halka, en üstteki halkadan daha büyükse,
		 * bu hareket oyun kurallarýna aykýrý olduðundan dolayý
		 * paneli bu çubuða eklemiyoruz ve geriye false deðerini döndürüyoruz.
		 */
		if(!HanoiPanels.empty() && HanoiPanels.peek().getWidth() < panel.getWidth())
			return false;
		
		/* Halkanýn çubuk içerisindeki konumunu hesapla */
		int base = this.getY() + this.getHeight() - panel.getHeight();
	    int height = base - (panel.getHeight() * HanoiPanels.size());
	    /* Halkayý çubuðumuza ekleyelim */
	    HanoiPanels.push(panel);
	   
	    /* Halkamýzýn yeni konumunu uygulayalým */
	    panel.setCurrentLocationAndPole(this.getX() - (panel.getWidth() / 2) + (this.getWidth() / 2),height,this);
	    /* Oyunun bitip bitmediðini kontrol edelim */
		if(isGoalPole && HanoiPanels.size() == HanoiTower.HanoiPanels.size()){
			JOptionPane.showMessageDialog(null, "you win!");
		}
		return true;
		//panel.setLocation(p);
	}
	
	public boolean popAndTransferTo(HanoiPole targetPole){
		/* Eðer halkayý hedeflenen çubuða aktarabildiysek, bu çubuktan silelim
		 * ve geriye true deðerini döndürelim.
		 * Yoksa, geriye iþlemin gerçekleþtirilemediðini belirtmek için
		 * false deðerini döndürelim.
		 */
		if(targetPole.addPanel(HanoiPanels.peek()))
		{
			HanoiPanels.pop();
			return true;
		}
		return false;
	}

}
