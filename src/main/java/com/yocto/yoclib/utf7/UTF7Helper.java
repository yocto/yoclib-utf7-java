package com.yocto.yoclib.utf7;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UTF7Helper{

    private static final Base64.Decoder DECODER = Base64.getMimeDecoder();
    private static final Base64.Encoder ENCODER = Base64.getMimeEncoder();

    public static String decodeModifiedBase64(String input){
        byte[] outputBytes = UTF7Helper.DECODER.decode(input);
        return new String(outputBytes,StandardCharsets.UTF_16BE);
    }

    public static String decodeIMAPModifiedBase64(String input){
        return UTF7Helper.decodeModifiedBase64(input.replaceAll(Character.toString(UTF7Constants.BASE64_SLASH_IMAP),Character.toString(UTF7Constants.BASE64_SLASH)));
    }

    public static String encodeModifiedBase64(String input){
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_16BE);
        return UTF7Helper.ENCODER.encodeToString(inputBytes).replaceAll("=","");
    }

    public static String encodeIMAPModifiedBase64(String input){
        return UTF7Helper.encodeModifiedBase64(input).replaceAll(Character.toString(UTF7Constants.BASE64_SLASH),Character.toString(UTF7Constants.BASE64_SLASH_IMAP));
    }

}