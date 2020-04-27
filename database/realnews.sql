CREATE DATABASE portal_realnews;

USE portal_realnews;

CREATE TABLE noticia (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(512),
	titulo VARCHAR(126),
	texto TEXT
);

CREATE TABLE comentario (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(126),
	texto VARCHAR(512),
	fk_noticia_id INT NOT NULL,
	FOREIGN KEY (fk_noticia_id)
	REFERENCES noticia(id)
);


## INSERCAO DE NOTICIAS
INSERT INTO noticia (descricao, titulo, texto) VALUES
("Um exoplaneta descoberto pelo telescópio Hubble em 2004 desapareceu por completo - e,
a menos que exista algo parecido com a Estrela da Morte destruindo mundos por aí, 
como no universo Star Wars, isso não deveria acontecer. ",
"Colisão rara? Um planeta inteiro desapareceu nas observações do Hubble!",
"Astrônomos estão procurando uma explicação plausível para o ocorrido, e 
um novo estudo sugere que, na verdade, não havia nenhum planeta ali.<br><br>
Conhecido como Dagon, ou Fomalhaut b, e localizado a 25 anos-luz da Terra, 
o exoplaneta (nome dado àqueles que orbitam estrelas que não o Sol) era 
famoso por ter sido um dos primeiros já descobertos em luz visível pelo Hubble. 
Quando os astrônomos o viram pela primeira vez, o Dagon apareceu como um ponto brilhante 
e frio se movendo rapidamente pelo céu. Dez anos depois, esse ponto havia desaparecido.<br><br>
E há outros mistérios que cercam Dagon. Por exemplo, o brilho dele, que permitiu ao Hubble 
mostrá-lo em luz visível, é muito incomum em exoplanetas. Geralmente esses mundos distantes 
são pequenos demais para refletirem essa quantidade de luz de sua estrela anfitriã. Além disso, 
o Fomalhaut b não mostrou assinatura de luz infravermelha, o que significa que estava 
extremamente frio - outra vez, algo incomum para um planeta."),

("A pandemia de coronavírus trouxe o isolamento social e uma pausa forçada na indústria do entretenimento, 
especialmente a cinematográfica. Os grandes estúdios, em geral, já estabeleceram novas datas para suas estreias.",
"Adiados! Thor 4 e Doutor Estranho ganham nova data, e sequência de Homem-Aranha fica para 2021",
"Ganham novas datas as estreias de Thor 4: Love and Thunder e Doutor Estranho 2. O novo filme de Thor, que contará 
com o retorno da personagem Jane Foster, chega às telonas no dia 11 de fevereiro de 2022, apesar da previsão anterior 
ser de 28 de fevereiro de 2022. Já Doutor Estranho 2, previsto inicialmente para 5 de novembro de 2021, será lançado 
em 25 de março de 2022.<br><br>
Doutor Estranho 2 teve sua direção assumida por Sam Raimi, após a saída de Scott Derrrickon. Raimi trabalhou em 
películas do Homem-Aranha com Tobey Maguire. Já Thor 4 ganha o reforço do retorno do diretor e roteirista Taika 
Waititi. O ator Chris Hemsworth avaliou o filme como aquele com o melhor roteiro que já leu em anos.<br><br>
A Sony Pictures também foi forçada a adiar as datas de lançamento da sequência dos próximos filmes de Homem-Aranha. 
Segundo a empresa japonesa, a continuação de Homem-Aranha Longe de Casa chegará no final de 2021, enquanto o novo 
Homem-Aranha no Aranhaverso 2 chega no segundo semestre de 2022."),

("Praticamente um ano após a chegada da versão 19.04 “Disco Dingo”, o Linux Ubuntu 20.04 LTS “Focal Fossa” ficou 
disponível nesta sexta-feira (24), com uma série de novidades aos usuários.",
"Pode atualizar! Ubuntu 20.04 LTS fica disponível com novo modo escuro e mais",
"Em seu visual, o sistema operacional agora tem os elementos centralizados na sua tela de entrada. Houve também 
mudanças no explorador de arquivos, o qual possui cores gradientes para alguns ícones.<br><br>Outro destaque é a 
inclusão de mais recursos para o modo escuro. Os usuários agora podem habilitar o recurso de forma mais simples, 
ao abrir as configurações e acessar a seção “Aparência”. A novidade é vista como uma opção para quem utiliza a 
máquina durante a noite.<br><br>O ambiente gráfico ganhou atualização para o Gnome 3.36. Na prática, as animações 
passaram a ter mais fluidez e velocidade. Quem utiliza a plataforma também conseguirá ativar o modo 
“não perturbe”, para não receber notificações.");


## INSERCAO DE COMENTARIOS
INSERT INTO comentario (nome, texto, fk_noticia_id) VALUES
("Ygor","Ótima notícia",1),
("Tony","Interessante!!",1),
("Tchala","A terra é plana, sem mais.",1),
("Thor","Estava ansioso pelos filmes :(",2),
("Ygor","Ótima notícia",3),
("Charles","Utilizo Ubuntu, essa atualização ficou realmente maravilhosa!",3),
("Douglas","Adorei o novo modo dark",3);


## ÁREA DE TESTES
-- SELECT *FROM noticia WHERE id =1;
-- SELECT *FROM comentario;
-- DELETE FROM comentario WHERE id>4;
-- SELECT * FROM comentario order by id desc;
-- DROP DATABASE portal_realnews;