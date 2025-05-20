CREATE TABLE IF NOT EXISTS public.voting_topic (
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) NULL,
    created_at timestamp(6) NULL,
    updated_at timestamp(6) NULL
);