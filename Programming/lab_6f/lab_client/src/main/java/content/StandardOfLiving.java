package content;

import exceptions.InvalidParameterException;
import util.IOManager;

public enum StandardOfLiving {
    VERY_HIGH,
    MEDIUM,
    ULTRA_LOW,
    NIGHTMARE;

    public static StandardOfLiving prompt() {
        return (StandardOfLiving) IOManager.enumPrompt(StandardOfLiving.values(), "Цвет волос", " ");
    }

    public static StandardOfLiving parse(String str) throws InvalidParameterException {
        if (str.equals("null")) {
            return null;
        }
        try {
            return StandardOfLiving.valueOf(str);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("Нет такого варианта");
        }
    }
}

