import br.univille.trabalhotadss.CRUD_Lojas;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LojaCRUDTest {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private CRUD_Lojas lojaCRUD;

    @Before
    public void setUp() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("trabalho");
        lojaCRUD = new CRUD_Lojas(database.getCollection("LOJAS"));
    }

    @Test
    public void testCRUDOperations() {
        // Test create operation
        String enderecoWeb = "endereco1";
        String enderecoFisico = "Endereco Fisico 1";
        Document newLoja = lojaCRUD.create(enderecoWeb, enderecoFisico);
        assertNotNull(newLoja);
        assertEquals(enderecoWeb, newLoja.getString("ENDERECO_WEB"));

        // Test read operation
        Document foundLoja = lojaCRUD.read(enderecoWeb);
        assertNotNull(foundLoja);
        assertEquals(enderecoWeb, foundLoja.getString("ENDERECO_WEB"));

        // Test update operation
        String newEnderecoWeb = "newendereco";
        String newEnderecoFisico = "Novo Endereco Fisico";
        Document updatedLoja = lojaCRUD.update(enderecoWeb, newEnderecoWeb, newEnderecoFisico);
        assertNotNull(updatedLoja);
        assertEquals(newEnderecoWeb, updatedLoja.getString("ENDERECO_WEB"));

        // Test delete operation
        lojaCRUD.delete(newEnderecoWeb);
        Document deletedLoja = lojaCRUD.read(newEnderecoWeb);
        assertNull(deletedLoja);
    }

    @After
    public void tearDown() {
        mongoClient.close();
    }
}