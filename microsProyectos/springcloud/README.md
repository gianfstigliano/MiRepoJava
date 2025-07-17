# Proyecto Spring Cloud con Sleuth y Zipkin 🌟

¡Proyecto implementado con **Spring Cloud**, **Sleuth** y **Zipkin** para trazabilidad distribuida! 🎉

---

# Guía de uso 📋

1. **Clona el proyecto**  
   Asegúrate de tener el proyecto en tu máquina local. 🖥️

2. **Instala las dependencias**  
   mvn clean install  
   Descarga e instala todas las dependencias del proyecto. 🔧

3. **Levanta todo con Docker Compose**  
   docker-compose up --build  
   Este comando construye y arranca todos los servicios (RabbitMQ, Zipkin, Config Server, Eureka Server, Gateway Server, pizza-read, pizza-write y usuarios) en contenedores Docker. 🐳🚀

---

# Documentación 📚

Accede a los servicios una vez que estén corriendo:

- **Config Server**: [http://localhost:8888/<nombre_servicio>/default](http://localhost:8888/<nombre_servicio>/default)  
  Configuraciones centralizadas. 🔧
- **Eureka Server**: [http://localhost:8761/](http://localhost:8761/)  
  Registro de servicios. 🌐
- **Gateway**: [http://localhost:9000/](http://localhost:9000/)  
  Entrada a los microservicios. 🚪
- **Pizza-write**: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)  
  API para escribir pizzas. 🍕✍️
- **Pizza-read**: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)  
  API para leer pizzas. 🍕👀
- **Usuarios**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
  API de gestión de usuarios. 👤
- **Zipkin**: Puerto `9411` - [http://localhost:9411/](http://localhost:9411/)  
  Trazabilidad distribuida. 🔍
- **Prometheus**: Puerto `9090` - [http://localhost:9090/](http://localhost:9090/)  
  Monitoreo de métricas en tiempo real. 📈
- **Grafana**: Puerto `3000` - [http://localhost:3000/](http://localhost:3000/)  
  Visualización de métricas y dashboards. 📊  
  (Usuario/Contraseña por defecto: admin/admin)
- **Sonar**: Puerto `9300`  
  Calidad de código. ✅

---

# Autor ✒️

**Gian Franco Stigliano**  
Hecho con entusiasmo y código. 😊