package lion.translateapi;

import lion.translateapi.exeptions.YandexUnsupportedLanguageException;

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
        FINNISH("Finnish", "fi"),
        GREEK("Greek", "el"),
        ICELANDIC("Icelandic", "is"),
        MALTESE("Maltese", "mt"),
        CROATIAN("Croatian", "hr"),
        CHINESE("Chinese", "zh"),
        THAI("Thai", "th"),
        LITHUANIAN("Lithuanian", "lt"),
        POLISH("Polish", "pl"),
        HUNAGRIAN("Hungarian", "hu"),
        ESTONIAN("Estonian", "et"),
        LATVIAN("Latvian", "lv"),
        ROMANIAN("Romanian", "ro"),
        CZECH("Czech", "cs"),
        SLOVAK("Slovak", "sk"),
        SLOVENIAN("Slovenian", "sl"),
        SERBIAN("Serbian", "sr"),
        MACEDONIAN("Macedonian", "mk"),
        BULGARIAN("Bulgarian", "bg"),
        UKRANIAN("Ukrainian", "uk"),
        GEORGIAN("Georgian", "ka"),
        VIETNAMESE("Vietnamese", "vi"),
        INDONESIAN("Indonesian", "id"),
        AFRIKAANS("Afrikaans","ar"),
        ALBANIAN("Albanian", "sq"),
        ARABIC("Arabic", "ar"),
        ARMENIAN("Armenian", "hy"),
        AZERBAIJANI("Azerbaijani","az"),
        BASHKIR("Bashkir","ba"),
        BASQUE("Basque","eu"),
        BELARUSIAN("Belarusian","be"),
        BENGALI("Bengali","bn"),
        BOSNIAN("Bosnian","bs"),
        CATALAN("Catalan","ca"),
        CEBUANO("Cebuano","ceb"),
        ELVIShSINDARIN("Elvish(Sindarin)","snj"),
        ESPERANTO("Esperanto","eo"),
        GALICIAN("Galician","gl"),
        GUJARATI("Gujarati","gu"),
        JAPANESE("Japanese","ja"),
        TURKISH("Turkish","tr");
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
