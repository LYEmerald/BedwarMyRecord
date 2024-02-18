package net.endlight.record;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.window.FormWindowSimple;
import org.sobadfish.bedwar.BedWarMain;
import org.sobadfish.bedwar.player.PlayerData;

public class MyCommand extends Command {

    static int MyRecord = 0x346bc;

    public MyCommand() {
        super("my","MyRecord Command");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {
        if (strings.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                this.sendMyRecord(player);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void sendMyRecord(Player player) {
        PlayerData data = BedWarMain.getDataManager().getData(player.getName());
        FormWindowSimple simple = new FormWindowSimple("起床战争战绩统计",
                "§f玩家名称§a  " + player.getName() + "\n" +
                "§f游戏等级§a  " + data.getLevelString() + "\n" +
                "§f游戏经验§a  " + data.getExpString(data.getExp()) + "\n" +
                "§f游戏数§a  " + data.getFinalData(PlayerData.DataType.GAME) + "\n" +
                "§f胜利数§a  " + data.getFinalData(PlayerData.DataType.VICTORY) + "\n" +
                "§f击杀数§a  " + data.getFinalData(PlayerData.DataType.KILL) + "\n" +
                "§f破坏床数§a  " + data.getFinalData(PlayerData.DataType.BED_BREAK));
        player.showFormWindow(simple,MyRecord);
    }
}
