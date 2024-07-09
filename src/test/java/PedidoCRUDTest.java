import br.univille.trabalhotadss.CRUD_Pedidos;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PedidoCRUDTest {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private CRUD_Pedidos pedidoCRUD;

    @Before
    public void setUp() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("trabalho");
        pedidoCRUD = new CRUD_Pedidos(database.getCollection("PEDIDOS"));
    }

    @Test
    public void testCRUDOperations() {
        // Test create operation
        String status = "status1";
        Document newPedido = pedidoCRUD.create(status);
        assertNotNull(newPedido);
        assertEquals(status, newPedido.getString("status_pedido"));

        // Test read operation
        Document foundPedido = pedidoCRUD.read(status);
        assertNotNull(foundPedido);
        assertEquals(status, foundPedido.getString("status_pedido"));

        // Test update operation
        String newStatus = "newstatus";
        Document updatedPedido = pedidoCRUD.update(status, newStatus);
        assertNotNull(updatedPedido);
        assertEquals(newStatus, updatedPedido.getString("status_pedido"));

        // Test delete operation
        pedidoCRUD.delete(newStatus);
        Document deletedPedido = pedidoCRUD.read(newStatus);
        assertNull(deletedPedido);
    }

    @After
    public void tearDown() {
        mongoClient.close();
    }
}