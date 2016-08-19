package lion.translateapi;

import lion.translateapi.errors.*;

/**
 * Created by Angel on 17/08/2016.
 */
public enum  Lang {
        ENGLISH("English", "en"),
        RUSSIAN("Russian", "ru"),
        DUTCH("Dutch", "nl"),
        FRENCH("French", "fr"),
        GERMAN("German", "de"),
        ITALIAN("Italian", "it"),
        SWEEDISH("Sweedish", "sv"),
        SPANISH("Spanish", "es"),
        DANISH("Danish", "da"),
        PORTUGUESE("Portuguese", "pt"),
        HEBREW("Hebrew", "he"),
        ARABIC("Arabic", "ar"),
        FINNISH("Finnish", "fi"),
        GREEK("Greek", "el"),
        ICELANDIC("Icelandic", "is"),
        MALTESE("Maltese", "mt"),
        TURKISH("Turkish", "tr"),
        CROATIAN("Croatian", "hr"),
        CHINESE("Chinese", "zh"),
        THAI("Thai", "th"),
        LITHUANIAN("Lithuanian", "lt"),
        POLISH("Polish", "pl"),
        HUNAGRIAN("Hungarian", "hu"),
        ESTONIAN("Estonian", "et"),
        LATVIAN("Latvian", "lv"),
        ALBANIAN("Albanian", "sq"),
        ROMANIAN("Romanian", "ro"),
        CZECH("Czech", "cs"),
        SLOVAK("Slovak", "sk"),
        SLOVENIAN("Slovenian", "sl"),
        SERBIAN("Serbian", "sr"),
        MACEDONIAN("Macedonian", "mk"),
        BULGARIAN("Bulgarian", "bg"),
        UKRANIAN("Ukrainian", "uk"),
        ByeLorussian("ByeLorussion", "be"),
        AZERBAIJANI("Azerbaijani", "az"),
        ARMENIAN("Armenian", "hy"),
        GEORGIAN("Georgian", "ka"),
        VIETNAMESE("Vietnamese", "vi"),
        INDONESIAN("Indonesian", "id");
        private String name;
        private String shortName;

        private Lang(String name, String shortName) {
                this.name = name;
                this.shortName = shortName;
        }

        public String getLanguageName() {
                return this.name;
        }

        public String getShortLangName() {
                return this.shortName;
        }

        public String getTranslateString(Lang to) {
                return getTranslateString(this, to);
        }

        public static String getTranslateString(Lang from, Lang to) {
                return from.getShortLangName() + "-" + to.getShortLangName();
        }
        public static String shotName(Lang lang){
                return lang.getShortLangName();
        }
        public static Lang[] getLangs(){
                return Lang.values();
        }
        public static Lang forShortString(String s) throws YandexUnsupportedLanguageException {
                Lang[] var4;
                int var3 = (var4 = values()).length;

                for(int var2 = 0; var2 < var3; ++var2) {
                        Lang l = var4[var2];
                        if(l.getShortLangName().equals(s)) {
                                return l;
                        }
                }

                throw new YandexUnsupportedLanguageException();
        }

        public static Lang forSimilarShortString(String s) throws YandexUnsupportedLanguageException {
                Lang[] var4;
                int var3 = (var4 = values()).length;

                for(int var2 = 0; var2 < var3; ++var2) {
                        Lang l = var4[var2];
                        if(l.getShortLangName().equalsIgnoreCase(s)) {
                                return l;
                        }
                }

                throw new YandexUnsupportedLanguageException();
        }

        public static Lang forLangName(String s) throws YandexUnsupportedLanguageException {
                Lang[] var4;
                int var3 = (var4 = values()).length;

                for(int var2 = 0; var2 < var3; ++var2) {
                        Lang l = var4[var2];
                        if(l.getLanguageName().equals(s)) {
                                return l;
                        }
                }

                throw new YandexUnsupportedLanguageException();
        }

        public static Lang forSimilarLangName(String s) throws YandexUnsupportedLanguageException {
                Lang[] var4;
                int var3 = (var4 = values()).length;

                for(int var2 = 0; var2 < var3; ++var2) {
                        Lang l = var4[var2];
                        if(l.getLanguageName().equalsIgnoreCase(s)) {
                                return l;
                        }
                }

                throw new YandexUnsupportedLanguageException();
        }
}
