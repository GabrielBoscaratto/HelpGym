<h1 align="center">🏋️ HelpGym 🏋️</h1>
<p align="center">Sistema completo para gerenciamento de academias</p>
<p align="center">💼 <b>Projeto freelance desenvolvido e vendido em 2023.</b></p>

<h1 align="center">O que tem no projeto?</h1>
<ul>
  <li>Cadastro e login de usuários com autenticação JWT</li>
  <li>Gerenciamento de academias</li>
  <li>Artigos de fitness</li>
  <li>Patrocinadores</li>
  <li>Treinamentos</li>
  <li>Dashboard com rotas privadas</li>
</ul>

<h1 align="center">💻 Tecnologias utilizadas 💻</h1>
<ul>
  <li><b>Back-end:</b> Java + Spring Boot (API REST), Spring Security com JWT, Maven</li>
  <li><b>Banco de dados:</b> H2 (em memória)</li>
  <li><b>Front-end:</b> React, React Router, Axios, Styled Components</li>
</ul>

<h1 align="center">🚀 Como executar 🚀</h1>

```bash
# Back-end (porta 8080)
cd backend
mvn spring-boot:run

# Front-end (porta 3000)
cd academia-app
npm install
npm start
```

Ou use os scripts `start-project.sh` / `stop-project.sh` na raiz do projeto.

A documentação completa (endpoints da API, estrutura e solução de problemas) está em [`docs/README.md`](docs/README.md), e o passo a passo de instalação em [`docs/guia_instalacao.md`](docs/guia_instalacao.md).
