# 📚 Projeto Final – Bloco 01: Livraria

![Java](https://img.shields.io/badge/Java-17+-blue?style=for-the-badge&logo=java)
![GitHub](https://img.shields.io/badge/GitHub-Control-blue?style=for-the-badge&logo=github)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

---

## 📝 Descrição
Este projeto é uma aplicação em **Java** que simula o gerenciamento de uma **livraria**, permitindo:  
- Cadastrar livros com atributos como título, autor, preço e categoria.  
- Diferenciar livros por categorias (Infantil, Terror, etc.).  
- Consultar, listar e manipular livros via menu interativo.  

O projeto foi desenvolvido como desafio final da conclusão do **Bloco 01** do Curso Java FullStack Devas da @GenerationBrasil.

---

## ⚙️ Funcionalidades
- Cadastro de livros com título, autor, preço e categoria  
- Diferenciação de livros por categorias: Infantil, Terror, etc.  
- Menu interativo via terminal  
- Listagem e busca de livros  
- Tratamento de exceções para entradas inválidas  
- Estrutura modular com pacotes (`model`, `controller`, `util`, `application`)  

---

## 🗂 Estrutura do Projeto

livraria/
│
├── model/ # Classes do modelo (Livro, Infantil, Terror, etc.)
├── controller/ # Lógica e controle do sistema
├── util/ # Utilitários (cores, validações, etc.)
├── application/ # Menu principal
└── README.md # Este arquivo

---

## 🚀 Tecnologias
- Java 17+  
- Git e GitHub  
- Terminal / Console  

---

## 🏃 Como Executar
1. Clone o repositório:

   ```bash
git clone https://github.com/nadiacaricatto/projeto_final_bloco_01.git

3. Entre na pasta do projeto:

cd livraria

5. Compile o projeto:

javac -d bin $(find . -name "*.java")
  
7. Execute o programa:

java -cp bin livraria.application.Menu

---

📝 Histórico de Versões

v1.0 – Menu e cadastro de livros

v1.1 – Categorias e tratamento de exceções

v1.2 – Correção de bugs e merge das branches

---

👩‍💻 Autor

Nádia Piccinin Caricatto
Linkedin: https://www.linkedin.com/in/n%C3%A1dia-piccinin-caricatto-4b376789/


