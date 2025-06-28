# TestNG BrowserStack Testathon 🚀

A modern, maintainable, and scalable Selenium + TestNG automation suite for the [StackDemo](https://kolkata.bugbash.live/) e-commerce site. Built for speed, clarity, and real-world testing best practices.

---

## 📦 Project Structure

```
src/test/java/
├── com/browserstack/      # Test classes (TestNG)
├── pages/                # Page Object Model (POM) classes
├── utils/                # Test data, credentials, and utility classes
```

---

## 🛠️ Setup & Prerequisites

- Java 8+ (JDK)
- Maven or Gradle
- Chrome browser (for local runs)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) (ensure it's in your PATH)

**Install dependencies:**
```sh
mvn clean install
```

---

## 🚦 Running the Tests

Run all tests:
```sh
mvn test
```

Run a specific test class:
```sh
mvn -Dtest=ClassName test
# Example:
mvn -Dtest=BStackOrderFlowTest test
```

---

## 🧩 Key Features

- **Page Object Model (POM):** All selectors and page logic are encapsulated for maintainability.
- **Test Data Utilities:** Credentials and test data are externalized for security and reusability.
- **Brand-Device Mapping:** Brand filter tests use a robust mapping for accurate validation.
- **TestNG Data Providers:** Parameterized tests for maximum coverage.
- **Explicit Waits:** No brittle sleeps—robust, reliable waits everywhere.
- **Modular & Extensible:** Add new flows, brands, or devices with minimal effort.

---

## 📝 Example Test Scenarios

- **Login:** Validates login with credentials.
- **Order Flow:** Add to cart, checkout, and verify order in history.
- **Brand Filter:** Ensures filtering by brand only shows correct devices.
- **Favourites:** Add/remove products from favourites and verify.
- **Offers:** Checks for the no-offers message in the Offers section.

---

## 🤝 Contributing

1. Fork this repo
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes
4. Push and open a PR

---

## 💡 Best Practices

- Keep selectors in POMs, not in tests.
- Use utility classes for credentials and test data.
- Prefer explicit waits over Thread.sleep.
- Parameterize tests for coverage and reusability.

---

## 📣 Credits

- Built for the BrowserStack Testathon
- Powered by Selenium, TestNG, and Java

---

## 🏁 Happy Testing!

> "Automate like a pro. Test like a user." 