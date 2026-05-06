# OS Resource & Processor Access Simulator

## 📝 Opis projektu
Aplikacja symulująca kluczowe mechanizmy działania systemów operacyjnych w zakresie zarządzania pamięcią, czasem procesora oraz dostępem do dysku. Projekt został zrealizowany w ramach kursu Systemy Operacyjne na Politechnice Wrocławskiej.
Projekt pozwala na obserwację, w jaki sposób różne strategie szeregowania wpływają na czas oczekiwania procesów oraz ogólną wydajność systemu.

## ✨ Kluczowe algorytmy i funkcjonalności
* **Szeregowanie czasu procesora (CPU Scheduling):** Autorska implementacja algorytmów przydzielania czasu procesora, w tym:
  * **Round Robin (RR):** Sprawiedliwy przydział kwantów czasu dla każdego procesu.
  * **SRTF (Shortest Remaining Time First / SJF z wywłaszczaniem):** Dynamiczne przydzielanie procesora zadaniu o najkrótszym pozostałym czasie wykonania, wymagające obsługi wywłaszczania (preemption) i ciągłego monitorowania stanu procesów.
* **Statystyki i metryki:** Generowanie danych dotyczących czasu oczekiwania (waiting time) i sredniego czasu przetwarzania procesów przez różne algorytmy

## 🛠 Technologie i struktury danych
* **Język:** Java
* **Struktury danych:** Intensywne wykorzystanie kolejek (Queues) oraz list jedno- i dwukierunkowych 
* **Paradygmaty:** Programowanie Obiektowe (OOP) – reprezentacja procesów i zasobów jako niezależnych obiektów.
