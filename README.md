# Spring Dependency Injection Demo

A small Java project that shows how **Dependency Injection (DI)** works in the
Spring Framework using annotation-based configuration.

## What is Dependency Injection?

Dependency Injection is a design pattern where a class does not create its own
dependencies. Instead, they are supplied from outside by the Spring **IoC
(Inversion of Control) container**, the `ApplicationContext`.

## How the container works

| Stage | What happens | Annotations used |
|---|---|---|
| Create | Spring discovers classes and instantiates them as beans | `@Component`, `@Service`, `@Repository` |
| Configure | Spring is told where to scan for beans | `@Configuration`, `@ComponentScan` |
| Inject | Spring wires beans into the classes that need them | `@Autowired` |
| Resolve ambiguity | Choose between several implementations | `@Primary`, `@Qualifier` |

## Project structure

```
src/main/java/com/example/di/
├── Notifier.java          # interface (abstraction)
├── EmailNotifier.java     # default implementation (@Primary)
├── SmsNotifier.java       # alternative implementation
├── OrderRepository.java   # data-access bean
├── OrderService.java      # business logic, dependencies injected
├── AppConfig.java         # container configuration
└── MainApp.java           # application entry point
src/test/java/com/example/di/
└── OrderServiceTest.java  # unit test with a fake Notifier
```

## Requirements

- JDK 17 or higher
- Maven

## How to run

1. Clone the repository and open it in IntelliJ IDEA.
2. Sync the Maven project.
3. Run `MainApp.main()`.

## Expected output

```
Order saved to database: Laptop
EMAIL sent: Your order 'Laptop' has been placed.
```

## How DI helps

- **Loose coupling:** `OrderService` depends on the `Notifier` interface, not on
  `EmailNotifier`. Switching to SMS needs only a `@Qualifier`, not a change to
  the business logic.
- **Reusability:** `OrderRepository` and the notifiers are independent
  components that can be injected into any other service.
- **Maintainability:** object creation and wiring live in one place. A new
  `WhatsAppNotifier` is just one new class, and existing code stays untouched.
- **Testability:** dependencies can be replaced with fakes, so
  `OrderServiceTest` runs without Spring, an email server or a database.

## Switching to SMS
