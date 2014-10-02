/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgcase.tool;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Aseem
 */
public class Bubble extends Symbol {
    Circle c;
    Line2D.Double l;
    String location;
    dfd d;
    Bubble(int r, int x, int y, String name){
        c = new Circle(r,x,y);
        this.name = name;
        System.out.println("New Bubble Created");
        id = "id";
        d = new dfd(name);
        l = new Line2D.Double();
    }
    Bubble (Bubble b) {
        this.c = b.c;
        this.l = b.l;
        this.location = b.location;
    }
    void draw (Graphics2D g) {
        g.draw(c);
        Point p = new Point();
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D strb = fm.getStringBounds(name, g);
        //name
        g.drawString ( name,
                (getX() + getWidth()/2 - fm.stringWidth(name)/2),
                (int) (getY() + getHeight()/2 + strb.getHeight()));
        //id
        g.drawString ( id,
                (getX() + getWidth()/2 - fm.stringWidth(id)/2),
                (int) (getY() + getHeight()*1/5 + strb.getHeight()/2));
        //line
        if(getWidth()>20 && getHeight()>20) {
        p.move((int) getX(), (int)(getY() + getHeight()*1/3));
        while (!c.contains(p)) p.x++;
        l.x1 = p.x;
        l.y1 = p.y;
        p.move((int) getX()+ getWidth(), (int)(getY() + getHeight()*1/3));
        while (!contains(p)) p.x--;
        l.x2 = p.x;
        l.y2 = p.y;
        g.draw(l);
        }
    };
    void move(int x, int y) {
        c.x = x;
        c.y = y;
    }
    void resize (int width, int height) {
        c.height = height;
        c.width = width;
    }
    
    boolean contains(Point p) {
        return c.contains(p);
    }
    Rectangle2D getBounds2D () {
        return c.getBounds2D();
    }
    String gettype () {
        return "bubble";
    }
}
