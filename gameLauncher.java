///Game Launcher
    import globalPack.*;
    import static globalPack.globalVar.*;import static globalPack.globalScripts.*;import static globalPack.globalRoom.*;


///---------------Public Class---------------\\\
public class gameLauncher{
    public static void main(String[] args) throws InterruptedException {
        ///------------------Game Start Event------------------\\\
        game_frame_setup();
            while(gameIsRunning){
                globalUpdate();
                //------------Events-----------\\\
                /*Room Events*/     if (roomIndex != roomLast) room_create_event(); room_step_event();

                /*Button Events*/   for(globalButton _index:instance_id) _index.button_selection(); 

                /*Game Events*/     if (gameIsGaming==true){for(int i = 0;i<2;i++){playerList[i].player_movement();if (gameIsGaming==true) draw_game_update(); else break;}}
                else game_frame_update();

                game_list_clear();Thread.sleep(1);/*Cleanup Events*/
            }

            ///------------------Game End Event------------------\\\
            gameFrame.setVisible(false);
            System.exit(0);
    }
}