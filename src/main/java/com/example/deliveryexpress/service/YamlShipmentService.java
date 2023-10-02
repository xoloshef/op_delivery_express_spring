package com.example.deliveryexpress.service;

import com.example.deliveryexpress.model.Shipment;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class YamlShipmentService {

    public List<Shipment> readShipmentsFromYamlFile(String filePath) throws IOException {
        Yaml yaml = new Yaml();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            // Загружаем данные из файла YAML
            List<Shipment> shipments = yaml.load(inputStream);
            return shipments;
        }
    }

    public void saveShipmentsToYamlFile(List<Shipment> shipments, String filePath) throws IOException {
        Yaml yaml = new Yaml();
        // Сериализуем список отправлений в формат YAML и сохраняем в файл
        yaml.dump(shipments, new FileWriter(filePath));
    }
}