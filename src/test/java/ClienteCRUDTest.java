import br.univille.trabalhotadss.CRUD_Clientes;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteCRUDTest {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private CRUD_Clientes clienteCRUD;

    @Before
    public void setUp() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("trabalho");
        clienteCRUD = new CRUD_Clientes(database.getCollection("CLIENTES"));
    }

    @Test
    public void testCRUDOperations() {
        // Test create operation
        String email = "email1@example.com";
        String nome = "Nome 1";
        Document newCliente = clienteCRUD.create(email, nome);
        assertNotNull(newCliente);
        assertEquals(email, newCliente.getString("EMAIL"));

        // Test read operation
        Document foundCliente = clienteCRUD.read(email);
        assertNotNull(foundCliente);
        assertEquals(email, foundCliente.getString("EMAIL"));

        // Test update operation
        String newEmail = "newemail@example.com";
        String newNome = "Novo Nome";
        Document updatedCliente = clienteCRUD.update(email, newEmail, newNome);
        assertNotNull(updatedCliente);
        assertEquals(newEmail, updatedCliente.getString("EMAIL"));

        // Test delete operation
        clienteCRUD.delete(newEmail);
        Document deletedCliente = clienteCRUD.read(newEmail);
        assertNull(deletedCliente);
    }

    @After
    public void tearDown() {
        mongoClient.close();
    }
}