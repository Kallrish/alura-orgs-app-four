Olá, este repositório contém a implementação de código do terceiro curso da Formação Android da Alura. O código deste respositório tem a implementação extra do desafio proposto na descrição do curso (e que é comentado logo abaixo), inclusive o tópico de Corotines abordado na série de vídeos que vem logo em sequência.

Abaixo deixo a explicação do repositório original:
![Thumbnail](https://user-images.githubusercontent.com/8989346/147508031-c6ce2809-56d4-4030-b0ea-08b50d736e38.png)

# Orgs

App de simulação de um e-commerce de produtos naturais.

## 🔨 Funcionalidades do projeto

O projeto permite acessar a tela de login, cadastro, autenticação de usuário, e também, sair do App caso esteja autenticado. Além disso, possibilita a criação de produto e listagem dos produtos de cada usuário. Além disso, mantém os comportamentos de editar e remover produtos. 

![Amostra das funcionalidades do App](https://user-images.githubusercontent.com/8989346/145200235-342f5f66-451a-4150-9f52-94e2385a7d9c.gif)

## 🎯 Desafios

- Tela de perfil

![img4_01](https://user-images.githubusercontent.com/8989346/147489716-f331f89a-7772-4932-8010-60846b2e8bd9.gif)

- Tela de produtos sem usuário

![img5_01](https://user-images.githubusercontent.com/8989346/147489725-9533d33b-e1d5-4055-ba69-b6e10ab0f55b.gif)

## ✔️ Técnicas e tecnologias utilizadas

- `Fluxo de autenticação com DataStore`: armazenar tipos primitivos via preferences, como por exemplo, o id do usuário autenticado
- `Migration`: permitir que o App evolua cada vez que as entidades do Room são modificadas, pois modificam também o schema do banco de dados
- `Coroutines e Flow`: utilizados para fazer a comunicação com o Room e o DataStore
- `StateFlow`: permitir a alteração do valor do Flow fora do builder, como por exemplo, atualizar o valor ao coletar novos valores de um outro Flow.
- `Activity base`: compartilhar código comum entre as Activities, como por exemplo, código de autenticação que permite acessar o usuário logado, deslogar do App e verificar se o usuário está ou não logado
- `Relacionamento no Room`: configurar entidade para identificar a qual registro ela pertence, como por exemplo, um produto que pertence a um usuário
