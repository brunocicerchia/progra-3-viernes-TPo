función contadorCambio(monedas, monto)
ordenar monedas de mayor a menor
para cada moneda en monedas:
mientras monto >= moneda:
monto = monto - moneda
si monto es 0:
devolver Verdadero
de lo contrario:
devolver Falso
fin función

Ordenamiento: O(n log n)
