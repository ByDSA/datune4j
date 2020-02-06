package es.danisales.datune;

import es.danisales.datune.cultural.OccidentalCulture;
import es.danisales.datune.lang.Language;
import es.danisales.datune.cultural.Cultural;

public class GlobalSettings {
    private Language language;
    private Cultural cultural;

    private static GlobalSettings globalSettings;

    private GlobalSettings() {
        language = Language.EN;
        cultural = OccidentalCulture.singleton();
    }

    public static GlobalSettings sigleton() {
        if (globalSettings == null)
            globalSettings = new GlobalSettings();

        return globalSettings;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Cultural getCultural() {
        return cultural;
    }

    public void setCultural(Cultural cultural) {
        this.cultural = cultural;
    }
}
