# CollabReview — Backend

Spring Boot backend for a real-time collaborative code review platform.
Provides GitHub OAuth authentication, pull request data, real-time collaboration, and AI-powered code analysis.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Security (OAuth2 GitHub)
* Spring WebSocket (STOMP)
* Spring Data JPA (Hibernate)
* PostgreSQL
* Flyway (database migrations)
* Redis (optional, for scaling)
* Claude API (AI integration)

---

## Features

* GitHub OAuth login
* Fetch repositories and pull requests
* Review session management
* Real-time collaboration (presence, cursors, comments)
* Inline comments with persistence
* AI analysis via streaming (SSE)

---

## Project Structure

```
src/main/java/com/collabreview/
 ├── config/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 ├── dto/
 ├── websocket/

src/main/resources/
 ├── application.properties
 └── db/migration/
```

---

## Setup

### Prerequisites

* Java 17+
* Maven
* PostgreSQL
* Docker (optional)

---

### 1. Clone repository

```bash
git clone https://github.com/<your-username>/CollabReview-backend.git
cd CollabReview-backend
```

---

### 2. Configure `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/collabreview
spring.datasource.username=postgres
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true

spring.security.oauth2.client.registration.github.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_CLIENT_SECRET

anthropic.api.key=YOUR_CLAUDE_API_KEY
```

---

### 3. Run PostgreSQL (Docker)

```bash
docker run -d -p 5432:5432 \
-e POSTGRES_DB=collabreview \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=password \
postgres
```

---

### 4. Start application

```bash
./mvnw spring-boot:run
```

Server:

```
http://localhost:8080
```

---

## Database Migrations (Flyway)

* Location: `src/main/resources/db/migration`
* Naming:

```
V1__init.sql
V2__review_sessions.sql
V3__comments.sql
```

Flyway runs automatically on startup.

---

## API Overview

### Auth

```
GET /oauth2/authorization/github
```

### Pull Requests

```
GET /api/pulls
```

### Sessions

```
POST /api/sessions
GET /api/sessions/{id}
```

### Comments

```
POST /api/comments
GET /api/comments/{sessionId}
```

### AI (SSE)

```
GET /api/ai/analyze
```

---

## WebSocket

* Endpoint: `/ws`
* Topic:

```
/topic/session/{sessionId}
```

Events:

* join_session
* leave_session
* cursor_move
* user_presence
* new_comment
* review_decision

---

## Development Notes

* Use DTOs instead of exposing entities
* Keep business logic in services
* Validate inputs at controller level
* Do not use `ddl-auto=update` in production

---

## Future Enhancements

* Redis-based WebSocket scaling
* Notification system
* Advanced AI prompts
* Performance optimization

---

## License

MIT
