-- 1. PLANOS DE MEMBRESIA
INSERT INTO planos_membresia (id, nome, descricao, preco, duracao_meses, ativo) VALUES
                                                                                    ('11111111-1111-1111-1111-111111111111', 'Plano Smart', 'Acesso a musculação e cardio', 89.90, 12, true),
                                                                                    ('22222222-2222-2222-2222-222222222222', 'Plano Gold', 'Acesso total + Aulas Coletivas', 149.90, 6, true),
                                                                                    ('33333333-3333-3333-3333-333333333333', 'Plano Family', 'Pacote para 3 pessoas da mesma família', 299.90, 12, true);

-- 2. USUÁRIOS E INSTRUTORES
INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Arnold Schwarzenegger', 'arnold@gym.com', '123456', '11122233301', 'ADMIN', NOW(), NOW());

INSERT INTO instrutores (id, usuario_id, cref, especialidade, data_contratacao) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='arnold@gym.com'), '123456-G/SP', 'Musculação', '2023-01-10');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Sheila Zen', 'sheila@gym.com', '123456', '11122233302', 'USER', NOW(), NOW());

INSERT INTO instrutores (id, usuario_id, cref, especialidade, data_contratacao) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='sheila@gym.com'), '654321-G/RJ', 'Pilates e Yoga', '2024-02-15');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Ronnie Coleman', 'ronnie@gym.com', '123456', '11122233303', 'USER', NOW(), NOW());

INSERT INTO instrutores (id, usuario_id, cref, especialidade, data_contratacao) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='ronnie@gym.com'), '998877-G/MG', 'CrossFit e Powerlifting', '2023-05-20');


-- 3. USUÁRIOS E MEMBROS

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Ana Silva', 'ana.silva@email.com', '123', '00000000001', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='ana.silva@email.com'), '11111111-1111-1111-1111-111111111111', '2025-01-01', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Bruno Souza', 'bruno.souza@email.com', '123', '00000000002', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='bruno.souza@email.com'), '22222222-2222-2222-2222-222222222222', '2025-01-02', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Carla Diaz', 'carla.diaz@email.com', '123', '00000000003', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='carla.diaz@email.com'), '33333333-3333-3333-3333-333333333333', '2025-01-03', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Daniel Oliveira', 'daniel.o@email.com', '123', '00000000004', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='daniel.o@email.com'), '11111111-1111-1111-1111-111111111111', '2025-01-04', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Eduardo Lima', 'edu.lima@email.com', '123', '00000000005', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='edu.lima@email.com'), '22222222-2222-2222-2222-222222222222', '2025-01-05', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Fernanda Costa', 'nanda@email.com', '123', '00000000006', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='nanda@email.com'), '11111111-1111-1111-1111-111111111111', '2024-06-01', 'INATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Gabriel Medina', 'gabs@email.com', '123', '00000000007', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='gabs@email.com'), '22222222-2222-2222-2222-222222222222', '2025-02-01', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Hugo Gloss', 'hugo@email.com', '123', '00000000008', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='hugo@email.com'), '33333333-3333-3333-3333-333333333333', '2025-02-02', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Igor 3K', 'igor@email.com', '123', '00000000009', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='igor@email.com'), '11111111-1111-1111-1111-111111111111', '2025-02-03', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Joana Dark', 'joana@email.com', '123', '00000000010', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='joana@email.com'), '22222222-2222-2222-2222-222222222222', '2025-02-04', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Kleber Bambam', 'kleber@email.com', '123', '00000000011', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='kleber@email.com'), '22222222-2222-2222-2222-222222222222', '2025-03-01', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Luisa Sonza', 'luisa@email.com', '123', '00000000012', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='luisa@email.com'), '33333333-3333-3333-3333-333333333333', '2025-03-02', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Marcos Mion', 'mion@email.com', '123', '00000000013', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='mion@email.com'), '11111111-1111-1111-1111-111111111111', '2025-03-03', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Neymar Junior', 'neymar@email.com', '123', '00000000014', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='neymar@email.com'), '22222222-2222-2222-2222-222222222222', '2025-03-04', 'ATIVO');

INSERT INTO usuarios (id, nome, email, senha, cpf, perfil, criado_em, atualizado_em) VALUES
    (gen_random_uuid(), 'Oscar Schmidt', 'oscar@email.com', '123', '00000000015', 'USER', NOW(), NOW());
INSERT INTO membros (id, usuario_id, plano_id, data_matricula, status) VALUES
    (gen_random_uuid(), (SELECT id FROM usuarios WHERE email='oscar@email.com'), '33333333-3333-3333-3333-333333333333', '2025-03-05', 'ATIVO');


-- 4. EQUIPAMENTOS
INSERT INTO equipamentos (id, nome, grupo_muscular, data_aquisicao, status) VALUES
                                                                                (gen_random_uuid(), 'Esteira Pro 5000', 'Cardio', '2023-01-01', 'Operacional'),
                                                                                (gen_random_uuid(), 'Supino Reto', 'Peito', '2023-01-01', 'Operacional'),
                                                                                (gen_random_uuid(), 'Leg Press 45', 'Pernas', '2023-02-15', 'Em Manutenção');
