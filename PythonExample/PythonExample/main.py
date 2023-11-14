from utils.log import Log


class Hero:
    cnt = 0

    def __init__(self, name):
        self.name = name
        Hero.cnt += 1

    def get_name(self):
        return self.name + "xxx"

class Aka(Hero):
    def __init__(self, level,name):
        super().__init__(name)
        self.level = level

    def get_level(self):
        return self.level


a = Hero("aaaa")
b = Aka("ccc","bbb")
print(a.get_name())
print(b.get_level())
print(b.get_name())
# try:
#     x = int(input())
#     print(x)
# except Exception as e:
#     from traceback import print_exc
#     print_exc()

log = Log("test")
log.info()