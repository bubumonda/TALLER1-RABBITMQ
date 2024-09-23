# Usar una imagen base de Python
FROM python:3.9-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo de dependencias
COPY requirements.txt .

# Instalar las dependencias
RUN pip install -r requirements.txt

# Copiar los scripts de Python al contenedor
COPY publisher.py .
##COPY subscriber.py .

# Comando por defecto para iniciar el publicador
CMD ["python", "publisher.py"]

