CREATE TABLE IF NOT EXISTS public.vote (
    id bigserial PRIMARY KEY,
    is_approved bool NULL,
    vote_session_id bigserial,
    associate_id bigserial,
    created_at timestamp(6) NULL,
    FOREIGN KEY (vote_session_id) REFERENCES voting_session(id),
    FOREIGN KEY (associate_id) REFERENCES associate(id)
);