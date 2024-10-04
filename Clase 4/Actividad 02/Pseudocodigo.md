función calcularComprobantesMinimos(comprobantes, monto)
    ordenar comprobantes de mayor a menor
    inicializar un diccionario cantidadComprobantes = {}

    para cada comprobante en comprobantes:
        inicializar conteo = 0
        mientras monto >= comprobante:
            monto = monto - comprobante
            incrementar conteo
        si conteo > 0:
            guardar en cantidadComprobantes[comprobante] = conteo

    devolver cantidadComprobantes
fin función

función principal
    definir monto = 1379  // Definir el monto directamente en el código
    definir comprobantes = {1000, 500, 100, 50, 20, 10, 5, 1}  // Definir los comprobantes disponibles
    
    llamar a calcularComprobantesMinimos(comprobantes, monto)
    
    imprimir el resultado de cantidadComprobantes
fin función

Ordenamiento: O(n log n) [Predominante]
Algoritmo seleccion comprobantes: O(n)