FROM python:3.12.3


COPY requirements.txt .
RUN pip install -r requirements.txt && mkdir /opt/app
COPY app.py /opt/app


WORKDIR /opt/app
EXPOSE 7000

CMD ["python","app.py"]
