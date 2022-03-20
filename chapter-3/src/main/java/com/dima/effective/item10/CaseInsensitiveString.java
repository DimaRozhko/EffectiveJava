package com.dima.effective.item10;

public class CaseInsensitiveString {

    private final String string;

    public CaseInsensitiveString(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString &&
                string.equalsIgnoreCase(((CaseInsensitiveString)obj).string);
    }
}
