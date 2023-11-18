# Instruction to Run #

## Data base On Docker ##

Para rodar o banco local usando docker execute 

``` docker compose up -d```

Conecte ao banco usando o seu software preferido e execute 
### credênciais:

user: SYS as SYSDBA 

Database: XE 

password: 310192

o script em [Documentation](/Documentation)
ele ira cria o usuario e atribuir as permissoes necessarias

### Endpoints ###

## Usuarios ##
- GET /api/user: Obtenha uma lista de todos os usuários.
- GET /api/user/{id}: Obtenha detalhes de um usuário específico.
- POST /api/user: Crie um novo usuário.
- PUT /api/user/{id}: Atualize um usuário existente.
- DELETE /api/user/{id}: Exclua um usuário.


## Contribuindo

Se você encontrar problemas com a coleção Postman ou tiver sugestões de melhoria, sinta-se à vontade para abrir uma issue ou enviar uma solicitação de pull. As contribuições são sempre bem-vindas!

## Licença

Esta coleção do Postman está licenciada sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
