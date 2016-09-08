import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HanoiPanel extends JPanel implements MouseListener,MouseMotionListener
{
	/* �uanki hanoi �ubu�undaki konumumuz 
	 * (e�er ki yanl�� hamle yap�l�rsa, halkam�z geri bu konuma d�necek)
	 */
	private int _addX = 0, _addY = 0;
	/* �uan bulundu�umuz halka */
	private HanoiPole _currentPole = null;
	public void setCurrentLocationAndPole(int x, int y,HanoiPole thePole){
		_addX = x; _addY = y;
		this.setLocation(_addX, _addY);
		this._currentPole = thePole;
	}
	
	public void cancelMove(){
		/* Yap�lan hareketi geri al ve bizi �uanki �ubuktaki konumumuza geri d�nd�r */
		this.setLocation(_addX,_addY);
	}
	public HanoiPanel(int width,int height){
		/* Hanoi halkam�z� yaratal�m */
		this.setSize(new Dimension(width,height));
		this.setPreferredSize(new Dimension(width,height));
		/* Halkam�za siyah �er�eve yaratal�m */
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		/* Halkam�z�n dolgu rengini ye�il olarak ayarlayal�m */
		this.setBackground(Color.GREEN);
		/* Halkam�z�n �zerinde yap�lan mouse t�klamalar�n� yakalamak i�in */
		this.addMouseListener(this);
		/* Halkam�z�n �zerinde yap�lan mouse hareketlerini yakalamak i�in */
		this.addMouseMotionListener(this);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released");
		/* Farenin sol butonu b�rak�ld���nda, halkan�n b�rak�ld��� konuma
		 * bakarak hangi �ubu�un �zerinde oldu�umuzu bulal�m ve (e�er)
		 * halkam�z� bu �ubu�a aktar�p aktaramayaca��m�z� belirleyelim.
		 * E�er ki halkam�z, b�rakt���m�z noktadaki �ubu�a girebiliyor ise
		 * (kendisinden daha k���k bir halka mevcut de�ilse)
		 * halkay� bu �ubu�a aktaral�m. Yoksa, halkam�z� geri �uanki �ubuktaki
		 * pozisyonuna geri d�nd�relim.
		 */
		for(HanoiPole p : HanoiTower.HanoiPoles){
			int radstart = p.getX() - 150;
			int radend = p.getX() + 150;
			if(this.getX() >= radstart && this.getX() <= radend)
			{
				if(!_currentPole.popAndTransferTo(p))
				{
					cancelMove();
					JOptionPane.showMessageDialog(null, "Illegal move");
				}
				else
				{
				return;
				}
			}
		}
		cancelMove();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		/* Halkay� farenin sol butonu bas�l�yken
		 * farenin hareketi ile senkronize olarak hareket ettir */
		int newX = (arg0.getX() + this.getLocation().x) - this.getWidth() / 2;
		int newY = (arg0.getY() + this.getLocation().y) - this.getHeight() / 2;
		this.setLocation(newX,newY);
	}



}
