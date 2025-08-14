# 🏎️ Kafka F1

## ✍️ Autor
**Gian Franco Stigliano**

---

## 🚀 Ejecución de la Aplicación

1. Ejecutar `mvn clean install` en la carpeta raíz del proyecto.
2. Ejecutar `docker-compose up --build` para arrancar los contenedores.
3. Prueba de la aplicación en Swagger:
   - 👤 **Creación de usuarios**: [http://localhost:8090/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html)
   - 📝 **Creación de entradas**: [http://localhost:8091/swagger-ui/index.html](http://localhost:8091/swagger-ui/index.html)
   - 💾 **Receptor-asignador (persistencia)**: [http://localhost:8093/swagger-ui/index.html](http://localhost:8093/swagger-ui/index.html)

4. 🐍 **Script de Python**: se corre por separado. Al ejecutarlo, pedirá un evento (en mayúsculas).

📌 **NOTA**: Al levantar los contenedores, los topics de Kafka se crean automáticamente.  
Este proyecto es una **demo**: en un entorno real, estos deberían estar **preconfigurados**.

---

## 📦 Microservicios y Endpoints

| Servicio                        | URL                   | Descripción                                      |
|-------------------------------|-----------------------|--------------------------------------------------|
| 🚀 enviador-usuarios           | http://localhost:8090 | Crea usuarios                                    |
| 📨 enviador-entradas           | http://localhost:8091 | Crea entradas                                    |
| 🔗 asignador-entradas-usuarios | http://localhost:8095 | Asigna entradas a usuarios                       |
| 🧩 agrupador-entradas          | http://localhost:8094 | Agrupa entradas según lógica definida            |
| 🗺️ asignador-pais              | http://localhost:8092 | Asigna país a datos recibidos                    |
| 🧬 receptor-asignador          | http://localhost:8093 | Receptor y asignador con persistencia en MongoDB |

---

## 🔧 Servicios de Soporte

### 📊 Redpanda Console
- Visualización de tópicos y eventos Kafka.
- 🌐 URL: [http://localhost:8080](http://localhost:8080)

### 🐘 PostgreSQL (`enviador-usuarios-db`)
- DB para usuarios.

### 🍃 MongoDB (`db-receptor-asignador`)
- DB para receptor-asignador.

---

## 📡 Observabilidad

| Herramienta | URL |
|-------------|-----|
| 📈 **Prometheus** | [http://localhost:9090](http://localhost:9090) |
| 📊 **Grafana**    | [http://localhost:3000](http://localhost:3000) |
| 📉 **Node Exporter** | Internamente expuesto en `:9100` |

---

## 🧪 Análisis de Calidad de Código

| Herramienta   | URL                          |
|---------------|------------------------------|
| 🔍 SonarQube   | [http://localhost:9000](http://localhost:9000)

> 📌 Conectado a PostgreSQL (`sonarq-postgres`) como base de datos.

---

## 🧠 Infraestructura

- 🧬 Kafka Broker: `localhost:9092`
- 🦓 Zookeeper: `localhost:2181`
- 🧾 Schema Registry: `http://localhost:8081`

---

## 🛠️ Red Interna y Volúmenes

Todos los servicios comparten la red Docker `moodle`.  
Los datos de bases y métricas se almacenan en volúmenes persistentes.

---

## ✅ ¡Todo listo para probar!