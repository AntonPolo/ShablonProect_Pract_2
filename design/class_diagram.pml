@startuml
interface RequestSource {
    +boolean exists(String studentId, String topic)
    +int save(Request request)
}

class RequestService {
    -source: RequestSource
    -notifier: NotificationService
    -logger: AuditLogger
    +String process(...)
}

class RequestSourceFactory {
    +static RequestSource create()
}

class DatabaseRequestSource
class FileRequestSource
class WebRequestSource

RequestService --> RequestSource
RequestSourceFactory --> RequestSource
DatabaseRequestSource ..|> RequestSource
FileRequestSource ..|> RequestSource
WebRequestSource ..|> RequestSource

note right of RequestSourceFactory
  Читает config.properties
  и создаёт нужную реализацию
end note
@enduml