# Semana08_Excepciones_Hilos

Este proyecto demuestra el uso de hilos y sincronización en Java utilizando una simulación de cuenta bancaria.

## Comportamiento con y sin sincronización

### Sin sincronización (sin la palabra clave `synchronized`)
Cuando los métodos `depositar()` y `retirar()` no están sincronizados, pueden ocurrir condiciones de carrera:
- Múltiples hilos pueden acceder simultáneamente al saldo
- El saldo final puede ser incorrecto
- Pueden producirse retiros exitosos incluso cuando no hay saldo suficiente
- El resultado es impredecible y no confiable

### Con sincronización (usando `synchronized`)
Cuando los métodos están sincronizados como en esta implementación:
- Solo un hilo puede ejecutar los métodos `depositar()` o `retirar()` a la vez
- El saldo se mantiene consistente
- Las operaciones son atómicas
- Se garantiza que no se pueda retirar más dinero del disponible
- El resultado es predecible y confiable

## Ejemplo práctico
En nuestro programa:
- Saldo inicial: 1000
- 3 cajeros intentan retirar 500 cada uno
- Con sincronización: Solo dos cajeros podrán retirar exitosamente (total 1000), el tercero recibirá una excepción
- Sin sincronización: Podría permitir retiros incorrectos o producir un saldo final negativo
