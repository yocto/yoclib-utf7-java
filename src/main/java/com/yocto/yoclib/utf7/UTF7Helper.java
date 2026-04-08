package com.yocto.yoclib.utf7;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Helper functions for encoding and decoding UTF-7.
 */
public final class UTF7Helper{

    private static final Base64.Decoder DECODER = Base64.getMimeDecoder();
    private static final Base64.Encoder ENCODER = Base64.getMimeEncoder();

    private UTF7Helper(){}

    /**
     * Decode modified base 64.
     * @param input The input string.
     * @return The output string.
     */
    public static String decodeModifiedBase64(String input){
        byte[] outputBytes = UTF7Helper.DECODER.decode(input);
        return new String(outputBytes,StandardCharsets.UTF_16BE);
    }

    /**
     * Decode IMAP-specific modified base 64.
     * @param input The input string.
     * @return The output string.
     */
    public static String decodeIMAPModifiedBase64(String input){
        return UTF7Helper.decodeModifiedBase64(input.replace(UTF7Constants.BASE64_SLASH_IMAP,UTF7Constants.BASE64_SLASH));
    }

    /**
     * Encode modified base 64.
     * @param input The input string.
     * @return The output string.
     */
    public static String encodeModifiedBase64(String input){
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_16BE);
        return UTF7Helper.ENCODER.encodeToString(inputBytes).replace("=","");
    }

    /**
     * Encode IMAP-specific modified base 64.
     * @param input The input string.
     * @return The output string.
     */
    public static String encodeIMAPModifiedBase64(String input){
        return UTF7Helper.encodeModifiedBase64(input).replace(UTF7Constants.BASE64_SLASH,UTF7Constants.BASE64_SLASH_IMAP);
    }

}