package br.univille.trabalhotadss;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("trabalho");

        PopulateDB populateClientes = new PopulateDB(database.getCollection("CLIENTES"));
        populateClientes.populateClientes();

        PopulateDB populateLojas = new PopulateDB(database.getCollection("LOJAS"));
        populateLojas.populateLojas();

        PopulateDB populatePedidos = new PopulateDB(database.getCollection("PEDIDOS"));
        populatePedidos.populatePedidos();

        mongoClient.close();
    }
}