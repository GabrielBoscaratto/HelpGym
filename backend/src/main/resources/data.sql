INSERT INTO artigos (titulo, conteudo_resumido, conteudo_completo, url_imagem) VALUES
('Treinamento Inclusivo: Acessibilidade para Todos', 
'Descubra como adaptar seus treinos para diferentes necessidades e habilidades...', 
'<div><h2>Treinamento Inclusivo: Acessibilidade para Todos</h2><p>Acreditamos que o fitness deve ser acessível a todos, independentemente de suas habilidades ou limitações. Este artigo explora como adaptar treinos para atender às necessidades individuais, promovendo um ambiente inclusivo e encorajador.</p><h3>Princípios do Treinamento Inclusivo:</h3><ul><li><strong>Adaptação:</strong> Modifique exercícios para atender às necessidades individuais.</li><li><strong>Acessibilidade:</strong> Garanta que o ambiente de treino seja acessível a todos.</li><li><strong>Respeito:</strong> Crie um ambiente de apoio e respeito mútuo.</li></ul><p>(Exemplos de adaptações para diferentes necessidades)</p></div>', 
'https://images.unsplash.com/photo-1584735935682-2f2b69dff9d2?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');

INSERT INTO artigos (titulo, conteudo_resumido, conteudo_completo, url_imagem) VALUES
('Nutrição Consciente: Alimentando um Corpo Diversificado', 
'Aprenda a importância da nutrição personalizada para diferentes tipos de corpos e necessidades...', 
'<div><h2>Nutrição Consciente: Alimentando um Corpo Diversificado</h2><p>A nutrição desempenha um papel fundamental na saúde e no bem-estar, mas as necessidades nutricionais variam de pessoa para pessoa. Este artigo aborda a importância da nutrição personalizada e como adaptar sua dieta para atender às suas necessidades individuais.</p><h3>Princípios da Nutrição Consciente:</h3><ul><li><strong>Individualização:</strong> Adapte sua dieta para atender às suas necessidades específicas.</li><li><strong>Variedade:</strong> Inclua uma variedade de alimentos nutritivos em sua dieta.</li><li><strong>Equilíbrio:</strong> Mantenha um equilíbrio entre macronutrientes e micronutrientes.</li></ul><p>(Exemplos de planos alimentares para diferentes necessidades)</p></div>', 
'https://images.unsplash.com/photo-1546069901-ba9599a7e63c?q=80&w=1780&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');

INSERT INTO patrocinadores (nome, url_logo, descricao) VALUES
('Max Titanium', 'https://logospng.org/download/max-titanium/max-titanium-2048.png', 'Suplementos de alta qualidade para atletas e praticantes de atividades físicas');

INSERT INTO patrocinadores (nome, url_logo, descricao) VALUES
('Growth Supplements', 'https://s2-cbn.glbimg.com/Zk44PZ_XneRbUnJPV-nWLwCVFfg=/0x0:2048x1364/888x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_d975fad146a14bbfad9e763717b09688/internal_photos/bs/2025/r/j/9MWoDzQ9KcfB8Qm2kkCg/gip1mfaxwae4i3g.jpeg', 'Suplementação esportiva de qualidade para todos os níveis de atletas');

INSERT INTO academia (nome, sobre_nos, url_logo, endereco, telefone, email, horario_funcionamento) VALUES
('HelpGym', 'Olá! Bem-vindos ao nosso espaço dedicado à saúde e bem-estar. Somos um grupo de entusiastas do fitness, unidos pela paixão por um estilo de vida ativo e equilibrado.', 
'https://static.vecteezy.com/system/resources/previews/036/028/618/non_2x/gym-logo-creative-strong-academy-fitness-reaching-star-sport-design-concept-vector.jpg', 
'Av. Paulista, 1000 - São Paulo/SP', '(11) 99999-9999', 'contato@helpgym.com.br', 'Segunda a Sexta: 6h às 22h | Sábado: 8h às 18h | Domingo: 8h às 14h');

INSERT INTO treinamentos (nome, descricao, nivel_dificuldade, duracao_minutos, calorias_estimadas, url_imagem, data_criacao) VALUES
('Treino HIIT para Iniciantes', 'Um treino de alta intensidade adaptado para quem está começando, com foco em exercícios simples e eficazes.', 
'Iniciante', 30, 300, 'https://images.unsplash.com/photo-1541534741688-6078c6bfb5c5?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 
CURRENT_TIMESTAMP());

INSERT INTO treinamentos (nome, descricao, nivel_dificuldade, duracao_minutos, calorias_estimadas, url_imagem, data_criacao) VALUES
('Treino de Força Total', 'Treino completo para desenvolvimento de força em todos os grupos musculares, com foco em exercícios compostos.', 
'Intermediário', 60, 450, 'https://images.unsplash.com/photo-1574680178288-7918b82d2429?q=80&w=1965&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', 
CURRENT_TIMESTAMP());
