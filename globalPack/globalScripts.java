package globalPack;
///Global Scripts

    import localPack.*;     import static globalPack.globalVar.*;
    import javax.swing.*;   import java.nio.charset.StandardCharsets;
    import java.awt.Color;  import java.awt.Dimension;
    import java.awt.Toolkit;

///---------------Public Class---------------\\\
public class globalScripts{
    ///-----------------------------------Chapter I: Game Manipulation-----------------------------------\\\
    public static void game_frame_setup() {
        gameFrame.setLayout(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set the close operation
        gameFrame.setSize(roomWidth,roomHeight); // set the size of the window
        gameFrame.setResizable(false); //if window can be resizable
        gameFrame.setLocationRelativeTo(null); //set the location of the window
        gameFrame.addKeyListener(listener_keyboard);
        gameFrame.addMouseListener(listener_mouse);
        gameFrame.getContentPane().setBackground(roomColor);
        gameFrame.setUndecorated(true);;
    }

    public static void game_frame_update(){
        gameFrame.revalidate();
        gameFrame.repaint();
        gameFrame.setVisible(true); //make the window visible
    }
    
    public static void game_frame_disable(){
        gameFrame.setVisible(false); //make the window invisible
    }

    public static void game_set_fullscreen(boolean _arg){
        gameIsFullscreen = _arg;roomIndex = RM_MENU1;
        if (_arg == true){
            gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            roomWidth =     (int)screenSize.getWidth();
            roomHeight =    (int)screenSize.getHeight();
        } 
        else if (_arg == false){
            gameFrame.setExtendedState(JFrame.NORMAL);
            roomWidth =     1080;
            roomHeight =    720;
        } 
        else
            System.out.println("/!/ Wrong Value Fullscreen Value /!/");
    }

    public static globalButton game_button_create(int _x , int _y, int _arg){
        globalButton _inst = new globalButton(_x,_y,_arg);
        instance_id.add(_inst);
        return _inst;
    }
  
    public static void game_list_clear(){
        keyTyped_List.clear();      keyPressed_List.clear();    keyReleased_List.clear();
        mouseClicked_List.clear();  mousePressed_List.clear();  mouseReleased_List.clear();
    }
    
    public static void game_exit(){
        gameIsRunning = false;
    }

    ///-----------------------------------Chapter I: Inputs-----------------------------------\\\
    public static int ord(String _char){
        byte[] b = _char.toUpperCase().getBytes(StandardCharsets.UTF_8);
        return b[0];
    }
    
    public static Boolean keyboard_check(int _key){
        if (_key == noone) if (keyTyped_List.size()==0) return true;
       if (keyTyped_List.contains(_key)){
            return true;
       } 
       return false;
    }

    public static Boolean keyboard_check_pressed(int _key){
        if (_key == noone) if (keyPressed_List.size()==0) return true;
        if (keyPressed_List.contains(_key)){
             return true;
        } 
        return false;
    }

    public static Boolean keyboard_check_released(int _key){
        if (_key == noone) if (keyReleased_List.size()==0) return true;
        if (keyReleased_List.contains(_key)){
             return true;
        } 
        return false;
    }
    
    public static Boolean mouse_button_check(int _button){
        if (_button == noone) if (mouseClicked_List.size()==0) return true;
       if (mouseClicked_List.contains(_button)){
            return true;
       } 
       return false;
    }

    public static Boolean mouse_button_check_pressed(int _button){
        if (_button == noone) if (mousePressed_List.size()==0) return true;
        if (mousePressed_List.contains(_button)){
             return true;
        } 
        return false;
    }

    public static Boolean mouse_button_check_released(int _button){
        if (_button == noone) if (mouseReleased_List.size()==0) return true;
        if (mouseReleased_List.contains(_button)){
             return true;
        } 
        return false;
    }
    
    ///-----------------------------------Chapter II: Display Observation-----------------------------------\\\
    
    public static int sprite_get_width(String _sprite){
        JLabel _label = new JLabel(); //create a label
        ImageIcon _image = new ImageIcon(_sprite);

        _label.setIcon(_image);
        Dimension _size = _label.preferredSize();
        return _size.width;
    }

    public static int sprite_get_height(String _sprite){
        JLabel _label = new JLabel(); //create a label
        ImageIcon _image = new ImageIcon(_sprite);

        _label.setIcon(_image);
        Dimension _size = _label.preferredSize();
        return _size.height;
    }

    public static int string_get_width(String _text){
        JLabel _label = new JLabel(); //create a label
        _label.setText(_text); //change the color of the label
        _label.setFont(drawFont);

        Dimension _size = _label.preferredSize();
        return _size.width;
    }

    public static int string_get_height(String _text){
        JLabel _label = new JLabel(); //create a label
        _label.setText(_text); //change the color of the label
        _label.setFont(drawFont);

        Dimension _size = _label.preferredSize();
        return _size.height;
    }

    ///-----------------------------------Chapter III: Display Manipulation-----------------------------------\\\
    public static void draw_rectangle(int _x1, int _y1, int _x2, int _y2, Color _color){
        JPanel _panel = new JPanel();                   /*Declare A New Panel*/ 
        _panel.setBackground(_color);                   /*Change Its Color*/ 
        _panel.setBounds(_x1,_y1, _x2-_x1, _y2-_y1);    /*Change Its Coordinate*/
        gameFrame.add(_panel);  /*frame  <-add to->  panel list*/  panel_id.add(_panel);
    }

    public static void draw_text(int _x, int _y, Color _color,String _text){
        JLabel _label = new JLabel();               /*Declare A New Label*/ 
        _label.setText(_text);                      /*Change Its Text*/ 
        _label.setFont(drawFont);                   /*Change Its Font*/ 
        Dimension _size = _label.preferredSize();   /*Declare Its Preffered Size*/ 
        
            if (drawHalign == 1) _x = _x-(_size.width/2);   else if (drawHalign == 2) _x = _x-_size.width;  /*Setup The Preffered Width*/ 
            if (drawValign == 1) _y = _y-(_size.height/2);  else if (drawValign == 2) _y = _y-_size.height; /*Setup The Preffered Height*/
        _label.setForeground(_color);                       /*Change Its Color*/ 
        _label.setBounds(_x,_y,_size.width,_size.height);   /*Change Its Coordinate*/
        gameFrame.add(_label);  /*frame  <-add to->  label list*/  label_id.add(_label);
    }
    
    public static void draw_sprite(String _sprite, int _x, int _y){
        JLabel _label = new JLabel(); //create a label
        ImageIcon _image = new ImageIcon(_sprite);
        _label.setIcon(_image);
        Dimension _size = _label.preferredSize();
        _label.setBounds(_x-(_size.width/2),_y-(_size.height/2),_size.width,_size.height);/*Setup The Preffered Width/Height */ 
        gameFrame.add(_label);  /*frame  <-add to->  label list*/  label_id.add(_label);
    }

    public static void draw_game_grid(){
        int gridLength = 32; int gridSpace = 8;
        for (int _Y = 0; _Y < ruleGridSize; _Y++) { for (int _X = 0; _X < ruleGridSize; _X++) {
                Rectangle rect = new Rectangle(gridLength*_X + gridSpace*_X, gridLength* _Y + gridSpace*_Y, gridLength, gridLength);
                ruleGridList[_X][_Y] = rect;
                ruleGridList[_X][_Y].draw();
            }
            
        }
    }
    
    public static void draw_game_update(){
        for (int _Y = 0; _Y < ruleGridSize; _Y++) { for (int _X = 0; _X < ruleGridSize; _X++) {
            if (ruleGridId[_X][_Y] != 0){
                    localPack.Color _color = localPack.Color.WHITE;
                    if (ruleGridId[_X][_Y] == -2)   {_color = localPack.Color.RED;}
                    if (ruleGridId[_X][_Y] == -1)   {_color = localPack.Color.BLUE;}
                    if (ruleGridId[_X][_Y] == 1)    {_color = localPack.Color.CYAN;}
                    if (ruleGridId[_X][_Y] == 2)    {_color = localPack.Color.ORANGE;}
                    if (ruleGridId[_X][_Y] == 3)    {_color = localPack.Color.GRAY;}
    
                    ruleGridList[_X][_Y].setColor(_color);ruleGridList[_X][_Y].fill();}
            }
        }
    }
    
    ///-----------------------------------Chapter IV: Events-----------------------------------\\\
    

    public static void event_generate_obstacle(){
        int obstNbr = ruleGridSize/2 + (int)(Math.random() * ruleGridSize);
        for (int i = 0; i < obstNbr; i++) {
            int targX = (int)(Math.random() * ruleGridSize);
            int targY = (int)(Math.random() * ruleGridSize);
            if (ruleGridId[targX][targY] == 0)
                ruleGridId[targX][targY] = 3;
            else
                i--;
        }
    }
    
    public static void event_generate_player(){
        playerList = new Player[2];
        for (int _playerId = 1; _playerId < 2+1; _playerId++) {
            int targX = (int)(Math.random() * ruleGridSize);
            int targY = (int)(Math.random() * ruleGridSize);
            if (ruleGridId[targX][targY] == 0){
                playerList[_playerId-1] = new Player(targX,targY);
                playerList[_playerId-1].playerId = _playerId;
                ruleGridId[targX][targY] = -_playerId;
            }
            else
                _playerId--;

        }
    }

    public static void event_game_start() {
        show_board();
        draw_game_grid();
        event_generate_obstacle();
        show_board();
        draw_game_update();

        event_generate_player();
        show_board();
        draw_game_update();
        gameIsGaming = true;
    }
    
    public static void event_game_end(int _plId){
        String[] plName = new String[3];
        plName[1] = "BLUE";plName[2] = "RED";
        if (_plId == 1) _plId = 2; else _plId = 1;

        roomIndex = RM_MENU1;Canvas.close();gameIsGaming = false;
        JOptionPane.showMessageDialog(null, "Player " + String.valueOf(_plId) +"("+ plName[_plId] + ") Won" , "InfoBox: " + "Game End Event", JOptionPane.INFORMATION_MESSAGE);
    }
  
    ///-----------------------------------Chapter V: Comfort-----------------------------------\\\
    public static Boolean boovert(Boolean _arg){
        Boolean _ret = null;
        if (_arg == true) _ret = false;
        else if (_arg == false) _ret = true;
    
        return _ret;
    }
    
    public static int intvert(int _arg){
        int _ret = -1;
        if (_arg == 1) _ret = 0;
        else if (_arg == 0) _ret = 1;
    
        return _ret;
    }
    
    public static Boolean inside(int _x, int _min, int _max){
        if (_x >= _min && _x < _max)
            return true;
    
        return false;
    }

    ///-----------------------------------Chapter ?: Debug-----------------------------------\\\

    public static void show_board(){
        for (int _Y = 0; _Y < ruleGridSize; _Y++) { for (int _X = 0; _X < ruleGridSize; _X++) {
                System.out.print(ruleGridId[_X][_Y]); System.out.print(" ");}
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }

    public static void message_show(String _message){
        JOptionPane.showMessageDialog(gameFrame, _message);
    }

    public static String message_input(String _message){
        String _str = JOptionPane.showInputDialog(gameFrame, _message);
        return _str;
    }

}

/*
public static int array_length(Object[] _arg){
    int _val = 0;
    if ( _arg != null){
        _val = _arg.length;
    }
    return _val;
}*/