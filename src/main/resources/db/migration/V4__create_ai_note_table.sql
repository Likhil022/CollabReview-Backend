CREATE TABLE ai_note (
                         id BIGSERIAL PRIMARY KEY,

                         session_id BIGINT NOT NULL,

                         type VARCHAR(100),

                         code_snippet TEXT,

                         ai_response TEXT,

                         CONSTRAINT fk_ai_note_session
                             FOREIGN KEY (session_id)
                                 REFERENCES review_sessions(id)
                                 ON DELETE CASCADE
);