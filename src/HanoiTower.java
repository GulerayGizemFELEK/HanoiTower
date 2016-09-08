import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;

public class HanoiTower extends JFrame implements ActionListener
{
	
	/* Hanoi çubuklarýmýzý tutacak statik vektör */
	public static Vector<HanoiPole> HanoiPoles = new Vector<HanoiPole>();
	/* Hanoi halkalarýmýzý saklayacaðýmýz statik vektör */
	public static Vector<HanoiPanel> HanoiPanels = new Vector<HanoiPanel>();

	public HanoiTower(){
		
		/* Üç adet hanoi çubuðu yarat ve bunlarý vektörümüze ekle */
		HanoiPoles.add(new HanoiPole());
		HanoiPoles.add(new HanoiPole());
		HanoiPoles.add(new HanoiPole());
		/* Üç adet hanoi halkasý ekle ve bunlarý vektörümüze ekle */
		HanoiPanels.add(new HanoiPanel(125,25));
		HanoiPanels.add(new HanoiPanel(150,25));
		HanoiPanels.add(new HanoiPanel(175,25));
		/* Standart form hazýrlama */
		this.setLayout(null);
		this.setSize(new Dimension(1024,480));
		this.setTitle("Hanoi Tower");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		/* Hanoi halkalarýný forma ekle*/
		for(HanoiPanel panel :HanoiPanels){
			this.add(panel);
		}

		/* Hanoi çubuklarýný forma ekle */
		for(HanoiPole p:HanoiPoles){
			this.add(p);
		}
		
		/* Hanoi çubuklarýnýn form içerisindeki pozisyonlarýný belirle */
		HanoiPoles.get(0).setLocation(new Point((this.getWidth() / 2) - 300,80));
		HanoiPoles.get(1).setLocation(new Point((this.getWidth() / 2) ,80));
		HanoiPoles.get(2).setLocation(new Point((this.getWidth() / 2) + 300,80));
		/* Sonuncu hanoi çubuðunu bitiþ çubuðu olarak ayarla */
		HanoiPoles.get(2).setAsGoalPole();
		
		/* Hanoi halkalarýný ilk hanoi çubuðuna ekle */
		HanoiPoles.get(0).addPanel(HanoiPanels.get(2));
		HanoiPoles.get(0).addPanel(HanoiPanels.get(1));
		HanoiPoles.get(0).addPanel(HanoiPanels.get(0));
			
	}
	

	public static void main(String[] args) 
	{
		new HanoiTower();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
