public class Sensor {
    // Simulação de leitura do sensor via USB
    // No projeto real, você usaria javax.usb para interagir com o hardware

    public String detectarTag() {
        // Simulação de detecção de uma tag RFID (ID e ECC)
        // Aqui você deve implementar a leitura real do sensor RFID via USB
        return "ID_VACA_001";  // Simulando o retorno de um ID
    }

    public String obterECC() {
        return "ECC123";  // Simulando o retorno de um código ECC
    }
}
