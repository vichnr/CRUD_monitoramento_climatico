---SISTEMA DE MONITORAMENTO CLIMÁTICOS---

-> O que é este projeto? 
Este é um sistema de gerenciamento climático desenvolvido em Java que permite o monitoramento de condições climáticas de qualquer cidade em tempo real. Usando o formato de funcionamento do CRUD, com integração à API externa.

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
InterfaceUsuario.java 
Main.java

-> model:
LeituraClimatica.java

-> repository:
GerenciadorLeituras.java

-> service:
APLIclimatica.java
AtualizarLeitura.java
CadastrarLeitura.java
ExcluirLeitura.java
ListarLeituras.java

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
O sistema iniciará automaticamente com o menu principal no terminal.


