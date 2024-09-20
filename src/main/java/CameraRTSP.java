import org.freedesktop.gstreamer.*;
import org.freedesktop.gstreamer.elements.AppSink;
import org.freedesktop.gstreamer.elements.PlayBin;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CameraRTSP {
    private PlayBin playbin;
    private AppSink appsink;

    public CameraRTSP(String rtspUrl) {
        Gst.init("CameraRTSP", new String[]{});

        // Inicializar PlayBin para o fluxo RTSP
        playbin = new PlayBin("VideoPlayer");
        playbin.setURI(URI.create(rtspUrl));

        // Criar o AppSink para capturar os frames de vídeo
        appsink = new AppSink("AppSink");
        appsink.set("emit-signals", true);
        appsink.connect(new AppSink.NEW_SAMPLE() {
            @Override
            public FlowReturn newSample(AppSink elem) {
                // Aqui é onde o frame será processado
                Sample sample = elem.pullSample();
                Buffer buffer = sample.getBuffer();
                try {
                    BufferedImage imagem = bufferParaImagem(buffer);
                    processarImagem(imagem);  // Salva ou processa a imagem
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return FlowReturn.OK;
            }
        });
        playbin.setVideoSink(appsink);
        playbin.play();
    }

    public BufferedImage bufferParaImagem(Buffer buffer) throws IOException {
        ByteBuffer byteBuffer = buffer.map(false);
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        return ImageIO.read(new ByteArrayInputStream(bytes));
    }

    public void stop() {
        playbin.stop();
    }

    // Este método pode ser modificado para processar os dados
    private void processarImagem(BufferedImage imagem) {
        // Método para processar ou salvar a imagem
    }
}
