import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;

public class HanoiTower extends JFrame implements ActionListener
{
	
	/* Hanoi �ubuklar�m�z� tutacak statik vekt�r */
	public static Vector<HanoiPole> HanoiPoles = new Vector<HanoiPole>();
	/* Hanoi halkalar�m�z� saklayaca��m�z statik vekt�r */
	public static Vector<HanoiPanel> HanoiPanels = new Vector<HanoiPanel>();

	public HanoiTower(){
		
		/* �� adet hanoi �ubu�u yarat ve bunlar� vekt�r�m�ze ekle */
		HanoiPoles.add(new HanoiPole());
		HanoiPoles.add(new HanoiPole());
		HanoiPoles.add(new HanoiPole());
		/* �� adet hanoi halkas� ekle ve bunlar� vekt�r�m�ze ekle */
		HanoiPanels.add(new HanoiPanel(125,25));
		HanoiPanels.add(new HanoiPanel(150,25));
		HanoiPanels.add(new HanoiPanel(175,25));
		/* Standart form haz�rlama */
		this.setLayout(null);
		this.setSize(new Dimension(1024,480));
		this.setTitle("Hanoi Tower");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		/* Hanoi halkalar�n� forma ekle*/
		for(HanoiPanel panel :HanoiPanels){
			this.add(panel);
		}

		/* Hanoi �ubuklar�n� forma ekle */
		for(HanoiPole p:HanoiPoles){
			this.add(p);
		}
		
		/* Hanoi �ubuklar�n�n form i�erisindeki pozisyonlar�n� belirle */
		HanoiPoles.get(0).setLocation(new Point((this.getWidth() / 2) - 300,80));
		HanoiPoles.get(1).setLocation(new Point((this.getWidth() / 2) ,80));
		HanoiPoles.get(2).setLocation(new Point((this.getWidth() / 2) + 300,80));
		/* Sonuncu hanoi �ubu�unu biti� �ubu�u olarak ayarla */
		HanoiPoles.get(2).setAsGoalPole();
		
		/* Hanoi halkalar�n� ilk hanoi �ubu�una ekle */
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
