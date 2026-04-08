package com.yocto.yoclib.utf7;

/**
 * Constants for UTF-7.
 */
public class UTF7Constants{

    /**
     * Slash character in base 64.
     */
    public static final char BASE64_SLASH = '/';
    /**
     * Slash character replacement in IMAP-specific base 64.
     */
    public static final char BASE64_SLASH_IMAP = ',';

    /**
     * Subset for Modified Base 64.
     */
    public static final char[] SET_B = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9',
            '+','/',
    };
    /**
     * Subset for Directly encoded characters.
     */
    public static final char[] SET_D = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9',
            '\'','(',')',',','-','.','/',':','?',
    };
    /**
     * Subset for Optional direct characters.
     */
    public static final char[] SET_O = {
            '!','"','#','$','%','&','*',';','<','=','>','@','[',']','^','_','`','{','|','}',
    };

    /**
     * Shift character for UTF-7.
     */
    public static final char SHIFT = '+';
    /**
     * IMAP-specific shift character for UTF-7.
     */
    public static final char SHIFT_IMAP = '&';
    /**
     * Shift terminator character for UTF-7.
     */
    public static final char SHIFT_TERMINATOR = '-';

    private UTF7Constants(){}

}