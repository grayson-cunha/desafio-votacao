CREATE TABLE IF NOT EXISTS public.voting_session (
    id bigserial PRIMARY KEY,
    duration timestamp(6) NOT NULL,
    description VARCHAR(1000) NULL,
    is_open bool NOT NULL DEFAULT true,
    voting_topic_id bigserial,
    created_at timestamp(6) NULL,
    FOREIGN KEY (voting_topic_id) REFERENCES voting_topic(id)
);