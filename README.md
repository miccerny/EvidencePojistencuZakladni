Naprogramuj konzolovou aplikaci pro evidenci pojistných událostí. Před odevzdáním si zkontroluj, že tvůj kód odpovídá kritériím uvedeným v další záložce níže.

# Minimální požadavky ke splnění
## Aplikace obsahuje správu pojištěných (to jsou pojištěné osoby, např. "Jan Novák"):
- Vytvoření pojištěného
- Evidujte jméno, příjmení, věk a telefonní číslo
- Zobrazení seznamu všech pojištěných
- Vyhledání pojištěného podle jména a příjmení
- Dané entity jsou uloženy v kolekci v paměti
## Aplikace je naprogramována podle dobrých praktik
- Využívejte konstruktory pro inicializaci objektů
- toString() pro jejich výpis
- SRP - Oddělujte kód do samostatných tříd a souborů (lekce C#, Java, Python, JavaScript, PHP)
- SoC - Nekomunikujte s uživatelem v té samé třídě, která ukládá data (lekce C#, Java, Python, JavaScript, PHP)
- Dodejte validace alespoň prázdného jména
- DRY - Neopakujte ten samý kód vícekrát, ale takový kód vložte do metody (např. zadání jména a příjmení se v aplikaci může opakovat několikrát, lekce C#, Java, - - Python, JavaScript, PHP)
- Editaci a odstranění pojištěných ani ukládání dat po skončení aplikace není třeba řešit.

## Ukázkové obrazovky aplikace
Pro představu si ukažme, jak může být realizováno několik z funkčností zmíněných výše:

Přidání pojištěného:


Výpis všech pojištěných:


Vyhledání pojištěného:

