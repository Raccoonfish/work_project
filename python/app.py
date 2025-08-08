from flask import Flask, Response
from prometheus_client import Counter, generate_latest, CONTENT_TYPE_LATEST

app = Flask(__name__)

# Создаём счётчик
page_refresh_counter = Counter('page_refresh_count', 'Количество обновлений страницы')

@app.route('/metrics')
def metrics():
    page_refresh_counter.inc()
    return Response(generate_latest(), mimetype=CONTENT_TYPE_LATEST)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=7000)


