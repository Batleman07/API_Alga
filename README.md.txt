#Passos para  criação de ambiente apiJavaEclipse

## (A)Configurações
### 1-Criar springStarter - maven (adicionando SpringWEB, Lombok dev toos)
### 2-Criar uma workspace no postaman.
####obs= localhost:8080/[mapeamentoEntidade]
####obs= instalar postmanAgent  se ambiente online
####obs= IANA codigos de  status HTTP .
####obs= Para teste, no postman é  possivel  definir o formato de recebimento de dados que a  aplpicação dee aceitar.
####obs= Adicionar dependencias para definir  formato deenvio de dados
### 3-Adicionar o {spring-boot-starter-data-jpa}{mysql-connector-j com o scope runtime}

#### obs=spring.datasource.url=jdbc:mysql://localhost:[porta que o banco esta trabalhando]/awpag?createDatabaseIfNotExist=true&serverTimezone=UTC
#### obs=spring.datasource.username=root
#### obs=spring.datasource.password=[senha do  banco de dados]
### 4- Adicionar dependência flyway {flyway-core}{org.flywaydb} {flyway-mysql}
#### obs- Para criar o arquivo de versionamento utilizar  o  padrao de  diretorios db->migration->V[numero da versao]__[o que esta fazerndo em sql]
#### obs-Testar codigo antes da criação do versionamento


##(B)GerarFatJar
### 1- pow->maven build->(clear package) usar essas duas ferramenas do maven
#### obs: Apos gerar pacote, para executar -> java -jar   [nome do arquivo com extensão]
#### obs: alterar porta para subir aplicação->application.propertis->escrever {server.port=[numero da porta]

##(C)Criar entidades
### 1-Criar pacote de controle  e a classe ->@RestController classe principal{(@GetMapping(/[caminho]))}
### 2-Criar packege para  entidades -> dentro  é  criado  os  clientes.
### 3-Cirar mapeamento de objeto relacional
#### obs:Para mapear ID  @ID ->@GeneratedValue(strategy = GenerationType.IDENTITY) e demais colunas com @Column(name="[nome da tabela]")
#### obs:Definir propriedade equals para as propriedades  que devem ser unicas.
#### @PersistenceContext
	private EntityManager manager; <- no controller
#### criar um  retorno    manager.createQuery("from Cliente",Cliente.class)
				.getResultList();
### 4-Gerar package na package "domain" com o nome "repository", e criar o arquivo   ClienteRepository como interface.
### 5-extender ClienteRepository com JpaRpository<[objeto],[Long]>
#### Utiliza o  uma instância  do  ClienteRepository no controle, para inserir ou  retornar info, do banco.
### 6-Criando endpoint como id de uma tabela de requisição
### 7-Criação
### 8-Alteração
### 9-Exclusao
### 10-Adicionar dependencia "spreing-boot-validation




