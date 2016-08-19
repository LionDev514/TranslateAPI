package lion.translateapi;
import java.lang.reflect.Array;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lion.translateapi.errors.*;

import javax.net.ssl.HttpsURLConnection;

public class TranslateAPI extends PluginBase {
    String API_KEY;
    boolean enabled;
    TranslateAPI instance;

    public TranslateAPI(String API_KEY) {
        this.API_KEY=API_KEY;
        this.enabled=true;
        instance=this;
    }

    public String translate(Lang from, Lang to, String text)throws YandexException, MalformedURLException, IOException {
        if(getInstance().enabled!=true) {
            return text;
        }
        else {
            JsonElement resp = this.getJSONResponse(this.getTranslateUrl(from, to, text));
            if(resp == null) {
                throw new YandexUnknownException();
            } else {
                JsonObject ob = resp.getAsJsonObject();
                if(!ob.has("code")) {
                    throw new YandexUnknownException();
                } else {
                    int code = ob.get("code").getAsInt();
                    if(code == 200) {
                        if(!ob.has("text")) {
                            throw new YandexUnknownException();
                        } else {
                            return ob.get("text").getAsString();
                        }
                    } else {
                        this.throwException(code);
                        return "";
                    }
                }
            }
        }
    }
    public String translateAuto(Lang to,String text)throws YandexException, MalformedURLException, IOException{
        if(getInstance().enabled!=true) {
            return text;
        }
        else {
            JsonElement resp = this.getJSONResponse(this.getTranslateUrl(this.getLang(text), to, text));
            if(resp == null) {
                throw new YandexUnknownException();
            } else {
                JsonObject ob = resp.getAsJsonObject();
                if(!ob.has("code")) {
                    throw new YandexUnknownException();
                } else {
                    int code = ob.get("code").getAsInt();
                    if(code == 200) {
                        if(!ob.has("text")) {
                            throw new YandexUnknownException();
                        } else {
                            return ob.get("text").getAsString();
                        }
                    } else {
                        this.throwException(code);
                        return "";
                    }
                }
            }
        }
    }
    public JsonElement getJSONResponse(String url) throws MalformedURLException, IOException {
        String s = this.getResponse(url);
        return (new JsonParser()).parse(s);
    }
    private String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is, "UTF-8");
        s.useDelimiter("\\A");

        try {
            String e = s.hasNext()?s.next():"";
            s.close();
            return e;
        } catch (Exception var4) {
            s.close();
            return "";
        }
    }
    private String urlEncode(String s) {
        String urlEncodedMsg;
        try {
            urlEncodedMsg = URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException var4) {
            System.out.println("Unsupported URL encoding for this platform: UTF-8");
            return null;
        }

        return urlEncodedMsg.replace("%20", "+");
    }
    private String getTranslateUrl(String langString, String toTranslate) {
        StringBuilder base = new StringBuilder("https://translate.yandex.net/api/v1.5/tr.json/translate?key=");
        base.append(this.urlEncode(this.API_KEY));
        base.append("&lang=");
        base.append(this.urlEncode(langString));
        base.append("&text=");
        base.append(this.urlEncode(toTranslate));
        return base.toString();
    }
    private String getTranslateUrl(Lang from, Lang to, String toTranslate) {
        return this.getTranslateUrl(Lang.getTranslateString(from, to), toTranslate);
    }
    public String debugMsg(Object msg){
        if((boolean)this.getConfig().get("debug")==true) {return msg.toString();}
        return null;
    }
    public String getResponse(String url) throws MalformedURLException, IOException, YandexException {
        URLConnection con = (new URL(url)).openConnection();
        con.setUseCaches(true);
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        con.connect();
        int response;
        if(con instanceof HttpURLConnection) {
            HttpURLConnection in = (HttpURLConnection)con;
            response = in.getResponseCode();
            if(response != 200) {
                this.throwException(response);
            }
        }

        if(con instanceof HttpsURLConnection) {
            HttpsURLConnection in1 = (HttpsURLConnection)con;
            response = in1.getResponseCode();
            if(response != 200) {
                this.throwException(response);
            }
        }

        InputStream in2 = con.getInputStream();
        String response1 = this.convertStreamToString(in2);
        in2.close();
        return response1;
    }
    private String toStr(Object obj){
        return obj.toString();
    }
        private void throwException(int code) throws YandexException {
            if(code == 401) {
                throw new YandexInvalidKeyException();
            } else if(code == 402) {
                throw new YandexBlockedKeyException();
            } else if(code == 403) {
                throw new YandexRequestLimitExceededException();
            } else if(code == 404) {
                throw new YandexCharLimitExceededException();
            } else if(code == 413) {
                throw new YandexTextToolongException();
            } else if(code == 422) {
                throw new YandexUnprocessableTextException();
            } else if(code != 501 && code != 400) {
                throw new YandexUnknownException(code);
            } else {
                throw new YandexUnsupportedLanguageException();
            }
        }
    public Lang getLang(String text) throws YandexUnsupportedLanguageException, YandexException, MalformedURLException, IOException {
        if(getInstance().enabled!=true) {
            return Lang.ENGLISH;
        } else {
            JsonElement resp = this.getJSONResponse(this.getDetectUrl(text));
            if(resp == null) {
                throw new YandexUnknownException();
            } else {
                JsonObject ob = resp.getAsJsonObject();
                if(!ob.has("code")) {
                    throw new YandexUnknownException();
                } else {
                    int code = ob.get("code").getAsInt();
                    if(code == 200) {
                        if(!ob.has("lang")) {
                            throw new YandexUnknownException();
                        } else {
                            return Lang.forShortString(ob.get("lang").getAsString());
                        }
                    } else {
                        this.throwException(code);
                        return Lang.ENGLISH;
                    }
                }
            }
        }
    }
    private String getDetectUrl(String toTranslate) {
        StringBuilder base = new StringBuilder("https://translate.yandex.net/api/v1.5/tr.json/detect?key=");
        base.append(this.urlEncode(this.API_KEY));
        base.append("&text=");
        base.append(this.urlEncode(toTranslate));
        return base.toString();
    }

    /**
     * Not use please :v
     * @return TranslateAPI
     */
    public TranslateAPI getInstance(){
        return this.instance;
    }
}

