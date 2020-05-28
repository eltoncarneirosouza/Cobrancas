INSERT INTO public.perfil(
            id, descricao)
    VALUES (1, 'Administrador');

INSERT INTO public.usuario(
            id, ativo, email, nome, senha)
    VALUES (1, true, 'admim@controle.com', 'Administrador', '$2a$10$p4cqk7lO7UBNtSZZUeqyZOVxQBqaQ7k9teFknTIVPNFF9Bb3WZO/2');

INSERT INTO public.usuario_perfil(
	     usuario_id, perfil_id)
    VALUES (1, 1);
