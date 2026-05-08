CREATE TABLE review_sessions (
                                 id BIGSERIAL PRIMARY KEY,

                                 title VARCHAR(255) NOT NULL,
                                 description TEXT,

                                 owner_id BIGINT NOT NULL,

                                 status VARCHAR(50) DEFAULT 'OPEN',

                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                 CONSTRAINT fk_review_session_owner
                                     FOREIGN KEY (owner_id)
                                         REFERENCES users(id)
                                         ON DELETE CASCADE
);