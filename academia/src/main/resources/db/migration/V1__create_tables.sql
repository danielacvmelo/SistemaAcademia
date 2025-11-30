CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 1. Tabela de Usuários (Login)
CREATE TABLE usuarios (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          nome VARCHAR(150) NOT NULL,
                          email VARCHAR(254) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL,
                          cpf VARCHAR(14) UNIQUE,
                          perfil VARCHAR(20) NOT NULL,
                          criado_em TIMESTAMP NOT NULL,
                          atualizado_em TIMESTAMP NOT NULL
);

-- 2. Tabela de Planos (Para Membros)
CREATE TABLE planos_membresia (
                                  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  nome VARCHAR(100) NOT NULL,
                                  descricao TEXT,
                                  preco DECIMAL(10, 2) NOT NULL,
                                  duracao_meses INTEGER,
                                  ativo BOOLEAN DEFAULT TRUE
);

-- 3. Tabela de Instrutores
CREATE TABLE instrutores (
                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             usuario_id UUID NOT NULL UNIQUE,
                             cref VARCHAR(20) NOT NULL UNIQUE,
                             especialidade VARCHAR(100),
                             data_contratacao DATE,
                             FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- 4. Tabela de Membros
CREATE TABLE membros (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         usuario_id UUID NOT NULL UNIQUE,
                         plano_id UUID,
                         data_matricula DATE NOT NULL,
                         status VARCHAR(20),
                         FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
                         FOREIGN KEY (plano_id) REFERENCES planos_membresia(id)
);

-- 5. Equipamentos
CREATE TABLE equipamentos (
                              id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                              nome VARCHAR(100) NOT NULL,
                              grupo_muscular VARCHAR(50),
                              data_aquisicao DATE,
                              ultima_manutencao DATE,
                              status VARCHAR(30)
);

-- 6. Aulas
CREATE TABLE aulas (
                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                       instrutor_id UUID,
                       nome VARCHAR(100) NOT NULL,
                       dia_da_semana VARCHAR(20),
                       horario TIME,
                       duracao_minutos INTEGER,
                       FOREIGN KEY (instrutor_id) REFERENCES instrutores(id)
);

-- 7. Agendamentos
CREATE TABLE agendamentos (
                              id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                              membro_id UUID NOT NULL,
                              instrutor_id UUID,
                              tipo VARCHAR(50) NOT NULL,
                              data_hora TIMESTAMP NOT NULL,
                              status VARCHAR(30),
                              observacoes TEXT,
                              FOREIGN KEY (membro_id) REFERENCES membros(id),
                              FOREIGN KEY (instrutor_id) REFERENCES instrutores(id)
);

-- 8. Avaliações Físicas
CREATE TABLE avaliacoes_fisicas (
                                    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                    membro_id UUID NOT NULL,
                                    instrutor_id UUID NOT NULL,
                                    data_avaliacao DATE NOT NULL,
                                    peso DECIMAL(5, 2),
                                    altura DECIMAL(5, 2),
                                    percentual_gordura DECIMAL(5, 2),
                                    observacoes TEXT,
                                    FOREIGN KEY (membro_id) REFERENCES membros(id),
                                    FOREIGN KEY (instrutor_id) REFERENCES instrutores(id)
);