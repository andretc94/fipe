# Readme

Rodar o `docker-compose up -d` na raiz do projeto para iniciar os servicos de:
- Mensageria (RabbitMQ)
- API1 responsável por consultar as marcas API tabela fipe e enviar para o servico de mensageria alem de consultar na base de dados as marcas e modelos cadastrados no banco de dados sql;
- API2 responsável por ler da fila as marcas e salvar no banco SQL alem de consultar os modelos dos carros da marca recebida no tópico; 
;

acesso ao swagger: http://localhost:8080/swagger-ui/index.html