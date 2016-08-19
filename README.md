# TranslateAPI
for Nukkit :)

## How To

#### Get Api key:
enter on this [page](https://tech.yandex.com/keys/get/?service=trnsl) (important: register before :v)
#### Use Api:
```java
import cn.nukkit.plugin.*;
import lion.translateapi;

//I don't have to :v
import lion.translateapi.errors.*;

public class example extends PluginBase{
    TranslateAPI api;
    @Override
    void onEnable(){
        this.api=new TranslateAPI("yourKey");
        this.getLogger.info("example loaded!")
    }
    @Override
    boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        case "translate":
            sender.sendMessage(TranslateAuto(args[0],args[1]));
        break;
    }
    string TranslateAuto(String text,Lang lang){
        try{
        //get auto the lang of the string ,return string
            return this.api.translateAuto(lang,text);
        }
        catch(IOExeption e){
            return e.toString();
        }
        return null;
    }
    String Translate(String text,Lang lang,Lang to){
        try{
        //return string
            return this.api.translate(lang,to,text);
        }
        catch(IOExeption e){
            return e.toString();
        }
        return null;
    }
}
```
