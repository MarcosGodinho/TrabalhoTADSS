package br.univille.trabalhotadss;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class CRUD_Clientes {
    private MongoCollection<Document> collection;

    public CRUD_Clientes(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Document create(String email, String nome) {
        Document newCliente = new Document("EMAIL", email)
                .append("NOME_INTEIRO", nome);
        collection.insertOne(newCliente);
        return newCliente;
    }

    public Document read(String email) {
        return collection.find(Filters.eq("EMAIL", email)).first();
    }

    public Document update(String email, String newEmail, String newNome) {
        collection.updateOne(Filters.eq("EMAIL", email), Updates.combine(Updates.set("EMAIL", newEmail), Updates.set("NOME_INTEIRO", newNome)));
        return collection.find(Filters.eq("EMAIL", newEmail)).first();
    }

    public void delete(String email) {
        Document docToDelete = collection.find(Filters.eq("EMAIL", email)).first();
        if (docToDelete != null) {
            collection.deleteOne(Filters.eq("EMAIL", email));
        }
    }
}