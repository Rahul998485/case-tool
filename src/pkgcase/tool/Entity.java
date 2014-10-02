/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgcase.tool;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Aseem
 */
public class Entity extends Symbol{
    Rectangle rect;
    Entity (int x, int y, int width, int height, String name){
        rect = new Rectangle (x,y,width,height);
        this.name = name;
        System.out.println("New Entity Created");
    }
    Entity (Entity e) {
        this.rect = e.rect;
    }
    void draw (Graphics2D g) {
        g.draw(rect);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D strb = fm.getStringBounds(name, g);
        g.drawString ( name,
                (getX() + getWidth()/2 - fm.stringWidth(name)/2),
                (int) (getY() + getHeight()/2 + strb.getHeight()/2));
    };
    void move(int x, int y) {
        rect.setLocation(x, y);
    }
    void resize (int width, int height) {
        rect.height = height;
        rect.width = width;
    }
    
    boolean contains(Point p) {
        return rect.contains(p);
    }
    
    Rectangle2D getBounds2D () {
        return rect.getBounds2D();
    }
    String gettype () {
        return "entity";
    }
}
