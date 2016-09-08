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
	/* Şuanki hanoi çubuğundaki konumumuz 
	 * (eğer ki yanlış hamle yapılırsa, halkamız geri bu konuma dönecek)
	 */
	private int _addX = 0, _addY = 0;
	/* Şuan bulunduğumuz halka */
	private HanoiPole _currentPole = null;
	public void setCurrentLocationAndPole(int x, int y,HanoiPole thePole){
		_addX = x; _addY = y;
		this.setLocation(_addX, _addY);
		this._currentPole = thePole;
	}
	
	public void cancelMove(){
		/* Yapılan hareketi geri al ve bizi şuanki çubuktaki konumumuza geri döndür */
		this.setLocation(_addX,_addY);
	}
	public HanoiPanel(int width,int height){
		/* Hanoi halkamızı yaratalım */
		this.setSize(new Dimension(width,height));
		this.setPreferredSize(new Dimension(width,height));
		/* Halkamıza siyah çerçeve yaratalım */
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		/* Halkamızın dolgu rengini yeşil olarak ayarlayalım */
		this.setBackground(Color.GREEN);
		/* Halkamızın üzerinde yapılan mouse tıklamalarını yakalamak için */
		this.addMouseListener(this);
		/* Halkamızın üzerinde yapılan mouse hareketlerini yakalamak için */
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
		/* Farenin sol butonu bırakıldığında, halkanın bırakıldığı konuma
		 * bakarak hangi çubuğun üzerinde olduğumuzu bulalım ve (eğer)
		 * halkamızı bu çubuğa aktarıp aktaramayacağımızı belirleyelim.
		 * Eğer ki halkamız, bıraktığımız noktadaki çubuğa girebiliyor ise
		 * (kendisinden daha küçük bir halka mevcut değilse)
		 * halkayı bu çubuğa aktaralım. Yoksa, halkamızı geri şuanki çubuktaki
		 * pozisyonuna geri döndürelim.
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
		/* Halkayı farenin sol butonu basılıyken
		 * farenin hareketi ile senkronize olarak hareket ettir */
		int newX = (arg0.getX() + this.getLocation().x) - this.getWidth() / 2;
		int newY = (arg0.getY() + this.getLocation().y) - this.getHeight() / 2;
		this.setLocation(newX,newY);
	}



}
