package org.codergirl.java.bookshelf.demos;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Sha256 {

    public static String to256(String originalString){
        //https://www.baeldung.com/sha-256-hashing-java

        String sha256hex = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

    public static void main(String [] args){
        System.out.println(to256("!2345"));
        System.out.println();

        System.out.println(to256("GoodPasswordsAreHardButCodingIsHarder"));
        System.out.println(to256("Code"));
        System.out.println(to256("Cool"));
        System.out.println(to256("Corn"));
        System.out.println(to256("Coin"));
//        System.out.println(to256("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
//                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Hac habitasse platea dictumst quisque. " +
//                "Integer eget aliquet nibh praesent. Mattis vulputate enim nulla aliquet porttitor lacus luctus " +
//                "accumsan. Massa eget egestas purus viverra accumsan in nisl. " +
//                "Porta nibh venenatis cras sed felis eget. Turpis tincidunt id aliquet risus " +
//                "feugiat. Id donec ultrices tincidunt arcu non sodales. Tincidunt eget nullam non nisi est sit amet " +
//                "facilisis magna. In fermentum posuere urna nec tincidunt. Eu scelerisque felis imperdiet proin " +
//                "fermentum leo. Mattis enim ut tellus elementum sagittis."));
    }
}
