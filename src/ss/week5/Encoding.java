package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 */
public class Encoding {
    public static void main(String[] args) throws DecoderException {
        String input = "4d6f64756c652032";
        byte[] bytesarray = Hex.decodeHex(input);
        String result = new String(bytesarray);
        System.out.println(result.toCharArray());

        String input1 = "Hello World";
        byte [] result1 = encodeBase64(input1.getBytes());
        System.out.println(new String(result1));

        String hex = "010203040506";
        byte [] hexarr = Hex.decodeHex(hex);
        byte[] hexarr1 = encodeBase64(hexarr);
        System.out.println(new String(hexarr1));

        String s = "U29mdHdhcmUgRGV2ZWxvcG1lbnQ=";
        byte[] s1 = decodeBase64(s);
        System.out.println(new String(s1));

        String a = "";
        for (int i =0; i<10; i++){
            a += "a";
            byte[] as = encodeBase64(a.getBytes());
            System.out.println(new String(as));
        }
    }
}
