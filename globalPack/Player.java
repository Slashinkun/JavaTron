///Global Player
package globalPack;

    import static globalPack.globalVar.*;import static globalPack.globalScripts.*;
    import javax.swing.JOptionPane;


///---------------Public Class---------------\\\
public class Player {
    int posX;
    int posY;
    public int playerId;

    
    public Player(int posX,int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void player_movement(){
        String[] plName = new String[3];
        plName[1] = "BLUE";plName[2] = "RED";
        String strEnter = (JOptionPane.showInputDialog("Enter "+ plName[playerId] +" Player Movement(ZQSD)"));
        int playerGotoX = 0;int playerGotoY = 0;

        switch(strEnter.toLowerCase()){
            case("z"):
                playerGotoY --;
            break;

            case("q"):
                playerGotoX --;
            break;

            case("s"):
                playerGotoY ++;
            break;

            case("d"):
                playerGotoX ++;
            break;

            default:
                System.out.println("/!/ Wrong Value, Please Enter Player Movement(ZQSD) /!/");
                this.player_movement();
            break;
        }
        if(playerGotoX != 0 || playerGotoY != 0){
            if (posX+playerGotoX > -1 && posY+playerGotoY > -1 && posX+playerGotoX < ruleGridSize && posY+playerGotoY < ruleGridSize){
                if (ruleGridId[posX+playerGotoX][posY+playerGotoY] == 0){
                    ruleGridId[posX][posY] = playerId;
                    posX += playerGotoX;
                    posY += playerGotoY;
                    ruleGridId[posX][posY] = -playerId;
                }else{
                    event_game_end(playerId);
                }
            } else{
                event_game_end(playerId);
            }
        }
    }

    ///Main Part
    public static void main(String[] args) {
        
    }
}
