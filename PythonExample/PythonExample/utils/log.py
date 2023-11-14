from datetime import datetime


class Log:
    def __init__(self, text):
        self.text = text

    def info(self):
        print(datetime.now().strftime("%Y-%m-%d %H:%M:%S"), "INFO:", self.text)