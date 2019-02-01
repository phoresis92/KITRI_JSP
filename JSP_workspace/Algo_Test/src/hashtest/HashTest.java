package hashtest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTest {
    public static void main(String[] args) {
        String str = "ktko";
        String hashStr = createHash("ktko");
        System.out.println("str : " + str + ", hashStr : " + hashStr);
        
        System.out.println(hashStr.equals(createHash(str)));
        
    }
 
    public static String createHash(String str) {
        String hashString = "";
        try {
            // MD2, MD4, MD5, SHA-1, SHA-256, SHA-512
            MessageDigest sh = MessageDigest.getInstance("SHA-512");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashString = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            hashString = null;
        }
        return hashString;
    }
}


