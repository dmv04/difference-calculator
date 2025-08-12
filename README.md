[![Maintainability](https://api.codeclimate.com/v1/badges/1d66404e424a42b7388e/maintainability)](https://codeclimate.com/github/DmitryVerchenko/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/1d66404e424a42b7388e/test_coverage)](https://codeclimate.com/github/DmitryVerchenko/java-project-71/test_coverage)

# 🔍 Калькулятор различий (Difference Calculator)

Простое консольное приложение на Java, которое **сравнивает два файла с данными** и выводит разницу в удобочитаемом формате.

Поддерживаемые форматы:  
🔹 `.json`  
🔹 `.yml` или `.yaml`

Отлично подходит для анализа изменений в конфигурационных файлах.

---

## 🎯 Как это работает?

Приложение анализирует структуру данных в двух файлах и показывает:
- какие значения изменились,
- что было добавлено или удалено.

Результат выводится в виде древовидной структуры с подсветкой изменений.

[![Демонстрация работы](https://asciinema.org/a/OVQIlhOZpFw1Z4ZWA3VP7hL67.svg)](https://asciinema.org/a/OVQIlhOZpFw1Z4ZWA3VP7hL67)

---

## 📦 Установка и сборка

Убедитесь, что у вас установлены **Java 11+** и **Gradle** (или Make).

Выполните команды:

```bash
make install
make build