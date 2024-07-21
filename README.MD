# UrlShortner

UrlShortner é um encurtador de URL que utiliza base 62 para criptografar URLs. O projeto inclui medidas de segurança, como a adição de um timestamp em milissegundos para gerar encurtadores únicos com a base 62.

## Tecnologias Usadas

- **Java**
- **Spring**
- **MongoDB**

## Rotas

| Endpoint         | Método | Descrição                    | Body                              | Exemplo de Resposta                                                                                                                                                   |
|------------------|--------|------------------------------|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `/shortenUrl`    | POST   | Retorna a URL encurtada      | `{ "url": "https://www.example.com" }` | `{ "id": "669d04a5a2128a78c017f7b7", "originalUrl": "https://exemplo.com.br", "shortUrlHash": "maoqaYr", "userId": null, "createdAt": "2024-07-21T09:52:53.955259" }` |
| `/{shortUrl}`    | GET    | Redireciona para a URL original |                           | Redireciona o usuário para `https://www.example.com`                                                                                                                  |
