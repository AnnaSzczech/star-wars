Star Wars - Zadanie rekrutacyjne
Zadanie polega na przygotowaniu  usługi REST która zwróci:
• stronicowaną listę bohaterów Gwiezdnych Wojen
• szczegóły poszczególnych bohaterów.

API powinno wystawiać dwie końcówki:
GET /characters?page=x
GET /characters/{id}

Wymagania
Wymagania poza funkcjonalne
• powinna być w stanie obsłużyć 20 zapytań na sekundę (nie powinna zawierać oczywistych wąskich gardeł)
• pełny zestaw testów uruchamiany wraz z narzędziem budującym (Maven lub Gradle)
• dobry projekt i jakość kodu

Dodatkowe wymagania
• obsługa i logowanie błędów
• konfiguracja Swagger UI
• dokeryzacja aplikacji
• przygotowanie do monitorowania przy pomocy Prometheus

Technologie
Wymagane technologie
• Java 11

Zalecane technologie:
• Spring
• Spock
