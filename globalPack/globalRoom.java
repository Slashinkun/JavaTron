package globalPack;
///Global Rooms


    import localPack.*;
    import static globalPack.globalVar.*;import static globalPack.globalButton.*;import static globalPack.globalScripts.*;
    import javax.swing.JOptionPane;

///---------------Public Class---------------\\\
public class globalRoom {
        ///--------------------------------------Room Events--------------------------------------
        public static void room_create_event() {instance_id.clear();
            switch(roomIndex)
            {
                case(RM_MENU1):  
                game_button_create(roomWidth/2,roomHeight/2, Obj_Button_Play );
                game_button_create(roomWidth/2,roomHeight/2+100,     Obj_Button_Settings );
                game_button_create(roomWidth/2,roomHeight/2+200, Obj_Button_Quit );
                break;
    
                ///Main2 Room
                case(RM_MENU2):  
                    game_button_create(roomWidth/2,roomHeight/2, Obj_Button_Play_Solo );
                    game_button_create(roomWidth/2,roomHeight/2+100,     Obj_Button_Play_Duo );
                    game_button_create(roomWidth/2,roomHeight/2+200, Obj_Button_Play_Back );
                break;
    
                ///Game1 Room
                case(RM_GAME1):  
                
                break;
                
                ///Game2 Room
                case(RM_GAME2):  
                    ruleGridSize = Integer.parseInt(JOptionPane.showInputDialog("Give Board Length"));
                    ruleGridId = new int [ruleGridSize][ruleGridSize];
                    ruleGridList = new Rectangle [ruleGridSize][ruleGridSize];
                    game_frame_disable();
                    event_game_start();
                break;
    
                ///Game2 Room
                case(RM_SETTINGS):  
                    game_button_create(roomWidth/2,roomHeight/2+200, Obj_Button_Settings_Fullscreen);
                break;
    
                ///Default
                default: message_show("Critical Error : Selected Room Not Recognised"); break;
            }roomLast = roomIndex;
        }
    
        public static void room_step_event() {
            switch(roomIndex)
            {
                ///Menu1 Room
                case(RM_MENU1):
                    draw_sprite(SPR_TRON,roomWidth/2,roomHeight/2-roomHeight/3);
                break;
    
                 ///Menu2 & Settings Room 
                case(RM_MENU2):  case(RM_SETTINGS):  
                    draw_sprite(SPR_TRON,roomWidth/2,roomHeight/2-roomHeight/3);
                    if (mouse_button_check_pressed(MB_RIGHT) || keyboard_check_pressed(VK_ESCAPE)) roomIndex = RM_MENU1;
                break;
    
                ///Game1 Room
                case(RM_GAME1):  
                
                break;
                
                ///Game2 Room
                case(RM_GAME2):  
                break;
            }
    
            draw_text(roomWidth-50,roomHeight-25, C_WHITE,Integer.toString(gameSpeed));
            if (keyboard_check_pressed(VK_CONTROL)){
                game_exit();
            }
    }
}
