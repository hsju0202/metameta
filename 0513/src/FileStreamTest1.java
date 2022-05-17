import java.io.*;

public class FileStreamTest1 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream("news.txt");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("cpy_news.txt");
            bos = new BufferedOutputStream(fos);

//            int data;
//            while((data = fis.read()) != -1) {
//                fos.write(data);
//            }

            int len;
            byte[] buff = new byte[1024];
            while ((len = bis.read(buff)) > 0) {
                bos.write(buff,0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) bis.close();
                if(fos != null) bos.close();
            } catch (IOException e) {

            }
        }
    }
}
