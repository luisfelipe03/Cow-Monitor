import org.opencv.core.Mat;

public class MainApp {
    public static void main(String[] args) {
        // Iniciar a conexão com a câmera RTSP
        CameraRTSP camera = new CameraRTSP("rtsp://192.168.0.100:554/stream");

        // Inicializar o sensor RFID
        Sensor sensor = new Sensor();

        while (true) {
            // Detectar a tag RFID
            String id = sensor.detectarTag();
            String ecc = sensor.obterECC();

            // Simular captura de um frame
            BufferedImage imagem = camera.capturarFrame();  // Captura o frame da câmera

            if (imagem != null) {
                // Converter a imagem para o formato OpenCV Mat
                Mat matImagem = Sobreposicao.bufferedImageToMat(imagem);

                // Sobrepor os dados na imagem (ID, ECC, data)
                Sobreposicao.sobreporDados(matImagem, id, ecc);

                // Salvar a imagem com os dados sobrepostos
                Sobreposicao.salvarImagem(matImagem, "vaca_" + id + ".png");
            }
        }
    }
}
