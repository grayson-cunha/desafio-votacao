CREATE TABLE IF NOT EXISTS public.voting_topic (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000)
);