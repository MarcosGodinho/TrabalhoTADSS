package br.univille.trabalhotadss;

import org.bson.Document;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.List;

public class PopulateDB {
    private MongoCollection<Document> collection;

    public PopulateDB(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void populateClientes() {
        List<Document> clientes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Document cliente = new Document("EMAIL", "email" + i + "@example.com")
                    .append("NOME_INTEIRO", "Nome " + i);
            clientes.add(cliente);
        }
        collection.insertMany(clientes);
    }

    public void populateLojas() {
        List<Document> lojas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Document loja = new Document("ENDERECO_WEB", "ENDEREÇO" + i)
                    .append("ENDERECO_FISICO", "ENDEREÇO" + i);
            lojas.add(loja);
        }
        collection.insertMany(lojas);
    }

    public void populatePedidos() {
        List<Document> pedidos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Document pedido = new Document("STATUS_PEDIDO", "STATUS");
            pedidos.add(pedido);
        }
        collection.insertMany(pedidos);
    }
}