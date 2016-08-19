package lion.translateapi;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import lion.translateapi.errors.YandexUnsupportedLanguageException;

import java.io.IOException;
import java.util.*;


public class Main extends PluginBase {
    @Override
    public void onEnable(){
        this.getLogger().notice(TextFormat.GREEN+"Loaded Yandex Translation Api for Nukkit by: _Lion");
    }
    @Override
    public void onDisable(){
        this.getLogger().notice(TextFormat.RED+"Disabled Yandex Translation Api for Nukkit by: _Lion");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        switch (command.getName()){
            case "translate":
                if(args.length<2){
                    //sender.sendMessage(TextFormat.RED+"Usage: "+command.getUsage());
                    return false;
                }
                String msg=String.join(" ",args);
                msg=msg.replace(args[0],"");
                try {
                    sender.sendMessage(new TranslateAPI(this.getConfig().get("API_KEY").toString()).translateAuto(Lang.forSimilarShortString(args[0]),msg));
                } catch (IOException e) {
                    sender.sendMessage(e.toString());
                }
                break;
            case "getLangs":
                String[] str;
                Lang[] langs=Lang.getLangs();
                str=new String[langs.length];
                for (int i=0;i<str.length;i++){
                    str[i]=TextFormat.AQUA+langs[i].getLanguageName()+": "+langs[i].getShortLangName();
                }
                sender.sendMessage(String.join("\n",str));
                break;
        }
        return true;
    }
}
