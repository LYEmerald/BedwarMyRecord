package net.endlight.record;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase {

     @Override
    public void onEnable() {
         this.getLogger().info(TextFormat.GREEN + "MyRecord Plugin Enabled!");
         this.getServer().getCommandMap().register("my",new MyCommand());
     }

}
