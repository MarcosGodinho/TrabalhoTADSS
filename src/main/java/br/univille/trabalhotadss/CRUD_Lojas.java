package br.univille.trabalhotadss;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class CRUD_Lojas {
    private MongoCollection<Document> collection;

    public CRUD_Lojas(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Document create(String enderecoWeb, String enderecoFisico) {
        Document newLoja = new Document("ENDERECO_WEB", enderecoWeb)
                .append("ENDERECO_FISICO", enderecoFisico);
        collection.insertOne(newLoja);
        return newLoja;
    }

    public Document read(String enderecoWeb) {
        return collection.find(Filters.eq("ENDERECO_WEB", enderecoWeb)).first();
    }

    public Document update(String enderecoWeb, String newEnderecoWeb, String newEnderecoFisico) {
        collection.updateOne(Filters.eq("ENDERECO_WEB", enderecoWeb), Updates.combine(Updates.set("ENDERECO_WEB", newEnderecoWeb), Updates.set("ENDERECO_FISICO", newEnderecoFisico)));
        return collection.find(Filters.eq("ENDERECO_WEB", newEnderecoWeb)).first();
    }

    public void delete(String enderecoWeb) {
        Document docToDelete = collection.find(Filters.eq("ENDERECO_WEB", enderecoWeb)).first();
        if (docToDelete != null) {
            collection.deleteOne(Filters.eq("ENDERECO_WEB", enderecoWeb));
        }
    }
}