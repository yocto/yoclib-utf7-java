package com.yocto.yoclib.utf7.tests;

import com.yocto.yoclib.utf7.UTF7Helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UTF7HelperTest{

    @Test
    public void testDecodeModifiedBase64(){
        assertEquals("ﳼﳼﳼﳼ",UTF7Helper.decodeModifiedBase64("/Pz8/Pz8/Pw"));
    }

    @Test
    public void testDecodeIMAPModifiedBase64(){
        assertEquals("ﳼﳼﳼﳼ",UTF7Helper.decodeIMAPModifiedBase64(",Pz8,Pz8,Pw"));
    }

    @Test
    public void testEncodeModifiedBase64(){
        assertEquals("/Pz8/Pz8/Pw",UTF7Helper.encodeModifiedBase64("ﳼﳼﳼﳼ"));
    }

    @Test
    public void testEncodeIMAPModifiedBase64(){
        assertEquals(",Pz8,Pz8,Pw",UTF7Helper.encodeIMAPModifiedBase64("ﳼﳼﳼﳼ"));
    }

}