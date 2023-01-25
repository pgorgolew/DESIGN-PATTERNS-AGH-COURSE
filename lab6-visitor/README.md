## Comment (in polish)

wzorzec Visitor niestety został źle przez Pana zaimplementowany. Błąd, który Pan popełnił, to "podwójny visitor". Node jest operacją w grafie, visitor odwiedza Node (accept(...)), a on wywołuje metodę visit, która wywołuje metodę calculate z Node :). Sens visitora to właśnie zaimplementowanie calculate POZA Node, a nie w nim.
