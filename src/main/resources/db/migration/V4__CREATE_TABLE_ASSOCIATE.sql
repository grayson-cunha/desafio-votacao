CREATE TABLE IF NOT EXISTS public.associate (
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at timestamp(6) NULL
);