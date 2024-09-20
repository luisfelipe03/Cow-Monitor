import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;
import java.awt.image.BufferedImage;

public class Sobreposicao {

    // Converte BufferedImage para OpenCV Mat
    public static Mat bufferedImageToMat(BufferedImage bi) {
        Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }

    // Sobrepõe ID, ECC e data na imagem
    public static void sobreporDados(Mat imagem, String id, String ecc) {
        String data = new java.util.Date().toString();
        Imgproc.putText(imagem, "ID: " + id, new Point(10, 30), Imgproc.FONT_HERSHEY_SIMPLEX, 1.0, new Scalar(255, 255, 255), 2);
        Imgproc.putText(imagem, "ECC: " + ecc, new Point(10, 60), Imgproc.FONT_HERSHEY_SIMPLEX, 1.0, new Scalar(255, 255, 255), 2);
        Imgproc.putText(imagem, "Data: " + data, new Point(10, 90), Imgproc.FONT_HERSHEY_SIMPLEX, 1.0, new Scalar(255, 255, 255), 2);
    }

    // Método para salvar a imagem em um arquivo
    public static void salvarImagem(Mat imagem, String caminho) {
        Imgcodecs.imwrite(caminho, imagem);
    }
}
