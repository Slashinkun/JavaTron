///Objects
package globalPack;

    import static globalPack.globalVar.*;import static globalPack.globalScripts.*;
    
    import java.awt.Color;


///---------------Public Class---------------\\\
public class globalButton {

    ///Variable Declarations
    private int nameId = -1;
    private String nameDisplay = "";

    private int x = -1;
    private int y = -1;

    String sprite_index         = "";
    private int sprite_ubox     = -1;
    private int sprite_dbox     = -1;
    private int sprite_lbox     = -1;
    private int sprite_rbox     = -1;
    
    private Color colorDull     = C_WHITE;
    private Color colorSelected = C_RED;
    
    ///Room Buttons
        //Main Room
        public final static int Obj_Button_Play = 1;
        public final static int Obj_Button_Settings = 2;
        public final static int Obj_Button_Quit = 3;
        
        //Main2 Room
        public final static int Obj_Button_Play_Solo = 4;
        public final static int Obj_Button_Play_Duo = 5;
        public final static int Obj_Button_Play_Back = 6;
        
        //Settings Room
        public final static int Obj_Button_Settings_Fullscreen = 7;
        

    ///----------------------------------Create Event----------------------------------\\\
    public globalButton(int _x, int _y, int _name) {System.out.println("Entity : " + _name + " Created");x= _x; y=_y; nameId = _name; 
        switch(nameId)
        {   
            case(Obj_Button_Play):                  nameDisplay = "Play";               break;
            case(Obj_Button_Settings):              nameDisplay = "Settings";           break;
            case(Obj_Button_Quit):                  nameDisplay = "Leave Game";         break;
            case(Obj_Button_Play_Solo):             nameDisplay = "Solo Vs AI";         break;
            case(Obj_Button_Play_Duo):              nameDisplay = "Player Vs Player";   break;
            case(Obj_Button_Play_Back):             nameDisplay = "Back";               break;
            case(Obj_Button_Settings_Fullscreen):   nameDisplay = "Fullscreen : " + Boolean.toString(gameIsFullscreen); break;
            
            default: message_show("Button Name Unrecognised"); break;
        }
    }

    ///----------------------------------Step Events----------------------------------\\\
    public void button_selection(){
        if (sprite_index != "") {draw_sprite(sprite_index, x, y);sprite_ubox = y-sprite_get_height(sprite_index)/2;sprite_dbox = y+sprite_get_height(sprite_index)/2; sprite_lbox = x-sprite_get_width(sprite_index)/2; sprite_rbox = x+sprite_get_width(sprite_index)/2;}
        else {sprite_ubox = y-string_get_height(nameDisplay)/2;sprite_dbox = y+string_get_height(nameDisplay)/2;sprite_lbox = x-string_get_width(nameDisplay)/2;sprite_rbox = x+string_get_width(nameDisplay)/2;};
        Color _color = colorDull;

        if (inside(mouse_y, sprite_ubox, sprite_dbox) && inside(mouse_x, sprite_lbox, sprite_rbox)){
            _color = colorSelected;
            if (keyboard_check_pressed(VK_SPACE) || keyboard_check_pressed(VK_ENTER) || mouse_button_check_pressed(MB_LEFT)){
                button_triggered();
            }
        }

        draw_text(x,y,_color,nameDisplay);
    } 

    public void button_triggered(){
        switch(nameId){
            case(Obj_Button_Play):                  roomIndex = RM_MENU2;                               break;
            case(Obj_Button_Settings):              roomIndex = RM_SETTINGS;                            break;
            case(Obj_Button_Quit):                  game_exit();                                         break;
            case(Obj_Button_Play_Solo):             roomIndex = RM_GAME1;                               break;
            case(Obj_Button_Play_Duo):              roomIndex = RM_GAME2;                               break;
            case(Obj_Button_Play_Back):             roomIndex = RM_MENU1;                               break;
            case(Obj_Button_Settings_Fullscreen):   game_set_fullscreen(boovert(gameIsFullscreen));   break;
        }
    }
}
