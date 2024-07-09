# Coleções e Documentos MongoDB

Este projeto utiliza MongoDB como seu banco de dados. O banco de dados consiste em três coleções principais: `CLIENTES`, `LOJAS` e `PEDIDOS`. Cada coleção contém documentos com campos específicos. Aqui está uma explicação detalhada de cada coleção e seus documentos:

## Coleção CLIENTES

A coleção `CLIENTES` contém documentos que representam os clientes. Cada documento na coleção `CLIENTES` possui os seguintes campos:

- `EMAIL`: Uma string que representa o email do cliente. Este campo é único para cada cliente.
- `NOME_INTEIRO`: Uma string que representa o nome completo do cliente.

Exemplo de um documento `CLIENTES`:

```json
{
  "EMAIL": "email1@example.com",
  "NOME_INTEIRO": "Nome 1"
}
```

## Coleção LOJAS

A coleção `LOJAS` contém documentos que representam as lojas. Cada documento na coleção `LOJAS` possui os seguintes campos:

- `ENDERECO_WEB`: Uma string que representa o endereço web da loja. Este campo é único para cada loja.
- `ENDERECO_FISICO`: Uma string que representa o endereço físico da loja.
- `LOGO`: Um objeto que contém informações sobre o logotipo da loja. Possui os seguintes campos:
    - `LOGO_IMG`: Dados binários (BLOB) que representam a imagem do logotipo.
    - `LOGO_MIME_TYPE`: Uma string que representa o tipo MIME da imagem do logotipo.
    - `LOGO_FILENAME`: Uma string que representa o nome do arquivo da imagem do logotipo.
    - `LOGO_CHARSET`: Uma string que representa o conjunto de caracteres da imagem do logotipo.
    - `LOGO_LAST_UPDATED`: Uma data que representa a última vez que a imagem do logotipo foi atualizada.

Exemplo de um documento `LOJAS`:

```json
{
  "ENDERECO_WEB": "endereco1",
  "ENDERECO_FISICO": "Endereco Fisico 1",
  "LOGO": {
    "LOGO_IMG": "<Dados BLOB>",
    "LOGO_MIME_TYPE": "image/png",
    "LOGO_FILENAME": "logo.png",
    "LOGO_CHARSET": "UTF-8",
    "LOGO_LAST_UPDATED": "2022-01-01T00:00:00Z"
  }
}
```

## Coleção PEDIDOS

A coleção `PEDIDOS` contém documentos que representam os pedidos. Cada documento na coleção `PEDIDOS` possui os seguintes campos:

- `status_pedido`: Uma string que representa o status do pedido.
- `itens`: Uma matriz de objetos, onde cada objeto representa um item no pedido. Cada objeto de item possui os seguintes campos:
    - `item_id`: Um número que representa o ID do item.
    - `quantidade`: Um número que representa a quantidade do item.
    - `produto`: Um objeto que contém informações sobre o produto. Possui os seguintes campos:
        - `produto_id`: Um número que representa o ID do produto.
        - `nome`: Uma string que representa o nome do produto.
        - `categoria`: Uma string que representa a categoria do produto.
        - `marca`: Uma string que representa a marca do produto.
        - `preco_unitario`: Um número que representa o preço unitário do produto.

Exemplo de um documento `PEDIDOS`:

```json
{
  "status_pedido": "status1",
  "itens": [
    {
      "item_id": 1,
      "quantidade": 2,
      "produto": {
        "produto_id": 245,
        "nome": "Smartphone Galaxy S23",
        "categoria": "Celulares",
        "marca": "Samsung",
        "preco_unitario": 2999.99
      }
    },
    {
      "item_id": 2,
      "quantidade": 1,
      "produto": {
        "produto_id": 3,
        "nome": "Carregador sem fio",
        "categoria": "Acessórios",
        "marca": "Samsung",
        "preco_unitario": 499.99
      }
    }
  ]
}
```

Por favor, note que os dados reais no campo `LOGO_IMG` na coleção `LOJAS` e o status real no campo `status_pedido` na coleção `PEDIDOS` variarão dependendo da loja e do pedido específicos.