
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime
 */
public class ImageEdit extends JFrame{

    JButton quitButton, cutButton, undoButton, redoButton;
    ImagePane imagePane;
    UndoAction undoAction;
    RedoAction redoAction;
    UndoManager undoManager = new UndoManager();
    
    
    ImageEdit(){
        
        setTitle("Editeur d'image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        undoAction = new UndoAction("Annuler");
        redoAction = new RedoAction("Rétablir");
        
        quitButton = new JButton("Quitter");
        cutButton = new JButton("Couper");
        undoButton = new JButton(undoAction);
        redoButton = new JButton(redoAction);
        
        JMenuBar menu = new JMenuBar();
        menu.add(quitButton);
        menu.add(cutButton);
        menu.add(redoButton);
        
        setJMenuBar(menu);
        
        cutButton.setEnabled(false);
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);
        
        quitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        
        cutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CutEdit modif = imagePane.saveCut(); //On enregistre l'action
                undoManager.addEdit(modif); //On ajoute la modif au gesionnaire
                undoButton.setEnabled(true);
                redoButton.setEnabled(true);
            }
            
        });
        
        menu.add(quitButton);
        menu.add(cutButton);
        menu.add(undoButton);
        menu.add(redoButton);
        
        imagePane = new ImagePane();
        setContentPane(imagePane);
        
    }

    class ImagePane extends JPanel{
        
        BufferedImage image;
        Selection selection = new Selection();
        
        ImagePane(){
            try {
                image = ImageIO.read(new File("img/Val_Thorens_2012.jpg"));
            } 
            catch (IOException ex) {
                image = new BufferedImage(300, 300, 100);
            }
            
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
            
            addMouseListener(selection);
            addMouseMotionListener(selection);
            
            repaint(); // appelle paintComponent
        }
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
            ((Graphics2D) g).draw(selection.getRectangle());
        }
        
        void fillzone(Rectangle z, int[][] pixels){
            
            int w1 = (int) z.getWidth();
            int h1 = (int) z.getHeight();
            int x1 = (int) z.getX();
            int y1 = (int) z.getY();
            
            WritableRaster rasterW = image.getRaster(); //On obtient l'image en version éditable
            ColorModel model = image.getColorModel(); //On obtient le modèle de couleur de l'image
            
            for(int x=0; x<w1; x++){
                for(int y=0; y<h1; y++){
                    int col = pixels[x][y];
                    Object colorData = model.getDataElements(col, null);
                    rasterW.setDataElements(x1+x, y1+y, colorData); //Ecriture du pixel dans l'image globale
                }
            }
            repaint();
        }
        
        void clearzone(Rectangle z){
            
            WritableRaster raster = image.getRaster(); //On obtient l'image en version éditable
            ColorModel model = image.getColorModel(); //On obtient le modèle de couleur de l'image
            
            Color color = Color.white;
            int argb = color.getRGB();  //Coordonnées de color
            Object colorData = model.getDataElements(argb, null); //Conversion de color dans le bon modèle
            
            int width = (int) z.getWidth();
            int height = (int) z.getHeight();
            int x = (int) z.getX();
            int y = (int) z.getY();
            
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    raster.setDataElements(x+i, y+j, colorData);
                }
            }
            repaint();
        }
        
        void clearzone(){
            Rectangle z = selection.getRectangle();
            clearzone(z);
        }
        
        CutEdit saveCut(Rectangle z){
            int x = (int)z.getX();
            int y = (int)z.getY();
            int width = (int)z.getWidth();
            int height = (int)z.getHeight();
            
            BufferedImage zoneImage = image.getSubimage(x, y, width, height);
            Coupe c = new Coupe(x, y, zoneImage);
            c.doit();
            
            return new CutEdit(c);
            
        }
        
        CutEdit saveCut(){
            return saveCut(selection.getRectangle());
        }
        class Selection extends MouseAdapter implements MouseMotionListener {
            
            int x1, y1, x2, y2;   //coordonnées de la souris
            
            @Override
            public void mousePressed(MouseEvent e){
                x1 = e.getX();
                y1 = e.getY();
                cutButton.setEnabled(false);
            }
            
            @Override
            public void mouseDragged(MouseEvent e){
                x2 = e.getX();
                y2 = e.getY();
                cutButton.setEnabled(x1 != x2 && y1 != y2);
                repaint();
            }
            
            @Override
            public void mouseMoved(MouseEvent e){
                //Ne fait rien
            }
            
            Rectangle getRectangle(){
                return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
            }
        }
        
    }
    
    class Coupe{
        
        Rectangle z;
        int[][] pixels;
        
        Coupe(int x, int y, BufferedImage image){
            int width = image.getWidth();
            int height = image.getHeight();
            
            pixels = new int[width][height];
            z = new Rectangle(x, y, width, height); 
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    pixels[i][j] = image.getRGB(i, j);
                }
            }
        }
        
        void doit(){
            imagePane.clearzone();
        }
        
        void undo(){
            imagePane.fillzone(z, pixels);
        }
    }
    
    class CutEdit extends AbstractUndoableEdit{
        
        Coupe c;
        
        CutEdit(Coupe c){
            this.c = c;
        }
        
        @Override
        public void undo(){
            super.undo();
            c.undo();
        }
        
        @Override
        public void redo(){
            super.redo();
            c.doit();
        }
    }
    
    class UndoAction extends AbstractAction {

        public UndoAction(String s) {
            super(s);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(undoManager.canUndo())
                undoManager.undo();
        }
        
    }
    
    class RedoAction extends AbstractAction {

        public RedoAction(String s) {
            super(s);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(undoManager.canRedo())
                undoManager.redo();
        }
        
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run(){
                ImageEdit view = new ImageEdit();
                view.pack();
                view.setVisible(true);
            }
        });
    }
}
