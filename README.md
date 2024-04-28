# ProjetoSinerji
# Configuração do Projeto
## Configuração do Banco de Dados
Abra o arquivo persistence.xml localizado no diretório src/main/resources/META-INF/.
Dentro do arquivo, configure as seguintes informações:
Banco de dados: nome_do_banco_de_dados
Usuário: nome_do_usuario
Senha: senha_do_usuario
Host: host_do_banco_de_dados
Nome da base: nome_da_base_de_dados
## Criação da Estrutura de Tabelas
Execute o arquivo Main.java localizado no diretório src/main/java/com/example/Main.java.
Este passo criará a estrutura de tabelas no banco de dados com base nas configurações do arquivo persistence.xml.
## Build do Projeto
Após a criação da estrutura de tabelas, você pode buildar o projeto para gerar o artefato final.
Utilize a ferramenta de build de sua preferência ou execute mvn clean package na raiz do projeto para gerar o pacote compilado.
Espero que isso seja útil para o seu README!