package zengchen233.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @class: ImageJPanel
 * @author: Zc
 * @Date: 2021/03/21 9:22
 * @Description:
 */
public class ImageJPanel extends JPanel implements MouseListener {
    Image image;
    ImageJPanel() {
        setOpaque(false);
        setBorder(null);
        setToolTipText("单击图像单独调整观看");
        addMouseListener(this);
    }

    public void setImage(Image img) {
        image = img;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,getBounds().width,getBounds().height,this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ShowImageDialog showImageDialog = new ShowImageDialog(image);
        showImageDialog.setVisible(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

}
