
import java.io.*;
import java.security.*;

public class ComputeSHA 
{
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException
	{
			String complete_file=new String();
			String sCurrentLine;
 
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
 
			while ((sCurrentLine = br.readLine()) != null) {
				complete_file = complete_file.concat(sCurrentLine);
			}
			System.out.println(complete_file);

	     MessageDigest md = MessageDigest.getInstance("SHA1");

         md.update(complete_file.getBytes()); 
      	 byte[] output = md.digest();


      	 //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < output.length; i++) 
        {
          sb.append(Integer.toString((output[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        //System.out.println("Hex format : " + sb.toString());

        if (sb.toString().equals("17a23c746fed66a6f285c665422deafcf51aca40"))
        {
        	System.out.println("You computed the SHA-1 Hash correctly!");
        }
        else System.out.println("You hella stupid!");

	}

}