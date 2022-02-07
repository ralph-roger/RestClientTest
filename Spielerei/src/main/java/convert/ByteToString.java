package convert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ByteToString {

    public static void main(String[] args) {
    	
    	//https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/
    	
    	// CONVERT TEXTDATA

        String example = "This is raw text!";
        // string to byte[]
        byte[] bytes = example.getBytes();

        System.out.println("Text : " + example);
        System.out.println("Text [Byte Format] : " + bytes);

        // no, don't do this, it returns like before the address of the object in memory 
        System.out.println("Text [Byte Format] toString() : " + bytes.toString());

        // convert byte[] to string
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("Output : " + s);


     // CONVERT Binary Data 

        String filepath = "/home/mkyong/phone.png";
        try {
            byte[] bytes1 = Files.readAllBytes(Paths.get(filepath));

            // readable string that encoded in base64, easy transfer as a string

            // byte[] to base64 string
            String s1 = Base64.getEncoder().encodeToString(bytes1);
            System.out.println(s1);

            // base64 string to byte[]
            byte[] decode = Base64.getDecoder().decode(s1);
            Files.write(Paths.get("/home/mkyong/phone2.png"), decode);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}