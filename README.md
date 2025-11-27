---SISTEMA DE MONITORAMENTO CLIMÁTICOS---

-> O que é este projeto? 
Este é um sistema de gerenmento climático desenvolvido em Java que permite monitorar condições climáticas de qualquer cidade em tempo real. Usando o formato de funcionamento do CRUD, com integração à API externa.

---
-> Funcionalidades Principais:
1. CADASTRAR LEITURAS
    - Você digita o nome de uma cidade, o sistema conecta na API do OpenWeatherMap e busca os dados climáticas atuais, salvando automaticamente no banco de dados.
2. VISUALIZAR LEITURAS
    - Lista todas as cidades cadastradas;
    - Mostra dados completos: temperatura, umidade, condição, vento;
    - Exibe data e hora da coleta.
3. ATUALIZAR LEITURAS
    - Escolhe uma leitura existente;
    - Muda para outra cidade;
    - Busca novos dados atualizados.
4. EXCLUIR LEITURAS
    - Remove leituras do sistema.
   
A estrutura do projeto foi dividia em 4 pastas;
-> app:
1. InterfaceUsuario.java 
2. Main.java
-> model:
3. LeituraClimatica.java
-> repository:
4. GerenciadorLeituras.java
-> service:
5. APIClimatica.java
6. AtualizarLeitura.java
7. CadastrarLeitura.java
8. ExcluirLeitura.java
9. ListarLeituras.java
---

-> É NECESSÁRIO:
1. Java 11+ instalado
2. Conexão com internet
3. Maven

-> COMO EXECUTAR?
1. Criar uma conta em https://openweathermap.org/api
2. Pegar sua chave em My API keys
3. Após isso, dentro da pasta service procure a classe APIClimatica.java e adicione a sua chave na linha 11 dentro das aspas em: private static final String API_KEY = "SUA_CHAVE_AQUI";

Para iniciar o programa, execute o arquivo Main.java.
O sistema iniciará automaticamente com o menu principal.


