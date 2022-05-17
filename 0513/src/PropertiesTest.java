import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("age", "20");
        properties.setProperty("name", "홍길동");
        properties.setProperty("height", "182.3");
        properties.setProperty("weight", "75");

        FileInputStream in = null;
        try {
            in = new FileInputStream("info.txt");
            properties.load(in);
            System.out.println(properties.get("age"));
        }
        catch (IOException e) {
        }
        finally {
            try {
                if (in != null) in.close();
            }
            catch (IOException e){
            }
        }


    }
}
