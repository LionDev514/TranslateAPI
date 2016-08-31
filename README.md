# TranslateAPI
for Nukkit :-)
> Powered by Yandex.Translate, More Information [here](https://tech.yandex.com/translate/doc/dg/concepts/About-docpage/)

## How To

#### Get Api key:
enter on this [page](https://tech.yandex.com/keys/get/?service=trnsl)
#### Use Api:
>Example Plugin:

```java
import cn.nukkit.plugin.*;
import lion.translateapi.*;

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
    String TranslateAuto(String text,Lang lang){
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
