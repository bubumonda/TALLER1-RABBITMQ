import pika
import time
import jsons
import random
import logging

# Conectar a RabbitMQ
connection = pika.BlockingConnection(pika.ConnectionParameters(host='192.168.20.112'))
channel = connection.channel()

# Declarar el intercambio (exchange) de tipo 'fanout'
channel.exchange_declare(exchange='exchange', exchange_type='fanout', durable=True)
logging.basicConfig(level=logging.INFO)
# Publicar un mensaje cada 20 segundos

class Message:
    def __init__(self, id, message):
        self.id = id
        self.message= message 
    id: int
    message: str

while True:
    text = "Hello World FROM PYTHON!"
    message = jsons.dumps(Message(random.randint(0, 1000000), text))
    channel.basic_publish(exchange='exchange', routing_key='', body=message)
    logging.info(f"Message {text} will be send ... ")
    time.sleep(3)

