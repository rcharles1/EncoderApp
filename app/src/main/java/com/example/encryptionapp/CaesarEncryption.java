package com.example.encryptionapp;

public class CaesarEncryption {

    public static String encrypt(String plaintext) {

        StringBuilder Ciphertext = new StringBuilder();
        int length = plaintext.length();

        for(int i=0; i<length;i++){
            char ch = plaintext.charAt(i);
            if(Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + 3);
                    if(c>'z'){
                        Ciphertext.append((char) (ch - (26 - 3)));
                    }
                    else{
                        Ciphertext.append(c);
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + 3);
                    if(c>'Z'){
                        Ciphertext.append((char) (ch - (26 - 3)));
                    }
                    else{
                        Ciphertext.append(c);
                    }
                }
            }
            else{
                Ciphertext.append(ch);
            }
        }
        return Ciphertext.toString();
    }

}



