/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgcase.tool;

/**
 *
 * @author Aseem
 */
public class Global {
    public static int mode=0;
        /*
    0 - Do nothing, adjust position
    1 - Draw entity
    2 - Draw bubble
    3 - Draw Data Store
    5 - Editing
     * 11 - Internal
    21 - Delete
    */
    public static MainFrame n;
    /*
    void changeMode(int m) {
        this.mode = m;
        System.out.println("Mode = "+m);
    }
    */
    static void changemode(int m) {
        mode = m;
        System.out.println("Mode: " + mode);
        MainFrame.updatestatus(m);
    }
}
