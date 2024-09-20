## Cow Monitor - Sistema de Monitoramento de Vacas com RFID e Câmera IP

### Descrição
Este projeto visa criar um sistema para monitorar vacas utilizando tags RFID e uma câmera IP conectada via RTSP. Quando uma tag RFID é detectada, a câmera captura uma imagem da vaca e sobrepõe informações relevantes, como o ID do animal, código ECC e a data/hora da captura, na imagem.

### Tecnologias Utilizadas
- Java 17
- Maven
- GStreamer (para conexão com a câmera IP via RTSP)
- OpenCV (para processamento e manipulação de imagens)
- javax.usb (para integração com o sensor RFID via USB, ainda não implementado)

### Funcionamento
Ao iniciar o sistema, a câmera IP se conecta e aguarda a detecção de uma tag RFID.
Quando o sensor RFID detecta um animal, o sistema captura uma imagem e sobrepõe os dados do animal na foto.
As imagens são salvas localmente com as informações do ID, ECC e data/hora.
Status do Projeto
Devido à falta de equipamentos físicos (como o sensor RFID e as tags), a implementação completa do código não foi finalizada. Até o momento, foram realizados testes apenas para a conexão com a câmera IP via protocolo RTSP, com sucesso. O sensor RFID e o disparo da captura da imagem ainda não foram implementados, pois requerem hardware específico.

Dependências Principais
gstreamer-java: Para conexão e captura de vídeo via RTSP.
opencv: Para manipulação e sobreposição de dados na imagem capturada.
