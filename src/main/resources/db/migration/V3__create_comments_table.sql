CREATE TABLE comments (
                          id BIGSERIAL PRIMARY KEY,

                          review_session_id BIGINT NOT NULL,
                          user_id BIGINT NOT NULL,

                          content TEXT NOT NULL,

                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT fk_comment_review_session
                              FOREIGN KEY (review_session_id)
                                  REFERENCES review_sessions(id)
                                  ON DELETE CASCADE,

                          CONSTRAINT fk_comment_user
                              FOREIGN KEY (user_id)
                                  REFERENCES users(id)
                                  ON DELETE CASCADE
);