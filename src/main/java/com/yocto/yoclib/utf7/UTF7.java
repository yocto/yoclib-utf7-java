package com.yocto.yoclib.utf7;

public class UTF7{

    public static String decodeIMAP(String input){
        StringBuilder sb = new StringBuilder();
        int shiftIndex = -1;
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c==UTF7Constants.SHIFT_IMAP && shiftIndex==-1){
                shiftIndex = i;
                continue;
            }
            if(c==UTF7Constants.UNSHIFT && shiftIndex!=-1){
                if(shiftIndex+1==i){
                    sb.append(UTF7Constants.SHIFT_IMAP);
                }else{
                    sb.append(UTF7Helper.decodeIMAPModifiedBase64(input.substring(shiftIndex+1,i)));
                }
                shiftIndex = -1;
                continue;
            }
            if(shiftIndex==-1){
                sb.append(c);
            }
        }
        if(shiftIndex!=-1){
            throw new RuntimeException("String terminated in wrong mode.");
        }
        return sb.toString();
    }

    public static String encodeIMAP(String input){
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if((c>=0x20 && c<=0x25) || (c>=0x27 && c<=0x7E)){
                // Printable
                sb.append(c);
                continue;
            }
            sb.append(UTF7Constants.SHIFT_IMAP);
            if(c!=UTF7Constants.SHIFT_IMAP){
                StringBuilder subSB = new StringBuilder();
                while(i<chars.length){
                    c = chars[i];
                    if((c>=0x20 && c<=0x25) || (c>=0x27 && c<=0x7E) || c==UTF7Constants.SHIFT_IMAP){
                        i--;
                        break;
                    }
                    i++;
                    subSB.append(c);
                }

                sb.append(UTF7Helper.encodeIMAPModifiedBase64(subSB.toString()));
            }
            sb.append(UTF7Constants.UNSHIFT);
        }
        return sb.toString();
    }

}