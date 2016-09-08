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
		/* E�er eklenmeye �al���lan halka null ise */
		if(panel == null)
			return false;
		/* E�er eklenmeye �al���lan halka, en �stteki halkadan daha b�y�kse,
		 * bu hareket oyun kurallar�na ayk�r� oldu�undan dolay�
		 * paneli bu �ubu�a eklemiyoruz ve geriye false de�erini d�nd�r�yoruz.
		 */
		if(!HanoiPanels.empty() && HanoiPanels.peek().getWidth() < panel.getWidth())
			return false;
		
		/* Halkan�n �ubuk i�erisindeki konumunu hesapla */
		int base = this.getY() + this.getHeight() - panel.getHeight();
	    int height = base - (panel.getHeight() * HanoiPanels.size());
	    /* Halkay� �ubu�umuza ekleyelim */
	    HanoiPanels.push(panel);
	   
	    /* Halkam�z�n yeni konumunu uygulayal�m */
	    panel.setCurrentLocationAndPole(this.getX() - (panel.getWidth() / 2) + (this.getWidth() / 2),height,this);
	    /* Oyunun bitip bitmedi�ini kontrol edelim */
		if(isGoalPole && HanoiPanels.size() == HanoiTower.HanoiPanels.size()){
			JOptionPane.showMessageDialog(null, "you win!");
		}
		return true;
		//panel.setLocation(p);
	}
	
	public boolean popAndTransferTo(HanoiPole targetPole){
		/* E�er halkay� hedeflenen �ubu�a aktarabildiysek, bu �ubuktan silelim
		 * ve geriye true de�erini d�nd�relim.
		 * Yoksa, geriye i�lemin ger�ekle�tirilemedi�ini belirtmek i�in
		 * false de�erini d�nd�relim.
		 */
		if(targetPole.addPanel(HanoiPanels.peek()))
		{
			HanoiPanels.pop();
			return true;
		}
		return false;
	}

}
