# Ekran główny

### Co widzimy:

- Menu opcji z przyciskiem **"Stwórz zamówienie"**

# Ekran wyboru lokalizacji dostawy

### Co widzimy:

- Formularz z opcjami dostępnych lokalizacji dostawy (wczytane z systemu)
- Przycisk "Potwierdź" do tworzenia zamówienia

# Ekran tworzenia zamówienia

### Co widzimy:

- Przycisk "Stwórz zamówienie" przenosi do ekranu z listą produktów

### Interakcja z bazą danych:

- Zapytanie do bazy danych o dostępne produkty
- Filtrowanie kategoriami
- Po kliknięciu reprezentacja stanu magazynowego produktów w wybranym magazynie

# Ekran listy produktów (Przeglądanie listy produktów)

### Co widzimy:

- Listę produktów z informacjami takimi jak nazwa, cena, dostępność
- Przycisk "Dodaj do koszyka" przy każdym produkcie

# Ekran koszyka (Potwierdzenie zamówienia)

### Co widzimy:

- Przegląd produktów dodanych do koszyka
- Możliwość modyfikacji ilości lub usunięcia produktów
- Przycisk **"Zatwierdź zamówienie"**

### Interakcja z bazą danych:

- Aktualizacja bazy danych z wybranymi ilościami i produktami
- Przejście do ekranu podsumowania zamówienia

# Ekran podsumowania zamówienia (Finalizacja i zapisanie zamówienia)

### Co widzimy:

- Szczegółowe podsumowanie zamówienia wraz z lokalizacją dostawy
- Przycisk "Potwierdź i zamów"

### Interakcja z bazą danych:

- Zapisanie całego zamówienia w bazie danych
- Generowanie potwierdzenia zamówienia

# Ekran potwierdzenia złożenia zamówienia

### Co widzimy:

- Komunikat o sukcesie złożenia zamówienia
- Szczegóły zamówienia, numer zamówienia
- Przycisk **"Nowe zamówienie"** lub **"Wróć do głównego ekranu"**

### Interakcja z bazą danych:

- Wyświetlenie potwierdzenia z bazy danych
```
