///Global Variables
package globalPack;

    import localPack.*;

    import java.util.ArrayList;         import java.awt.Color;              import java.awt.Font;
    import java.awt.Point;              import java.awt.event.KeyEvent;     import java.awt.event.KeyListener;
    import java.awt.event.MouseEvent;   import java.awt.event.MouseListener;import javax.swing.*;
    
///---------------Public Class---------------\\\
    public class globalVar {
    ///------------------------------------------------------Constants------------------------------------------------------\\\
    ///Comfort Constants
        public static final int noone = -4; 

        public static final Color C_WHITE   = Color.white;  
        public static final Color C_BLUE    = Color.blue; 
        public static final Color C_BLACK   = Color.black; 
        public static final Color C_RED     = Color.red;
        public static final Color C_GREEN   = Color.green;
        public static final Color C_GRAY    = Color.gray;
        public static final Color C_MAGENTA = Color.magenta;
        public static final Color C_CYAN    = Color.cyan;
        public static final Color C_YELLOW  = Color.yellow;
        
        public static final int FA_LEFT     = 0;
        public static final int FA_CENTER   = 1;
        public static final int FA_RIGHT    = 2;

    ///Sprite Constants
        public static final String SPR_TRON = "tron.png";
    
    ///Room Constants 
        public static final int RM_MENU1    = 0;
        public static final int RM_MENU2    = 1;
        public static final int RM_GAME1    = 2;
        public static final int RM_GAME2    = 3;
        public static final int RM_SETTINGS = 4;

    ///Key Constants
        public static final int VK_NOONE = noone;
        public static final int VK_ALL = 0;
        public static final int VK_SPACE = 32;
        public static final int VK_ENTER = 10;
        public static final int VK_ESCAPE= 27;
        public static final int VK_F1 = 112;    public static final int VK_F2 = 113;    public static final int VK_F3 = 114;    public static final int VK_F4 = 115;
        public static final int VK_F5 = 116;    public static final int VK_F6 = 117;    public static final int VK_F7 = 118;    public static final int VK_F8 = 119;
        public static final int VK_F9 = 120;    public static final int VK_F10 = 121;   public static final int VK_F11 = 122;   public static final int VK_F12 = 123;
        public static final int VK_CONTROL = 17;
    
    ///Mouse Constants
        public static final int MB_NOONE    = noone;
        public static final int MB_ALL      = 0;
        public static final int MB_LEFT     = 1;
        public static final int MB_MIDDLE   = 2;
        public static final int MB_RIGHT    = 3;

    ///------------------------------------------------------Global Variables------------------------------------------------------\\\
    public static void globalUpdate(){
        ///Time Variables Update
        timeDelta   = (int)     ((System.nanoTime() - timeLast) / 1000); 
        timeGamma   = (double)  timeDelta/1000000;
        timeLast    =           System.nanoTime();
        gameSpeed   =           1000000/timeDelta;
        
        ///Mouse Positions
            final Point mousePos = gameFrame.getMousePosition();
            if (mousePos != null) {mouse_x = mousePos.x;mouse_y = mousePos.y;}

        ///Draw Clear Frame
            for(JPanel _index:panel_id) gameFrame.remove(_index);
            for(JLabel _index:label_id) gameFrame.remove(_index);
            panel_id.clear();label_id.clear();
    }
    
    ///Room     Variables
        public static int   roomIndex   = 0; 
        public static int   roomLast    = -1;
        public static int   roomWidth   = 1080;
        public static int   roomHeight  = 720;
        public static Color roomColor   = C_BLACK;

    ///Game     Variables
        public static String    gameFrameName       = "TRON";
        public static JFrame    gameFrame           = new JFrame(gameFrameName);
        public static int       gameSpeed   = 0;
        public static Boolean   gameIsFullscreen    = false;
        public static Boolean   gameIsRunning       = true;
        public static Boolean   gameIsGaming       = false;


    ///Game Rules
        public static Boolean   ruleObstacle  = true;
        public static Integer   ruleGridSize  = 15;
        public static int[][]   ruleGridId; 
        public static Rectangle[][] ruleGridList;
        

    ///Drawing  Variables
        public static Font  drawFont    = new Font("Verdana",1,30);
        public static int   drawAlpha   = 1;
        public static Color drawColor   = C_WHITE;
        public static int   drawHalign  = FA_CENTER;
        public static int   drawValign  = FA_CENTER;


    ///Time     Variables
        private static long     timeLast   = System.nanoTime();
        public static int       timeDelta  = 0;
        public static double    timeGamma  = 0;

    ///Player   Variables
    public static  Player[] playerList;

    ///List     Variables
    public static ArrayList<JPanel>         panel_id            = new ArrayList<>();
    public static ArrayList<JLabel>         label_id            = new ArrayList<>();
    public static ArrayList<globalButton>  instance_id         = new ArrayList<>();
    public static ArrayList<Integer>        keyTyped_List       = new ArrayList<>();
    public static ArrayList<Integer>        keyPressed_List     = new ArrayList<>();
    public static ArrayList<Integer>        keyReleased_List    = new ArrayList<>();
    public static ArrayList<Integer>        mouseClicked_List   = new ArrayList<>();
    public static ArrayList<Integer>        mousePressed_List   = new ArrayList<>();
    public static ArrayList<Integer>        mouseReleased_List  = new ArrayList<>();


        ///Keyboard Listener
        public static KeyListener listener_keyboard = new KeyListener() {
            public void keyTyped(KeyEvent e) {keyTyped_List.add(VK_ALL);keyTyped_List.add(e.getKeyCode());}

            public void keyPressed(KeyEvent e) {keyPressed_List.add(VK_ALL);keyPressed_List.add(e.getKeyCode());}

            public void keyReleased(KeyEvent e) {keyReleased_List.add(VK_ALL);keyReleased_List.add(e.getKeyCode());}   
        };

        ///Mouse Listener
        public static Integer mouse_x = 0;public static Integer mouse_y = 0;

        public static MouseListener listener_mouse = new MouseListener() {
            public void mouseClicked(MouseEvent e) {mouseClicked_List.add(MB_ALL);mouseClicked_List.add(e.getButton());}

            public void mousePressed(MouseEvent e) {mousePressed_List.add(MB_ALL);mousePressed_List.add(e.getButton());}

            public void mouseReleased(MouseEvent e) {mouseReleased_List.add(MB_ALL);mouseReleased_List.add(e.getButton());}

            public void mouseEntered(MouseEvent e) {System.out.println("Mouse Entered Screen");}

            public void mouseExited(MouseEvent e) {System.out.println("Mouse Exited Screen");}
        };
}
