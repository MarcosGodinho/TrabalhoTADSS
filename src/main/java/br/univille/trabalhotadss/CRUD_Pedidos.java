package br.univille.trabalhotadss;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class CRUD_Pedidos {
    private MongoCollection<Document> collection;

    public CRUD_Pedidos(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Document create(String status) {
        Document newPedido = new Document("status_pedido", status);
        collection.insertOne(newPedido);
        return newPedido;
    }

    public Document read(String status) {
        return collection.find(Filters.eq("status_pedido", status)).first();
    }

    public Document update(String status, String newStatus) {
        collection.updateOne(Filters.eq("status_pedido", status), Updates.set("status_pedido", newStatus));
        return collection.find(Filters.eq("status_pedido", newStatus)).first();
    }

    public void delete(String status) {
        Document docToDelete = collection.find(Filters.eq("status_pedido", status)).first();
        if (docToDelete != null) {
            collection.deleteOne(Filters.eq("status_pedido", status));
        }
    }
}