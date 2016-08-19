# TranslateAPI
for nukkit :)

## How-To

#### Get Api key:
enter on this [page](https://tech.yandex.com/keys/get/?service=trnsl) (important: register before :v)
#### Use Api:
```java
import cn.nukkit.plugin.*;
import lion.translateapi;
import lion.translateapi.errors.*;
public class example extends PluginBase{
    TranslateAPI api;
    @Override
    void onEnable(){
        this.api=new TranslateAPI("yourKey");
        this.getLogger.info("example loaded!")
    }
    void TranslateAuto(String text,Lang lang){
        try{
        //get auto the lang of the string ,return string
            this.api.translateAuto(lang,text);
        }
        catch(IOExeption e){
            //code here :v
        }
    }
    void Translate(String text,Lang lang,Lang to){
        try{
        //return string
            this.api.translate(lang,to,text);
        }
        catch(IOExeption e){
            //code here :v
        }
    }
}
```