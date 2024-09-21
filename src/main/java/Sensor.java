public class Sensor {
    // Simulação de leitura do sensor via USB
    // No projeto real, vamos usar a lib javax.usb para interagir com o hardware

    public String detectarTag() {
        // Simulação de detecção de uma tag RFID (ID)
        // Aqui sera implementado a leitura real do sensor RFID via USB
        return "ID_VACA_001";  // Simulando o retorno de um ID
    }

    public String obterECC() {
        return "4";
    }
}
